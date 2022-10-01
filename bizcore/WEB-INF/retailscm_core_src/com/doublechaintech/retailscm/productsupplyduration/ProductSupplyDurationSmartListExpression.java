package com.doublechaintech.retailscm.productsupplyduration;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ProductSupplyDurationSmartListExpression<T>
    extends SmartListExpression<T, ProductSupplyDuration> {
  public ProductSupplyDurationExpression<T> first() {
    return new ProductSupplyDurationExpression<T>() {
      @Override
      public ProductSupplyDuration eval(T l) {
        List<ProductSupplyDuration> list = ProductSupplyDurationSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ProductSupplyDurationSmartListExpression.this.$getRoot();
      }
    };
  }

  public ProductSupplyDurationExpression<T> get(int index) {
    return new ProductSupplyDurationExpression<T>() {
      @Override
      public ProductSupplyDuration eval(T l) {
        List<ProductSupplyDuration> list = ProductSupplyDurationSmartListExpression.this.eval(l);
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
        return ProductSupplyDurationSmartListExpression.this.$getRoot();
      }
    };
  }
}
