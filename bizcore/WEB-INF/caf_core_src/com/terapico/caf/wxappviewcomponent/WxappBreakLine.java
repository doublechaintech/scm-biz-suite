package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappBreakLine extends BaseWxappViewComponent<WxappBreakLine>{
	
	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		// nothing special need to do
	}

	@Override
	public String getType() {
		return "break-line";
	}
}
