package com.doublechaintech.retailscm.listaccess;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ListAccessExpression<T> implements Expression<T, ListAccess> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public String eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
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
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public String eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getInternalName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public String eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getInternalName();
      }
    };
  }

  public Expression<T, Boolean> getReadPermission() {
    return new Expression<T, Boolean>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public Boolean eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getReadPermission();
      }
    };
  }

  public Expression<T, Boolean> getCreatePermission() {
    return new Expression<T, Boolean>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public Boolean eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCreatePermission();
      }
    };
  }

  public Expression<T, Boolean> getDeletePermission() {
    return new Expression<T, Boolean>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public Boolean eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDeletePermission();
      }
    };
  }

  public Expression<T, Boolean> getUpdatePermission() {
    return new Expression<T, Boolean>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public Boolean eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUpdatePermission();
      }
    };
  }

  public Expression<T, Boolean> getExecutionPermission() {
    return new Expression<T, Boolean>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public Boolean eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getExecutionPermission();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.userapp.UserAppExpression<T> getApp() {
    return new com.doublechaintech.retailscm.userapp.UserAppExpression<T>() {
      @Override
      public T $getRoot() {
        return ListAccessExpression.this.$getRoot();
      }

      public UserApp eval(T listAccess) {
        ListAccess parent = ListAccessExpression.this.eval(listAccess);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getApp();
      }
    };
  }
}
