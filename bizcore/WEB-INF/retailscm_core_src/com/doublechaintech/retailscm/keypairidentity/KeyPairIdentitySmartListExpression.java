package com.doublechaintech.retailscm.keypairidentity;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class KeyPairIdentitySmartListExpression<T>
    extends SmartListExpression<T, KeyPairIdentity> {
  public KeyPairIdentityExpression<T> first() {
    return new KeyPairIdentityExpression<T>() {
      @Override
      public KeyPairIdentity eval(T l) {
        List<KeyPairIdentity> list = KeyPairIdentitySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return KeyPairIdentitySmartListExpression.this.$getRoot();
      }
    };
  }

  public KeyPairIdentityExpression<T> get(int index) {
    return new KeyPairIdentityExpression<T>() {
      @Override
      public KeyPairIdentity eval(T l) {
        List<KeyPairIdentity> list = KeyPairIdentitySmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return KeyPairIdentitySmartListExpression.this.$getRoot();
      }
    };
  }
}
