package com.doublechaintech.retailscm.retailstorememberaddress;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreMemberAddressSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreMemberAddress> {
  public RetailStoreMemberAddressExpression<T> first() {
    return new RetailStoreMemberAddressExpression<T>() {
      @Override
      public RetailStoreMemberAddress eval(T l) {
        List<RetailStoreMemberAddress> list =
            RetailStoreMemberAddressSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreMemberAddressSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreMemberAddressExpression<T> get(int index) {
    return new RetailStoreMemberAddressExpression<T>() {
      @Override
      public RetailStoreMemberAddress eval(T l) {
        List<RetailStoreMemberAddress> list =
            RetailStoreMemberAddressSmartListExpression.this.eval(l);
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
        return RetailStoreMemberAddressSmartListExpression.this.$getRoot();
      }
    };
  }
}
