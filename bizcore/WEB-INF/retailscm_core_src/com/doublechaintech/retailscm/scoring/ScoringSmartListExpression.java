package com.doublechaintech.retailscm.scoring;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ScoringSmartListExpression<T> extends SmartListExpression<T, Scoring> {
  public ScoringExpression<T> first() {
    return new ScoringExpression<T>() {
      @Override
      public Scoring eval(T l) {
        List<Scoring> list = ScoringSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ScoringSmartListExpression.this.$getRoot();
      }
    };
  }

  public ScoringExpression<T> get(int index) {
    return new ScoringExpression<T>() {
      @Override
      public Scoring eval(T l) {
        List<Scoring> list = ScoringSmartListExpression.this.eval(l);
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
        return ScoringSmartListExpression.this.$getRoot();
      }
    };
  }
}
