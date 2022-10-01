package com.doublechaintech.retailscm.scoring;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ScoringExpression<T> implements Expression<T, Scoring> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ScoringExpression.this.$getRoot();
      }

      @Override
      public String eval(T scoring) {
        Scoring parent = ScoringExpression.this.eval(scoring);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getScoredBy() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ScoringExpression.this.$getRoot();
      }

      @Override
      public String eval(T scoring) {
        Scoring parent = ScoringExpression.this.eval(scoring);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getScoredBy();
      }
    };
  }

  public Expression<T, Integer> getScore() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ScoringExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T scoring) {
        Scoring parent = ScoringExpression.this.eval(scoring);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getScore();
      }
    };
  }

  public Expression<T, String> getComment() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ScoringExpression.this.$getRoot();
      }

      @Override
      public String eval(T scoring) {
        Scoring parent = ScoringExpression.this.eval(scoring);
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
        return ScoringExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T scoring) {
        Scoring parent = ScoringExpression.this.eval(scoring);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.employeecompanytraining
              .EmployeeCompanyTrainingSmartListExpression<
          T>
      getEmployeeCompanyTrainingList() {
    return new com.doublechaintech.retailscm.employeecompanytraining
            .EmployeeCompanyTrainingSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return ScoringExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeCompanyTraining> eval(T scoring) {
        Scoring parent = ScoringExpression.this.eval(scoring);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeCompanyTrainingList();
      }
    };
  }
}
