package com.doublechaintech.retailscm.employeeeducation;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeEducationExpression<T> implements Expression<T, EmployeeEducation> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeEducationExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeEducation) {
        EmployeeEducation parent = EmployeeEducationExpression.this.eval(employeeEducation);
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
        return EmployeeEducationExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employeeEducation) {
        EmployeeEducation parent = EmployeeEducationExpression.this.eval(employeeEducation);
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
        return EmployeeEducationExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeEducation) {
        EmployeeEducation parent = EmployeeEducationExpression.this.eval(employeeEducation);
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
        return EmployeeEducationExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeEducation) {
        EmployeeEducation parent = EmployeeEducationExpression.this.eval(employeeEducation);
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
        return EmployeeEducationExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeEducation) {
        EmployeeEducation parent = EmployeeEducationExpression.this.eval(employeeEducation);
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
        return EmployeeEducationExpression.this.$getRoot();
      }

      public Employee eval(T employeeEducation) {
        EmployeeEducation parent = EmployeeEducationExpression.this.eval(employeeEducation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }
}
