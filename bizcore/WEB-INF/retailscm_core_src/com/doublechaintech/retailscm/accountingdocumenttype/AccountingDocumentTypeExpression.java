package com.doublechaintech.retailscm.accountingdocumenttype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class AccountingDocumentTypeExpression<T>
    implements Expression<T, AccountingDocumentType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocumentType) {
        AccountingDocumentType parent =
            AccountingDocumentTypeExpression.this.eval(accountingDocumentType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocumentType) {
        AccountingDocumentType parent =
            AccountingDocumentTypeExpression.this.eval(accountingDocumentType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocumentType) {
        AccountingDocumentType parent =
            AccountingDocumentTypeExpression.this.eval(accountingDocumentType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T accountingDocumentType) {
        AccountingDocumentType parent =
            AccountingDocumentTypeExpression.this.eval(accountingDocumentType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.accountset.AccountSetExpression<T> getAccountingPeriod() {
    return new com.doublechaintech.retailscm.accountset.AccountSetExpression<T>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentTypeExpression.this.$getRoot();
      }

      public AccountSet eval(T accountingDocumentType) {
        AccountingDocumentType parent =
            AccountingDocumentTypeExpression.this.eval(accountingDocumentType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingPeriod();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingdocument.AccountingDocumentSmartListExpression<T>
      getAccountingDocumentList() {
    return new com.doublechaintech.retailscm.accountingdocument
            .AccountingDocumentSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return AccountingDocumentTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountingDocument> eval(
          T accountingDocumentType) {
        AccountingDocumentType parent =
            AccountingDocumentTypeExpression.this.eval(accountingDocumentType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingDocumentList();
      }
    };
  }
}
