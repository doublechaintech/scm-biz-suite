package com.doublechaintech.retailscm.search;

import cn.hutool.core.util.StrUtil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AggregationItemMapper implements RowMapper<AggregationItem> {
  @Override
  public AggregationItem mapRow(ResultSet rs, int rowNum) throws SQLException {
    int columnCount = rs.getMetaData().getColumnCount();
    AggregationItem ret = new AggregationItem();
    for (int i = 0; i < columnCount; i++) {
      String columnLabel = rs.getMetaData().getColumnLabel(i + 1);
      if (columnLabel.startsWith("_")) {
        ret.addValue(columnLabel.substring(1), rs.getObject(columnLabel));
      } else {
        ret.addDimension(StrUtil.toCamelCase(columnLabel), rs.getString(columnLabel));
      }
    }
    return ret;
  }
}
