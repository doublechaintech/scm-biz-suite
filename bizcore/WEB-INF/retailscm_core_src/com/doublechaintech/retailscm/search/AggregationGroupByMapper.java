package com.doublechaintech.retailscm.search;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AggregationGroupByMapper implements RowMapper<Map<String, String>> {
  @Override
  public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
    Map<String, String> ret = new HashMap<>();
    int columnCount = rs.getMetaData().getColumnCount();
    for (int i = 0; i < columnCount; i++) {
      String columnLabel = rs.getMetaData().getColumnLabel(i + 1);
      ret.put(columnLabel, rs.getString(columnLabel));
    }
    return ret;
  }
}
