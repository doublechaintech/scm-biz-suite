package com.doublechaintech.retailscm.wechatminiappidentity;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class WechatMiniappIdentitySmartListExpression<T>
    extends SmartListExpression<T, WechatMiniappIdentity> {
  public WechatMiniappIdentityExpression<T> first() {
    return new WechatMiniappIdentityExpression<T>() {
      @Override
      public WechatMiniappIdentity eval(T l) {
        List<WechatMiniappIdentity> list = WechatMiniappIdentitySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return WechatMiniappIdentitySmartListExpression.this.$getRoot();
      }
    };
  }

  public WechatMiniappIdentityExpression<T> get(int index) {
    return new WechatMiniappIdentityExpression<T>() {
      @Override
      public WechatMiniappIdentity eval(T l) {
        List<WechatMiniappIdentity> list = WechatMiniappIdentitySmartListExpression.this.eval(l);
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
        return WechatMiniappIdentitySmartListExpression.this.$getRoot();
      }
    };
  }
}
