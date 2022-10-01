package com.doublechaintech.retailscm.employeeperformance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeePerformanceSmartListExpression<T>
    extends SmartListExpression<T, EmployeePerformance> {
  public EmployeePerformanceExpression<T> first() {
    return new EmployeePerformanceExpression<T>() {
      @Override
      public EmployeePerformance eval(T l) {
        List<EmployeePerformance> list = EmployeePerformanceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeePerformanceSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeePerformanceExpression<T> get(int index) {
    return new EmployeePerformanceExpression<T>() {
      @Override
      public EmployeePerformance eval(T l) {
        List<EmployeePerformance> list = EmployeePerformanceSmartListExpression.this.eval(l);
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
        return EmployeePerformanceSmartListExpression.this.$getRoot();
      }
    };
  }
}
