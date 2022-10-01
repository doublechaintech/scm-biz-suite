package com.doublechaintech.retailscm.interviewtype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class InterviewTypeExpression<T> implements Expression<T, InterviewType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InterviewTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T interviewType) {
        InterviewType parent = InterviewTypeExpression.this.eval(interviewType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InterviewTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T interviewType) {
        InterviewType parent = InterviewTypeExpression.this.eval(interviewType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InterviewTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T interviewType) {
        InterviewType parent = InterviewTypeExpression.this.eval(interviewType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, String> getDetailDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InterviewTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T interviewType) {
        InterviewType parent = InterviewTypeExpression.this.eval(interviewType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDetailDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return InterviewTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T interviewType) {
        InterviewType parent = InterviewTypeExpression.this.eval(interviewType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getCompany() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return InterviewTypeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T interviewType) {
        InterviewType parent = InterviewTypeExpression.this.eval(interviewType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewSmartListExpression<T>
      getEmployeeInterviewList() {
    return new com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return InterviewTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeInterview> eval(T interviewType) {
        InterviewType parent = InterviewTypeExpression.this.eval(interviewType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeInterviewList();
      }
    };
  }
}
