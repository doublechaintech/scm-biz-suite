package com.terapico.uccaf;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.terapico.caf.InvocationContext;
import com.terapico.caf.InvocationException;
import com.terapico.caf.ServletInvocationContextFactory;
import com.terapico.caf.SimpleInvocationContext;
import org.springframework.context.ApplicationContext;

public class UCInvocationContextFactory extends ServletInvocationContextFactory {
	public UCInvocationContextFactory(ApplicationContext pApplicationContext) {
		super(pApplicationContext);
	}

	public UCInvocationContextFactory(){
		super();
	}

	/*
	 * 检查第一个参数的类型，如果是基于BaseUserContext的，那么就内部构造一个UserContext出来，
	 * 目前可以通过的办法是通过SessionId来构造一个用户
	 * 如果不是，就按照原来的方式返回
	 *
	 * */
	protected Type [] removeIfFirstUCTypeFromTypeList(Type[] types, Object[] parameters) {
		Type firstParameterType = types[0];
		if(!UCTypeTool.isBaseUCType(firstParameterType)){
			return types;// keep the original types
		}
		Type ignoredUCTypes [] = Arrays.copyOfRange(types, 1,types.length);
		/*
		if(ignoredUCTypes.length != parameters.length){

			throw new IllegalArgumentException("ignoredUCTypes.length != parameters.length not match '"
			+ignoredUCTypes.length+" != "+ parameters.length+"', types.length="+types.length);
		}*/

		return ignoredUCTypes;


	}


	@Override
	protected Object[] getParameters(Type[] types, Object[] parameters,HttpServletRequest request) {
		// FIXME: need to make some improvement to make the code better,


		Type ignoredUCTypes [] =removeIfFirstUCTypeFromTypeList(types, parameters);
		Object[] params = super.getParameters(ignoredUCTypes, parameters);
		return wrapFinalParameters(params,request);

	}

	@Override
	protected Object[] getPostParameters(Type[] types, Object[] parameters, HttpServletRequest request) {

		Type ignoredUCTypes [] =removeIfFirstUCTypeFromTypeList(types, parameters);
		Object[] params = super.getPostParameters(ignoredUCTypes, parameters,request);
		return wrapFinalParameters(params,request);



	}

	@Override
	protected Object[] getPutParameters(Type[] types, Object[] parameters, HttpServletRequest request) {

		Type ignoredUCTypes [] = removeIfFirstUCTypeFromTypeList(types, parameters);
		Object[] params = super.getPutParameters(ignoredUCTypes, parameters,request);
		return wrapFinalParameters(params,request);



	}

	protected Object[] wrapFinalParameters( Object[] params, HttpServletRequest request){
		Object[] finalParams = new Object[params.length+1];

		System.arraycopy(params, 0, finalParams, 1, params.length);
		finalParams[0] = loadUserConext(request);
		return finalParams;
	}

	protected SimpleInvocationContext createNewInvocationContext(){
		return new UCInvocationContext();
	}

	public InvocationContext create(Object input) throws InvocationException{
		InvocationContext context = super.create(input);
		if(!(context instanceof UCInvocationContext)){
			//基本的Form服务还是要保留下来
			return context;
		}
		UCInvocationContext invocationContext = (UCInvocationContext)context;
		Object[] parameters = invocationContext.getParameters();

		if(parameters.length <= 0){
			return context;
		}
		if(parameters[0] instanceof BaseUserContext){
			BaseUserContext baseUserConrtext = (BaseUserContext)parameters[0];
			invocationContext.setUserContext(baseUserConrtext);
		}


		return context;

	}
	//shift the control to managers to build the form
	@Override
	protected InvocationContext buildFormContext(String beanName,
			Method targetMethod, Object[] parameters)
			throws InvocationException {

		return super.buildFormContext(beanName, targetMethod, parameters);
	}





	protected void saveUserConext(HttpServletRequest request) throws Exception{
		Object manager = getBean("secUserManager");
		if(manager == null){
			throw new IllegalStateException("user context provider can not be null for an app!");
		}
		boolean isTypeRight = (manager instanceof UserContextProvider);
		if(!isTypeRight){
			throw new IllegalStateException("user context service must implement UserContextProvider interface!");
		}
		UserContextProvider provider = (UserContextProvider)manager;

		BaseUserContext uc = (BaseUserContext)request.getAttribute("userContext");

		provider.saveUserContext(uc);

	}
	protected BaseUserContext loadUserConext(HttpServletRequest request) {

		Object manager = getBean("secUserManager");
		if(manager == null){
			throw new IllegalStateException("user context provider can not be null for an app!");
		}
		boolean isTypeRight = (manager instanceof UserContextProvider);
		if(!isTypeRight){
			throw new IllegalStateException("user context service must implement UserContextProvider interface!");
		}
		UserContextProvider provider = (UserContextProvider)manager;


		//safe, let's go
		try {
			//request

			request.setAttribute("beanFactory", this.getBeanFactory());

			BaseUserContext uc = provider.loadUserConext(request);
			request.setAttribute("userContext", uc);
			return uc;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("User Context is not able to init" + e.getMessage());
		}

	}
	protected void checkParametersLength(Type []parameterTypes, Object[] parameters){
		Type firstType = parameterTypes[0];


		if(!UCTypeTool.isBaseUCType(firstType)){
			super.checkParametersLength(parameterTypes, parameters);
			return;
		}

		int newLength = parameterTypes.length-1;

		if(newLength != parameters.length){
			throw new IllegalArgumentException("The parameter length expect be:"+newLength+" but the actual length is:"+parameters.length);
		}
	}
	@Override
	protected int expectedCountOfParameters(HttpServletRequest request, List<String> urlElements,Method targetMethod)
	{

		Type [] parameterTypes=targetMethod.getGenericParameterTypes();
		if(parameterTypes.length == 0){
			return 0;
		}

		Type firstType = parameterTypes[0];
		int noUCCount = super.expectedCountOfParameters(request, urlElements, targetMethod);
		if(!UCTypeTool.isBaseUCType(firstType)){
			return noUCCount;
		}
		return noUCCount + 1;//with an extra UC type

	}

}
