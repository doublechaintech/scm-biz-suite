package com.doublechaintech.retailscm.candidatecontainer;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.candidateelement.CandidateElement;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class CandidateContainerExpression<T> implements Expression<T, CandidateContainer> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CandidateContainerExpression.this.$getRoot();
      }

      @Override
      public String eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CandidateContainerExpression.this.$getRoot();
      }

      @Override
      public String eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return CandidateContainerExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.candidateelement.CandidateElementSmartListExpression<T>
      getCandidateElementList() {
    return new com.doublechaintech.retailscm.candidateelement.CandidateElementSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return CandidateContainerExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<CandidateElement> eval(T candidateContainer) {
        CandidateContainer parent = CandidateContainerExpression.this.eval(candidateContainer);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCandidateElementList();
      }
    };
  }
}
