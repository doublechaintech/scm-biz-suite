package com.doublechaintech.retailscm.levelthreecategory;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.product.Product;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LevelThreeCategoryExpression<T> implements Expression<T, LevelThreeCategory> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelThreeCategoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelThreeCategory) {
        LevelThreeCategory parent = LevelThreeCategoryExpression.this.eval(levelThreeCategory);
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
        return LevelThreeCategoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelThreeCategory) {
        LevelThreeCategory parent = LevelThreeCategoryExpression.this.eval(levelThreeCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return LevelThreeCategoryExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T levelThreeCategory) {
        LevelThreeCategory parent = LevelThreeCategoryExpression.this.eval(levelThreeCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryExpression<T>
      getParentCategory() {
    return new com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryExpression<T>() {
      @Override
      public T $getRoot() {
        return LevelThreeCategoryExpression.this.$getRoot();
      }

      public LevelTwoCategory eval(T levelThreeCategory) {
        LevelThreeCategory parent = LevelThreeCategoryExpression.this.eval(levelThreeCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getParentCategory();
      }
    };
  }

  public com.doublechaintech.retailscm.product.ProductSmartListExpression<T> getProductList() {
    return new com.doublechaintech.retailscm.product.ProductSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return LevelThreeCategoryExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Product> eval(T levelThreeCategory) {
        LevelThreeCategory parent = LevelThreeCategoryExpression.this.eval(levelThreeCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProductList();
      }
    };
  }
}
