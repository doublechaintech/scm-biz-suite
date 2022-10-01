package com.doublechaintech.retailscm.retailstorecityservicecenter;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.citypartner.CityPartner;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreCityServiceCenterExpression<T>
    implements Expression<T, RetailStoreCityServiceCenter> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
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
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
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
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
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
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
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
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
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
      getBelongsTo() {
    return new com.doublechaintech.retailscm.retailstoreprovincecenter
            .RetailStoreProvinceCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      public RetailStoreProvinceCenter eval(T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }

  public com.doublechaintech.retailscm.citypartner.CityPartnerSmartListExpression<T>
      getCityPartnerList() {
    return new com.doublechaintech.retailscm.citypartner.CityPartnerSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<CityPartner> eval(
          T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityPartnerList();
      }
    };
  }

  public com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerSmartListExpression<T>
      getPotentialCustomerList() {
    return new com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PotentialCustomer> eval(
          T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomerList();
      }
    };
  }

  public com.doublechaintech.retailscm.cityevent.CityEventSmartListExpression<T>
      getCityEventList() {
    return new com.doublechaintech.retailscm.cityevent.CityEventSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<CityEvent> eval(
          T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityEventList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreSmartListExpression<T>
      getRetailStoreList() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreCityServiceCenterExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStore> eval(
          T retailStoreCityServiceCenter) {
        RetailStoreCityServiceCenter parent =
            RetailStoreCityServiceCenterExpression.this.eval(retailStoreCityServiceCenter);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreList();
      }
    };
  }
}
