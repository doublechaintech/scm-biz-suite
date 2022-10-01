package com.doublechaintech.retailscm.potentialcustomer;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class PotentialCustomerExpression<T> implements Expression<T, PotentialCustomer> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
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
        return PotentialCustomerExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
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
        return PotentialCustomerExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
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
        return PotentialCustomerExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
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
        return PotentialCustomerExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
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
        return PotentialCustomerExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
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
        return PotentialCustomerExpression.this.$getRoot();
      }

      public RetailStoreCityServiceCenter eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityServiceCenter();
      }
    };
  }

  public com.doublechaintech.retailscm.citypartner.CityPartnerExpression<T> getCityPartner() {
    return new com.doublechaintech.retailscm.citypartner.CityPartnerExpression<T>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerExpression.this.$getRoot();
      }

      public CityPartner eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityPartner();
      }
    };
  }

  public com.doublechaintech.retailscm.potentialcustomercontactperson
              .PotentialCustomerContactPersonSmartListExpression<
          T>
      getPotentialCustomerContactPersonList() {
    return new com.doublechaintech.retailscm.potentialcustomercontactperson
            .PotentialCustomerContactPersonSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return PotentialCustomerExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PotentialCustomerContactPerson> eval(
          T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomerContactPersonList();
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
        return PotentialCustomerExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PotentialCustomerContact> eval(
          T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomerContactList();
      }
    };
  }

  public com.doublechaintech.retailscm.eventattendance.EventAttendanceSmartListExpression<T>
      getEventAttendanceList() {
    return new com.doublechaintech.retailscm.eventattendance.EventAttendanceSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return PotentialCustomerExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EventAttendance> eval(T potentialCustomer) {
        PotentialCustomer parent = PotentialCustomerExpression.this.eval(potentialCustomer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEventAttendanceList();
      }
    };
  }
}
