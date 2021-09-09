package com.doublechaintech.retailscm.utils;

import com.doublechaintech.retailscm.expression.*;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeanUtils {

    static Map<String, Expression> expressionMap = new ConcurrentHashMap<>();

    public static <T> T getPropertyValue(Class<T> type, Object o, String propertyPath) {
        Expression expression = getExpression(propertyPath);
        return getPropertyValue(type, o, expression);
    }

    public static <T> T getPropertyValue(Class<T> type, Object o, Expression expression) {
        StandardEvaluationContext context = new StandardEvaluationContext(o);
        context.addPropertyAccessor(new MapAccessor());
        context.addPropertyAccessor(new DynamicPropertyAccessor());
        context.addMethodResolver(new DynamicMapperOrFilter());
        return expression.getValue(context, type);
    }

    public static <T> T getPropertyValue(Object o, String propertyPath) {
        Expression expression = getExpression(propertyPath);
        return getPropertyValue(o, expression);
    }

    public static <T> T getPropertyValue(Object o, Expression expression) {
        StandardEvaluationContext context = new StandardEvaluationContext(o);
        context.addPropertyAccessor(new MapAccessor());
        context.addPropertyAccessor(new DynamicPropertyAccessor());
        context.addMethodResolver(new DynamicMapperOrFilter());
        return (T) expression.getValue(context);
    }

    public static Expression getExpression(String propertyPath) {
        if (expressionMap.containsKey(propertyPath)) {
            return expressionMap.get(propertyPath);
        }
        ExpressionParser parser = new SpelExpressionParser(new SpelParserConfiguration(true, true));
        Expression expression = parser.parseExpression(propertyPath);
        expressionMap.put(propertyPath, expression);
        return expression;
    }

    public static <T> T getPropertyValue(Object o, String propertyPath, T defaultValue) {
        T propertyValue = getPropertyValue(o, propertyPath);
        if (propertyValue == null) {
            return defaultValue;
        }
        return propertyValue;
    }

    public static void setPropertyValue(Object o, String propertyPath, Object value) {
        Expression expression = getExpression(propertyPath);
        StandardEvaluationContext context = new StandardEvaluationContext(o);
        context.addPropertyAccessor(new MapAccessor());
        expression.setValue(context, value);
    }

    public static void copy(Object from, Object to, String... properties) {
        if (properties == null) {
            return;
        }
        for (String property : properties) {
            setPropertyValue(to, property, getPropertyValue(from, property));
        }
    }
}


