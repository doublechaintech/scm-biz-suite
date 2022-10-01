package com.doublechaintech.retailscm.accountingsubject;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class AccountingSubjectSmartListExpression<T>
    extends SmartListExpression<T, AccountingSubject> {
  public AccountingSubjectExpression<T> first() {
    return new AccountingSubjectExpression<T>() {
      @Override
      public AccountingSubject eval(T l) {
        List<AccountingSubject> list = AccountingSubjectSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return AccountingSubjectSmartListExpression.this.$getRoot();
      }
    };
  }

  public AccountingSubjectExpression<T> get(int index) {
    return new AccountingSubjectExpression<T>() {
      @Override
      public AccountingSubject eval(T l) {
        List<AccountingSubject> list = AccountingSubjectSmartListExpression.this.eval(l);
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
        return AccountingSubjectSmartListExpression.this.$getRoot();
      }
    };
  }
}
