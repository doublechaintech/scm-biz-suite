package com.doublechaintech.retailscm.levelthreedepartment;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LevelThreeDepartmentSmartListExpression<T>
    extends SmartListExpression<T, LevelThreeDepartment> {
  public LevelThreeDepartmentExpression<T> first() {
    return new LevelThreeDepartmentExpression<T>() {
      @Override
      public LevelThreeDepartment eval(T l) {
        List<LevelThreeDepartment> list = LevelThreeDepartmentSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LevelThreeDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }

  public LevelThreeDepartmentExpression<T> get(int index) {
    return new LevelThreeDepartmentExpression<T>() {
      @Override
      public LevelThreeDepartment eval(T l) {
        List<LevelThreeDepartment> list = LevelThreeDepartmentSmartListExpression.this.eval(l);
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
        return LevelThreeDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }
}
