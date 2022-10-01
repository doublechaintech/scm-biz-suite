package com.doublechaintech.retailscm.retailstorememberaddress;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreMemberAddressExpression<T>
    implements Expression<T, RetailStoreMemberAddress> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberAddressExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberAddress) {
        RetailStoreMemberAddress parent =
            RetailStoreMemberAddressExpression.this.eval(retailStoreMemberAddress);
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
        return RetailStoreMemberAddressExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberAddress) {
        RetailStoreMemberAddress parent =
            RetailStoreMemberAddressExpression.this.eval(retailStoreMemberAddress);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getMobilePhone() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberAddressExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberAddress) {
        RetailStoreMemberAddress parent =
            RetailStoreMemberAddressExpression.this.eval(retailStoreMemberAddress);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobilePhone();
      }
    };
  }

  public Expression<T, String> getAddress() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberAddressExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberAddress) {
        RetailStoreMemberAddress parent =
            RetailStoreMemberAddressExpression.this.eval(retailStoreMemberAddress);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAddress();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberAddressExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreMemberAddress) {
        RetailStoreMemberAddress parent =
            RetailStoreMemberAddressExpression.this.eval(retailStoreMemberAddress);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T> getOwner() {
    return new com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberAddressExpression.this.$getRoot();
      }

      public RetailStoreMember eval(T retailStoreMemberAddress) {
        RetailStoreMemberAddress parent =
            RetailStoreMemberAddressExpression.this.eval(retailStoreMemberAddress);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }
}
