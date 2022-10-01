package com.doublechaintech.retailscm.search;

import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregation {
  private String name;
  private List<String> groupColumns = new ArrayList<>();
  private List<String> aggColumns = new ArrayList<>();
  private List<String> groupSelects = new ArrayList<>();
  private Map<String, AggFunc> aggNameFunc = new HashMap<>();
  private boolean isEmpty = true;

  private List<AggregationInfo> aggregationDetail = new ArrayList<>();
  private List<GroupByInfo> groupByDetail = new ArrayList<>();

  public void aggregate(String ret, AggFunc fun, String... properties) {
    if (ArrayUtil.isEmpty(properties)) {
      return;
    }
    aggNameFunc.put(ret, fun);
    aggColumn(fun.toSql(ret, properties));
    aggregationDetail.add(new AggregationInfo(ret, fun, properties));
  }

  private void aggColumn(String columnName) {
    if (!aggColumns.contains(columnName)) {
      aggColumns.add(columnName);
      isEmpty = false;
    }
  }

  public void groupBy(String ret, SqlFunction fun, String... properties) {
    String columnName = fun.toSql(ret, properties);
    if (!groupColumns.contains(ret)) {
      groupSelects.add(columnName);
      groupColumns.add(ret);
    }
    groupByDetail.add(new GroupByInfo(ret, fun, properties));
  }

  public List<String> getGroupColumns() {
    return groupColumns;
  }

  public List<String> getGroupSelects() {
    return groupSelects;
  }

  public void setGroupColumns(List<String> pGroupColumns) {
    groupColumns = pGroupColumns;
  }

  public List<String> getAggColumns() {
    return aggColumns;
  }

  public void setAggColumns(List<String> pAggColumns) {
    aggColumns = pAggColumns;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  public List<String> getAggSelects() {
    List<String> aggSelects = new ArrayList<>(getAggColumns());
    aggSelects.addAll(getGroupSelects());
    return aggSelects;
  }

  public String getName() {
    return name;
  }

  public void setName(String pName) {
    name = pName;
  }

  public AggFunc getFunc(String retName) {
    return aggNameFunc.get(retName);
  }

  public List<AggregationInfo> getAggregationDetail() {
    return aggregationDetail;
  }

  public void setAggregationDetail(List<AggregationInfo> pAggregationDetail) {
    aggregationDetail = pAggregationDetail;
  }

  public List<GroupByInfo> getGroupByDetail() {
    return groupByDetail;
  }

  public void setGroupByDetail(List<GroupByInfo> pGroupByDetail) {
    groupByDetail = pGroupByDetail;
  }

  public static class AggregationInfo {
    private String ret;
    private AggFunc fun;
    private String[] properties;

    public AggregationInfo(String ret, AggFunc fun, String... properties) {
      this.ret = ret;
      this.fun = fun;
      this.properties = properties;
    }

    public String getRet() {
      return ret;
    }

    public void setRet(String pRet) {
      ret = pRet;
    }

    public AggFunc getFun() {
      return fun;
    }

    public void setFun(AggFunc pFun) {
      fun = pFun;
    }

    public String[] getProperties() {
      return properties;
    }

    public void setProperties(String[] pProperties) {
      properties = pProperties;
    }
  }

  public static class GroupByInfo {
    private String ret;
    private SqlFunction fun;
    private String[] properties;

    public GroupByInfo(String ret, SqlFunction fun, String... properties) {
      this.ret = ret;
      this.fun = fun;
      this.properties = properties;
    }

    public String getRet() {
      return ret;
    }

    public void setRet(String pRet) {
      ret = pRet;
    }

    public SqlFunction getFun() {
      return fun;
    }

    public void setFun(SqlFunction pFun) {
      fun = pFun;
    }

    public String[] getProperties() {
      return properties;
    }

    public void setProperties(String[] pProperties) {
      properties = pProperties;
    }
  }
}
