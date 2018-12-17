package com.terapico.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


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
}
