package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappTextareaField extends WxappFormField<WxappTextareaField>{
	protected Integer maxLength;
	protected Integer minLength;
	
	
	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}
	
	public WxappTextareaField withMaxLength(Integer len) {
		this.setMaxLength(len);
		return this;
	}
	public WxappTextareaField withMinLength(Integer len) {
		this.setMinLength(len);
		return this;
	}

	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		super.mapFieldsToMap(resultMap);
		putInMap(resultMap, "maxLength", maxLength);
	}

	@Override
	public String getType() {
		return "textarea";
	}

}
