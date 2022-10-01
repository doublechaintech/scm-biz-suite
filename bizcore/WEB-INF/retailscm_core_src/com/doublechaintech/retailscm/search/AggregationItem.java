package com.doublechaintech.retailscm.search;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AggregationItem {

  private Map<String, String> dimensions = new LinkedHashMap<>();;

  private Map<String, Object> values = new LinkedHashMap<>();

  public Map<String, String> getDimensions() {
    return dimensions;
  }

  public void setDimensions(Map<String, String> pDimensions) {
    dimensions = pDimensions;
  }

  public Map<String, Object> getValues() {
    return values;
  }

  public void setValues(Map<String, Object> pValues) {
    values = pValues;
  }

  public void addDimension(String property, String value) {
    dimensions.put(property, value);
  }

  public void addValue(String agg, Object value) {
    values.put(agg, value);
  }

  public String group(String propertyName) {
    return dimensions.get(propertyName);
  }
}
