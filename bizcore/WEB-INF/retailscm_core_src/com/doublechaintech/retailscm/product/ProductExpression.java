package com.doublechaintech.retailscm.product;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.sku.Sku;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ProductExpression<T> implements Expression<T, Product> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T product) {
        Product parent = ProductExpression.this.eval(product);
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
        return ProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getOrigin() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOrigin();
      }
    };
  }

  public Expression<T, String> getRemark() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRemark();
      }
    };
  }

  public Expression<T, String> getBrand() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBrand();
      }
    };
  }

  public Expression<T, String> getPicture() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPicture();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T product) {
        Product parent = ProductExpression.this.eval(product);
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
        return ProductExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryExpression<T>
      getParentCategory() {
    return new com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryExpression<T>() {
      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      public LevelThreeCategory eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getParentCategory();
      }
    };
  }

  public com.doublechaintech.retailscm.sku.SkuSmartListExpression<T> getSkuList() {
    return new com.doublechaintech.retailscm.sku.SkuSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return ProductExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Sku> eval(T product) {
        Product parent = ProductExpression.this.eval(product);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSkuList();
      }
    };
  }
}
