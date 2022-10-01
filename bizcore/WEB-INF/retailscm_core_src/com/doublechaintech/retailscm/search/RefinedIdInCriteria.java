package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.Beans;

import cn.hutool.core.util.StrUtil;
import com.terapico.utils.TextUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RefinedIdInCriteria<T extends BaseEntity> implements SearchCriteria {
  private BaseRequest<T> mDependsOn;
  private String mProperty;
  private String mLocalProperty;
  private IDRefine<T> mIdRefine;

  public RefinedIdInCriteria(
      BaseRequest<T> pDependsOn, String pProperty, IDRefine<T> pIdRefine, String localProperty) {
    mDependsOn = pDependsOn;
    mProperty = pProperty;
    mIdRefine = pIdRefine;
    mLocalProperty = localProperty;
  }

  @Override
  public String prepareParameterAndSql(Map<String, Object> parameters) {
    String columnName = TextUtil.propertyToColumnName(mProperty);
    if (isLocalModel(mDependsOn)) {
      return String.format(
          "%s IN (%s)", columnName, prepareParameterAndSql(parameters, mDependsOn, mLocalProperty));
    }

    List<T> results = Searcher.search(parameters.get("userContext"), mDependsOn);
    Set<String> refineIds = results.stream().map(mIdRefine::refineId).collect(Collectors.toSet());
    String parameterName = refineParameterName(parameters, mProperty);
    if (refineIds == null || refineIds.isEmpty()) {
      return "false";
    } else if (refineIds.size() == 1) {
      parameters.put(parameterName, refineIds.iterator().next());
      return String.format("(%s = :%s)", columnName, parameterName);
    } else {
      parameters.put(parameterName, refineIds);
      return String.format("(%s IN (:%s))", columnName, parameterName);
    }
  }

  private Object prepareParameterAndSql(
      Map<String, Object> pParameters, BaseRequest<T> pRequest, String localProperty) {
    String sql =
        String.format(
            "SELECT %s FROM %s",
            TextUtil.propertyToColumnName(localProperty), SqlBuilder.tableName(pRequest));
    String condition = SqlBuilder.prepareParametersAndCondition(pRequest, pParameters);

    if (!StrUtil.isEmpty(condition)) {
      sql = sql + String.format(" WHERE %s ", condition);
    }
    SimpleOrderBy orderBy = pRequest.getOrderBy();
    String orderBySql = orderBy.toSql();
    if (orderBySql != null) {
      sql = sql + " " + orderBySql;
    }

    if (pRequest.hasLimit()) {
      sql = sql + String.format(" LIMIT %d,%d ", pRequest.getOffset(), pRequest.getSize());
    }
    return sql;
  }

  private boolean isLocalModel(BaseRequest<T> pDependsOn) {
    String model = pDependsOn.getModel();
    if (model == null) {
      model = Beans.getBean(SearchConfiguration.class).getModel();
    }
    return SearchConfiguration.MODEL_LOCAL.equals(model);
  }
}
