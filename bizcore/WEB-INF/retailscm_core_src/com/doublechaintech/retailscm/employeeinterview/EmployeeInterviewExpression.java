package com.doublechaintech.retailscm.employeeinterview;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.interviewtype.InterviewType;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeInterviewExpression<T> implements Expression<T, EmployeeInterview> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeInterviewExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeInterview) {
        EmployeeInterview parent = EmployeeInterviewExpression.this.eval(employeeInterview);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getRemark() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeInterviewExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeInterview) {
        EmployeeInterview parent = EmployeeInterviewExpression.this.eval(employeeInterview);
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
        return EmployeeInterviewExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeInterview) {
        EmployeeInterview parent = EmployeeInterviewExpression.this.eval(employeeInterview);
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
        return EmployeeInterviewExpression.this.$getRoot();
      }

      public Employee eval(T employeeInterview) {
        EmployeeInterview parent = EmployeeInterviewExpression.this.eval(employeeInterview);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }

  public com.doublechaintech.retailscm.interviewtype.InterviewTypeExpression<T> getInterviewType() {
    return new com.doublechaintech.retailscm.interviewtype.InterviewTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeInterviewExpression.this.$getRoot();
      }

      public InterviewType eval(T employeeInterview) {
        EmployeeInterview parent = EmployeeInterviewExpression.this.eval(employeeInterview);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getInterviewType();
      }
    };
  }
}
