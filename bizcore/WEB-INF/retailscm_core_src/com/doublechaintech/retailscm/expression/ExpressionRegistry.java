package com.doublechaintech.retailscm.expression;

import com.doublechaintech.retailscm.utils.BeanUtils;
import org.springframework.expression.Expression;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExpressionRegistry {
  static Map<String, Expression> expressionDefinition = new ConcurrentHashMap<>();

  public static void registerExpression(String name, String definition) {
    expressionDefinition.put(name, BeanUtils.getExpression(definition));
  }

  public static Expression getExpression(String name) {
    return expressionDefinition.get(name);
  }

  public static void clear() {
    expressionDefinition.clear();
  }
}
