package com.doublechaintech.retailscm.expression;

import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypedValue;

public class DynamicPropertyAccessor implements PropertyAccessor {

  @Override
  public Class<?>[] getSpecificTargetClasses() {
    return null;
  }

  @Override
  public boolean canRead(EvaluationContext context, Object target, String name)
      throws AccessException {
    return findMethod(target, name) != null;
  }

  @Override
  public TypedValue read(EvaluationContext context, Object target, String name)
      throws AccessException {
    try {
      DynamicPropertyRegistry.ObjectAndMethod v = findMethod(target, name);
      Object value = v.method.invoke(v.object, target);
      return new TypedValue(value);
    } catch (Exception pE) {
      pE.printStackTrace();
    }
    return null;
  }

  @Override
  public boolean canWrite(EvaluationContext context, Object target, String name)
      throws AccessException {
    return false;
  }

  @Override
  public void write(EvaluationContext context, Object target, String name, Object newValue)
      throws AccessException {}

  public DynamicPropertyRegistry.ObjectAndMethod findMethod(Object target, String name) {
    return DynamicPropertyRegistry.findMethod(target, name);
  }
}
