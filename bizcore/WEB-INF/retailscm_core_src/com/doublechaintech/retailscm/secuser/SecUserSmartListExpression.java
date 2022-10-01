package com.doublechaintech.retailscm.secuser;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SecUserSmartListExpression<T> extends SmartListExpression<T, SecUser> {
  public SecUserExpression<T> first() {
    return new SecUserExpression<T>() {
      @Override
      public SecUser eval(T l) {
        List<SecUser> list = SecUserSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SecUserSmartListExpression.this.$getRoot();
      }
    };
  }

  public SecUserExpression<T> get(int index) {
    return new SecUserExpression<T>() {
      @Override
      public SecUser eval(T l) {
        List<SecUser> list = SecUserSmartListExpression.this.eval(l);
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
        return SecUserSmartListExpression.this.$getRoot();
      }
    };
  }
}
