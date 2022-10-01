package com.doublechaintech.retailscm.userapp;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class UserAppSmartListExpression<T> extends SmartListExpression<T, UserApp> {
  public UserAppExpression<T> first() {
    return new UserAppExpression<T>() {
      @Override
      public UserApp eval(T l) {
        List<UserApp> list = UserAppSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return UserAppSmartListExpression.this.$getRoot();
      }
    };
  }

  public UserAppExpression<T> get(int index) {
    return new UserAppExpression<T>() {
      @Override
      public UserApp eval(T l) {
        List<UserApp> list = UserAppSmartListExpression.this.eval(l);
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
        return UserAppSmartListExpression.this.$getRoot();
      }
    };
  }
}
