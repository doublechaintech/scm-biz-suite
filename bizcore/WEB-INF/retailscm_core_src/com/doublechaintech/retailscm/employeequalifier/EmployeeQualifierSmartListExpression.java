package com.doublechaintech.retailscm.employeequalifier;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeQualifierSmartListExpression<T>
    extends SmartListExpression<T, EmployeeQualifier> {
  public EmployeeQualifierExpression<T> first() {
    return new EmployeeQualifierExpression<T>() {
      @Override
      public EmployeeQualifier eval(T l) {
        List<EmployeeQualifier> list = EmployeeQualifierSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeQualifierSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeQualifierExpression<T> get(int index) {
    return new EmployeeQualifierExpression<T>() {
      @Override
      public EmployeeQualifier eval(T l) {
        List<EmployeeQualifier> list = EmployeeQualifierSmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return EmployeeQualifierSmartListExpression.this.$getRoot();
      }
    };
  }
}
