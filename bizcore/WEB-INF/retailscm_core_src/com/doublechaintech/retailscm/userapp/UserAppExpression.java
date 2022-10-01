package com.doublechaintech.retailscm.userapp;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class UserAppExpression<T> implements Expression<T, UserApp> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, String> getAppIcon() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAppIcon();
      }
    };
  }

  public Expression<T, Boolean> getFullAccess() {
    return new Expression<T, Boolean>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public Boolean eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFullAccess();
      }
    };
  }

  public Expression<T, String> getPermission() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPermission();
      }
    };
  }

  public Expression<T, String> getAppType() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAppType();
      }
    };
  }

  public Expression<T, String> getAppId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAppId();
      }
    };
  }

  public Expression<T, String> getCtxType() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCtxType();
      }
    };
  }

  public Expression<T, String> getCtxId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCtxId();
      }
    };
  }

  public Expression<T, String> getLocation() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public String eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLocation();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
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
        return UserAppExpression.this.$getRoot();
      }

      public SecUser eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSecUser();
      }
    };
  }

  public com.doublechaintech.retailscm.quicklink.QuickLinkSmartListExpression<T>
      getQuickLinkList() {
    return new com.doublechaintech.retailscm.quicklink.QuickLinkSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<QuickLink> eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getQuickLinkList();
      }
    };
  }

  public com.doublechaintech.retailscm.listaccess.ListAccessSmartListExpression<T>
      getListAccessList() {
    return new com.doublechaintech.retailscm.listaccess.ListAccessSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return UserAppExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ListAccess> eval(T userApp) {
        UserApp parent = UserAppExpression.this.eval(userApp);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getListAccessList();
      }
    };
  }
}
