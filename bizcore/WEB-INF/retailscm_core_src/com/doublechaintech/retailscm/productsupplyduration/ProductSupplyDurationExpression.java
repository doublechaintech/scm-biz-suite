package com.doublechaintech.retailscm.productsupplyduration;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ProductSupplyDurationExpression<T>
    implements Expression<T, ProductSupplyDuration> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProductSupplyDurationExpression.this.$getRoot();
      }

      @Override
      public String eval(T productSupplyDuration) {
        ProductSupplyDuration parent =
            ProductSupplyDurationExpression.this.eval(productSupplyDuration);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, Integer> getQuantity() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ProductSupplyDurationExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T productSupplyDuration) {
        ProductSupplyDuration parent =
            ProductSupplyDurationExpression.this.eval(productSupplyDuration);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getQuantity();
      }
    };
  }

  public Expression<T, String> getDuration() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProductSupplyDurationExpression.this.$getRoot();
      }

      @Override
      public String eval(T productSupplyDuration) {
        ProductSupplyDuration parent =
            ProductSupplyDurationExpression.this.eval(productSupplyDuration);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDuration();
      }
    };
  }

  public Expression<T, BigDecimal> getPrice() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return ProductSupplyDurationExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T productSupplyDuration) {
        ProductSupplyDuration parent =
            ProductSupplyDurationExpression.this.eval(productSupplyDuration);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPrice();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ProductSupplyDurationExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T productSupplyDuration) {
        ProductSupplyDuration parent =
            ProductSupplyDurationExpression.this.eval(productSupplyDuration);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.supplierproduct.SupplierProductExpression<T> getProduct() {
    return new com.doublechaintech.retailscm.supplierproduct.SupplierProductExpression<T>() {
      @Override
      public T $getRoot() {
        return ProductSupplyDurationExpression.this.$getRoot();
      }

      public SupplierProduct eval(T productSupplyDuration) {
        ProductSupplyDuration parent =
            ProductSupplyDurationExpression.this.eval(productSupplyDuration);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProduct();
      }
    };
  }
}
