package com.doublechaintech.retailscm.shippingspace;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ShippingSpaceSmartListExpression<T>
    extends SmartListExpression<T, ShippingSpace> {
  public ShippingSpaceExpression<T> first() {
    return new ShippingSpaceExpression<T>() {
      @Override
      public ShippingSpace eval(T l) {
        List<ShippingSpace> list = ShippingSpaceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ShippingSpaceSmartListExpression.this.$getRoot();
      }
    };
  }

  public ShippingSpaceExpression<T> get(int index) {
    return new ShippingSpaceExpression<T>() {
      @Override
      public ShippingSpace eval(T l) {
        List<ShippingSpace> list = ShippingSpaceSmartListExpression.this.eval(l);
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
        return ShippingSpaceSmartListExpression.this.$getRoot();
      }
    };
  }
}
