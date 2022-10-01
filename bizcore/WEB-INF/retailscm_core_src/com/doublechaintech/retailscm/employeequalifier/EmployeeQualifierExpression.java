package com.doublechaintech.retailscm.employeequalifier;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeQualifierExpression<T> implements Expression<T, EmployeeQualifier> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeQualifierExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeQualifier) {
        EmployeeQualifier parent = EmployeeQualifierExpression.this.eval(employeeQualifier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getQualifiedTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return EmployeeQualifierExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employeeQualifier) {
        EmployeeQualifier parent = EmployeeQualifierExpression.this.eval(employeeQualifier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getQualifiedTime();
      }
    };
  }

  public Expression<T, String> getType() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeQualifierExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeQualifier) {
        EmployeeQualifier parent = EmployeeQualifierExpression.this.eval(employeeQualifier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getType();
      }
    };
  }

  public Expression<T, String> getLevel() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeQualifierExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeQualifier) {
        EmployeeQualifier parent = EmployeeQualifierExpression.this.eval(employeeQualifier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLevel();
      }
    };
  }

  public Expression<T, String> getRemark() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeQualifierExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeQualifier) {
        EmployeeQualifier parent = EmployeeQualifierExpression.this.eval(employeeQualifier);
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
        return EmployeeQualifierExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeQualifier) {
        EmployeeQualifier parent = EmployeeQualifierExpression.this.eval(employeeQualifier);
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
        return EmployeeQualifierExpression.this.$getRoot();
      }

      public Employee eval(T employeeQualifier) {
        EmployeeQualifier parent = EmployeeQualifierExpression.this.eval(employeeQualifier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }
}
