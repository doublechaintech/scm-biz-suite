package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappForm extends BaseWxappViewComponent<WxappForm>{
	
	protected String formKey;
	
	public String getFormKey() {
		return formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}

	public WxappForm withFormKey(String fKey) {
		this.setFormKey(fKey);
		return this;
	}
	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		putInMap(resultMap, "formKey", formKey);
	}

	@Override
	public String getType() {
		return "form";
	}
}
