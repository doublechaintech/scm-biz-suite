package com.terapico.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapUtil {
	public static class MapBuilder {
		private Map<String, Object> mapInstance= null;
		public MapBuilder put(String key, Object value) {
			ensuerMapInstance();
			mapInstance.put(key, value);
			return this;
		}
		private void ensuerMapInstance() {
			if (mapInstance == null) {
				mapInstance = new HashMap<String, Object>();
			}
		}
		public Map<String, Object> into_map() {
			ensuerMapInstance();
			return mapInstance;
		}
		
	}
	public static class _MapEntryUtil{
		String key;
		Object value;
	}
	public static Object getByPath(Map<String, ? extends Object> dataMap, String keyPath){
		if (keyPath == null){
			return dataMap.get(keyPath);
		}
		String[] keyTokens = keyPath.split("\\.");
		int idx = 0;
		return getByPathOf(dataMap, keyTokens, idx);
	}

	public static Object getByPathOf(Map<String, ? extends Object> dataMap, String[] keyTokens, int idx) {
		if (dataMap == null){
			return null;
		}
		if (idx >= keyTokens.length){
			return null;
		}
		Object objData = getByToken(dataMap, keyTokens[idx]);
		if (idx == keyTokens.length - 1){
			return objData;
		}
		if (!(objData instanceof Map)){
			return null;
		}
		return getByPathOf((Map<String, Object>) objData, keyTokens, idx+1);
	}

	protected static final Pattern ptnListToken = Pattern.compile("([a-zA-Z0-9_$#]+)\\[(\\d+)\\]");
	protected static Object getByToken(Map<String, ? extends Object> dataMap, String token) {
		Matcher m = ptnListToken.matcher(token);
		if (m.matches()){
			String name = m.group(1);
			int idx = Integer.parseInt( m.group(2));
			Object listData = dataMap.get(name);
			if (listData == null){
				return null;
			}
			if (listData.getClass().isArray()){
				Object[] array = (Object[]) listData;
				if (idx >= array.length){
					return null;
				}
				return array[idx];
			}
			if (listData instanceof List){
				List list = (List) listData;
				if (idx >= list.size()){
					return null;
				}
				return list.get(idx);
			}
		}
		return dataMap.get(token);
	}
	
	@Deprecated
	/**
	 * 被 MapUtil.put(k,v).put(k,v)....put(k,v).into_map(); 取代
	 */
	public static _MapEntryUtil $(String key, Object value) {
		_MapEntryUtil result = new _MapEntryUtil();
		result.key = key;
		result.value = value;
		return result;
	}
	
	@Deprecated
	/**
	 * 被 MapUtil.put(k,v).put(k,v)....put(k,v).into_map(); 取代
	 */
	public static Map<String, Object> newMap(_MapEntryUtil ...entries){
		Map<String, Object> map = new HashMap<String, Object>();
		if (entries != null && entries.length > 0) {
			for(_MapEntryUtil entry : entries) {
				map.put(entry.key, entry.value);
			}
		}
		return map;
	}

	public static MapBuilder put(String key, Object value) {
		return new MapBuilder().put(key, value);
	}
}
