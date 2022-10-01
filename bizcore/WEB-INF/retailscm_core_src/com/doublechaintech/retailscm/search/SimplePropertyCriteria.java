package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.BaseEntity;
import com.terapico.utils.TextUtil;

import java.lang.reflect.Array;
import java.util.*;

public class SimplePropertyCriteria implements SearchCriteria {
  private String mProperty;
  private QueryOperator mQueryOperator;
  private Object mValue;

  public SimplePropertyCriteria(String property, QueryOperator pQueryOperator, Object pValue) {
    mProperty = property;
    mQueryOperator = pQueryOperator;
    mValue = pValue;
  }

  public boolean isVersionPropertyCriteria() {
    return "version".equals(mProperty);
  }

  public String prepareParameterAndSql(Map<String, Object> parameters) {
    if (mQueryOperator == QueryOperator.BETWEEN) {
      return prepareParameterAndSqlForBetween(parameters);
    }
    StringBuilder sb = new StringBuilder("(");
    sb.append(TextUtil.propertyToColumnName(mProperty)).append(mQueryOperator.getOperator());
    String parameterName = refineParameterName(parameters, mProperty);
    if (mQueryOperator.hasParameter()) {
      if (!mQueryOperator.containsOperator()) {
        sb.append(mQueryOperator.getPrefix());
      }
      sb.append(":").append(parameterName);
      if (!mQueryOperator.containsOperator()) {
        sb.append(mQueryOperator.getSuffix());
      }
      Object value = cleanValue(mValue);
      if (value == null) {
        return "";
      }
      parameters.put(parameterName, value);
    }
    sb.append(")");
    return sb.toString();
  }

  private String prepareParameterAndSqlForBetween(Map<String, Object> parameters) {
    StringBuilder sb = new StringBuilder("(");
    sb.append(TextUtil.propertyToColumnName(mProperty)).append(mQueryOperator.getOperator());
    LinkedHashSet value = (LinkedHashSet) cleanValue(mValue);

    if (value.size() == 0) {
      throw new IllegalArgumentException("between needs two parameters");
    }
    Iterator iterator = value.iterator();
    Object value1 = iterator.next();
    String parameterName1 = refineParameterName(parameters, mProperty);
    sb.append(":").append(parameterName1);
    parameters.put(parameterName1, value1);
    String parameterName2 = refineParameterName(parameters, mProperty);
    sb.append(" AND :").append(parameterName2);
    sb.append(")");
    if (value.size() == 1) {
      // 只有一个参数或者两个参数相同
      parameters.put(parameterName2, value1);
      return sb.toString();
    }
    parameters.put(parameterName2, iterator.next());
    return sb.toString();
  }

  private Object cleanValue(Object value) {
    if (value == null) {
      return null;
    }
    Set<Object> listValues = new LinkedHashSet<>();
    addValue(listValues, value);
    if (listValues.isEmpty()) {
      return null;
    }
    if (mQueryOperator.hasArrayParameter()) {
      return listValues;
    } else {
      if (mQueryOperator.containsOperator()) {
        return mQueryOperator.getPrefix()
            + listValues.iterator().next()
            + mQueryOperator.getSuffix();
      }
      return listValues.iterator().next();
    }
  }

  protected void addValue(Set<Object> listValues, Object value) {
    if (value == null) {
      return;
    }
    if (value.getClass().isArray()) {
      int len = Array.getLength(value);
      for (int i = 0; i < len; i++) {
        Object ele = Array.get(value, i);
        addValue(listValues, ele);
      }
    } else if (value instanceof Iterable) {
      addValue(listValues, ((Iterable<?>) value).iterator());
    } else if (value instanceof Iterator) {
      while (((Iterator<?>) value).hasNext()) {
        addValue(listValues, ((Iterator<?>) value).next());
      }
    } else if (value instanceof BaseEntity) {
      listValues.add(((BaseEntity) value).getId());
    } else {
      listValues.add(value);
    }
  }
}
