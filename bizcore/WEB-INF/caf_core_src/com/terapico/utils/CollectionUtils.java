package com.terapico.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;


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

	public static void addToList(List<Object> params, Object ... values) {
		if (values == null || values.length == 0) {
			return;
		}
		Stream.of(values).forEach(it->{
			params.add(it);
		});
	}

	public static void shortList(List<? extends Object> list, int maxLength) {
		if (list == null || list.size() <= maxLength || maxLength <= 1) {
			return;
		}
		while(list.size() > maxLength) {
			list.remove(list.size() - 1);
		}
		
	}
}
