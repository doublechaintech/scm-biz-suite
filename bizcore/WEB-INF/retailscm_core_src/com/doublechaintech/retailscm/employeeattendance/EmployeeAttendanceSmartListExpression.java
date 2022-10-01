package com.doublechaintech.retailscm.employeeattendance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeAttendanceSmartListExpression<T>
    extends SmartListExpression<T, EmployeeAttendance> {
  public EmployeeAttendanceExpression<T> first() {
    return new EmployeeAttendanceExpression<T>() {
      @Override
      public EmployeeAttendance eval(T l) {
        List<EmployeeAttendance> list = EmployeeAttendanceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeAttendanceSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeAttendanceExpression<T> get(int index) {
    return new EmployeeAttendanceExpression<T>() {
      @Override
      public EmployeeAttendance eval(T l) {
        List<EmployeeAttendance> list = EmployeeAttendanceSmartListExpression.this.eval(l);
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
        return EmployeeAttendanceSmartListExpression.this.$getRoot();
      }
    };
  }
}
