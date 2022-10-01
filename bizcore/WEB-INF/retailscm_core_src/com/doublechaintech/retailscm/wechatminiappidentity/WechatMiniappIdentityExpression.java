package com.doublechaintech.retailscm.wechatminiappidentity;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class WechatMiniappIdentityExpression<T>
    implements Expression<T, WechatMiniappIdentity> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      @Override
      public String eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getOpenId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      @Override
      public String eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOpenId();
      }
    };
  }

  public Expression<T, String> getAppId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      @Override
      public String eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAppId();
      }
    };
  }

  public Expression<T, String> getUnionId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      @Override
      public String eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUnionId();
      }
    };
  }

  public Expression<T, DateTime> getCreateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCreateTime();
      }
    };
  }

  public Expression<T, DateTime> getLastLoginTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastLoginTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
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
        return WechatMiniappIdentityExpression.this.$getRoot();
      }

      public SecUser eval(T wechatMiniappIdentity) {
        WechatMiniappIdentity parent =
            WechatMiniappIdentityExpression.this.eval(wechatMiniappIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSecUser();
      }
    };
  }
}
