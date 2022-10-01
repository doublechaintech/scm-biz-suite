package com.doublechaintech.retailscm.userdomain;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class UserDomainSmartListExpression<T> extends SmartListExpression<T, UserDomain> {
  public UserDomainExpression<T> first() {
    return new UserDomainExpression<T>() {
      @Override
      public UserDomain eval(T l) {
        List<UserDomain> list = UserDomainSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return UserDomainSmartListExpression.this.$getRoot();
      }
    };
  }

  public UserDomainExpression<T> get(int index) {
    return new UserDomainExpression<T>() {
      @Override
      public UserDomain eval(T l) {
        List<UserDomain> list = UserDomainSmartListExpression.this.eval(l);
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
        return UserDomainSmartListExpression.this.$getRoot();
      }
    };
  }
}
