package com.terapico.utils;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
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

	public static <K,V extends Comparable<V>> List<K> sortWithValue(Map<K, V> keyValueMap, boolean asc) {
		if (keyValueMap == null || keyValueMap.isEmpty()) {
			return new ArrayList<>();
		}
		List<Entry<K, V>> list = keyValueMap.entrySet().stream().collect(Collectors.toList());
		Collections.sort(list, new Comparator<Entry<K, V>>() {
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				if (o1.getValue() == o2.getValue()) {
					return 0;
				}
				if (asc) {
					if (o1.getValue() == null) {
						return -1;
					}
					if (o2.getValue() == null) {
						return 1;
					}
					return o1.getValue().compareTo(o2.getValue());
				}else {
					if (o1.getValue() == null) {
						return 1;
					}
					if (o2.getValue() == null) {
						return -1;
					}
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		return list.stream().map(it->it.getKey()).collect(Collectors.toList());
	}
}
