package com.terapico.caf;

import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ServletInvocationContextFactory extends ReflectionTool implements InvocationContextFactory {
	private int start = 1;
	private String formBuilderBeanName = "formbuilder";
	private String formBuilderMethodName = "buildForm";

	private BeanFactory beanFactory = null;
	private ApplicationContext mApplicationContext;

	public ServletInvocationContextFactory(ApplicationContext pApplicationContext) {
		super();
		mApplicationContext = pApplicationContext;
	}

	public ServletInvocationContextFactory() {
		super();
	}

	protected int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public BeanFactory getBeanFactory() {

		if (beanFactory == null) {
			beanFactory = new SpringBeanFactory(mApplicationContext);
		}
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beaFactory) {
		this.beanFactory = beaFactory;
	}

	public static final String OVERRIDE_URI = "__overrideURI";

	protected String getRequestPath(HttpServletRequest request) {
		String overrideURI = (String) request.getAttribute(OVERRIDE_URI);

		if (overrideURI != null) {
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
			throw new InvocationException("No sufficient parameter to call" + String.join(" and ", urlElements));
		}

		Object targetObject = getBean(request, urlElements);

		if (targetObject == null) {
			throw new InvocationException("Not able to find the target object to call: " + request.getRequestURI());
		}

		Method targetMethod = this.getMethod(request, targetObject, urlElements);

		if (targetMethod == null) {
			throw new InvocationException("Not able to find the target method to call： " + request.getRequestURI());
		}
		if (!hasRightNumberOfParameters(request, urlElements, targetMethod)) {
			Object[] parameters = this.getCandidateParameters(urlElements);
			return buildFormContext(getBeanName(urlElements), targetMethod, parameters);
		}

		Object[] parameters = this.getParameters(request, targetObject, urlElements, targetMethod);

		SimpleInvocationContext context = createNewInvocationContext();
		context.setTargetObject(targetObject);
		context.setTargetMethod(targetMethod);
		context.setParameters(parameters);
		return context;

	}

	protected List<String> parse(HttpServletRequest request) throws InvocationException {
		if (request.getMethod().equals("POST")) {
			return this.parsePost(request);
		}
		if (request.getMethod().equals("PUT")) {
			return this.parsePut(request);
		}
		return this.parseGet(request);
	}

	protected SimpleInvocationContext createNewInvocationContext() {
		return new SimpleInvocationContext();
	}

	protected InvocationContext buildFormContext(String beanName, Method targetMethod, Object[] parameters)
			throws InvocationException {

		SimpleInvocationContext context = new SimpleInvocationContext();
		Object formBuilder = getBean(formBuilderBeanName);
		if (formBuilder == null) {
			throw new InvocationException("Form Builder can not be found with the name: " + formBuilderBeanName);
		}

		context.setTargetObject(formBuilder);
		Method method = findSingleMethod(formBuilder, formBuilderMethodName);
		if (method == null) {
			throw new InvocationException("Form Builder method can not be found with the name: " + formBuilderBeanName
					+ "." + formBuilderMethodName);
		}

		context.setTargetMethod(method);
		context.setParameters(new Object[] { beanName, targetMethod, parameters });
		return context;
	}

	protected int expectedCountOfParameters(HttpServletRequest request, List<String> urlElements, Method targetMethod) {

		if (this.isPutRequest(request)) {
			return 1;
		}

		int size = urlElements.size();

		return (size - start - 2);

	}

	protected boolean hasRightNumberOfParameters(HttpServletRequest request, List<String> urlElements,
			Method targetMethod) {
		Type[] parameterTypes = targetMethod.getGenericParameterTypes();

		int expectedParameterCount = this.expectedCountOfParameters(request, urlElements, targetMethod);

		return expectedParameterCount == parameterTypes.length;

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
		Object[] parameters = Arrays.copyOfRange(elements, start + 2, urlElements.size());

		return parameters;

	}

	protected Object[] getParameters(HttpServletRequest request, Object targetObject, List<String> urlElements,
			Method method) {
		System.out.println(urlElements);
		Type[] parameterTypes = method.getGenericParameterTypes();
		if (parameterTypes.length == 0) {
			return new Object[] {};
		}
		// Object [] parameters=new String[urlElements.size()-start-2];
		Object elements[] = urlElements.toArray();
		Object[] parameters = Arrays.copyOfRange(elements, start + 2, urlElements.size());
		if (isPutRequest(request)) {
			return getPutParameters(parameterTypes, parameters, request);
		}
		checkParametersLength(parameterTypes, parameters);

		if (isGetRequest(request)) {
			return getParameters(parameterTypes, parameters, request);
		}
		if (isPostRequest(request)) {
			return getPostParameters(parameterTypes, parameters, request);
		}

		return getParameters(parameterTypes, parameters, request);

	}

	protected void checkParametersLength(Type[] parameterTypes, Object[] parameters) {
		if (parameterTypes.length != parameters.length) {
			throw new IllegalArgumentException("The parameter length expect be:" + parameterTypes.length
					+ " but the actual length is:" + parameters.length);
		}
	}

	protected Object[] getParameters(Type[] types, Object[] parameters, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.getParameters(types, parameters);
	}

	/*
	 * 处理PUT请求，只是允许两种情况 如果这个函数包括了userContext，那么允许两个参数
	 * 如果这个函数没有包括userContext，那么只是允许一个参数 没有UC的情况下，只是允许一个参数
	 * 
	 */
	protected Object[] getPutParameters(Type[] types, Object[] parameters, HttpServletRequest request) {
		int length = types.length;

		if (length == 0) {
			return new Object[] {};
			//
		}
		if (length > 1) {
			throw new IllegalArgumentException(
					"For put method without a userContext parameter, only one parameter allowed");
		}
		
		
		if(ReflectionTool.isFirstParameterByteArray(types)) {
			return new Object[] {this.readBodyAsBytes(request)};
		}
		// only one parameter allowed, the body should be a json object string
		String strExpr = this.readBodyAsString(request);
		Object object = ReflectionTool.convertOnlyOneParameter(types, strExpr);
		// return new Object[] {strExpr};
		return new Object[] { object };

	}

	/*
	 * 处理POST请求， 请求的路径的格式不变，不过路径里面的各个参数不是最终的值，而是要经过request.getParameter之后取得的值 比如
	 * POST /serviceMethod/param1/param2/
	 * 此时，对于serviceMethod而言，param1只是表示参数的名字，正确的表示是 POST
	 * /serviceMethod/param1Name/param2Name/ 而不是值，在调用serviceMethod之前，必须要通过 Object
	 * param1 = request.getParameter("param1Name") 来获得，一次类推 Object param2 =
	 * request.getParameter("param2Name") 但是，当目标类型是一个数组的时候，要取得的参数就是 Object[] param3
	 * = request.getParameterValues("param3");
	 */
	protected Object[] getPostParameters(Type[] types, Object[] parameters, HttpServletRequest request) {

		int length = parameters.length;
		if (length == 0) {
			return new Object[] {};
		}
		Object[] ret = new Object[length];

		for (int i = 0; i < length; i++) {
			ret[i] = convertExprToObject(types[i], parameters[i], request);
			// System.out.println(ret[i].getClass() + "" + ret[i]);
		}
		return ret;
	}

	private Object convertExprToObject(Type type, Object parameterName, HttpServletRequest request) {
		if (type == File.class) {
			throw new IllegalArgumentException(
					"The file type  for prameter '" + parameterName + "'is not supported yet!");
		}
		// 如果是基本类型，不是array，就直接调用上层
		String stringParameter = parameterName.toString();
		Class typeClazz = (Class) type;
		if (this.isPrimaryTypeOrOneStringConstructor(typeClazz)) {
			return convertExprToObject(type, request.getParameter(stringParameter));
		}
		// 如果是数组。不能使用父类提供的方法，而是要request.getParameterValues来转
		if (isArrayOfPrimaryType(type)) {
			String subParameters[] = request.getParameterValues(stringParameter);
			if (subParameters == null) {
				System.err.println("Found null valua for parameter: '" + stringParameter + "'");
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

		throw new IllegalArgumentException(
				"The  type '" + type + "' for parameter '" + parameterName + "'is not supported yet!");
		
	}

	protected boolean isGetRequest(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("GET");
	}

	protected boolean isPutRequest(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("PUT");
	}

	protected boolean isPostRequest(HttpServletRequest request) {
		return request.getMethod().equalsIgnoreCase("POST");
	}

	protected Method getMethod(HttpServletRequest request, Object targetObject, List<String> urlElements)
			throws InvocationException {
		if (urlElements.size() < start + 2) {

			throw new InvocationException("Not able to get method name, the method name is not specified by the URI!");

		}
		String methodName = urlElements.get(start + 1);

		return findSingleMethod(targetObject, methodName);

	}

	protected String readBodyAsString(HttpServletRequest request) {
		String str = null;
		StringBuilder resultString = new StringBuilder();
		try {
			while ((str = request.getReader().readLine()) != null) {
				resultString.append(str);
			}
			return resultString.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	static final int MAX_ALLOWED_BYTES_LENGTH = 1024*128;
	protected byte[] readBodyAsBytes(HttpServletRequest request) {
		
		int length = request.getContentLength();
		
		if(length==0) {
			return new byte[] {};
		}
		if(length>1024*128) {
			throw new IllegalArgumentException("The length '"+length+"' is large than allowed size from MAX_ALLOWED_BYTES_LENGTH: "+ MAX_ALLOWED_BYTES_LENGTH);
			
		}
		byte [] buffer = new byte[1024];
		
		ByteBuffer resultString = ByteBuffer.allocate(request.getContentLength());
		try {
			
			int readLength = 0;
			
			while ((readLength = request.getInputStream().read(buffer)) >0) {
				resultString.put(buffer, 0, readLength);
			}
			return resultString.array();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	

	protected List<String> parsePut(HttpServletRequest request) throws InvocationException {

		List<String> parameters = new ArrayList<String>(10);
		String requestURI = this.getRequestPath(request);

		System.out.println("PUT : " + requestURI);

		String array[] = requestURI.split("/");
		// System.out.println("GET : "+requestURI);
		// Only method name should be parsed

		for (int i = 0; i < array.length; i++) {
			if (i > 2) {
				break;// ignore any parameter for put
			}
			try {
				String val = URLDecoder.decode(array[i], "UTF-8").trim();
				// System.out.println("array[" + i + "]:" + val);
				parameters.add(val);
			} catch (UnsupportedEncodingException e) {
				throw new InvocationException("Encoding UTF-8 is not supported");
			}
			// the last parameter sh
		}

		// String body = this.readBodyAsString(request);

		// parameters.add(body);

		/*
		 * try { while ((str = request.getReader().readLine()) != null) {
		 * resultString.append(str); } System.out.println("PUT data: "+resultString);
		 * parameters.add(resultString.toString()); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return parameters;

	}

	protected List<String> parsePost(HttpServletRequest request) throws InvocationException {

		List<String> parameters = new ArrayList<String>(10);
		String requestURI = this.getRequestPath(request);
		String array[] = requestURI.split("/");
		System.out.println("POST : " + requestURI);
		for (int i = 0; i < array.length; i++) {

			try {
				String name = URLDecoder.decode(array[i], "UTF-8").trim();
//				System.out
//						.println("array[" + i + "]:" + name + " = " + joinArray(",", request.getParameterValues(name)));
				parameters.add(name);
			} catch (UnsupportedEncodingException e) {
				throw new InvocationException("Encoding UTF-8 is not supported");
			}

		}
		// System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return parameters;

	}

	protected String joinArray(String delimiter, String[] args) {
		if (args == null) {
			return null;
		}
		if (args.length < 1) {
			return "<empty array>";
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			if (i > 0)
				stringBuilder.append(delimiter);
			stringBuilder.append(args[i]);
		}
		return stringBuilder.toString();

	}

	protected List<String> parseGet(HttpServletRequest request) throws InvocationException {

		List<String> parameters = new ArrayList<String>(10);
		String requestURI = this.getRequestPath(request);
		String array[] = requestURI.split("/");
		System.out.println("GET : " + requestURI);
		for (int i = 0; i < array.length; i++) {

			try {
				String val = URLDecoder.decode(array[i], "UTF-8").trim();
				// System.out.println("array[" + i + "]:" + val);
				parameters.add(val);
			} catch (UnsupportedEncodingException e) {
				throw new InvocationException("Encoding UTF-8 is not supported");
			}

		}
		// System.out.println(URLDecoder.decode(schema[2],"UTF-8"));
		return parameters;

	}

}
