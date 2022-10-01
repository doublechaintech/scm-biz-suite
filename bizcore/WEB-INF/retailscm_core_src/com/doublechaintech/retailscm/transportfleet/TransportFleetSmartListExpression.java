package com.doublechaintech.retailscm.transportfleet;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TransportFleetSmartListExpression<T>
    extends SmartListExpression<T, TransportFleet> {
  public TransportFleetExpression<T> first() {
    return new TransportFleetExpression<T>() {
      @Override
      public TransportFleet eval(T l) {
        List<TransportFleet> list = TransportFleetSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TransportFleetSmartListExpression.this.$getRoot();
      }
    };
  }

  public TransportFleetExpression<T> get(int index) {
    return new TransportFleetExpression<T>() {
      @Override
      public TransportFleet eval(T l) {
        List<TransportFleet> list = TransportFleetSmartListExpression.this.eval(l);
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
        return TransportFleetSmartListExpression.this.$getRoot();
      }
    };
  }
}
