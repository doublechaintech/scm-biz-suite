package com.doublechaintech.retailscm.receivingspace;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ReceivingSpaceSmartListExpression<T>
    extends SmartListExpression<T, ReceivingSpace> {
  public ReceivingSpaceExpression<T> first() {
    return new ReceivingSpaceExpression<T>() {
      @Override
      public ReceivingSpace eval(T l) {
        List<ReceivingSpace> list = ReceivingSpaceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ReceivingSpaceSmartListExpression.this.$getRoot();
      }
    };
  }

  public ReceivingSpaceExpression<T> get(int index) {
    return new ReceivingSpaceExpression<T>() {
      @Override
      public ReceivingSpace eval(T l) {
        List<ReceivingSpace> list = ReceivingSpaceSmartListExpression.this.eval(l);
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
        return ReceivingSpaceSmartListExpression.this.$getRoot();
      }
    };
  }
}
