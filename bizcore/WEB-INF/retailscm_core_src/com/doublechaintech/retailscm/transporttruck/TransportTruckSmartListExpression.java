package com.doublechaintech.retailscm.transporttruck;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TransportTruckSmartListExpression<T>
    extends SmartListExpression<T, TransportTruck> {
  public TransportTruckExpression<T> first() {
    return new TransportTruckExpression<T>() {
      @Override
      public TransportTruck eval(T l) {
        List<TransportTruck> list = TransportTruckSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TransportTruckSmartListExpression.this.$getRoot();
      }
    };
  }

  public TransportTruckExpression<T> get(int index) {
    return new TransportTruckExpression<T>() {
      @Override
      public TransportTruck eval(T l) {
        List<TransportTruck> list = TransportTruckSmartListExpression.this.eval(l);
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
        return TransportTruckSmartListExpression.this.$getRoot();
      }
    };
  }
}
