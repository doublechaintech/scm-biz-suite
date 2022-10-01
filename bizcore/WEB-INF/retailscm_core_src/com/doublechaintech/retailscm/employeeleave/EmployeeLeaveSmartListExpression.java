package com.doublechaintech.retailscm.employeeleave;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeLeaveSmartListExpression<T>
    extends SmartListExpression<T, EmployeeLeave> {
  public EmployeeLeaveExpression<T> first() {
    return new EmployeeLeaveExpression<T>() {
      @Override
      public EmployeeLeave eval(T l) {
        List<EmployeeLeave> list = EmployeeLeaveSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeLeaveSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeLeaveExpression<T> get(int index) {
    return new EmployeeLeaveExpression<T>() {
      @Override
      public EmployeeLeave eval(T l) {
        List<EmployeeLeave> list = EmployeeLeaveSmartListExpression.this.eval(l);
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
        return EmployeeLeaveSmartListExpression.this.$getRoot();
      }
    };
  }
}
