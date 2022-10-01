package com.doublechaintech.retailscm.configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class DBConfiguration {

  public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate template) {
    return new NamedParameterJdbcTemplate(template);
  }
}
