package com.doublechaintech.retailscm.supplyorder;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SupplyOrderSmartListExpression<T>
    extends SmartListExpression<T, SupplyOrder> {
  public SupplyOrderExpression<T> first() {
    return new SupplyOrderExpression<T>() {
      @Override
      public SupplyOrder eval(T l) {
        List<SupplyOrder> list = SupplyOrderSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SupplyOrderSmartListExpression.this.$getRoot();
      }
    };
  }

  public SupplyOrderExpression<T> get(int index) {
    return new SupplyOrderExpression<T>() {
      @Override
      public SupplyOrder eval(T l) {
        List<SupplyOrder> list = SupplyOrderSmartListExpression.this.eval(l);
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
        return SupplyOrderSmartListExpression.this.$getRoot();
      }
    };
  }
}
