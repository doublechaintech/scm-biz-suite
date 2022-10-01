package com.doublechaintech.retailscm.goods;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class GoodsExpression<T> implements Expression<T, Goods> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      @Override
      public String eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
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
        return GoodsExpression.this.$getRoot();
      }

      @Override
      public String eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getRfid() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      @Override
      public String eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRfid();
      }
    };
  }

  public Expression<T, String> getUom() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      @Override
      public String eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUom();
      }
    };
  }

  public Expression<T, Integer> getMaxPackage() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMaxPackage();
      }
    };
  }

  public Expression<T, DateTime> getExpireTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getExpireTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.sku.SkuExpression<T> getSku() {
    return new com.doublechaintech.retailscm.sku.SkuExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public Sku eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSku();
      }
    };
  }

  public com.doublechaintech.retailscm.receivingspace.ReceivingSpaceExpression<T>
      getReceivingSpace() {
    return new com.doublechaintech.retailscm.receivingspace.ReceivingSpaceExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public ReceivingSpace eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getReceivingSpace();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsallocation.GoodsAllocationExpression<T>
      getGoodsAllocation() {
    return new com.doublechaintech.retailscm.goodsallocation.GoodsAllocationExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public GoodsAllocation eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsAllocation();
      }
    };
  }

  public com.doublechaintech.retailscm.smartpallet.SmartPalletExpression<T> getSmartPallet() {
    return new com.doublechaintech.retailscm.smartpallet.SmartPalletExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public SmartPallet eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSmartPallet();
      }
    };
  }

  public com.doublechaintech.retailscm.shippingspace.ShippingSpaceExpression<T> getShippingSpace() {
    return new com.doublechaintech.retailscm.shippingspace.ShippingSpaceExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public ShippingSpace eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getShippingSpace();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttask.TransportTaskExpression<T> getTransportTask() {
    return new com.doublechaintech.retailscm.transporttask.TransportTaskExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public TransportTask eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportTask();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T> getRetailStore() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public RetailStore eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStore();
      }
    };
  }

  public com.doublechaintech.retailscm.supplyorder.SupplyOrderExpression<T> getBizOrder() {
    return new com.doublechaintech.retailscm.supplyorder.SupplyOrderExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public SupplyOrder eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderExpression<T>
      getRetailStoreOrder() {
    return new com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public RetailStoreOrder eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreOrder();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsmovement.GoodsMovementSmartListExpression<T>
      getGoodsMovementList() {
    return new com.doublechaintech.retailscm.goodsmovement.GoodsMovementSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return GoodsExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<GoodsMovement> eval(T goods) {
        Goods parent = GoodsExpression.this.eval(goods);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsMovementList();
      }
    };
  }
}
