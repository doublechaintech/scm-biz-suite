package com.doublechaintech.retailscm.consumerorderpriceadjustment;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ConsumerOrderPriceAdjustmentSmartListExpression<T>
    extends SmartListExpression<T, ConsumerOrderPriceAdjustment> {
  public ConsumerOrderPriceAdjustmentExpression<T> first() {
    return new ConsumerOrderPriceAdjustmentExpression<T>() {
      @Override
      public ConsumerOrderPriceAdjustment eval(T l) {
        List<ConsumerOrderPriceAdjustment> list =
            ConsumerOrderPriceAdjustmentSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ConsumerOrderPriceAdjustmentSmartListExpression.this.$getRoot();
      }
    };
  }

  public ConsumerOrderPriceAdjustmentExpression<T> get(int index) {
    return new ConsumerOrderPriceAdjustmentExpression<T>() {
      @Override
      public ConsumerOrderPriceAdjustment eval(T l) {
        List<ConsumerOrderPriceAdjustment> list =
            ConsumerOrderPriceAdjustmentSmartListExpression.this.eval(l);
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
        return ConsumerOrderPriceAdjustmentSmartListExpression.this.$getRoot();
      }
    };
  }
}
