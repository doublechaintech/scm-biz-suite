package com.doublechaintech.retailscm.warehouseasset;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class WarehouseAssetExpression<T> implements Expression<T, WarehouseAsset> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseAssetExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouseAsset) {
        WarehouseAsset parent = WarehouseAssetExpression.this.eval(warehouseAsset);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseAssetExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouseAsset) {
        WarehouseAsset parent = WarehouseAssetExpression.this.eval(warehouseAsset);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getPosition() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseAssetExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouseAsset) {
        WarehouseAsset parent = WarehouseAssetExpression.this.eval(warehouseAsset);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPosition();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return WarehouseAssetExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T warehouseAsset) {
        WarehouseAsset parent = WarehouseAssetExpression.this.eval(warehouseAsset);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastUpdateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return WarehouseAssetExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T warehouseAsset) {
        WarehouseAsset parent = WarehouseAssetExpression.this.eval(warehouseAsset);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.warehouse.WarehouseExpression<T> getOwner() {
    return new com.doublechaintech.retailscm.warehouse.WarehouseExpression<T>() {
      @Override
      public T $getRoot() {
        return WarehouseAssetExpression.this.$getRoot();
      }

      public Warehouse eval(T warehouseAsset) {
        WarehouseAsset parent = WarehouseAssetExpression.this.eval(warehouseAsset);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }
}
