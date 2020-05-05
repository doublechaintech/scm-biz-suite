package com.terapico.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageUtil {
	protected static Map<String, List<String>> SAMPLE_ROOM = new HashMap<>();
	protected static String DEFAULT_AVANTAR = "https://doublechain.oss-cn-hangzhou.aliyuncs.com/chainqa/avatar.png";
	static {
		SAMPLE_ROOM.put("animal_small", Arrays.asList(
				
				));
		SAMPLE_ROOM.put("girl_small", Arrays.asList(
				
				));
		SAMPLE_ROOM.put("boy_small", Arrays.asList(
				
				));
		SAMPLE_ROOM.put("plant_small", Arrays.asList(
				
				));
		SAMPLE_ROOM.put("scenery_small", Arrays.asList(
				
				));
	}
	
	public static String animal() {
		return getImageFromSampleRoom("animal");
	}
	public static String boy() {
		return getImageFromSampleRoom("boy");
	}
	public static String girl() {
		return getImageFromSampleRoom("girl");
	}
	public static String plant() {
		return getImageFromSampleRoom("plant");
	}
	public static String scenery() {
		return getImageFromSampleRoom("scenery");
	}
	protected static String getImageFromSampleRoom(String style) {
		return getImageFromSampleRoom(style, "small");
	}
	protected static String getImageFromSampleRoom(String style, String size) {
		List<String> list = SAMPLE_ROOM.get(style+"_"+size);
		if (list == null || list.isEmpty()) {
			return DEFAULT_AVANTAR;
		}
		
		return list.get(RandomUtil.getRandomInRange(0, list.size()));
	}
	
}
