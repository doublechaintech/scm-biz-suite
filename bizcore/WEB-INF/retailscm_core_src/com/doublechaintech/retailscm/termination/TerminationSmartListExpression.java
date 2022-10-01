package com.doublechaintech.retailscm.termination;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TerminationSmartListExpression<T>
    extends SmartListExpression<T, Termination> {
  public TerminationExpression<T> first() {
    return new TerminationExpression<T>() {
      @Override
      public Termination eval(T l) {
        List<Termination> list = TerminationSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TerminationSmartListExpression.this.$getRoot();
      }
    };
  }

  public TerminationExpression<T> get(int index) {
    return new TerminationExpression<T>() {
      @Override
      public Termination eval(T l) {
        List<Termination> list = TerminationSmartListExpression.this.eval(l);
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
        return TerminationSmartListExpression.this.$getRoot();
      }
    };
  }
}
