package com.doublechaintech.retailscm.truckdriver;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TruckDriverSmartListExpression<T>
    extends SmartListExpression<T, TruckDriver> {
  public TruckDriverExpression<T> first() {
    return new TruckDriverExpression<T>() {
      @Override
      public TruckDriver eval(T l) {
        List<TruckDriver> list = TruckDriverSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TruckDriverSmartListExpression.this.$getRoot();
      }
    };
  }

  public TruckDriverExpression<T> get(int index) {
    return new TruckDriverExpression<T>() {
      @Override
      public TruckDriver eval(T l) {
        List<TruckDriver> list = TruckDriverSmartListExpression.this.eval(l);
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
        return TruckDriverSmartListExpression.this.$getRoot();
      }
    };
  }
}
