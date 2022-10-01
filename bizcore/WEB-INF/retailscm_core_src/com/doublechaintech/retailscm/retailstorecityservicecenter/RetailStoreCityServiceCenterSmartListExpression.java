package com.doublechaintech.retailscm.retailstorecityservicecenter;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreCityServiceCenterSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreCityServiceCenter> {
  public RetailStoreCityServiceCenterExpression<T> first() {
    return new RetailStoreCityServiceCenterExpression<T>() {
      @Override
      public RetailStoreCityServiceCenter eval(T l) {
        List<RetailStoreCityServiceCenter> list =
            RetailStoreCityServiceCenterSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreCityServiceCenterSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreCityServiceCenterExpression<T> get(int index) {
    return new RetailStoreCityServiceCenterExpression<T>() {
      @Override
      public RetailStoreCityServiceCenter eval(T l) {
        List<RetailStoreCityServiceCenter> list =
            RetailStoreCityServiceCenterSmartListExpression.this.eval(l);
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
        return RetailStoreCityServiceCenterSmartListExpression.this.$getRoot();
      }
    };
  }
}
