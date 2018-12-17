package com.terapico.caf;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class SimpleInvocationContext implements InvocationContext {
	
	private Object targetObject;
	private Method targetMethod;
	private Object[] parameters;	

	
	public Method getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(Method targetMethod) {
		this.targetMethod = targetMethod;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	public Object getTargetObject() {
		
		return targetObject;
	}

	public Method getMethodToCall() {
		
		return targetMethod;
	}
	public boolean isVoidMethod() {
		Type returnType=getMethodToCall().getReturnType();
		return returnType.equals(Void.TYPE);
	}

	public Object[] getParameters() {
		
		return parameters;
	}
	
	protected void logCall(InvocationContext context){
		
		
		
		
	}
	protected void wrapParameters(StringBuilder stringBuilder,Object[] parameters, int start)
	{
		
		for(int i=start;i<parameters.length;i++){
			if(i>start){
				stringBuilder.append(", ");
			}
			wrapParameter(stringBuilder,parameters[i]);
		}
		
	}
	protected void wrapParameters(StringBuilder stringBuilder,Object[] parameters)
	{
		
		this.wrapParameters(stringBuilder, parameters,0);
		
	}
	
	protected void wrapParameter(StringBuilder stringBuilder,Object parameter)
	{
		if(parameter==null){
			stringBuilder.append("<null>");
			return;
		}
		if(parameter instanceof String){
			wrapString(stringBuilder,parameter.toString());
			return;
		}
		//
		if(isArrayType(parameter.getClass())){
			Object []objects =(Object []) parameter;
			stringBuilder.append("[");
			for(int i=0;i<objects.length;i++){
				if(i>0){
					stringBuilder.append(", ");
				}
				Object object = objects[i];
				wrapParameter(stringBuilder,object);
			}
			stringBuilder.append("]");
			return;
		}
		
		stringBuilder.append(parameter.toString());
	}
	
	protected boolean isArrayType(Type type) {
		
		
		Class<?> typeClazz = (Class<?>) type;
		if (typeClazz.isArray()) {
			return true;
		}
		return false;
	}
	
	protected void wrapString(StringBuilder stringBuilder,String parameter)
	{
		
		stringBuilder.append("\"");
		stringBuilder.append(parameter);
		stringBuilder.append("\"");
		
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(getMethodToCall().getDeclaringClass().getName());
		stringBuilder.append(".");
		stringBuilder.append(getMethodToCall().getName());
		stringBuilder.append("(");
		wrapParameters(stringBuilder,getParameters());
		stringBuilder.append(")");
		
		return stringBuilder.toString();
	}

}
