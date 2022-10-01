package com.doublechaintech.retailscm.goodssupplier;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class GoodsSupplierExpression<T> implements Expression<T, GoodsSupplier> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
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
        return GoodsSupplierExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getSupplyProduct() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplyProduct();
      }
    };
  }

  public Expression<T, String> getContactNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactNumber();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
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
        return GoodsSupplierExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getBelongTo() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongTo();
      }
    };
  }

  public com.doublechaintech.retailscm.supplierproduct.SupplierProductSmartListExpression<T>
      getSupplierProductList() {
    return new com.doublechaintech.retailscm.supplierproduct.SupplierProductSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SupplierProduct> eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplierProductList();
      }
    };
  }

  public com.doublechaintech.retailscm.supplyorder.SupplyOrderSmartListExpression<T>
      getSupplyOrderList() {
    return new com.doublechaintech.retailscm.supplyorder.SupplyOrderSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SupplyOrder> eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplyOrderList();
      }
    };
  }

  public com.doublechaintech.retailscm.accountset.AccountSetSmartListExpression<T>
      getAccountSetList() {
    return new com.doublechaintech.retailscm.accountset.AccountSetSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return GoodsSupplierExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountSet> eval(T goodsSupplier) {
        GoodsSupplier parent = GoodsSupplierExpression.this.eval(goodsSupplier);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountSetList();
      }
    };
  }
}
