package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreOrderPaymentGroupSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreOrderPaymentGroup> {
  public RetailStoreOrderPaymentGroupExpression<T> first() {
    return new RetailStoreOrderPaymentGroupExpression<T>() {
      @Override
      public RetailStoreOrderPaymentGroup eval(T l) {
        List<RetailStoreOrderPaymentGroup> list =
            RetailStoreOrderPaymentGroupSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreOrderPaymentGroupSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreOrderPaymentGroupExpression<T> get(int index) {
    return new RetailStoreOrderPaymentGroupExpression<T>() {
      @Override
      public RetailStoreOrderPaymentGroup eval(T l) {
        List<RetailStoreOrderPaymentGroup> list =
            RetailStoreOrderPaymentGroupSmartListExpression.this.eval(l);
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
        return RetailStoreOrderPaymentGroupSmartListExpression.this.$getRoot();
      }
    };
  }
}
