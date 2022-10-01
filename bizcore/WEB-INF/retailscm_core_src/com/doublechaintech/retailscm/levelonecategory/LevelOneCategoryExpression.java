package com.doublechaintech.retailscm.levelonecategory;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.catalog.Catalog;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LevelOneCategoryExpression<T> implements Expression<T, LevelOneCategory> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelOneCategoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelOneCategory) {
        LevelOneCategory parent = LevelOneCategoryExpression.this.eval(levelOneCategory);
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
        return LevelOneCategoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelOneCategory) {
        LevelOneCategory parent = LevelOneCategoryExpression.this.eval(levelOneCategory);
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
        return LevelOneCategoryExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T levelOneCategory) {
        LevelOneCategory parent = LevelOneCategoryExpression.this.eval(levelOneCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.catalog.CatalogExpression<T> getCatalog() {
    return new com.doublechaintech.retailscm.catalog.CatalogExpression<T>() {
      @Override
      public T $getRoot() {
        return LevelOneCategoryExpression.this.$getRoot();
      }

      public Catalog eval(T levelOneCategory) {
        LevelOneCategory parent = LevelOneCategoryExpression.this.eval(levelOneCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCatalog();
      }
    };
  }

  public com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategorySmartListExpression<T>
      getLevelTwoCategoryList() {
    return new com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategorySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return LevelOneCategoryExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LevelTwoCategory> eval(T levelOneCategory) {
        LevelOneCategory parent = LevelOneCategoryExpression.this.eval(levelOneCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLevelTwoCategoryList();
      }
    };
  }
}
