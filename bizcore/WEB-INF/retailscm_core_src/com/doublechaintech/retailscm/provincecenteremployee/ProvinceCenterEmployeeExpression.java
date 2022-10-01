package com.doublechaintech.retailscm.provincecenteremployee;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ProvinceCenterEmployeeExpression<T>
    implements Expression<T, ProvinceCenterEmployee> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
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
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getMobile() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobile();
      }
    };
  }

  public Expression<T, String> getEmail() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      @Override
      public String eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmail();
      }
    };
  }

  public Expression<T, DateTime> getFounded() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFounded();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentExpression<
          T>
      getDepartment() {
    return new com.doublechaintech.retailscm.provincecenterdepartment
            .ProvinceCenterDepartmentExpression<
        T>() {
      @Override
      public T $getRoot() {
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      public ProvinceCenterDepartment eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDepartment();
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
        return ProvinceCenterEmployeeExpression.this.$getRoot();
      }

      public RetailStoreProvinceCenter eval(T provinceCenterEmployee) {
        ProvinceCenterEmployee parent =
            ProvinceCenterEmployeeExpression.this.eval(provinceCenterEmployee);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProvinceCenter();
      }
    };
  }
}
