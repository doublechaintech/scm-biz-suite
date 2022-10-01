package com.doublechaintech.retailscm.search;

import cn.hutool.core.util.StrUtil;
import com.terapico.utils.TextUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import cn.hutool.core.util.ObjectUtil;

public class SqlBuilder {
  public static String baseSql(BaseRequest pRequest) {
    if (pRequest.getSelects().isEmpty()) {
      return null;
    }
    return String.format(
        "SELECT %s \n\t\tFROM %s",
        pRequest.getSelects().stream()
            .map(s -> TextUtil.propertyToColumnName((String) s))
            .collect(Collectors.joining(",")),
        tableName(pRequest));
  }

  public static String tableName(BaseRequest pRequest) {
    return StrUtil.toUnderlineCase(pRequest.getInternalType()).toLowerCase() + "_data";
  }

  public static String prepareFullDataSql(BaseRequest pRequest, String condition) {
    String partitionProperty = pRequest.getPartitionProperty();
    if (!ObjectUtil.isEmpty(partitionProperty) && pRequest.hasLimit()) {
      return prepareFullDataSqlForPartition(pRequest, condition);
    }
    String sql = baseSql(pRequest);
    if (sql == null) {
      return null;
    }
    if (!StrUtil.isEmpty(condition)) {
      sql = sql + String.format(" WHERE %s ", condition);
    }
    SimpleOrderBy orderBy = pRequest.getOrderBy();
    String orderBySql = orderBy.toSql();
    if (orderBySql != null) {
      sql = sql + " " + orderBySql;
    }

    if (pRequest.hasLimit()) {
      sql = sql + String.format(" LIMIT %d, %d ", pRequest.getOffset(), pRequest.getSize());
    }
    return sql;
  }

  private static String prepareFullDataSqlForPartition(BaseRequest request, String condition) {
    String partitionProperty = request.getPartitionProperty();
    SimpleOrderBy orderBy = request.getOrderBy();
    String orderBySql = orderBy.toSql();
    if (ObjectUtil.isEmpty(orderBySql)) {
      orderBySql = "ORDER BY ID ASC";
    }
    if (!ObjectUtil.isEmpty(condition)) {
      condition = "WHERE " + condition;
    } else {
      condition = "";
    }
    return StrUtil.format(
        "SELECT * FROM (SELECT {}, (row_number() over(partition by {} {})) as _rank from {} {}) as t where t._rank >= {} and t._rank < {}",
        request.getSelects().stream()
            .map(s -> TextUtil.propertyToColumnName((String) s))
            .collect(Collectors.joining(",")),
        TextUtil.propertyToColumnName(partitionProperty),
        orderBySql,
        tableName(request),
        condition,
        request.getOffset() + 1,
        request.getOffset() + request.getSize() + 1);
  }

  public static String prepareParametersAndCondition(
      BaseRequest pRequest, Map<String, Object> parameters) {
    List<SearchCriteria> searchCriteriaList = pRequest.getSearchCriteriaList();
    if (!searchCriteriaList.isEmpty()) {
      SearchCriteria criteria =
          SearchCriteria.and(
              searchCriteriaList.toArray(new SearchCriteria[searchCriteriaList.size()]));
      return criteria.prepareParameterAndSql(parameters);
    }
    return "";
  }
}
