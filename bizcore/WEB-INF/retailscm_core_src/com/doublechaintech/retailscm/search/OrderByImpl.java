package com.doublechaintech.retailscm.search;

import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.DBUtil;

public class OrderByImpl implements OrderBy {
  BaseEntity example;
  String property;
  boolean asc;

  public OrderByImpl(BaseEntity example, String property, boolean asc) {
    this.example = example;
    this.property = property;
    this.asc = asc;
  }

  public String toSql() {
    return DBUtil.getColumnRefer(example, property) + " " + (asc ? "asc" : "desc");
  }
}
