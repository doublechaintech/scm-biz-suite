package com.doublechaintech.retailscm.supplyorderlineitem;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SupplyOrderLineItemSmartListExpression<T>
    extends SmartListExpression<T, SupplyOrderLineItem> {
  public SupplyOrderLineItemExpression<T> first() {
    return new SupplyOrderLineItemExpression<T>() {
      @Override
      public SupplyOrderLineItem eval(T l) {
        List<SupplyOrderLineItem> list = SupplyOrderLineItemSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SupplyOrderLineItemSmartListExpression.this.$getRoot();
      }
    };
  }

  public SupplyOrderLineItemExpression<T> get(int index) {
    return new SupplyOrderLineItemExpression<T>() {
      @Override
      public SupplyOrderLineItem eval(T l) {
        List<SupplyOrderLineItem> list = SupplyOrderLineItemSmartListExpression.this.eval(l);
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
        return SupplyOrderLineItemSmartListExpression.this.$getRoot();
      }
    };
  }
}
