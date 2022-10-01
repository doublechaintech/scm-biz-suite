package com.doublechaintech.retailscm.employeeleave;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.leavetype.LeaveType;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeLeaveExpression<T> implements Expression<T, EmployeeLeave> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeLeaveExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeLeave) {
        EmployeeLeave parent = EmployeeLeaveExpression.this.eval(employeeLeave);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, Integer> getLeaveDurationHour() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return EmployeeLeaveExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeLeave) {
        EmployeeLeave parent = EmployeeLeaveExpression.this.eval(employeeLeave);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLeaveDurationHour();
      }
    };
  }

  public Expression<T, String> getRemark() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeLeaveExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeLeave) {
        EmployeeLeave parent = EmployeeLeaveExpression.this.eval(employeeLeave);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRemark();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return EmployeeLeaveExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeLeave) {
        EmployeeLeave parent = EmployeeLeaveExpression.this.eval(employeeLeave);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeExpression<T> getWho() {
    return new com.doublechaintech.retailscm.employee.EmployeeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeLeaveExpression.this.$getRoot();
      }

      public Employee eval(T employeeLeave) {
        EmployeeLeave parent = EmployeeLeaveExpression.this.eval(employeeLeave);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWho();
      }
    };
  }

  public com.doublechaintech.retailscm.leavetype.LeaveTypeExpression<T> getType() {
    return new com.doublechaintech.retailscm.leavetype.LeaveTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeLeaveExpression.this.$getRoot();
      }

      public LeaveType eval(T employeeLeave) {
        EmployeeLeave parent = EmployeeLeaveExpression.this.eval(employeeLeave);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getType();
      }
    };
  }
}
