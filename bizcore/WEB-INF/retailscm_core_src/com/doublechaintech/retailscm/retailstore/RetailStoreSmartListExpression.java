package com.doublechaintech.retailscm.retailstore;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreSmartListExpression<T>
    extends SmartListExpression<T, RetailStore> {
  public RetailStoreExpression<T> first() {
    return new RetailStoreExpression<T>() {
      @Override
      public RetailStore eval(T l) {
        List<RetailStore> list = RetailStoreSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreExpression<T> get(int index) {
    return new RetailStoreExpression<T>() {
      @Override
      public RetailStore eval(T l) {
        List<RetailStore> list = RetailStoreSmartListExpression.this.eval(l);
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
        return RetailStoreSmartListExpression.this.$getRoot();
      }
    };
  }
}
