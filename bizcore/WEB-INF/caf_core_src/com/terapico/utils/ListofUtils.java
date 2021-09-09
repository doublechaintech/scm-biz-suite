package com.terapico.utils;

import java.util.List;
import java.util.Map;

import com.terapico.uccaf.CafEntity;

public class ListofUtils {
	
	public static List<? extends CafEntity> toShortList(List<? extends CafEntity> list,
			String beanName) {

		if (list == null) {
			return list;
		}

		List<? extends CafEntity> result = list.subList(0, Math.min(list.size(), 3));
		result.forEach(it -> {
			it.addItemToValueMap("linkToUrl", String.format("%sManager/wxappview/%s/", beanName, it.getId()));
		});

		return result;
		
	}

	public static Map buildSection(String id, String title, String brief, String icon, String viewGroup,
			String linkToUrl, String displayMode) {
		return MapUtil.put("id", id)
				.put("title", title)
				.put("brief", brief)
				.put("icon", icon)
				.put("viewGroup", viewGroup)
				.put("linkToUrl", linkToUrl)
				.put("displayMode", displayMode)
				.into_map();
	}

}
