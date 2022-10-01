package com.doublechaintech.retailscm.mobileapp;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class MobileAppSmartListExpression<T> extends SmartListExpression<T, MobileApp> {
  public MobileAppExpression<T> first() {
    return new MobileAppExpression<T>() {
      @Override
      public MobileApp eval(T l) {
        List<MobileApp> list = MobileAppSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return MobileAppSmartListExpression.this.$getRoot();
      }
    };
  }

  public MobileAppExpression<T> get(int index) {
    return new MobileAppExpression<T>() {
      @Override
      public MobileApp eval(T l) {
        List<MobileApp> list = MobileAppSmartListExpression.this.eval(l);
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
        return MobileAppSmartListExpression.this.$getRoot();
      }
    };
  }
}
