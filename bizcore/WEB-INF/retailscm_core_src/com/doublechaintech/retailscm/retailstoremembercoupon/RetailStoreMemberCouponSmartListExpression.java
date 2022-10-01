package com.doublechaintech.retailscm.retailstoremembercoupon;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreMemberCouponSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreMemberCoupon> {
  public RetailStoreMemberCouponExpression<T> first() {
    return new RetailStoreMemberCouponExpression<T>() {
      @Override
      public RetailStoreMemberCoupon eval(T l) {
        List<RetailStoreMemberCoupon> list =
            RetailStoreMemberCouponSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreMemberCouponSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreMemberCouponExpression<T> get(int index) {
    return new RetailStoreMemberCouponExpression<T>() {
      @Override
      public RetailStoreMemberCoupon eval(T l) {
        List<RetailStoreMemberCoupon> list =
            RetailStoreMemberCouponSmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return RetailStoreMemberCouponSmartListExpression.this.$getRoot();
      }
    };
  }
}
