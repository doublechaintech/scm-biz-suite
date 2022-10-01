package com.doublechaintech.retailscm.retailstoreorder;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreOrderSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreOrder> {
  public RetailStoreOrderExpression<T> first() {
    return new RetailStoreOrderExpression<T>() {
      @Override
      public RetailStoreOrder eval(T l) {
        List<RetailStoreOrder> list = RetailStoreOrderSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreOrderSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreOrderExpression<T> get(int index) {
    return new RetailStoreOrderExpression<T>() {
      @Override
      public RetailStoreOrder eval(T l) {
        List<RetailStoreOrder> list = RetailStoreOrderSmartListExpression.this.eval(l);
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
        return RetailStoreOrderSmartListExpression.this.$getRoot();
      }
    };
  }
}
