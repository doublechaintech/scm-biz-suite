package com.terapico.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

import com.terapico.caf.viewcomponent.ButtonViewComponent;


public class CollectionUtils {
	public static boolean isEmpty(Collection collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		for (Object obj : collection) {
			if (obj == null) {
				continue;
			}
			if (obj instanceof String && TextUtil.isBlank((String) obj)) {
				continue;
			}
			// any other object, such as boolean, a list, a map... all be "not empty"
			return false;
		}
		return true;
	}

	public static <T> Set<T> toSet(T... objs) {
		if (objs == null || objs.length == 0) {
			return null;
		}
		HashSet<T> set = new HashSet<T>();
		set.addAll(Arrays.asList(objs));
		return set;
	}

	@SafeVarargs
    @SuppressWarnings("varargs")
	public static <T> List<T> toList(T... objs) {
		if (objs == null || objs.length == 0) {
			return new ArrayList<>();
		}
		List<T> list = new ArrayList<>();
		list.addAll(Arrays.asList(objs));
		return list;
	}

	public static <T> void addItem(ArrayList<T> list, int idx, T value) {
		while(list.size() <= idx) {
			list.add(null);
		}
		list.set(idx, value);
	}

	public static <T> void addItemToFreeSlot(ArrayList<T> list, T value) {
		for(int i=0;i<list.size();i++) {
			if (list.get(i) == null) {
				list.set(i, value);
				return;
			}
		}
		list.add(value);
	}

	public static <T extends Object> void addToList(List<T> params, T ... values) {
		if (values == null || values.length == 0) {
			return;
		}
		Stream.of(values).forEach(it->{
			params.add(it);
		});
	}

	public static List<? extends Object>  shortList(List<? extends Object> list, int maxLength) {
		if (list == null || list.size() <= maxLength || maxLength <= 1) {
			return list;
		}
		while(list.size() > maxLength) {
			list.remove(list.size() - 1);
		}
		return list;
	}

	public static <T extends Object> String getKeyOfMaxValue(Map<String, T> cntMap, Comparator<T> comparator) {
		if (cntMap == null || cntMap.isEmpty()) {
			return null;
		}
		T curValue = null;
		String maxKey = null;
		Iterator<Entry<String, T>> it = cntMap.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, T> ety = it.next();
			String key = ety.getKey();
			T value = ety.getValue();
			if (curValue == null) {
				curValue = value;
				maxKey = key;
				continue;
			}
			if (comparator.compare(curValue, value) < 0) {
				curValue = value;
				maxKey = key;
			}
		}

		return maxKey;
	}

	public static <T extends Number> String getKeyOfFirstNotEmpty(Map<String, T> cntMap, List<String> keyList) {
		if (cntMap == null || cntMap.isEmpty()) {
			return null;
		}
		T curValue = null;
		for(String key: keyList) {
			T value = cntMap.get(key);
			if (value == null) {
				continue;
			}
			if (value.intValue() > 0) {
				return key;
			}
		}
		return keyList.get(0);
	}

	public static Map<String, ButtonViewComponent> toMap(List<ButtonViewComponent> actions) {
		if (actions == null || actions.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, ButtonViewComponent> result = new HashMap<>();
		for(ButtonViewComponent action : actions) {
			result.put(action.getTag(), action);
		}
		return result;
	}
	
	public static <T> T first(Collection<T> collection) {
		if (collection == null || collection.isEmpty()) {
			return null;
		}
		return collection.iterator().next();
	}
}
