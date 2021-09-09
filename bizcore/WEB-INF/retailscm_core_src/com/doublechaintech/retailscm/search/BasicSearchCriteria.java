package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.DBUtil;
import com.terapico.utils.TextUtil;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BasicSearchCriteria implements Serializable, SearchCriteria {
  private BaseEntity holder;
  private String property;
  private Object value; // 数据
  private QueryOperator operator; // 操作符

  public BasicSearchCriteria(BaseEntity holder, String property, QueryOperator operator) {
    this.holder = holder;
    this.property = property;
    this.operator = operator;
  }

  public BasicSearchCriteria(
      BaseEntity holder, String property, Object value, QueryOperator operator) {
    this.holder = holder;
    this.property = property;
    this.value = value;
    this.operator = operator;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public QueryOperator getOperator() {
    return operator;
  }

  public void setOperator(QueryOperator operator) {
    this.operator = operator;
  }

  @Override
   public String prepareParameterAndSql(Map<String, Object> parameters) {

      String parameterName = DBUtil.alias(holder) + TextUtil.capFirstChar(property);
      parameterName = refineParameterName(parameters, parameterName);
      StringBuilder sb = new StringBuilder("(");
      sb.append(DBUtil.getColumnRefer(holder, property)).append(operator.getOperator());
      if (operator.hasParameter()) {
        if (!operator.containsOperator()) {
          sb.append(operator.getPrefix());
        }
        sb.append(":").append(parameterName);
        if (!operator.containsOperator()) {
          sb.append(operator.getSuffix());
        }
        Object value = cleanValue(getValue());
        if (value == null) {
          return "";
        }
        parameters.put(parameterName, value);
      }
      sb.append(")");
      return sb.toString();
    }

    private Object cleanValue(Object value) {
      if (value == null) {
        return null;
      }
      List<Object> listValues = new ArrayList<>();
      if (value.getClass().isArray()) {
        int len = Array.getLength(value);
        for (int i = 0; i < len; i++) {
          Object ele = Array.get(value, i);
          addValue(listValues, ele);
        }
      } else if (value instanceof Collection) {
        for (Object ele : (Collection) value) {
          addValue(listValues, ele);
        }
      } else {
        addValue(listValues, value);
      }

      if (listValues.isEmpty()) {
        return null;
      }
      if (getOperator().hasArrayParameter()) {
        return listValues;
      } else {
        if (getOperator().containsOperator()) {
          return getOperator().getPrefix() + listValues.get(0) + getOperator().getSuffix();
        }
        return listValues.get(0);
      }
    }

    protected void addValue(List<Object> listValues, Object ele) {
      if (ele instanceof BaseEntity) {
        listValues.add(((BaseEntity) ele).getId());
      } else {
        listValues.add(ele);
      }
    }

    public BaseEntity getHolder() {
      return holder;
    }

    public void setHolder(BaseEntity holder) {
      this.holder = holder;
    }

    public String getProperty() {
      return property;
    }

    public void setProperty(String property) {
      this.property = property;
    }
}


