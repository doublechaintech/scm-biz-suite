package com.doublechaintech.retailscm.accountingdocumentline;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class AccountingDocumentLineSmartListExpression<T>
    extends SmartListExpression<T, AccountingDocumentLine> {
  public AccountingDocumentLineExpression<T> first() {
    return new AccountingDocumentLineExpression<T>() {
      @Override
      public AccountingDocumentLine eval(T l) {
        List<AccountingDocumentLine> list = AccountingDocumentLineSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return AccountingDocumentLineSmartListExpression.this.$getRoot();
      }
    };
  }

  public AccountingDocumentLineExpression<T> get(int index) {
    return new AccountingDocumentLineExpression<T>() {
      @Override
      public AccountingDocumentLine eval(T l) {
        List<AccountingDocumentLine> list = AccountingDocumentLineSmartListExpression.this.eval(l);
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
        return AccountingDocumentLineSmartListExpression.this.$getRoot();
      }
    };
  }
}
