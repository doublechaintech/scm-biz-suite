package com.doublechaintech.retailscm.provincecenterdepartment;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ProvinceCenterDepartmentExpression<T>
    implements Expression<T, ProvinceCenterDepartment> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T provinceCenterDepartment) {
        ProvinceCenterDepartment parent =
            ProvinceCenterDepartmentExpression.this.eval(provinceCenterDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T provinceCenterDepartment) {
        ProvinceCenterDepartment parent =
            ProvinceCenterDepartmentExpression.this.eval(provinceCenterDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, DateTime> getFounded() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T provinceCenterDepartment) {
        ProvinceCenterDepartment parent =
            ProvinceCenterDepartmentExpression.this.eval(provinceCenterDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFounded();
      }
    };
  }

  public Expression<T, String> getManager() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T provinceCenterDepartment) {
        ProvinceCenterDepartment parent =
            ProvinceCenterDepartmentExpression.this.eval(provinceCenterDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getManager();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T provinceCenterDepartment) {
        ProvinceCenterDepartment parent =
            ProvinceCenterDepartmentExpression.this.eval(provinceCenterDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreprovincecenter
              .RetailStoreProvinceCenterExpression<
          T>
      getProvinceCenter() {
    return new com.doublechaintech.retailscm.retailstoreprovincecenter
            .RetailStoreProvinceCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentExpression.this.$getRoot();
      }

      public RetailStoreProvinceCenter eval(T provinceCenterDepartment) {
        ProvinceCenterDepartment parent =
            ProvinceCenterDepartmentExpression.this.eval(provinceCenterDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProvinceCenter();
      }
    };
  }

  public com.doublechaintech.retailscm.provincecenteremployee
              .ProvinceCenterEmployeeSmartListExpression<
          T>
      getProvinceCenterEmployeeList() {
    return new com.doublechaintech.retailscm.provincecenteremployee
            .ProvinceCenterEmployeeSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ProvinceCenterEmployee> eval(
          T provinceCenterDepartment) {
        ProvinceCenterDepartment parent =
            ProvinceCenterDepartmentExpression.this.eval(provinceCenterDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProvinceCenterEmployeeList();
      }
    };
  }
}
