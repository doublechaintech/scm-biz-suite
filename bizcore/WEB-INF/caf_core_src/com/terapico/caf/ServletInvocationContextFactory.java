package com.terapico.caf;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
public class ServletInvocationContextFactory  extends ReflectionTool implements InvocationContextFactory {
	private int start = 1;
	private String formBuilderBeanName="formbuilder";
	private String formBuilderMethodName="buildForm";
	
	private BeanFactory beanFactory=null;
	
	
	protected int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public BeanFactory getBeanFactory() {
		
		if(beanFactory==null){
			beanFactory=new SpringBeanFactory();
		}
		return beanFactory;
	}
	public void setBeanFactory(BeanFactory beaFactory) {
		this.beanFactory = beaFactory;
	}
	public static final String OVERRIDE_URI="__overrideURI";
	protected String getRequestPath(HttpServletRequest request)
	{
		String overrideURI=(String)request.getAttribute(OVERRIDE_URI);
		
		if(overrideURI!=null){
			return overrideURI;
		}
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		return path;
		
	}
	public InvocationContext create(Object input) throws InvocationException {

		if (input == null) {
			throw new IllegalArgumentException("Could not create the call, the input parameter is null");
		}

		if (!(input instanceof HttpServletRequest)) {
			throw new IllegalArgumentException("Could not create the call context since the type is: "
					+ input.getClass().getName() + ", Expected class: HttpServletRequest");
		}

		HttpServletRequest request = (HttpServletRequest) input;

		List<String> urlElements = parse(request);

		if (urlElements.size() < start + 1) {
			throw new InvocationException("No sufficient parameter to call");
		}

		Object targetObject = getBean(request, urlElements);

		if (targetObject == null) {
			throw new InvocationException("Not able to find the target object to call: "+request.getRequestURI());
		}

		Method targetMethod = this.getMethod(request, targetObject, urlElements);

		if (targetMethod == null) {
			throw new InvocationException("Not able to find the target method to call： " +request.getRequestURI());
		}
		if(!hasRightNumberOfParameters(urlElements,targetMethod)){
			Object []parameters=this.getCandidateParameters(urlElements);
			return buildFormContext(getBeanName(urlElements),targetMethod,parameters);
		}
	
		Object[] parameters = this.getParameters(request, targetObject, urlElements, targetMethod);
		

		SimpleInvocationContext context = createNewInvocationContext();
		context.setTargetObject(targetObject);
		context.setTargetMethod(targetMethod);
		context.setParameters(parameters);
		return context;

	}
	protected List<String> parse(HttpServletRequest request) throws InvocationException {
		if(request.getMethod()=="POST"){
			return this.parsePost(request);
		}
		return this.parseGet(request);
	}
	protected SimpleInvocationContext createNewInvocationContext(){
		return new SimpleInvocationContext();
	}
	protected InvocationContext buildFormContext(String beanName,Method targetMethod,Object[] parameters) throws InvocationException {
		
		SimpleInvocationContext context = new SimpleInvocationContext();
		Object formBuilder =getBean(formBuilderBeanName);
		if(formBuilder==null){
			throw new InvocationException("Form Builder can not be found with the name: "+ formBuilderBeanName);
		}
		
		context.setTargetObject(formBuilder);
		Method method=findSingleMethod(formBuilder,formBuilderMethodName);
		if(method==null){
			throw new InvocationException("Form Builder method can not be found with the name: "+ formBuilderBeanName+"."+formBuilderMethodName);
		}
		
		context.setTargetMethod(method);
		context.setParameters(new Object[]{beanName,targetMethod,parameters});
		return context;
	}
	protected boolean hasRightNumberOfParameters(List<String> urlElements,Method targetMethod)
	{
		int size=urlElements.size();
		Type [] parameterTypes=targetMethod.getGenericParameterTypes();
		
		return (size-start-2)==parameterTypes.length;
		
	}
	

	protected Object getBean(HttpServletRequest request, List<String> urlElements) {

		String beanName = urlElements.get(start);
		return getBean(beanName);
	}

	protected String getBeanName(List<String> urlElements) {

		return urlElements.get(start);
		
	}
	protected Object getBean(String beanName) {
		return this.getBeanFactory().getBean(beanName);
	}
	
	protected Object[] getCandidateParameters(List<String> urlElements) {

		
		// Object [] parameters=new String[urlElements.size()-start-2];
		Object elements[] = urlElements.toArray();
		Object[] parameters = Arrays.copyOfRange(elements, start+2, urlElements.size());

		return parameters;

	}
	
	protected Object[] getParameters(HttpServletRequest request, Object targetObject, List<String> urlElements,
			Method method) {

		Type []parameterTypes=method.getGenericParameterTypes();
		if(parameterTypes.length==0){
			return new Object[]{};
		}
		// Object [] parameters=new String[urlElements.size()-start-2];
		Object elements[] = urlElements.toArray();
		Object[] parameters = Arrays.copyOfRange(elements, start+2, urlElements.size());
		checkParametersLength(parameterTypes,parameters);
		
		if(isGetRequest(request)){
			return getParameters(parameterTypes, parameters,request);
		}
		if(isPostRequest(request)){
			return getPostParameters(parameterTypes, parameters,request);
		}
		return getParameters(parameterTypes, parameters,request);

	}
	protected void checkParametersLength(Type []parameterTypes, Object[] parameters){
		if(parameterTypes.length != parameters.length){
			throw new IllegalArgumentException("The parameter length expect be:"+parameterTypes.length+" but the actual length is:"+parameters.length);
		}
	}
	
