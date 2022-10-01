package com.doublechaintech.retailscm.expression;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

import java.util.List;

public abstract class SmartListExpression<T, U extends BaseEntity>
    implements Expression<T, SmartList<U>> {

  @Override
  public T $getRoot() {
    return SmartListExpression.this.$getRoot();
  }

  public Expression<T, Integer> size() {
    return new Expression<T, Integer>() {
      @Override
      public Integer eval(T p) {
        List<U> list = SmartListExpression.this.eval(p);
        return CollectionUtil.size(list);
      }

      @Override
      public T $getRoot() {
        return SmartListExpression.this.$getRoot();
      }
    };
  }

  public Expression<T, U> first() {
    return new Expression<T, U>() {
      @Override
      public U eval(T p) {
        List<U> list = SmartListExpression.this.eval(p);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SmartListExpression.this.$getRoot();
      }
    };
  }

  public Expression<T, U> get(int index) {
    return new Expression<T, U>() {
      @Override
      public U eval(T p) {
        List<U> list = SmartListExpression.this.eval(p);
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
        return SmartListExpression.this.$getRoot();
      }
    };
  }
}
