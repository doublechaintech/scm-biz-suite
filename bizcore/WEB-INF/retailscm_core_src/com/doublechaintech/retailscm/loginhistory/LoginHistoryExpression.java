package com.doublechaintech.retailscm.loginhistory;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LoginHistoryExpression<T> implements Expression<T, LoginHistory> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LoginHistoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T loginHistory) {
        LoginHistory parent = LoginHistoryExpression.this.eval(loginHistory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getLoginTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return LoginHistoryExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T loginHistory) {
        LoginHistory parent = LoginHistoryExpression.this.eval(loginHistory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLoginTime();
      }
    };
  }

  public Expression<T, String> getFromIp() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LoginHistoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T loginHistory) {
        LoginHistory parent = LoginHistoryExpression.this.eval(loginHistory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFromIp();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LoginHistoryExpression.this.$getRoot();
      }

      @Override
      public String eval(T loginHistory) {
        LoginHistory parent = LoginHistoryExpression.this.eval(loginHistory);
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
        return LoginHistoryExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T loginHistory) {
        LoginHistory parent = LoginHistoryExpression.this.eval(loginHistory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.secuser.SecUserExpression<T> getSecUser() {
    return new com.doublechaintech.retailscm.secuser.SecUserExpression<T>() {
      @Override
      public T $getRoot() {
        return LoginHistoryExpression.this.$getRoot();
      }

      public SecUser eval(T loginHistory) {
        LoginHistory parent = LoginHistoryExpression.this.eval(loginHistory);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSecUser();
      }
    };
  }
}
