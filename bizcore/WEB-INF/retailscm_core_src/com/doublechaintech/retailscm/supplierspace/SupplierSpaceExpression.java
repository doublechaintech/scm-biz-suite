package com.doublechaintech.retailscm.supplierspace;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SupplierSpaceExpression<T> implements Expression<T, SupplierSpace> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
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
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
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
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
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
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
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
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
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
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLongitude();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
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
        return SupplierSpaceExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.warehouse.WarehouseExpression<T> getWarehouse() {
    return new com.doublechaintech.retailscm.warehouse.WarehouseExpression<T>() {
      @Override
      public T $getRoot() {
        return SupplierSpaceExpression.this.$getRoot();
      }

      public Warehouse eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWarehouse();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsshelf.GoodsShelfSmartListExpression<T>
      getGoodsShelfList() {
    return new com.doublechaintech.retailscm.goodsshelf.GoodsShelfSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SupplierSpaceExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<GoodsShelf> eval(T supplierSpace) {
        SupplierSpace parent = SupplierSpaceExpression.this.eval(supplierSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsShelfList();
      }
    };
  }
}
