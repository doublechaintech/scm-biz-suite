package com.terapico.caf.viewcomponent;

import java.util.HashMap;
import java.util.Map;

public class NavigationViewComponent extends BaseViewComponent {
	protected String brief;
	protected String code;
	protected String imageUrl;
	protected String title;
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public NavigationViewComponent() {
		super();
	}
	public NavigationViewComponent(String title, String code, String linkToUrl) {
		this(title, code, linkToUrl, null, null);
	}
	public NavigationViewComponent(String title, String code, String linkToUrl, String brief, String imageUrl) {
		super();
		this.brief = brief;
		this.code = code;
		this.imageUrl = imageUrl;
		this.title = title;
		this.linkToUrl = linkToUrl;
	}
	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> result = super.toMap();
		result.remove("nodeHashcode");
		result.remove("pathHashcode");
		result.remove("statInPage");
		result.remove("visiable");
		result.remove("beContaniner");
		
		return result;
	}
	
	
	
}
