package com.terapico.caf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class SimpleInvocationTool implements InvocationTool {
	
	
	protected void checkForPrimaryType(Method method, Object parameters[]){
		
		Type [] parameterTypes = method.getParameterTypes();
		for(int i=0;i< parameterTypes.length;i++){
			if(checkSingleParameter(parameterTypes[i], parameters[i])){
				continue;
			}
			//find issue here;
			String message = "The method("+method.getName()+")'s parameters["+i+"] is a primary type("+parameterTypes[i]+"), not applicable for a null input";
			throw new IllegalArgumentException(message);
		}
		
		
	}
	static Type [] primaryTypes={int.class,float.class,double.class,long.class,char.class};
	protected boolean checkSingleParameter(Type type, Object value){
		if(value!=null){
			return true;
		}
		for(int i=0;i<primaryTypes.length;i++){
			if(type==primaryTypes[i]){
				return false;
			}
		}
		
		return true;
	}
	public InvocationResult invoke(InvocationContext context) throws InvocationException {

		Method method=context.getMethodToCall();
		Object targetObject=context.getTargetObject();
		Object parameters[]=context.getParameters();
		
		InvocationResult result=new SimpleInvocationResult();
		result.setInvocationContext(context);
		
		try {
			checkForPrimaryType(method,parameters);
			Object actualResult=method.invoke(targetObject, parameters);
			result.setActualResult(actualResult);
			
		} catch (InvocationTargetException exception) {
			//return  InvokeResult.createInstance(exception.getCause(),null,null);
			exception.printStackTrace();
			result.setActualResult(exception.getCause());
		}catch (IllegalArgumentException e) {
			//String message ="IllegalArgumentException: the parameters of method ";
			e.printStackTrace();
			result.setActualResult(e);
		}catch (Throwable e) {
			e.printStackTrace();
			result.setActualResult(e);
		}
		return result;
	}
	
	

}
