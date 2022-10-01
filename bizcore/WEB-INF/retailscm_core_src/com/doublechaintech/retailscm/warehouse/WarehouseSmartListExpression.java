package com.doublechaintech.retailscm.warehouse;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class WarehouseSmartListExpression<T> extends SmartListExpression<T, Warehouse> {
  public WarehouseExpression<T> first() {
    return new WarehouseExpression<T>() {
      @Override
      public Warehouse eval(T l) {
        List<Warehouse> list = WarehouseSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return WarehouseSmartListExpression.this.$getRoot();
      }
    };
  }

  public WarehouseExpression<T> get(int index) {
    return new WarehouseExpression<T>() {
      @Override
      public Warehouse eval(T l) {
        List<Warehouse> list = WarehouseSmartListExpression.this.eval(l);
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
        return WarehouseSmartListExpression.this.$getRoot();
      }
    };
  }
}
