package com.doublechaintech.retailscm.leveltwocategory;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LevelTwoCategorySmartListExpression<T>
    extends SmartListExpression<T, LevelTwoCategory> {
  public LevelTwoCategoryExpression<T> first() {
    return new LevelTwoCategoryExpression<T>() {
      @Override
      public LevelTwoCategory eval(T l) {
        List<LevelTwoCategory> list = LevelTwoCategorySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LevelTwoCategorySmartListExpression.this.$getRoot();
      }
    };
  }

  public LevelTwoCategoryExpression<T> get(int index) {
    return new LevelTwoCategoryExpression<T>() {
      @Override
      public LevelTwoCategory eval(T l) {
        List<LevelTwoCategory> list = LevelTwoCategorySmartListExpression.this.eval(l);
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
        return LevelTwoCategorySmartListExpression.this.$getRoot();
      }
    };
  }
}
