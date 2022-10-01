package com.doublechaintech.retailscm.terminationreason;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TerminationReasonSmartListExpression<T>
    extends SmartListExpression<T, TerminationReason> {
  public TerminationReasonExpression<T> first() {
    return new TerminationReasonExpression<T>() {
      @Override
      public TerminationReason eval(T l) {
        List<TerminationReason> list = TerminationReasonSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TerminationReasonSmartListExpression.this.$getRoot();
      }
    };
  }

  public TerminationReasonExpression<T> get(int index) {
    return new TerminationReasonExpression<T>() {
      @Override
      public TerminationReason eval(T l) {
        List<TerminationReason> list = TerminationReasonSmartListExpression.this.eval(l);
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
        return TerminationReasonSmartListExpression.this.$getRoot();
      }
    };
  }
}
