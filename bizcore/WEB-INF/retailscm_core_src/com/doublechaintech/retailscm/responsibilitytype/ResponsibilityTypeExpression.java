package com.doublechaintech.retailscm.responsibilitytype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ResponsibilityTypeExpression<T> implements Expression<T, ResponsibilityType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ResponsibilityTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T responsibilityType) {
        ResponsibilityType parent = ResponsibilityTypeExpression.this.eval(responsibilityType);
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
        return ResponsibilityTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T responsibilityType) {
        ResponsibilityType parent = ResponsibilityTypeExpression.this.eval(responsibilityType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getBaseDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ResponsibilityTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T responsibilityType) {
        ResponsibilityType parent = ResponsibilityTypeExpression.this.eval(responsibilityType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBaseDescription();
      }
    };
  }

  public Expression<T, String> getDetailDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ResponsibilityTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T responsibilityType) {
        ResponsibilityType parent = ResponsibilityTypeExpression.this.eval(responsibilityType);
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
        return ResponsibilityTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T responsibilityType) {
        ResponsibilityType parent = ResponsibilityTypeExpression.this.eval(responsibilityType);
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
        return ResponsibilityTypeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T responsibilityType) {
        ResponsibilityType parent = ResponsibilityTypeExpression.this.eval(responsibilityType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T> getEmployeeList() {
    return new com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return ResponsibilityTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Employee> eval(T responsibilityType) {
        ResponsibilityType parent = ResponsibilityTypeExpression.this.eval(responsibilityType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeList();
      }
    };
  }
}
