package com.doublechaintech.retailscm.iamservice;

public class LoginChannel {
	protected String serviceBeanName;
	protected String serviceMethodName;
	protected String clientName;
	
	
	
	public String getServiceBeanName() {
		return serviceBeanName;
	}

	public void setServiceBeanName(String serviceBeanName) {
		this.serviceBeanName = serviceBeanName;
	}

	public String getServiceMethodName() {
		return serviceMethodName;
	}

	public void setServiceMethodName(String serviceMethodName) {
		this.serviceMethodName = serviceMethodName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/** 获取当前登陆channel的key */
	public String getKey() {
		return String.format("%s/%s/%s", getClientName(), getServiceBeanName(), getServiceMethodName());
	}

	public static LoginChannel of(String clientName, String beanName, String methodName) {
		LoginChannel rst = new LoginChannel();
		rst.setClientName(clientName);
		rst.setServiceBeanName(beanName);
		rst.setServiceMethodName(methodName);
		return rst;
	}

}
















