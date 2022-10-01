package com.doublechaintech.retailscm.potentialcustomercontact;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class PotentialCustomerContactExpression<T>
    implements Expression<T, PotentialCustomerContact> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
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
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, DateTime> getContactDate() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactDate();
      }
    };
  }

  public Expression<T, String> getContactMethod() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactMethod();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
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
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
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
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerExpression<T>
      getPotentialCustomer() {
    return new com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerExpression<T>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      public PotentialCustomer eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomer();
      }
    };
  }

  public com.doublechaintech.retailscm.citypartner.CityPartnerExpression<T> getCityPartner() {
    return new com.doublechaintech.retailscm.citypartner.CityPartnerExpression<T>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      public CityPartner eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityPartner();
      }
    };
  }

  public com.doublechaintech.retailscm.potentialcustomercontactperson
              .PotentialCustomerContactPersonExpression<
          T>
      getContactTo() {
    return new com.doublechaintech.retailscm.potentialcustomercontactperson
            .PotentialCustomerContactPersonExpression<
        T>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactExpression.this.$getRoot();
      }

      public PotentialCustomerContactPerson eval(T potentialCustomerContact) {
        PotentialCustomerContact parent =
            PotentialCustomerContactExpression.this.eval(potentialCustomerContact);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactTo();
      }
    };
  }
}
