package com.doublechaintech.retailscm.supplyordershippinggroup;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SupplyOrderShippingGroupSmartListExpression<T>
    extends SmartListExpression<T, SupplyOrderShippingGroup> {
  public SupplyOrderShippingGroupExpression<T> first() {
    return new SupplyOrderShippingGroupExpression<T>() {
      @Override
      public SupplyOrderShippingGroup eval(T l) {
        List<SupplyOrderShippingGroup> list =
            SupplyOrderShippingGroupSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SupplyOrderShippingGroupSmartListExpression.this.$getRoot();
      }
    };
  }

  public SupplyOrderShippingGroupExpression<T> get(int index) {
    return new SupplyOrderShippingGroupExpression<T>() {
      @Override
      public SupplyOrderShippingGroup eval(T l) {
        List<SupplyOrderShippingGroup> list =
            SupplyOrderShippingGroupSmartListExpression.this.eval(l);
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
        return SupplyOrderShippingGroupSmartListExpression.this.$getRoot();
      }
    };
  }
}
