package com.doublechaintech.retailscm.consumerorder;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ConsumerOrderSmartListExpression<T>
    extends SmartListExpression<T, ConsumerOrder> {
  public ConsumerOrderExpression<T> first() {
    return new ConsumerOrderExpression<T>() {
      @Override
      public ConsumerOrder eval(T l) {
        List<ConsumerOrder> list = ConsumerOrderSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ConsumerOrderSmartListExpression.this.$getRoot();
      }
    };
  }

  public ConsumerOrderExpression<T> get(int index) {
    return new ConsumerOrderExpression<T>() {
      @Override
      public ConsumerOrder eval(T l) {
        List<ConsumerOrder> list = ConsumerOrderSmartListExpression.this.eval(l);
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
        return ConsumerOrderSmartListExpression.this.$getRoot();
      }
    };
  }
}
