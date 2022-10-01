package com.doublechaintech.retailscm;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.*;
import javax.sql.DataSource;
import java.util.*;

public class CustomNamedParameterJdbcTemplate extends NamedParameterJdbcTemplate {
  public CustomNamedParameterJdbcTemplate(JdbcOperations classicJdbcTemplate) {
    super(classicJdbcTemplate);
  }

  public CustomNamedParameterJdbcTemplate(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public <T> List<T> query(String sql, Map<String, ?> paramMap, RowMapper<T> rowMapper)
      throws DataAccessException {
    SqlParameterSource source = new MapSqlParameterSource(paramMap);
    List<T> result = super.query(sql, source, rowMapper);
    SQLLogger.logNamedSQL(sql, paramMap, result);
    return result;
  }
}
