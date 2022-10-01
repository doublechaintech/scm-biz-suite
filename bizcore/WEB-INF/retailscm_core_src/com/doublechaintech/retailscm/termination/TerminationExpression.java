package com.doublechaintech.retailscm.termination;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TerminationExpression<T> implements Expression<T, Termination> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationExpression.this.$getRoot();
      }

      @Override
      public String eval(T termination) {
        Termination parent = TerminationExpression.this.eval(termination);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getComment() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationExpression.this.$getRoot();
      }

      @Override
      public String eval(T termination) {
        Termination parent = TerminationExpression.this.eval(termination);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getComment();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TerminationExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T termination) {
        Termination parent = TerminationExpression.this.eval(termination);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.terminationreason.TerminationReasonExpression<T>
      getReason() {
    return new com.doublechaintech.retailscm.terminationreason.TerminationReasonExpression<T>() {
      @Override
      public T $getRoot() {
        return TerminationExpression.this.$getRoot();
      }

      public TerminationReason eval(T termination) {
        Termination parent = TerminationExpression.this.eval(termination);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getReason();
      }
    };
  }

  public com.doublechaintech.retailscm.terminationtype.TerminationTypeExpression<T> getType() {
    return new com.doublechaintech.retailscm.terminationtype.TerminationTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return TerminationExpression.this.$getRoot();
      }

      public TerminationType eval(T termination) {
        Termination parent = TerminationExpression.this.eval(termination);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getType();
      }
    };
  }
}
