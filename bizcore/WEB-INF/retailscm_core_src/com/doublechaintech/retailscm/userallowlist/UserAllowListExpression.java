package com.doublechaintech.retailscm.userallowlist;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.userdomain.UserDomain;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class UserAllowListExpression<T> implements Expression<T, UserAllowList> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAllowListExpression.this.$getRoot();
      }

      @Override
      public String eval(T userAllowList) {
        UserAllowList parent = UserAllowListExpression.this.eval(userAllowList);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getUserIdentity() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAllowListExpression.this.$getRoot();
      }

      @Override
      public String eval(T userAllowList) {
        UserAllowList parent = UserAllowListExpression.this.eval(userAllowList);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUserIdentity();
      }
    };
  }

  public Expression<T, String> getUserSpecialFunctions() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAllowListExpression.this.$getRoot();
      }

      @Override
      public String eval(T userAllowList) {
        UserAllowList parent = UserAllowListExpression.this.eval(userAllowList);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUserSpecialFunctions();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return UserAllowListExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T userAllowList) {
        UserAllowList parent = UserAllowListExpression.this.eval(userAllowList);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.userdomain.UserDomainExpression<T> getDomain() {
    return new com.doublechaintech.retailscm.userdomain.UserDomainExpression<T>() {
      @Override
      public T $getRoot() {
        return UserAllowListExpression.this.$getRoot();
      }

      public UserDomain eval(T userAllowList) {
        UserAllowList parent = UserAllowListExpression.this.eval(userAllowList);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDomain();
      }
    };
  }
}
