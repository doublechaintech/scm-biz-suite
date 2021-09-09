package com.terapico.meta;

import cn.hutool.core.collection.CollectionUtil;

import java.util.*;

public class BaseMeta<T> extends HashMap<String, Object> {
  public T with(String key, Object value) {
    put(key, value);
    return (T) this;
  }

  public T append(String key, Object value) {
    List o = (List) get(key);
    if (o == null) {
      o = new ArrayList();
      put(key, o);
    }
    o.add(value);
    return (T) this;
  }

  public boolean getBoolean(String key, boolean defaultValue) {
    Object o = get(key);
    if (o != null) {
      return Boolean.valueOf((String) o);
    }
    return defaultValue;
  }

  public String getStr(String key, String defaultValue) {
    Object o = get(key);
    if (o != null) {
      return String.valueOf(o);
    }
    return defaultValue;
  }

  public List<String> getList(String key, List<String> defaultValue) {
    Object o = get(key);
    if (o instanceof List) {
      return (List<String>) o;
    }
    if (o instanceof String) {
      String[] values = ((String) o).split(",");
      return CollectionUtil.newArrayList(values);
    }
    return defaultValue;
  }

  public Set<String> getFeatures() {
    Object featureSet = get("featureSet");
    if (featureSet == null) {
      featureSet = new HashSet<>(getList("features", Collections.emptyList()));
      put("featureSet", featureSet);
    }
    return (Set<String>) featureSet;
  }
}
