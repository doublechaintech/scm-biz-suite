package com.doublechaintech.retailscm.supplierproduct;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SupplierProductExpression<T> implements Expression<T, SupplierProduct> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplierProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierProduct) {
        SupplierProduct parent = SupplierProductExpression.this.eval(supplierProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getProductName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplierProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierProduct) {
        SupplierProduct parent = SupplierProductExpression.this.eval(supplierProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProductName();
      }
    };
  }

  public Expression<T, String> getProductDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplierProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierProduct) {
        SupplierProduct parent = SupplierProductExpression.this.eval(supplierProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProductDescription();
      }
    };
  }

  public Expression<T, String> getProductUnit() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplierProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplierProduct) {
        SupplierProduct parent = SupplierProductExpression.this.eval(supplierProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProductUnit();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SupplierProductExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T supplierProduct) {
        SupplierProduct parent = SupplierProductExpression.this.eval(supplierProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.goodssupplier.GoodsSupplierExpression<T> getSupplier() {
    return new com.doublechaintech.retailscm.goodssupplier.GoodsSupplierExpression<T>() {
      @Override
      public T $getRoot() {
        return SupplierProductExpression.this.$getRoot();
      }

      public GoodsSupplier eval(T supplierProduct) {
        SupplierProduct parent = SupplierProductExpression.this.eval(supplierProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplier();
      }
    };
  }

  public com.doublechaintech.retailscm.productsupplyduration
              .ProductSupplyDurationSmartListExpression<
          T>
      getProductSupplyDurationList() {
    return new com.doublechaintech.retailscm.productsupplyduration
            .ProductSupplyDurationSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SupplierProductExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ProductSupplyDuration> eval(
          T supplierProduct) {
        SupplierProduct parent = SupplierProductExpression.this.eval(supplierProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProductSupplyDurationList();
      }
    };
  }
}
