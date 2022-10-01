package com.doublechaintech.retailscm.retailstoreclosing;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreClosingSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreClosing> {
  public RetailStoreClosingExpression<T> first() {
    return new RetailStoreClosingExpression<T>() {
      @Override
      public RetailStoreClosing eval(T l) {
        List<RetailStoreClosing> list = RetailStoreClosingSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreClosingSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreClosingExpression<T> get(int index) {
    return new RetailStoreClosingExpression<T>() {
      @Override
      public RetailStoreClosing eval(T l) {
        List<RetailStoreClosing> list = RetailStoreClosingSmartListExpression.this.eval(l);
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
        return RetailStoreClosingSmartListExpression.this.$getRoot();
      }
    };
  }
}
