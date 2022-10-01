package com.doublechaintech.retailscm.retailstoreorderlineitem;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreOrderLineItemSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreOrderLineItem> {
  public RetailStoreOrderLineItemExpression<T> first() {
    return new RetailStoreOrderLineItemExpression<T>() {
      @Override
      public RetailStoreOrderLineItem eval(T l) {
        List<RetailStoreOrderLineItem> list =
            RetailStoreOrderLineItemSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreOrderLineItemSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreOrderLineItemExpression<T> get(int index) {
    return new RetailStoreOrderLineItemExpression<T>() {
      @Override
      public RetailStoreOrderLineItem eval(T l) {
        List<RetailStoreOrderLineItem> list =
            RetailStoreOrderLineItemSmartListExpression.this.eval(l);
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
        return RetailStoreOrderLineItemSmartListExpression.this.$getRoot();
      }
    };
  }
}
