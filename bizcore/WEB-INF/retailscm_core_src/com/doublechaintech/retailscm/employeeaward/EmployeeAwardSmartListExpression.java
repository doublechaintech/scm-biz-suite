package com.doublechaintech.retailscm.employeeaward;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeAwardSmartListExpression<T>
    extends SmartListExpression<T, EmployeeAward> {
  public EmployeeAwardExpression<T> first() {
    return new EmployeeAwardExpression<T>() {
      @Override
      public EmployeeAward eval(T l) {
        List<EmployeeAward> list = EmployeeAwardSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeAwardSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeAwardExpression<T> get(int index) {
    return new EmployeeAwardExpression<T>() {
      @Override
      public EmployeeAward eval(T l) {
        List<EmployeeAward> list = EmployeeAwardSmartListExpression.this.eval(l);
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
        return EmployeeAwardSmartListExpression.this.$getRoot();
      }
    };
  }
}
