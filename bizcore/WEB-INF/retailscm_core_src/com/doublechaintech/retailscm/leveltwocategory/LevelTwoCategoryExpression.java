package com.doublechaintech.retailscm.leveltwocategory;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LevelTwoCategoryExpression<T> implements Expression<T, LevelTwoCategory> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelTwoCategoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelTwoCategory) {
        LevelTwoCategory parent = LevelTwoCategoryExpression.this.eval(levelTwoCategory);
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
        return LevelTwoCategoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelTwoCategory) {
        LevelTwoCategory parent = LevelTwoCategoryExpression.this.eval(levelTwoCategory);
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
        return LevelTwoCategoryExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T levelTwoCategory) {
        LevelTwoCategory parent = LevelTwoCategoryExpression.this.eval(levelTwoCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryExpression<T>
      getParentCategory() {
    return new com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryExpression<T>() {
      @Override
      public T $getRoot() {
        return LevelTwoCategoryExpression.this.$getRoot();
      }

      public LevelOneCategory eval(T levelTwoCategory) {
        LevelTwoCategory parent = LevelTwoCategoryExpression.this.eval(levelTwoCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getParentCategory();
      }
    };
  }

  public com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategorySmartListExpression<T>
      getLevelThreeCategoryList() {
    return new com.doublechaintech.retailscm.levelthreecategory
            .LevelThreeCategorySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return LevelTwoCategoryExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LevelThreeCategory> eval(T levelTwoCategory) {
        LevelTwoCategory parent = LevelTwoCategoryExpression.this.eval(levelTwoCategory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLevelThreeCategoryList();
      }
    };
  }
}
