package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappInputField extends WxappFormField<WxappInputField>{
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
	
	public WxappInputField withMaxLength(Integer len) {
		this.setMaxLength(len);
		return this;
	}
	public WxappInputField withMinLength(Integer len) {
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
		return "input";
	}

}
