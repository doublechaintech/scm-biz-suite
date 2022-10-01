package com.doublechaintech.retailscm.search;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AggregationResult {
  private String name;
  private List<AggregationItem> data;

  public String getName() {
    return name;
  }

  public void setName(String pName) {
    name = pName;
  }

  public List<AggregationItem> getData() {
    return data;
  }

  public void setData(List<AggregationItem> pData) {
    data = pData;
  }

  public Map<String, Number> toSimpleMap() {
    Map<String, Number> map = new LinkedHashMap<>();
    if (data != null) {
      for (AggregationItem datum : data) {
        Map<String, String> dimensions = datum.getDimensions();
        Map<String, Object> values = datum.getValues();
        if (cn.hutool.core.util.ObjectUtil.isEmpty(dimensions)
            || cn.hutool.core.util.ObjectUtil.isEmpty(values)) {
          continue;
        }

        String key = dimensions.values().iterator().next();
        Number value = (Number) values.values().iterator().next();
        map.put(key, value);
      }
    }
    return map;
  }

  public Number toSimpleValue() {
    if (data != null) {
      for (AggregationItem datum : data) {
        Map<String, Object> values = datum.getValues();
        if (cn.hutool.core.util.ObjectUtil.isEmpty(values)) {
          continue;
        }
        return (Number) values.values().iterator().next();
      }
    }
    return 0L;
  }
}
