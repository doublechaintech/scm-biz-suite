package com.doublechaintech.retailscm.payingoff;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PayingOffSmartListExpression<T> extends SmartListExpression<T, PayingOff> {
  public PayingOffExpression<T> first() {
    return new PayingOffExpression<T>() {
      @Override
      public PayingOff eval(T l) {
        List<PayingOff> list = PayingOffSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PayingOffSmartListExpression.this.$getRoot();
      }
    };
  }

  public PayingOffExpression<T> get(int index) {
    return new PayingOffExpression<T>() {
      @Override
      public PayingOff eval(T l) {
        List<PayingOff> list = PayingOffSmartListExpression.this.eval(l);
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
        return PayingOffSmartListExpression.this.$getRoot();
      }
    };
  }
}
