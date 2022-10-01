package com.doublechaintech.retailscm.search;

import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.util.NumberUtil;
import com.terapico.utils.TextUtil;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AggFunc implements SqlFunction {
  COUNT("count", "count(%s) as %s"),
  MAX("max", "max(%s) as %s"),
  MIN("min", "min(%s) as %s"),
  SUM("sum", "sum(%s) as %s");

  private String name;
  private String template;

  AggFunc(String name, String template) {
    this.name = name;
    this.template = template;
  }

  public String getName() {
    return name;
  }

  public void setName(String pName) {
    name = pName;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String pTemplate) {
    template = pTemplate;
  }

  @Override
  public String toSql(String retName, String... properties) {
    return String.format(
        getTemplate(),
        Stream.of(properties).map(TextUtil::propertyToColumnName).collect(Collectors.joining(",")),
        "_" + retName);
  }

  public String simpleSql(String... properties) {
    switch (this) {
      case COUNT:
        return "count(1)";
      case MIN:
        return String.format("min(%s)", properties[0]);
      case MAX:
        return String.format("max(%s)", properties[0]);
      case SUM:
        return String.format("sum(%s)", properties[0]);
    }
    throw new com.doublechaintech.retailscm.ErrorMessageException("尚未实现");
  }

  public Object merge(Object v1, Object v2) {
    switch (this) {
      case MAX:
        return CompareUtil.compare(v1, v2, false) > 0 ? v1 : v2;
      case MIN:
        return CompareUtil.compare(v1, v2, false) > 0 ? v2 : v1;
      default:
        return NumberUtil.add((Number) v1, (Number) v2);
    }
  }
}
