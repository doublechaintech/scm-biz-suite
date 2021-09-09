package com.terapico.caf.baseelement;

public class LabFunctionEntrance {
	protected String callbackUrl;
	protected String sendVCodeUrl;
	
	
	public String getSendVCodeUrl() {
		return sendVCodeUrl;
	}

	public void setSendVCodeUrl(String sendVCodeUrl) {
		this.sendVCodeUrl = sendVCodeUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

}
