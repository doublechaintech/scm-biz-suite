package com.doublechaintech.retailscm.leveltwodepartment;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LevelTwoDepartmentSmartListExpression<T>
    extends SmartListExpression<T, LevelTwoDepartment> {
  public LevelTwoDepartmentExpression<T> first() {
    return new LevelTwoDepartmentExpression<T>() {
      @Override
      public LevelTwoDepartment eval(T l) {
        List<LevelTwoDepartment> list = LevelTwoDepartmentSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LevelTwoDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }

  public LevelTwoDepartmentExpression<T> get(int index) {
    return new LevelTwoDepartmentExpression<T>() {
      @Override
      public LevelTwoDepartment eval(T l) {
        List<LevelTwoDepartment> list = LevelTwoDepartmentSmartListExpression.this.eval(l);
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
        return LevelTwoDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }
}
