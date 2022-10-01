package com.doublechaintech.retailscm.accountset;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class AccountSetSmartListExpression<T> extends SmartListExpression<T, AccountSet> {
  public AccountSetExpression<T> first() {
    return new AccountSetExpression<T>() {
      @Override
      public AccountSet eval(T l) {
        List<AccountSet> list = AccountSetSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return AccountSetSmartListExpression.this.$getRoot();
      }
    };
  }

  public AccountSetExpression<T> get(int index) {
    return new AccountSetExpression<T>() {
      @Override
      public AccountSet eval(T l) {
        List<AccountSet> list = AccountSetSmartListExpression.this.eval(l);
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
        return AccountSetSmartListExpression.this.$getRoot();
      }
    };
  }
}
