package com.doublechaintech.retailscm.search;

import com.terapico.utils.TextUtil;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface SqlFunction {
  SqlFunction SELF =
      (retName, properties) -> {
        String joinProperty =
            Stream.of(properties)
                .map(TextUtil::propertyToColumnName)
                .collect(Collectors.joining(""));
        return String.format("%s as %s", joinProperty, retName);
      };

  SqlFunction DATE =
      (retName, properties) -> {
        String joinProperty =
            Stream.of(properties)
                .map(TextUtil::propertyToColumnName)
                .map(s -> "date_format(" + s + ", '%Y-%m-%d')")
                .collect(Collectors.joining(""));
        return String.format("%s as %s", joinProperty, retName);
      };

  SqlFunction MONTH =
      (retName, properties) -> {
        String joinProperty =
            Stream.of(properties)
                .map(TextUtil::propertyToColumnName)
                .map(s -> "date_format(" + s + ", '%Y-%m')")
                .collect(Collectors.joining(""));
        return String.format("%s as %s", joinProperty, retName);
      };
  SqlFunction YEAR =
      (retName, properties) -> {
        String joinProperty =
            Stream.of(properties)
                .map(TextUtil::propertyToColumnName)
                .map(s -> "date_format(" + s + ", '%Y')")
                .collect(Collectors.joining(""));
        return String.format("%s as %s", joinProperty, retName);
      };

  SqlFunction SHORT_DATE_SLASH =
      (retName, properties) -> {
        String joinProperty =
            Stream.of(properties)
                .map(TextUtil::propertyToColumnName)
                .map(s -> "date_format(" + s + ", '%m/%d')")
                .collect(Collectors.joining(""));
        return String.format("%s as %s", joinProperty, retName);
      };

  String toSql(String retName, String... properties);
}
