package com.doublechaintech.retailscm.view;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ViewExpression<T> implements Expression<T, View> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ViewExpression.this.$getRoot();
      }

      @Override
      public String eval(T view) {
        View parent = ViewExpression.this.eval(view);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getWho() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ViewExpression.this.$getRoot();
      }

      @Override
      public String eval(T view) {
        View parent = ViewExpression.this.eval(view);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWho();
      }
    };
  }

  public Expression<T, String> getAssessment() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ViewExpression.this.$getRoot();
      }

      @Override
      public String eval(T view) {
        View parent = ViewExpression.this.eval(view);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAssessment();
      }
    };
  }

  public Expression<T, DateTime> getInterviewTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return ViewExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T view) {
        View parent = ViewExpression.this.eval(view);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getInterviewTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ViewExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T view) {
        View parent = ViewExpression.this.eval(view);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }
}
