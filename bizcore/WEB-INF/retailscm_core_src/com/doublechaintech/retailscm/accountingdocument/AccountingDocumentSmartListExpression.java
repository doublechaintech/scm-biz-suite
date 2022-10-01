package com.doublechaintech.retailscm.accountingdocument;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class AccountingDocumentSmartListExpression<T>
    extends SmartListExpression<T, AccountingDocument> {
  public AccountingDocumentExpression<T> first() {
    return new AccountingDocumentExpression<T>() {
      @Override
      public AccountingDocument eval(T l) {
        List<AccountingDocument> list = AccountingDocumentSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return AccountingDocumentSmartListExpression.this.$getRoot();
      }
    };
  }

  public AccountingDocumentExpression<T> get(int index) {
    return new AccountingDocumentExpression<T>() {
      @Override
      public AccountingDocument eval(T l) {
        List<AccountingDocument> list = AccountingDocumentSmartListExpression.this.eval(l);
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
        return AccountingDocumentSmartListExpression.this.$getRoot();
      }
    };
  }
}
