package com.doublechaintech.retailscm.search;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface SearchCriteria extends Cloneable {
  String prepareParameterAndSql(Map<String, Object> parameters);

  default String refineParameterName(Map<String, Object> parameters, String parameterName) {
    while (parameters.containsKey(parameterName)) {
      parameterName = increaseKey(parameterName);
    }
    return parameterName;
  }

  default String increaseKey(String key) {
    char c = key.charAt(key.length() - 1);
    if (!Character.isDigit(c)) {
      return key + "0";
    } else {
      // 基本可用
      return key.substring(0, key.length() - 1) + (char) (c + 1);
    }
  }

  static SearchCriteria and(SearchCriteria... sub) {
    return new AndCriteria(sub);
  }

  static SearchCriteria or(SearchCriteria... sub) {
    return new OrCriteria(sub);
  }

  static SearchCriteria not(SearchCriteria sub) {
    return new NotCriteria(sub);
  }

  class AndCriteria implements SearchCriteria {
    SearchCriteria[] subs;

    public AndCriteria(SearchCriteria[] subs) {
      this.subs = subs;
    }

    @Override
    public String prepareParameterAndSql(Map<String, Object> parameters) {
      if (subs == null) {
        throw new RuntimeException("AndCriteria 至少需要一个条件");
      }

      if (subs.length == 1) {
        return subs[0].prepareParameterAndSql(parameters);
      }

      List<String> sqls = new ArrayList<>();
      for (SearchCriteria sub : subs) {
        String s = sub.prepareParameterAndSql(parameters);
        if (s.equalsIgnoreCase("true") || s.equals("1")) {
          continue;
        }
        if (s.equalsIgnoreCase("false") || s.equals("0")) {
          return "false";
        }
        sqls.add(s);
      }
      return sqls.stream()
          .filter(StrUtil::isNotEmpty)
          .collect(Collectors.joining(" AND ", "(", ")"));
    }
  }

  class OrCriteria implements SearchCriteria {
    SearchCriteria[] subs;

    public OrCriteria(SearchCriteria[] subs) {
      this.subs = subs;
    }

    @Override
    public String prepareParameterAndSql(Map<String, Object> parameters) {
      if (subs == null) {
        throw new RuntimeException("OrCriteria 至少需要一个条件");
      }

      if (subs.length == 1) {
        return subs[0].prepareParameterAndSql(parameters);
      }

      List<String> sqls = new ArrayList<>();
      for (SearchCriteria sub : subs) {
        String s = sub.prepareParameterAndSql(parameters);
        if (s.equalsIgnoreCase("true") || s.equals("1")) {
          return "true";
        }
        if (s.equalsIgnoreCase("false") || s.equals("0")) {
          continue;
        }
        sqls.add(s);
      }

      return sqls.stream()
          .filter(StrUtil::isNotEmpty)
          .collect(Collectors.joining(" or ", "(", ")"));
    }
  }

  class NotCriteria implements SearchCriteria {
    SearchCriteria inner;

    public NotCriteria(SearchCriteria inner) {
      this.inner = inner;
    }

    @Override
    public String prepareParameterAndSql(Map<String, Object> parameters) {
      String s = inner.prepareParameterAndSql(parameters);
      if (s.equalsIgnoreCase("true") || s.equals("1")) {
        return "false";
      }
      if (s.equalsIgnoreCase("false") || s.equals("0")) {
        return "true";
      }
      return String.format("(not(%s))", inner.prepareParameterAndSql(parameters));
    }
  }
}
