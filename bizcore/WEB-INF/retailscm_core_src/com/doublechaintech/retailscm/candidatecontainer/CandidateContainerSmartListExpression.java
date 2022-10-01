package com.doublechaintech.retailscm.candidatecontainer;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class CandidateContainerSmartListExpression<T>
    extends SmartListExpression<T, CandidateContainer> {
  public CandidateContainerExpression<T> first() {
    return new CandidateContainerExpression<T>() {
      @Override
      public CandidateContainer eval(T l) {
        List<CandidateContainer> list = CandidateContainerSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return CandidateContainerSmartListExpression.this.$getRoot();
      }
    };
  }

  public CandidateContainerExpression<T> get(int index) {
    return new CandidateContainerExpression<T>() {
      @Override
      public CandidateContainer eval(T l) {
        List<CandidateContainer> list = CandidateContainerSmartListExpression.this.eval(l);
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
        return CandidateContainerSmartListExpression.this.$getRoot();
      }
    };
  }
}
