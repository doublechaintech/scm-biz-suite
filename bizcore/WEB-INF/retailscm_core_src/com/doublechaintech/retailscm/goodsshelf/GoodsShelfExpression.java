package com.doublechaintech.retailscm.goodsshelf;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class GoodsShelfExpression<T> implements Expression<T, GoodsShelf> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsShelfExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
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
        return GoodsShelfExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLocation();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return GoodsShelfExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
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
        return GoodsShelfExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.storagespace.StorageSpaceExpression<T> getStorageSpace() {
    return new com.doublechaintech.retailscm.storagespace.StorageSpaceExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsShelfExpression.this.$getRoot();
      }

      public StorageSpace eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStorageSpace();
      }
    };
  }

  public com.doublechaintech.retailscm.supplierspace.SupplierSpaceExpression<T> getSupplierSpace() {
    return new com.doublechaintech.retailscm.supplierspace.SupplierSpaceExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsShelfExpression.this.$getRoot();
      }

      public SupplierSpace eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplierSpace();
      }
    };
  }

  public com.doublechaintech.retailscm.damagespace.DamageSpaceExpression<T> getDamageSpace() {
    return new com.doublechaintech.retailscm.damagespace.DamageSpaceExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsShelfExpression.this.$getRoot();
      }

      public DamageSpace eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDamageSpace();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountSmartListExpression<
          T>
      getGoodsShelfStockCountList() {
    return new com.doublechaintech.retailscm.goodsshelfstockcount
            .GoodsShelfStockCountSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return GoodsShelfExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<GoodsShelfStockCount> eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsShelfStockCountList();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsallocation.GoodsAllocationSmartListExpression<T>
      getGoodsAllocationList() {
    return new com.doublechaintech.retailscm.goodsallocation.GoodsAllocationSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return GoodsShelfExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<GoodsAllocation> eval(T goodsShelf) {
        GoodsShelf parent = GoodsShelfExpression.this.eval(goodsShelf);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsAllocationList();
      }
    };
  }
}
