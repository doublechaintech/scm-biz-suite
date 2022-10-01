package com.doublechaintech.retailscm.levelonecategory;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LevelOneCategorySmartListExpression<T>
    extends SmartListExpression<T, LevelOneCategory> {
  public LevelOneCategoryExpression<T> first() {
    return new LevelOneCategoryExpression<T>() {
      @Override
      public LevelOneCategory eval(T l) {
        List<LevelOneCategory> list = LevelOneCategorySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LevelOneCategorySmartListExpression.this.$getRoot();
      }
    };
  }

  public LevelOneCategoryExpression<T> get(int index) {
    return new LevelOneCategoryExpression<T>() {
      @Override
      public LevelOneCategory eval(T l) {
        List<LevelOneCategory> list = LevelOneCategorySmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return LevelOneCategorySmartListExpression.this.$getRoot();
      }
    };
  }
}
