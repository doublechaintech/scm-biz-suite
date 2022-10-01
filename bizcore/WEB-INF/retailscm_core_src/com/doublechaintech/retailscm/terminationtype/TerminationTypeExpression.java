package com.doublechaintech.retailscm.terminationtype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TerminationTypeExpression<T> implements Expression<T, TerminationType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T terminationType) {
        TerminationType parent = TerminationTypeExpression.this.eval(terminationType);
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
        return TerminationTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T terminationType) {
        TerminationType parent = TerminationTypeExpression.this.eval(terminationType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getBaseDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T terminationType) {
        TerminationType parent = TerminationTypeExpression.this.eval(terminationType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBaseDescription();
      }
    };
  }

  public Expression<T, String> getDetailDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TerminationTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T terminationType) {
        TerminationType parent = TerminationTypeExpression.this.eval(terminationType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDetailDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TerminationTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T terminationType) {
        TerminationType parent = TerminationTypeExpression.this.eval(terminationType);
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
        return TerminationTypeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T terminationType) {
        TerminationType parent = TerminationTypeExpression.this.eval(terminationType);
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
        return TerminationTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Termination> eval(T terminationType) {
        TerminationType parent = TerminationTypeExpression.this.eval(terminationType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTerminationList();
      }
    };
  }
}
