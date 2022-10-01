package com.doublechaintech.retailscm.search;

import com.terapico.utils.TextUtil;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleOrderBy implements OrderBy {

  private Map<String, Boolean> properties = new LinkedHashMap<>();

  @Override
  public String toSql() {
    if (properties.isEmpty()) {
      return null;
    }
    return properties.entrySet().stream()
        .map(
            e ->
                String.format(
                    "%s %s",
                    TextUtil.propertyToColumnName(e.getKey()), e.getValue() ? "asc" : "desc"))
        .collect(Collectors.joining(",", "order by ", ""));
  }

  public void addOrderBy(String property, boolean asc) {
    properties.putIfAbsent(property, asc);
  }
}
