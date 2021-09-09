package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappText extends BaseWxappViewComponent<WxappText>{
	protected String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public WxappText withText(String text) {
		this.setText(text);
		return this;
	}

	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		putInMap(resultMap, "text", text);
	}

	@Override
	public String getType() {
		return "text";
	}
	
}
