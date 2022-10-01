package com.doublechaintech.retailscm.retailstoreordershippinggroup;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreOrderShippingGroupSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreOrderShippingGroup> {
  public RetailStoreOrderShippingGroupExpression<T> first() {
    return new RetailStoreOrderShippingGroupExpression<T>() {
      @Override
      public RetailStoreOrderShippingGroup eval(T l) {
        List<RetailStoreOrderShippingGroup> list =
            RetailStoreOrderShippingGroupSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreOrderShippingGroupSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreOrderShippingGroupExpression<T> get(int index) {
    return new RetailStoreOrderShippingGroupExpression<T>() {
      @Override
      public RetailStoreOrderShippingGroup eval(T l) {
        List<RetailStoreOrderShippingGroup> list =
            RetailStoreOrderShippingGroupSmartListExpression.this.eval(l);
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
        return RetailStoreOrderShippingGroupSmartListExpression.this.$getRoot();
      }
    };
  }
}
