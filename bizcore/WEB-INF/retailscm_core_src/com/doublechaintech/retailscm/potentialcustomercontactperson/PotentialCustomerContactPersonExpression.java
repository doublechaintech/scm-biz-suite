package com.doublechaintech.retailscm.potentialcustomercontactperson;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class PotentialCustomerContactPersonExpression<T>
    implements Expression<T, PotentialCustomerContactPerson> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactPersonExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContactPerson) {
        PotentialCustomerContactPerson parent =
            PotentialCustomerContactPersonExpression.this.eval(potentialCustomerContactPerson);
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
        return PotentialCustomerContactPersonExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContactPerson) {
        PotentialCustomerContactPerson parent =
            PotentialCustomerContactPersonExpression.this.eval(potentialCustomerContactPerson);
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
        return PotentialCustomerContactPersonExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContactPerson) {
        PotentialCustomerContactPerson parent =
            PotentialCustomerContactPersonExpression.this.eval(potentialCustomerContactPerson);
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
        return PotentialCustomerContactPersonExpression.this.$getRoot();
      }

      @Override
      public String eval(T potentialCustomerContactPerson) {
        PotentialCustomerContactPerson parent =
            PotentialCustomerContactPersonExpression.this.eval(potentialCustomerContactPerson);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PotentialCustomerContactPersonExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T potentialCustomerContactPerson) {
        PotentialCustomerContactPerson parent =
            PotentialCustomerContactPersonExpression.this.eval(potentialCustomerContactPerson);
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
        return PotentialCustomerContactPersonExpression.this.$getRoot();
      }

      public PotentialCustomer eval(T potentialCustomerContactPerson) {
        PotentialCustomerContactPerson parent =
            PotentialCustomerContactPersonExpression.this.eval(potentialCustomerContactPerson);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomer();
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
        return PotentialCustomerContactPersonExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<PotentialCustomerContact> eval(
          T potentialCustomerContactPerson) {
        PotentialCustomerContactPerson parent =
            PotentialCustomerContactPersonExpression.this.eval(potentialCustomerContactPerson);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomerContactList();
      }
    };
  }
}
