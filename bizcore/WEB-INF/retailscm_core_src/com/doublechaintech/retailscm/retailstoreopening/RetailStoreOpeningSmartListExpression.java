package com.doublechaintech.retailscm.retailstoreopening;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreOpeningSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreOpening> {
  public RetailStoreOpeningExpression<T> first() {
    return new RetailStoreOpeningExpression<T>() {
      @Override
      public RetailStoreOpening eval(T l) {
        List<RetailStoreOpening> list = RetailStoreOpeningSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreOpeningSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreOpeningExpression<T> get(int index) {
    return new RetailStoreOpeningExpression<T>() {
      @Override
      public RetailStoreOpening eval(T l) {
        List<RetailStoreOpening> list = RetailStoreOpeningSmartListExpression.this.eval(l);
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
        return RetailStoreOpeningSmartListExpression.this.$getRoot();
      }
    };
  }
}
