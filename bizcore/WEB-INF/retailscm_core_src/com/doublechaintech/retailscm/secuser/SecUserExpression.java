package com.doublechaintech.retailscm.secuser;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SecUserExpression<T> implements Expression<T, SecUser> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getLogin() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLogin();
      }
    };
  }

  public Expression<T, String> getMobile() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobile();
      }
    };
  }

  public Expression<T, String> getEmail() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmail();
      }
    };
  }

  public Expression<T, String> getPwd() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPwd();
      }
    };
  }

  public Expression<T, String> getWeixinOpenid() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWeixinOpenid();
      }
    };
  }

  public Expression<T, String> getWeixinAppid() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWeixinAppid();
      }
    };
  }

  public Expression<T, String> getAccessToken() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public String eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccessToken();
      }
    };
  }

  public Expression<T, Integer> getVerificationCode() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVerificationCode();
      }
    };
  }

  public Expression<T, DateTime> getVerificationCodeExpire() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVerificationCodeExpire();
      }
    };
  }

  public Expression<T, DateTime> getLastLoginTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
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
        return SecUserExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
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
        return SecUserExpression.this.$getRoot();
      }

      public UserDomain eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDomain();
      }
    };
  }

  public com.doublechaintech.retailscm.userapp.UserAppSmartListExpression<T> getUserAppList() {
    return new com.doublechaintech.retailscm.userapp.UserAppSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<UserApp> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUserAppList();
      }
    };
  }

  public com.doublechaintech.retailscm.loginhistory.LoginHistorySmartListExpression<T>
      getLoginHistoryList() {
    return new com.doublechaintech.retailscm.loginhistory.LoginHistorySmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LoginHistory> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLoginHistoryList();
      }
    };
  }

  public com.doublechaintech.retailscm.wechatworkappidentity
              .WechatWorkappIdentitySmartListExpression<
          T>
      getWechatWorkappIdentityList() {
    return new com.doublechaintech.retailscm.wechatworkappidentity
            .WechatWorkappIdentitySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<WechatWorkappIdentity> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWechatWorkappIdentityList();
      }
    };
  }

  public com.doublechaintech.retailscm.wechatminiappidentity
              .WechatMiniappIdentitySmartListExpression<
          T>
      getWechatMiniappIdentityList() {
    return new com.doublechaintech.retailscm.wechatminiappidentity
            .WechatMiniappIdentitySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<WechatMiniappIdentity> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWechatMiniappIdentityList();
      }
    };
  }

  public com.doublechaintech.retailscm.keypairidentity.KeyPairIdentitySmartListExpression<T>
      getKeyPairIdentityList() {
    return new com.doublechaintech.retailscm.keypairidentity.KeyPairIdentitySmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SecUserExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<KeyPairIdentity> eval(T secUser) {
        SecUser parent = SecUserExpression.this.eval(secUser);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getKeyPairIdentityList();
      }
    };
  }
}
