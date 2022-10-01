package com.doublechaintech.retailscm.supplyorderpaymentgroup;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SupplyOrderPaymentGroupSmartListExpression<T>
    extends SmartListExpression<T, SupplyOrderPaymentGroup> {
  public SupplyOrderPaymentGroupExpression<T> first() {
    return new SupplyOrderPaymentGroupExpression<T>() {
      @Override
      public SupplyOrderPaymentGroup eval(T l) {
        List<SupplyOrderPaymentGroup> list =
            SupplyOrderPaymentGroupSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SupplyOrderPaymentGroupSmartListExpression.this.$getRoot();
      }
    };
  }

  public SupplyOrderPaymentGroupExpression<T> get(int index) {
    return new SupplyOrderPaymentGroupExpression<T>() {
      @Override
      public SupplyOrderPaymentGroup eval(T l) {
        List<SupplyOrderPaymentGroup> list =
            SupplyOrderPaymentGroupSmartListExpression.this.eval(l);
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
        return SupplyOrderPaymentGroupSmartListExpression.this.$getRoot();
      }
    };
  }
}