	protected Object[] getParameters(Type[] types, Object[] parameters, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.getParameters(types, parameters);
	}
	
	/*
	 * 处理POST请求， 请求的路径的格式不变，不过路径里面的各个参数不是最终的值，而是要经过request.getParameter之后取得的值
	 * 比如 
	 *     POST /serviceMethod/param1/param2/
	 * 此时，对于serviceMethod而言，param1只是表示参数的名字，正确的表示是
	 *     POST /serviceMethod/param1Name/param2Name/
	 * 而不是值，在调用serviceMethod之前，必须要通过
	 *     Object param1 = request.getParameter("param1Name")
	 * 来获得，一次类推
	 *     Object param2 = request.getParameter("param2Name")
	 * 但是，当目标类型是一个数组的时候，要取得的参数就是
	 *     Object[] param3 = request.getParameterValues("param3");
	 * */
	protected Object[] getPostParameters(Type[] types, Object[] parameters, HttpServletRequest request) {

		int length = parameters.length;
		if (length == 0) {
			return new Object[] {};
		}
		Object[] ret = new Object[length];

		for (int i = 0; i < length; i++) {
			ret[i] = convertExprToObject(types[i], parameters[i],request);
			// System.out.println(ret[i].getClass() + "" + ret[i]);
		}
		return ret;
	}
	
	
	private Object convertExprToObject(Type type, Object parameterName,
			HttpServletRequest request) {
		if(type == File.class){
			throw new IllegalArgumentException("The file type  for prameter '"+parameterName+"'is not supported yet!");
		}
		//如果是基本类型，不是array，就直接调用上层
		String stringParameter = parameterName.toString();
		Class typeClazz = (Class) type;
		if(this.isPrimaryType(typeClazz)){
			return convertExprToObject(type,request.getParameter(stringParameter));
		}
		//如果是数组。不能使用父类提供的方法，而是要request.getParameterValues来转
		if (isArrayOfPrimaryType(type)) {
			String subParameters[] = request.getParameterValues(stringParameter);
			if(subParameters==null){
				System.err.println("Found null valua for parameter: '"+stringParameter+"'");
				return null;
			}
			int length = subParameters.length;
			
			Class componentClazz = typeClazz.getComponentType();
			Object object = Array.newInstance(componentClazz, length);
			for (int index = 0; index < length; index++) {
				Array.set(object, index, convertExprToObject(typeClazz.getComponentType(), subParameters[index]));
			}
			return object;
		}
		
		throw new IllegalArgumentException("The  type '"+type+"' for prameter '"+parameterName+"'is not supported yet!");
		
	}
	protected boolean isGetRequest(HttpServletRequest request){
		return request.getMethod().equalsIgnoreCase("GET");
	}
	protected boolean isPostRequest(HttpServletRequest request){
		return request.getMethod().equalsIgnoreCase("POST");
	}
	protected Method getMethod(HttpServletRequest request, Object targetObject, List<String> urlElements)
			throws InvocationException {
		if(urlElements.size()<start + 2){
		
			throw new InvocationException("Not able to get method name, the method name is not specified by the URI!");
			
		}
		String methodName = urlElements.get(start + 1);

		return findSingleMethod(targetObject,methodName);

	}

	protected List<String> parsePost(HttpServletRequest request) throws InvocationException  {

		List<String> parameters = new ArrayList<String>(10);
		String requestURI = this.getRequestPath(request);
		String array[] = requestURI.split("/");
		System.out.println("POST : "+requestURI);
		for (int i = 0; i < array.length; i++) {
			
			try {
				String name = URLDecoder.decode(array[i], "UTF-8").trim();
				System.out.println("array["+i+"]:"+name+" = " + joinArray(",", request.getParameterValues(name)));
				parameters.add(name);
			} catch (UnsupportedEncodingException e) {
				throw new InvocationException("Encoding UTF-8 is not supported");
			}
			
		}
		// System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return parameters;

	}
	protected String joinArray(String delimiter, String []args){
		if(args==null){
			return null;
		}
		if(args.length<1){
			return "<empty array>";
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<args.length;i++){
			if(i>0) stringBuilder.append(delimiter);
			stringBuilder.append(args[i]);
		}
		return stringBuilder.toString();
		
	}
	protected List<String> parseGet(HttpServletRequest request) throws InvocationException  {

		List<String> parameters = new ArrayList<String>(10);
		String requestURI = this.getRequestPath(request);
		String array[] = requestURI.split("/");
		System.out.println("GET : "+requestURI);
		for (int i = 0; i < array.length; i++) {
			
			try {
				String val = URLDecoder.decode(array[i], "UTF-8").trim();
				System.out.println("array["+i+"]:"+val);
				parameters.add(val);
			} catch (UnsupportedEncodingException e) {
				throw new InvocationException("Encoding UTF-8 is not supported");
			}
			
		}
		// System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return parameters;

	}

}
