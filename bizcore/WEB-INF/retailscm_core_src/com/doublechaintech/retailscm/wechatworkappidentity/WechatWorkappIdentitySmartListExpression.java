package com.doublechaintech.retailscm.wechatworkappidentity;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class WechatWorkappIdentitySmartListExpression<T>
    extends SmartListExpression<T, WechatWorkappIdentity> {
  public WechatWorkappIdentityExpression<T> first() {
    return new WechatWorkappIdentityExpression<T>() {
      @Override
      public WechatWorkappIdentity eval(T l) {
        List<WechatWorkappIdentity> list = WechatWorkappIdentitySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return WechatWorkappIdentitySmartListExpression.this.$getRoot();
      }
    };
  }

  public WechatWorkappIdentityExpression<T> get(int index) {
    return new WechatWorkappIdentityExpression<T>() {
      @Override
      public WechatWorkappIdentity eval(T l) {
        List<WechatWorkappIdentity> list = WechatWorkappIdentitySmartListExpression.this.eval(l);
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
        return WechatWorkappIdentitySmartListExpression.this.$getRoot();
      }
    };
  }
}
