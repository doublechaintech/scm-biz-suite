package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.Beans;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.terapico.utils.TextUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AggregationCriteria implements SearchCriteria {
  public static final String ID = "id";
  private BaseRequest subRequest;
  private String parentProperty;
  private QueryOperator queryOperator;
  private Object value;

  public AggregationCriteria(
      BaseRequest pSubRequest,
      String pParentProperty,
      QueryOperator pQueryOperator,
      Object pValue) {
    subRequest = pSubRequest;
    parentProperty = pParentProperty;
    queryOperator = pQueryOperator;
    value = pValue;
  }

  @Override
  public String prepareParameterAndSql(Map<String, Object> parameters) {
    if (isLocalModel(subRequest)) {
      String subSql = createSubSql(subRequest, parentProperty, queryOperator, value, parameters);
      return String.format("%s IN (%s)", ID, subSql);
    }

    parameters = new HashMap<>();
    String subSql = createSubSql(subRequest, parentProperty, queryOperator, value, parameters);
    List<String> refineIds =
        Beans.namedParameterJdbcTemplate().queryForList(subSql, parameters, String.class);

    String parameterName = refineParameterName(parameters, ID);
    if (refineIds == null || refineIds.isEmpty()) {
      return "false";
    } else if (refineIds.size() == 1) {
      parameters.put(parameterName, refineIds.iterator().next());
      return String.format("(%s = :%s)", ID, parameterName);
    } else {
      parameters.put(parameterName, refineIds);
      return String.format("(%s IN (:%s))", ID, parameterName);
    }
  }

  private String createSubSql(
      BaseRequest subRequest,
      String parentProperty,
      QueryOperator queryOperator,
      Object value,
      Map<String, Object> parameters) {
    Aggregation aggregation = subRequest.getAggregation();
    String aggregationExpression = "COUNT(1)";
    if (!aggregation.isEmpty()) {
      Aggregation.AggregationInfo aggregationInfo =
          CollectionUtil.getFirst(aggregation.getAggregationDetail());
      AggFunc fun = aggregationInfo.getFun();
      aggregationExpression = fun.simpleSql(aggregationInfo.getProperties());
    }

    String where = SqlBuilder.prepareParametersAndCondition(subRequest, parameters);
    String parentColumn = TextUtil.propertyToColumnName(parentProperty);
    String sql =
        String.format("SELECT %s\n\t\t FROM %s", parentColumn, SqlBuilder.tableName(subRequest));

    // where
    if (!ObjectUtil.isEmpty(where)) {
      sql = sql + " WHERE " + where;
    }

    // group by
    sql = sql + "\n\t\t GROUP BY " + parentColumn;

    String count = refineParameterName(parameters, "count");

    // having
    sql =
        sql + "\n\t\t HAVING " + aggregationExpression + queryOperator.getOperator() + ":" + count;
    parameters.put(count, value);
    return sql;
  }

  private boolean isLocalModel(BaseRequest pDependsOn) {
    String model = pDependsOn.getModel();
    if (model == null) {
      model = Beans.getBean(SearchConfiguration.class).getModel();
    }
    return SearchConfiguration.MODEL_LOCAL.equals(model);
  }
}
