package com.doublechaintech.retailscm;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Beans implements ApplicationContextAware {
  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
  }

  public static DBUtil dbUtil() {
    if (context != null) {
      return context.getBean(DBUtil.class);
    }
    return null;
  }

  public static org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
      namedParameterJdbcTemplate() {
    return getBean("namedParameterJdbcTemplate");
  }

  public static <T> T getBean(String name) {
    if (context != null) {
      return (T) context.getBean(name);
    }
    return null;
  }

  public static <T> T getBean(Class<T> type) {
    if (context != null) {
      return context.getBean(type);
    }
    return null;
  }
}
