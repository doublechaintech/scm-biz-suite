package com.doublechaintech.retailscm.consumerordershippinggroup;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ConsumerOrderShippingGroupSmartListExpression<T>
    extends SmartListExpression<T, ConsumerOrderShippingGroup> {
  public ConsumerOrderShippingGroupExpression<T> first() {
    return new ConsumerOrderShippingGroupExpression<T>() {
      @Override
      public ConsumerOrderShippingGroup eval(T l) {
        List<ConsumerOrderShippingGroup> list =
            ConsumerOrderShippingGroupSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ConsumerOrderShippingGroupSmartListExpression.this.$getRoot();
      }
    };
  }

  public ConsumerOrderShippingGroupExpression<T> get(int index) {
    return new ConsumerOrderShippingGroupExpression<T>() {
      @Override
      public ConsumerOrderShippingGroup eval(T l) {
        List<ConsumerOrderShippingGroup> list =
            ConsumerOrderShippingGroupSmartListExpression.this.eval(l);
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
        return ConsumerOrderShippingGroupSmartListExpression.this.$getRoot();
      }
    };
  }
}
