package com.terapico.meta;

import cn.hutool.core.util.ClassUtil;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntityMeta extends BaseMeta<EntityMeta> {
  private Map<String, PropertyMeta> properties = new LinkedHashMap<>();

  public EntityMeta(String pEntity) {
    with("name", pEntity);
  }

  public PropertyMeta property(String name) {
    properties.putIfAbsent(name, new PropertyMeta(name));
    return properties.get(name);
  }

  public Class getType() {
    return ClassUtil.loadClass((String) get("name"));
  }

  public Map<String, PropertyMeta> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, PropertyMeta> pProperties) {
    properties = pProperties;
  }

  public boolean isConstant() {
    return getList("tokens", Collections.emptyList()).contains("CONSTANT");
  }
}
