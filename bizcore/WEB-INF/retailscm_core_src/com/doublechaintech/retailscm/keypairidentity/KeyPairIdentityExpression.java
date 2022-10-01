package com.doublechaintech.retailscm.keypairidentity;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class KeyPairIdentityExpression<T> implements Expression<T, KeyPairIdentity> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return KeyPairIdentityExpression.this.$getRoot();
      }

      @Override
      public String eval(T keyPairIdentity) {
        KeyPairIdentity parent = KeyPairIdentityExpression.this.eval(keyPairIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getPublicKey() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return KeyPairIdentityExpression.this.$getRoot();
      }

      @Override
      public String eval(T keyPairIdentity) {
        KeyPairIdentity parent = KeyPairIdentityExpression.this.eval(keyPairIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPublicKey();
      }
    };
  }

  public Expression<T, DateTime> getCreateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return KeyPairIdentityExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T keyPairIdentity) {
        KeyPairIdentity parent = KeyPairIdentityExpression.this.eval(keyPairIdentity);
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
        return KeyPairIdentityExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T keyPairIdentity) {
        KeyPairIdentity parent = KeyPairIdentityExpression.this.eval(keyPairIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.publickeytype.PublicKeyTypeExpression<T> getKeyType() {
    return new com.doublechaintech.retailscm.publickeytype.PublicKeyTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return KeyPairIdentityExpression.this.$getRoot();
      }

      public PublicKeyType eval(T keyPairIdentity) {
        KeyPairIdentity parent = KeyPairIdentityExpression.this.eval(keyPairIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getKeyType();
      }
    };
  }

  public com.doublechaintech.retailscm.secuser.SecUserExpression<T> getSecUser() {
    return new com.doublechaintech.retailscm.secuser.SecUserExpression<T>() {
      @Override
      public T $getRoot() {
        return KeyPairIdentityExpression.this.$getRoot();
      }

      public SecUser eval(T keyPairIdentity) {
        KeyPairIdentity parent = KeyPairIdentityExpression.this.eval(keyPairIdentity);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSecUser();
      }
    };
  }
}
