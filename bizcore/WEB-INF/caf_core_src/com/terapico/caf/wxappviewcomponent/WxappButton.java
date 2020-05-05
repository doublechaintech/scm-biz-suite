package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappButton extends BaseWxappViewComponent<WxappButton>{
	
	protected String btnType = "submit";
	protected String title;
	
	public String getBtnType() {
		return btnType;
	}
	public void setBtnType(String btnType) {
		this.btnType = btnType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public WxappButton withBtnType(String type) {
		this.setBtnType(type);
		return this;
	}
	public WxappButton withTitle(String title) {
		this.setTitle(title);
		return this;
	}

	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		putInMap(resultMap, "btnType", btnType);
		putInMap(resultMap, "title", title);
	}

	@Override
	public String getType() {
		return "button";
	}
}
