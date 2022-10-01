package com.doublechaintech.retailscm.terminationtype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TerminationTypeSmartListExpression<T>
    extends SmartListExpression<T, TerminationType> {
  public TerminationTypeExpression<T> first() {
    return new TerminationTypeExpression<T>() {
      @Override
      public TerminationType eval(T l) {
        List<TerminationType> list = TerminationTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TerminationTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public TerminationTypeExpression<T> get(int index) {
    return new TerminationTypeExpression<T>() {
      @Override
      public TerminationType eval(T l) {
        List<TerminationType> list = TerminationTypeSmartListExpression.this.eval(l);
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
        return TerminationTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
