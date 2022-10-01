package com.doublechaintech.retailscm.accountingperiod;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class AccountingPeriodSmartListExpression<T>
    extends SmartListExpression<T, AccountingPeriod> {
  public AccountingPeriodExpression<T> first() {
    return new AccountingPeriodExpression<T>() {
      @Override
      public AccountingPeriod eval(T l) {
        List<AccountingPeriod> list = AccountingPeriodSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return AccountingPeriodSmartListExpression.this.$getRoot();
      }
    };
  }

  public AccountingPeriodExpression<T> get(int index) {
    return new AccountingPeriodExpression<T>() {
      @Override
      public AccountingPeriod eval(T l) {
        List<AccountingPeriod> list = AccountingPeriodSmartListExpression.this.eval(l);
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
        return AccountingPeriodSmartListExpression.this.$getRoot();
      }
    };
  }
}
