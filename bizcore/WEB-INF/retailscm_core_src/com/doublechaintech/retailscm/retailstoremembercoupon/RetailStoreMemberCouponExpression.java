package com.doublechaintech.retailscm.retailstoremembercoupon;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreMemberCouponExpression<T>
    implements Expression<T, RetailStoreMemberCoupon> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberCouponExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberCoupon) {
        RetailStoreMemberCoupon parent =
            RetailStoreMemberCouponExpression.this.eval(retailStoreMemberCoupon);
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
        return RetailStoreMemberCouponExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberCoupon) {
        RetailStoreMemberCoupon parent =
            RetailStoreMemberCouponExpression.this.eval(retailStoreMemberCoupon);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberCouponExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberCoupon) {
        RetailStoreMemberCoupon parent =
            RetailStoreMemberCouponExpression.this.eval(retailStoreMemberCoupon);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getNumber();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberCouponExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreMemberCoupon) {
        RetailStoreMemberCoupon parent =
            RetailStoreMemberCouponExpression.this.eval(retailStoreMemberCoupon);
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
        return RetailStoreMemberCouponExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreMemberCoupon) {
        RetailStoreMemberCoupon parent =
            RetailStoreMemberCouponExpression.this.eval(retailStoreMemberCoupon);
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
        return RetailStoreMemberCouponExpression.this.$getRoot();
      }

      public RetailStoreMember eval(T retailStoreMemberCoupon) {
        RetailStoreMemberCoupon parent =
            RetailStoreMemberCouponExpression.this.eval(retailStoreMemberCoupon);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }
}
