package com.terapico.meta;

import cn.hutool.core.util.ClassUtil;

public class PropertyMeta extends BaseMeta<PropertyMeta> {

  public PropertyMeta(String pName) {
    with("name", pName);
  }

  public boolean isObj() {
    return get("parentType") != null;
  }

  public Class getParentType() {
    if (!isObj()) {
      return null;
    }
    return ClassUtil.loadClass(getStr("parentType", null));
  }

  public boolean isStr() {
    return getFeatures().contains("string");
  }

  public boolean isBoolean() {
    return getFeatures().contains("bool");
  }

  public boolean isDate() {
    return getFeatures().contains("date_time");
  }

  public boolean isInt() {
    return getFeatures().contains("int");
  }

  public boolean isLong() {
    return getFeatures().contains("long");
  }

  public boolean isDouble() {
    return getFeatures().contains("double");
  }

  public boolean isConstant() {
    return getFeatures().contains("status");
  }
}
