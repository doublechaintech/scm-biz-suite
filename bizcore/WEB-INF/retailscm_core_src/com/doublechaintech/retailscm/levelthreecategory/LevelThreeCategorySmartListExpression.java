package com.doublechaintech.retailscm.levelthreecategory;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LevelThreeCategorySmartListExpression<T>
    extends SmartListExpression<T, LevelThreeCategory> {
  public LevelThreeCategoryExpression<T> first() {
    return new LevelThreeCategoryExpression<T>() {
      @Override
      public LevelThreeCategory eval(T l) {
        List<LevelThreeCategory> list = LevelThreeCategorySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LevelThreeCategorySmartListExpression.this.$getRoot();
      }
    };
  }

  public LevelThreeCategoryExpression<T> get(int index) {
    return new LevelThreeCategoryExpression<T>() {
      @Override
      public LevelThreeCategory eval(T l) {
        List<LevelThreeCategory> list = LevelThreeCategorySmartListExpression.this.eval(l);
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
        return LevelThreeCategorySmartListExpression.this.$getRoot();
      }
    };
  }
}
