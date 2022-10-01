package com.doublechaintech.retailscm.retailstoreprovincecenter;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreProvinceCenterExpression<T>
    implements Expression<T, RetailStoreProvinceCenter> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
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
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
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
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFounded();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastUpdateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getCountry() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCountry();
      }
    };
  }

  public com.doublechaintech.retailscm.provincecenterdepartment
              .ProvinceCenterDepartmentSmartListExpression<
          T>
      getProvinceCenterDepartmentList() {
    return new com.doublechaintech.retailscm.provincecenterdepartment
            .ProvinceCenterDepartmentSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ProvinceCenterDepartment> eval(
          T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProvinceCenterDepartmentList();
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
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ProvinceCenterEmployee> eval(
          T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProvinceCenterEmployeeList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecityservicecenter
              .RetailStoreCityServiceCenterSmartListExpression<
          T>
      getRetailStoreCityServiceCenterList() {
    return new com.doublechaintech.retailscm.retailstorecityservicecenter
            .RetailStoreCityServiceCenterSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreProvinceCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreCityServiceCenter> eval(
          T retailStoreProvinceCenter) {
        RetailStoreProvinceCenter parent =
            RetailStoreProvinceCenterExpression.this.eval(retailStoreProvinceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreCityServiceCenterList();
      }
    };
  }
}
