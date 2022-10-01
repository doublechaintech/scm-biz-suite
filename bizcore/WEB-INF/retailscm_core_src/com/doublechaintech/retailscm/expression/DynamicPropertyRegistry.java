package com.doublechaintech.retailscm.expression;

import com.doublechaintech.retailscm.utils.BeanUtils;
import org.springframework.expression.Expression;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicPropertyRegistry {
  static Map<Class, Set<Object>> propertyProvidersRegistry = new ConcurrentHashMap<>();
  static Map<String, ObjectAndMethod> cache = new ConcurrentReferenceHashMap<>();

  public static void registryPropertyProvider(Class clazz, Object dynamicPropertyProvider) {
    propertyProvidersRegistry.putIfAbsent(clazz, new LinkedHashSet<>());
    Set<Object> objects = propertyProvidersRegistry.get(clazz);
    objects.add(dynamicPropertyProvider);
  }

  public static ObjectAndMethod findMethod(Object o, String name) {
    Class<?> aClass = o.getClass();
    return findMethodByClass(aClass, name);
  }

  public static ObjectAndMethod findMethodByClass(Class<?> aClass, String name) {

    String cacheKey = aClass.getName() + ":" + name;
    ObjectAndMethod cacheV = cache.get(cacheKey);
    if (cacheV != null) {
      if (cacheV == ObjectAndMethod.NULL) {
        return null;
      }
      return cacheV;
    }

    while (aClass != null) {

      Expression expression = ExpressionRegistry.getExpression(aClass.getSimpleName() + ":" + name);
      if (expression != null) {
        ObjectAndMethod objectAndMethod =
            new ObjectAndMethod(
                new ExpressionObjectAndMethod(expression),
                ExpressionObjectAndMethod.EXPRESSION_METHOD);
        cache.put(cacheKey, objectAndMethod);
        return objectAndMethod;
      }

      Set<Object> objects = propertyProvidersRegistry.get(aClass);
      if (objects != null) {
        for (Object object : objects) {
          Method method;
          if (object instanceof Class) {
            method = ReflectionUtils.findMethod((Class<?>) object, name, aClass);
          } else {
            method = ReflectionUtils.findMethod(object.getClass(), name, aClass);
          }

          if (method == null) {
            continue;
          }

          if (Modifier.isStatic(method.getModifiers())) {
            ObjectAndMethod objectAndMethod = new ObjectAndMethod(null, method);
            cache.put(cacheKey, objectAndMethod);
            return objectAndMethod;
          } else if (object instanceof Class) {
            try {
              ObjectAndMethod objectAndMethod =
                  new ObjectAndMethod(((Class<?>) object).newInstance(), method);
              cache.put(cacheKey, objectAndMethod);
              return objectAndMethod;
            } catch (Exception pE) {
              pE.printStackTrace();
            }
          }
          ObjectAndMethod objectAndMethod = new ObjectAndMethod(object, method);
          cache.put(cacheKey, objectAndMethod);
          return objectAndMethod;
        }
      }
      aClass = aClass.getSuperclass();
    }
    cache.put(cacheKey, ObjectAndMethod.NULL);
    return null;
  }

  static class ObjectAndMethod {
    Object object;
    Method method;
    static ObjectAndMethod NULL = new ObjectAndMethod(null, null);

    public ObjectAndMethod(Object pObject, Method pMethod) {
      object = pObject;
      method = pMethod;
    }

    public Object getObject() {
      return object;
    }

    public void setObject(Object pObject) {
      object = pObject;
    }

    public Method getMethod() {
      return method;
    }

    public void setMethod(Method pMethod) {
      method = pMethod;
    }
  }

  static class ExpressionObjectAndMethod {
    Expression expression;

    public ExpressionObjectAndMethod(Expression pExpression) {
      expression = pExpression;
    }

    static Method EXPRESSION_METHOD =
        ReflectionUtils.findMethod(ExpressionObjectAndMethod.class, "eval", Object.class);

    public Object eval(Object ctx) {
      return BeanUtils.getPropertyValue(ctx, expression);
    }
  }
}
