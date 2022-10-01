package com.doublechaintech.retailscm.levelonedepartment;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LevelOneDepartmentSmartListExpression<T>
    extends SmartListExpression<T, LevelOneDepartment> {
  public LevelOneDepartmentExpression<T> first() {
    return new LevelOneDepartmentExpression<T>() {
      @Override
      public LevelOneDepartment eval(T l) {
        List<LevelOneDepartment> list = LevelOneDepartmentSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LevelOneDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }

  public LevelOneDepartmentExpression<T> get(int index) {
    return new LevelOneDepartmentExpression<T>() {
      @Override
      public LevelOneDepartment eval(T l) {
        List<LevelOneDepartment> list = LevelOneDepartmentSmartListExpression.this.eval(l);
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
        return LevelOneDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }
}
