package com.doublechaintech.retailscm.sku;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SkuExpression<T> implements Expression<T, Sku> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public String eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
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
        return SkuExpression.this.$getRoot();
      }

      @Override
      public String eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getSize() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public String eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSize();
      }
    };
  }

  public Expression<T, String> getBarcode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public String eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBarcode();
      }
    };
  }

  public Expression<T, String> getPackageType() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public String eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPackageType();
      }
    };
  }

  public Expression<T, String> getNetContent() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public String eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getNetContent();
      }
    };
  }

  public Expression<T, BigDecimal> getPrice() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPrice();
      }
    };
  }

  public Expression<T, String> getPicture() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public String eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPicture();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.product.ProductExpression<T> getProduct() {
    return new com.doublechaintech.retailscm.product.ProductExpression<T>() {
      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      public Product eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProduct();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T> getGoodsList() {
    return new com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SkuExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Goods> eval(T sku) {
        Sku parent = SkuExpression.this.eval(sku);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsList();
      }
    };
  }
}
