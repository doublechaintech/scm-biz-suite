package com.doublechaintech.retailscm.employeeperformance;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeePerformanceExpression<T>
    implements Expression<T, EmployeePerformance> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeePerformanceExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeePerformance) {
        EmployeePerformance parent = EmployeePerformanceExpression.this.eval(employeePerformance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getPerformanceComment() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeePerformanceExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeePerformance) {
        EmployeePerformance parent = EmployeePerformanceExpression.this.eval(employeePerformance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPerformanceComment();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return EmployeePerformanceExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeePerformance) {
        EmployeePerformance parent = EmployeePerformanceExpression.this.eval(employeePerformance);
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
        return EmployeePerformanceExpression.this.$getRoot();
      }

      public Employee eval(T employeePerformance) {
        EmployeePerformance parent = EmployeePerformanceExpression.this.eval(employeePerformance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }
}
