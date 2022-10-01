package com.doublechaintech.retailscm.consumerorderlineitem;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ConsumerOrderLineItemSmartListExpression<T>
    extends SmartListExpression<T, ConsumerOrderLineItem> {
  public ConsumerOrderLineItemExpression<T> first() {
    return new ConsumerOrderLineItemExpression<T>() {
      @Override
      public ConsumerOrderLineItem eval(T l) {
        List<ConsumerOrderLineItem> list = ConsumerOrderLineItemSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemSmartListExpression.this.$getRoot();
      }
    };
  }

  public ConsumerOrderLineItemExpression<T> get(int index) {
    return new ConsumerOrderLineItemExpression<T>() {
      @Override
      public ConsumerOrderLineItem eval(T l) {
        List<ConsumerOrderLineItem> list = ConsumerOrderLineItemSmartListExpression.this.eval(l);
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
        return ConsumerOrderLineItemSmartListExpression.this.$getRoot();
      }
    };
  }
}
