package com.doublechaintech.retailscm.employee;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeSmartListExpression<T> extends SmartListExpression<T, Employee> {
  public EmployeeExpression<T> first() {
    return new EmployeeExpression<T>() {
      @Override
      public Employee eval(T l) {
        List<Employee> list = EmployeeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeExpression<T> get(int index) {
    return new EmployeeExpression<T>() {
      @Override
      public Employee eval(T l) {
        List<Employee> list = EmployeeSmartListExpression.this.eval(l);
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
        return EmployeeSmartListExpression.this.$getRoot();
      }
    };
  }
}
