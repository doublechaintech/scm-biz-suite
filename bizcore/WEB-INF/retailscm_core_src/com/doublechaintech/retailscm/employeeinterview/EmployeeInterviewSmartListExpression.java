package com.doublechaintech.retailscm.employeeinterview;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeInterviewSmartListExpression<T>
    extends SmartListExpression<T, EmployeeInterview> {
  public EmployeeInterviewExpression<T> first() {
    return new EmployeeInterviewExpression<T>() {
      @Override
      public EmployeeInterview eval(T l) {
        List<EmployeeInterview> list = EmployeeInterviewSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeInterviewSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeInterviewExpression<T> get(int index) {
    return new EmployeeInterviewExpression<T>() {
      @Override
      public EmployeeInterview eval(T l) {
        List<EmployeeInterview> list = EmployeeInterviewSmartListExpression.this.eval(l);
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
        return EmployeeInterviewSmartListExpression.this.$getRoot();
      }
    };
  }
}
