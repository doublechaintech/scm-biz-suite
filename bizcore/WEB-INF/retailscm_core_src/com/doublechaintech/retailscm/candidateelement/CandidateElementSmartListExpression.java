package com.doublechaintech.retailscm.candidateelement;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class CandidateElementSmartListExpression<T>
    extends SmartListExpression<T, CandidateElement> {
  public CandidateElementExpression<T> first() {
    return new CandidateElementExpression<T>() {
      @Override
      public CandidateElement eval(T l) {
        List<CandidateElement> list = CandidateElementSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return CandidateElementSmartListExpression.this.$getRoot();
      }
    };
  }

  public CandidateElementExpression<T> get(int index) {
    return new CandidateElementExpression<T>() {
      @Override
      public CandidateElement eval(T l) {
        List<CandidateElement> list = CandidateElementSmartListExpression.this.eval(l);
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
        return CandidateElementSmartListExpression.this.$getRoot();
      }
    };
  }
}
