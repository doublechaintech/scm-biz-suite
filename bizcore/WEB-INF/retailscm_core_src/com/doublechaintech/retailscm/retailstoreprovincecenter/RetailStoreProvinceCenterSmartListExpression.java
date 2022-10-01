package com.doublechaintech.retailscm.retailstoreprovincecenter;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreProvinceCenterSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreProvinceCenter> {
  public RetailStoreProvinceCenterExpression<T> first() {
    return new RetailStoreProvinceCenterExpression<T>() {
      @Override
      public RetailStoreProvinceCenter eval(T l) {
        List<RetailStoreProvinceCenter> list =
            RetailStoreProvinceCenterSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreProvinceCenterSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreProvinceCenterExpression<T> get(int index) {
    return new RetailStoreProvinceCenterExpression<T>() {
      @Override
      public RetailStoreProvinceCenter eval(T l) {
        List<RetailStoreProvinceCenter> list =
            RetailStoreProvinceCenterSmartListExpression.this.eval(l);
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
        return RetailStoreProvinceCenterSmartListExpression.this.$getRoot();
      }
    };
  }
}
