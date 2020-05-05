package com.terapico.caf.wxappviewcomponent;

import java.util.Map;

public class WxappImage extends BaseWxappViewComponent<WxappImage>{
	

	protected String imageUrl;

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public WxappImage withImageUrl(String imgUrl) {
		this.setImageUrl(imgUrl);
		return this;
	}

	@Override
	protected void mapFieldsToMap(Map<String, Object> resultMap) {
		putInMap(resultMap, "imageUrl", imageUrl);
	}

	@Override
	public String getType() {
		return "image";
	}
}
