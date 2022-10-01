package com.doublechaintech.retailscm.accountingdocumenttype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class AccountingDocumentTypeSmartListExpression<T>
    extends SmartListExpression<T, AccountingDocumentType> {
  public AccountingDocumentTypeExpression<T> first() {
    return new AccountingDocumentTypeExpression<T>() {
      @Override
      public AccountingDocumentType eval(T l) {
        List<AccountingDocumentType> list = AccountingDocumentTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return AccountingDocumentTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public AccountingDocumentTypeExpression<T> get(int index) {
    return new AccountingDocumentTypeExpression<T>() {
      @Override
      public AccountingDocumentType eval(T l) {
        List<AccountingDocumentType> list = AccountingDocumentTypeSmartListExpression.this.eval(l);
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
        return AccountingDocumentTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
