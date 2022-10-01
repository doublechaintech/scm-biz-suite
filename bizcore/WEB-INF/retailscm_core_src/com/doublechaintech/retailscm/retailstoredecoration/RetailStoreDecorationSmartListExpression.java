package com.doublechaintech.retailscm.retailstoredecoration;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreDecorationSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreDecoration> {
  public RetailStoreDecorationExpression<T> first() {
    return new RetailStoreDecorationExpression<T>() {
      @Override
      public RetailStoreDecoration eval(T l) {
        List<RetailStoreDecoration> list = RetailStoreDecorationSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreDecorationSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreDecorationExpression<T> get(int index) {
    return new RetailStoreDecorationExpression<T>() {
      @Override
      public RetailStoreDecoration eval(T l) {
        List<RetailStoreDecoration> list = RetailStoreDecorationSmartListExpression.this.eval(l);
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
        return RetailStoreDecorationSmartListExpression.this.$getRoot();
      }
    };
  }
}
