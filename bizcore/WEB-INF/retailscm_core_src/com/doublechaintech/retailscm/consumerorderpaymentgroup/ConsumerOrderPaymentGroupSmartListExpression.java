package com.doublechaintech.retailscm.consumerorderpaymentgroup;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ConsumerOrderPaymentGroupSmartListExpression<T>
    extends SmartListExpression<T, ConsumerOrderPaymentGroup> {
  public ConsumerOrderPaymentGroupExpression<T> first() {
    return new ConsumerOrderPaymentGroupExpression<T>() {
      @Override
      public ConsumerOrderPaymentGroup eval(T l) {
        List<ConsumerOrderPaymentGroup> list =
            ConsumerOrderPaymentGroupSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ConsumerOrderPaymentGroupSmartListExpression.this.$getRoot();
      }
    };
  }

  public ConsumerOrderPaymentGroupExpression<T> get(int index) {
    return new ConsumerOrderPaymentGroupExpression<T>() {
      @Override
      public ConsumerOrderPaymentGroup eval(T l) {
        List<ConsumerOrderPaymentGroup> list =
            ConsumerOrderPaymentGroupSmartListExpression.this.eval(l);
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
        return ConsumerOrderPaymentGroupSmartListExpression.this.$getRoot();
      }
    };
  }
}
