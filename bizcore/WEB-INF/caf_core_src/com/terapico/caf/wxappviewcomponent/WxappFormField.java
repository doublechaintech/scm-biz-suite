package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public abstract class WxappFormField<T> extends BaseWxappViewComponent<T>{
	
	protected String name;
	protected String title;
	protected String placeholder;
	protected String value;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeHolder) {
		this.placeholder = placeHolder;
	}
	public T withName(String name) {
		this.setName(name);
		return (T)this;
	}
	public T withTitle(String title) {
		this.setTitle(title);
		return (T)this;
	}
	public T withPlaceHolder(String placeholder) {
		this.setPlaceholder(placeholder);
		return (T)this;
	}
	public T withValue(String value) {
		this.setValue(value);
		return (T)this;
	}
	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		putInMap(resultMap, "name", name);
		putInMap(resultMap, "title", title);
		putInMap(resultMap, "placeholder", placeholder);
		putInMap(resultMap, "value", value);
	}

}
