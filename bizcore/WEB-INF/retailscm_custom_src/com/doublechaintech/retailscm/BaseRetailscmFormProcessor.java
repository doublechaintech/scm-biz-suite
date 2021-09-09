package com.doublechaintech.retailscm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseRetailscmFormProcessor extends BaseFormProcessor{
	protected RetailscmUserContext userContext;
	
	public RetailscmUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(RetailscmUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(RetailscmException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(RetailscmUserContext userContext) {
		return null; 
	}
}


























