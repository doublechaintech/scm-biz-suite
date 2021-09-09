package com.doublechaintech.retailscm.expression;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicMapperOrFilter implements MethodResolver {

  @Override
  public MethodExecutor resolve(
      EvaluationContext context,
      Object targetObject,
      String name,
      List<TypeDescriptor> argumentTypes)
      throws AccessException {
    if (targetObject == null) {
      return null;
    }

    if (argumentTypes != null && !argumentTypes.isEmpty()) {
      return null;
    }

    if (!isCollection(targetObject)) {
      DynamicPropertyRegistry.ObjectAndMethod stub =
          DynamicPropertyRegistry.findMethod(targetObject, name);
      if (stub == null) {
        return null;
      }
      return (context1, target, arguments) -> {
        try {
          return new TypedValue(stub.method.invoke(stub.object, target));
        } catch (Exception pE) {
          pE.printStackTrace();
        }
        return TypedValue.NULL;
      };
    }

    Class aClazz = inferClass(targetObject);
    DynamicPropertyRegistry.ObjectAndMethod methodByClass =
        DynamicPropertyRegistry.findMethodByClass(aClazz, name);
    if (methodByClass == null) {
      return null;
    }

    boolean filter =
        methodByClass.method.getReturnType() == Boolean.class
            || methodByClass.method.getReturnType() == Boolean.TYPE;
    List<Object> values = getValues(targetObject);
    return (context12, target, arguments) -> {
      List<Object> next = new ArrayList<>();
      for (Object v : values) {
        Object invokeV = null;
        try {
          invokeV = methodByClass.method.invoke(methodByClass.object, v);
        } catch (Exception pE) {
          pE.printStackTrace();
        }
        if (filter) {
          if (invokeV != null && (Boolean) invokeV) {
            next.add(v);
          }
        } else {
          next.add(invokeV);
        }
      }
      return new TypedValue(next);
    };
  }

  private Class inferClass(Object pTargetObject) {
    Class<?> aClass = pTargetObject.getClass();
    if (!isCollection(pTargetObject)) {
      return aClass;
    }
    if (aClass.isArray()) {
      return aClass.getComponentType();
    }

    if (((Collection) pTargetObject).isEmpty()) {
      return Object.class;
    }

    Object next = ((Collection<?>) pTargetObject).iterator().next();
    if (next == null) {
      return Object.class;
    }
    return next.getClass();
  }

  private boolean isCollection(Object pTargetObject) {
    Class<?> aClass = pTargetObject.getClass();
    if (aClass.isArray()) {
      return true;
    }
    if (Collection.class.isAssignableFrom(aClass)) {
      return true;
    }
    return false;
  }

  private List<Object> getValues(Object object) {
    List<Object> values = new ArrayList<>();
    Class<?> aClass = object.getClass();
    if (aClass.isArray()) {
      int length = Array.getLength(object);
      for (int i = 0; i < length; i++) {
        values.add(Array.get(object, i));
      }
    }
    if (Collection.class.isAssignableFrom(aClass)) {
      values.addAll((Collection) object);
    }
    return values;
  }
}

