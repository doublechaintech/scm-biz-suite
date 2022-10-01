package com.doublechaintech.retailscm.warehouse;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class WarehouseExpression<T> implements Expression<T, Warehouse> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getLocation() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLocation();
      }
    };
  }

  public Expression<T, String> getContactNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactNumber();
      }
    };
  }

  public Expression<T, String> getTotalArea() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTotalArea();
      }
    };
  }

  public Expression<T, BigDecimal> getLatitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLatitude();
      }
    };
  }

  public Expression<T, BigDecimal> getLongitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLongitude();
      }
    };
  }

  public Expression<T, String> getContract() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public String eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContract();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
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
        return WarehouseExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getOwner() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public com.doublechaintech.retailscm.storagespace.StorageSpaceSmartListExpression<T>
      getStorageSpaceList() {
    return new com.doublechaintech.retailscm.storagespace.StorageSpaceSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<StorageSpace> eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStorageSpaceList();
      }
    };
  }

  public com.doublechaintech.retailscm.smartpallet.SmartPalletSmartListExpression<T>
      getSmartPalletList() {
    return new com.doublechaintech.retailscm.smartpallet.SmartPalletSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SmartPallet> eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSmartPalletList();
      }
    };
  }

  public com.doublechaintech.retailscm.supplierspace.SupplierSpaceSmartListExpression<T>
      getSupplierSpaceList() {
    return new com.doublechaintech.retailscm.supplierspace.SupplierSpaceSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SupplierSpace> eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplierSpaceList();
      }
    };
  }

  public com.doublechaintech.retailscm.receivingspace.ReceivingSpaceSmartListExpression<T>
      getReceivingSpaceList() {
    return new com.doublechaintech.retailscm.receivingspace.ReceivingSpaceSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ReceivingSpace> eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getReceivingSpaceList();
      }
    };
  }

  public com.doublechaintech.retailscm.shippingspace.ShippingSpaceSmartListExpression<T>
      getShippingSpaceList() {
    return new com.doublechaintech.retailscm.shippingspace.ShippingSpaceSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ShippingSpace> eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getShippingSpaceList();
      }
    };
  }

  public com.doublechaintech.retailscm.damagespace.DamageSpaceSmartListExpression<T>
      getDamageSpaceList() {
    return new com.doublechaintech.retailscm.damagespace.DamageSpaceSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<DamageSpace> eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDamageSpaceList();
      }
    };
  }

  public com.doublechaintech.retailscm.warehouseasset.WarehouseAssetSmartListExpression<T>
      getWarehouseAssetList() {
    return new com.doublechaintech.retailscm.warehouseasset.WarehouseAssetSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return WarehouseExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<WarehouseAsset> eval(T warehouse) {
        Warehouse parent = WarehouseExpression.this.eval(warehouse);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWarehouseAssetList();
      }
    };
  }
}
