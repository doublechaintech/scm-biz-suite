package com.doublechaintech.retailscm;

public class Footprint {
	protected String beanName;
	protected String methodName;
	protected Object[] parameters;
	
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Object[] getParameters() {
		return parameters;
	}
	public void setParameters(Object[] parameters) {
		if (parameters == null || parameters.length == 0) {
			this.parameters = new Object[] {null};
			return;
		}
		this.parameters = new Object[parameters.length];
		System.arraycopy(parameters, 0, this.parameters, 0, parameters.length);
		this.parameters[0]=null;
	}
	
	
}








