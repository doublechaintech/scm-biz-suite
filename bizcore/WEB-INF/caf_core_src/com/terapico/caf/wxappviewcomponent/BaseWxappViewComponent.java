package com.terapico.caf.wxappviewcomponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.terapico.caf.viewcomponent.BaseViewComponent;

public abstract class BaseWxappViewComponent<T> extends BaseViewComponent{
	protected String id;
	protected Map<String, Boolean> className;
	protected List<BaseWxappViewComponent> kids;
	protected Map<String, Object> customStyle;
	protected Object flex;
	protected String linkToUrl;
	
	public Map<String, Object> getCustomStyle() {
		return customStyle;
	}

	
	public Object getFlex() {
		return flex;
	}


	public void setFlex(Object flex) {
		this.flex = flex;
	}


	public String getLinkToUrl() {
		return linkToUrl;
	}


	public void setLinkToUrl(String linkToUrl) {
		this.linkToUrl = linkToUrl;
	}


	public void setCustomStyle(Map<String, Object> customStyle) {
		this.customStyle = customStyle;
	}


	public List<BaseWxappViewComponent> getKids() {
		return kids;
	}


	public void setKids(List<BaseWxappViewComponent> kids) {
		this.kids = kids;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Boolean> getClassName() {
		return className;
	}
	public void setClassName(Map<String, Boolean> className) {
		this.className = className;
	}
	
	public T withId(String id) {
		this.setId(id);
		return (T) this;
	}
	public T withClassName(String clazzName) {
		ensureClassName();
		this.className.put(clazzName, true);
		return (T) this;
	}
	public T withCustomStyle(String name, Object value) {
		ensuerCustomStyle();
		customStyle.put(name, value);
		return (T) this;
	}
	public T withFlex(Object value) {
		this.setFlex(value);
		return (T) this;
	}
	protected void ensuerCustomStyle() {
		if (customStyle == null) {
			customStyle = new HashMap<>();
		}
	}


	public <U> T kid(BaseWxappViewComponent<U> kid) {
		ensureKids();
		kids.add(kid);
		if (kid.getId() == null) {
			kid.setId(String.format("%s-%04d", kid.getType(), kids.size()));
		}
		return (T) this;
	}
	
	protected void ensureKids() {
		if (kids == null) {
			kids = new ArrayList<>();
		}
	}


	protected void ensureClassName() {
		if (className == null) {
			className = new HashMap<>();
		}
	}

	@Override
	public Map<String, Object> toMap(){
		Map<String, Object> resultMap = new HashMap<>();
		putInMap(resultMap, "id", getId());
		putInMap(resultMap, "className", getClassName());
		putInMap(resultMap, "linkToUrl", getLinkToUrl());
		putInMap(resultMap, "type", getType());
		putInMap(resultMap, "flex", getFlex());
		putInMap(resultMap, "customStyle", getCustomStyle());
		mapFieldsToMap(resultMap);
		if (kids != null) {
			List<Map<String, Object>> kidsList = new ArrayList<>(kids.size());
			for(BaseWxappViewComponent<?> kid: kids) {
				Map<String, Object> kidMap = kid.toMap();
				kidsList.add(kidMap);
			}
			putInMap(resultMap, "kids", kidsList);
		}
		return resultMap;
	}


	public abstract String getType();
	protected abstract void mapFieldsToMap(Map<String, Object> resultMap) ;


	protected void putInMap(Map<String, Object> resultMap, String name, Object value) {
		if (value == null) {
			return;
		}
		if (value instanceof Collection) {
			if (((Collection) value).isEmpty()) {
				return;
			}
		}
		if (value instanceof Map) {
			if (((Map) value).isEmpty()) {
				return;
			}
		}
		resultMap.put(name, value);
	}


	public T flexFull() {
		this.withClassName("flex-full");
		return (T)this;
	}
	public T flexRowCenter() {
		this.withClassName("flex-row-center");
		return (T)this;
	}
	public T flexColumnCenter() {
		this.withClassName("flex-column-center");
		return (T)this;
	}
	
	
}
