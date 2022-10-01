package com.doublechaintech.retailscm.userallowlist;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class UserAllowListSmartListExpression<T>
    extends SmartListExpression<T, UserAllowList> {
  public UserAllowListExpression<T> first() {
    return new UserAllowListExpression<T>() {
      @Override
      public UserAllowList eval(T l) {
        List<UserAllowList> list = UserAllowListSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return UserAllowListSmartListExpression.this.$getRoot();
      }
    };
  }

  public UserAllowListExpression<T> get(int index) {
    return new UserAllowListExpression<T>() {
      @Override
      public UserAllowList eval(T l) {
        List<UserAllowList> list = UserAllowListSmartListExpression.this.eval(l);
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
        return UserAllowListSmartListExpression.this.$getRoot();
      }
    };
  }
}
