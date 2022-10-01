package com.doublechaintech.retailscm.quicklink;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class QuickLinkExpression<T> implements Expression<T, QuickLink> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
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
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getIcon() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getIcon();
      }
    };
  }

  public Expression<T, String> getImagePath() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getImagePath();
      }
    };
  }

  public Expression<T, String> getLinkTarget() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public String eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLinkTarget();
      }
    };
  }

  public Expression<T, DateTime> getCreateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCreateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return QuickLinkExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
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
        return QuickLinkExpression.this.$getRoot();
      }

      public UserApp eval(T quickLink) {
        QuickLink parent = QuickLinkExpression.this.eval(quickLink);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getApp();
      }
    };
  }
}
