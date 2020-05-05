package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappFlex extends BaseWxappViewComponent<WxappFlex>{
	
	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		// nothing special need to do
	}

	public WxappFlex horizontal() {
		this.withClassName("flex-row");
		return this;
	}
	public WxappFlex vertical() {
		this.withClassName("flex-column");
		return this;
	}
	
	@Override
	public String getType() {
		return "flex";
	}
}
