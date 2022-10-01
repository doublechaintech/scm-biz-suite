package com.doublechaintech.retailscm.citypartner;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class CityPartnerExpression<T> implements Expression<T, CityPartner> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CityPartnerExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
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
        return CityPartnerExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
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
        return CityPartnerExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobile();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CityPartnerExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return CityPartnerExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
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
        return CityPartnerExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecityservicecenter
              .RetailStoreCityServiceCenterExpression<
          T>
      getCityServiceCenter() {
    return new com.doublechaintech.retailscm.retailstorecityservicecenter
            .RetailStoreCityServiceCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return CityPartnerExpression.this.$getRoot();
      }

      public RetailStoreCityServiceCenter eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityServiceCenter();
      }
    };
  }

  public com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerSmartListExpression<T>
      getPotentialCustomerList() {
    return new com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return CityPartnerExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PotentialCustomer> eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomerList();
      }
    };
  }

  public com.doublechaintech.retailscm.potentialcustomercontact
              .PotentialCustomerContactSmartListExpression<
          T>
      getPotentialCustomerContactList() {
    return new com.doublechaintech.retailscm.potentialcustomercontact
            .PotentialCustomerContactSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return CityPartnerExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PotentialCustomerContact> eval(T cityPartner) {
        CityPartner parent = CityPartnerExpression.this.eval(cityPartner);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomerContactList();
      }
    };
  }
}
