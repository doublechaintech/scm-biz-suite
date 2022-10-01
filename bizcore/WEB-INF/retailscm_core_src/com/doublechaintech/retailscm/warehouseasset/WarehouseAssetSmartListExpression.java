package com.doublechaintech.retailscm.warehouseasset;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class WarehouseAssetSmartListExpression<T>
    extends SmartListExpression<T, WarehouseAsset> {
  public WarehouseAssetExpression<T> first() {
    return new WarehouseAssetExpression<T>() {
      @Override
      public WarehouseAsset eval(T l) {
        List<WarehouseAsset> list = WarehouseAssetSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return WarehouseAssetSmartListExpression.this.$getRoot();
      }
    };
  }

  public WarehouseAssetExpression<T> get(int index) {
    return new WarehouseAssetExpression<T>() {
      @Override
      public WarehouseAsset eval(T l) {
        List<WarehouseAsset> list = WarehouseAssetSmartListExpression.this.eval(l);
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
        return WarehouseAssetSmartListExpression.this.$getRoot();
      }
    };
  }
}
