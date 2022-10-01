package com.doublechaintech.retailscm.retailstorecountrycenter;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreCountryCenterSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreCountryCenter> {
  public RetailStoreCountryCenterExpression<T> first() {
    return new RetailStoreCountryCenterExpression<T>() {
      @Override
      public RetailStoreCountryCenter eval(T l) {
        List<RetailStoreCountryCenter> list =
            RetailStoreCountryCenterSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreCountryCenterSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreCountryCenterExpression<T> get(int index) {
    return new RetailStoreCountryCenterExpression<T>() {
      @Override
      public RetailStoreCountryCenter eval(T l) {
        List<RetailStoreCountryCenter> list =
            RetailStoreCountryCenterSmartListExpression.this.eval(l);
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
        return RetailStoreCountryCenterSmartListExpression.this.$getRoot();
      }
    };
  }
}
