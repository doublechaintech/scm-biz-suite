package com.doublechaintech.retailscm.terminationreason;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TerminationReasonExpression<T> implements Expression<T, TerminationReason> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationReasonExpression.this.$getRoot();
      }

      @Override
      public String eval(T terminationReason) {
        TerminationReason parent = TerminationReasonExpression.this.eval(terminationReason);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationReasonExpression.this.$getRoot();
      }

      @Override
      public String eval(T terminationReason) {
        TerminationReason parent = TerminationReasonExpression.this.eval(terminationReason);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationReasonExpression.this.$getRoot();
      }

      @Override
      public String eval(T terminationReason) {
        TerminationReason parent = TerminationReasonExpression.this.eval(terminationReason);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TerminationReasonExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T terminationReason) {
        TerminationReason parent = TerminationReasonExpression.this.eval(terminationReason);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getCompany() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return TerminationReasonExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T terminationReason) {
        TerminationReason parent = TerminationReasonExpression.this.eval(terminationReason);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.termination.TerminationSmartListExpression<T>
      getTerminationList() {
    return new com.doublechaintech.retailscm.termination.TerminationSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return TerminationReasonExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Termination> eval(T terminationReason) {
        TerminationReason parent = TerminationReasonExpression.this.eval(terminationReason);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTerminationList();
      }
    };
  }
}
