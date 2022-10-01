package com.doublechaintech.retailscm.employeeattendance;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeAttendanceExpression<T> implements Expression<T, EmployeeAttendance> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeAttendanceExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeAttendance) {
        EmployeeAttendance parent = EmployeeAttendanceExpression.this.eval(employeeAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getEnterTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return EmployeeAttendanceExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employeeAttendance) {
        EmployeeAttendance parent = EmployeeAttendanceExpression.this.eval(employeeAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEnterTime();
      }
    };
  }

  public Expression<T, DateTime> getLeaveTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return EmployeeAttendanceExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employeeAttendance) {
        EmployeeAttendance parent = EmployeeAttendanceExpression.this.eval(employeeAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLeaveTime();
      }
    };
  }

  public Expression<T, Integer> getDurationHours() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return EmployeeAttendanceExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeAttendance) {
        EmployeeAttendance parent = EmployeeAttendanceExpression.this.eval(employeeAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDurationHours();
      }
    };
  }

  public Expression<T, String> getRemark() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeAttendanceExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeAttendance) {
        EmployeeAttendance parent = EmployeeAttendanceExpression.this.eval(employeeAttendance);
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
        return EmployeeAttendanceExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeAttendance) {
        EmployeeAttendance parent = EmployeeAttendanceExpression.this.eval(employeeAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeExpression<T> getEmployee() {
    return new com.doublechaintech.retailscm.employee.EmployeeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeAttendanceExpression.this.$getRoot();
      }

      public Employee eval(T employeeAttendance) {
        EmployeeAttendance parent = EmployeeAttendanceExpression.this.eval(employeeAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }
}
