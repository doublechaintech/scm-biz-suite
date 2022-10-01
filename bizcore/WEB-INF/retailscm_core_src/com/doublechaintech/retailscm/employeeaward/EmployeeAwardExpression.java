package com.doublechaintech.retailscm.employeeaward;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeAwardExpression<T> implements Expression<T, EmployeeAward> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeAwardExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeAward) {
        EmployeeAward parent = EmployeeAwardExpression.this.eval(employeeAward);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getCompleteTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return EmployeeAwardExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employeeAward) {
        EmployeeAward parent = EmployeeAwardExpression.this.eval(employeeAward);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompleteTime();
      }
    };
  }

  public Expression<T, String> getType() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeAwardExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeAward) {
        EmployeeAward parent = EmployeeAwardExpression.this.eval(employeeAward);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getType();
      }
    };
  }

  public Expression<T, String> getRemark() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeAwardExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeAward) {
        EmployeeAward parent = EmployeeAwardExpression.this.eval(employeeAward);
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
        return EmployeeAwardExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeAward) {
        EmployeeAward parent = EmployeeAwardExpression.this.eval(employeeAward);
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
        return EmployeeAwardExpression.this.$getRoot();
      }

      public Employee eval(T employeeAward) {
        EmployeeAward parent = EmployeeAwardExpression.this.eval(employeeAward);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }
}
