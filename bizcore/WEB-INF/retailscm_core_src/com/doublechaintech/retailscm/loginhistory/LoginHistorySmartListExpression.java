package com.doublechaintech.retailscm.loginhistory;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LoginHistorySmartListExpression<T>
    extends SmartListExpression<T, LoginHistory> {
  public LoginHistoryExpression<T> first() {
    return new LoginHistoryExpression<T>() {
      @Override
      public LoginHistory eval(T l) {
        List<LoginHistory> list = LoginHistorySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LoginHistorySmartListExpression.this.$getRoot();
      }
    };
  }

  public LoginHistoryExpression<T> get(int index) {
    return new LoginHistoryExpression<T>() {
      @Override
      public LoginHistory eval(T l) {
        List<LoginHistory> list = LoginHistorySmartListExpression.this.eval(l);
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
        return LoginHistorySmartListExpression.this.$getRoot();
      }
    };
  }
}
