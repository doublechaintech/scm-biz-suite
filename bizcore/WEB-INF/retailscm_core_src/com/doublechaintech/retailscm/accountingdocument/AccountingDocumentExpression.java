package com.doublechaintech.retailscm.accountingdocument;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class AccountingDocumentExpression<T> implements Expression<T, AccountingDocument> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
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
        return AccountingDocumentExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, DateTime> getAccountingDocumentDate() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingDocumentDate();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingperiod.AccountingPeriodExpression<T>
      getAccountingPeriod() {
    return new com.doublechaintech.retailscm.accountingperiod.AccountingPeriodExpression<T>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentExpression.this.$getRoot();
      }

      public AccountingPeriod eval(T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingPeriod();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeExpression<T>
      getDocumentType() {
    return new com.doublechaintech.retailscm.accountingdocumenttype
            .AccountingDocumentTypeExpression<
        T>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentExpression.this.$getRoot();
      }

      public AccountingDocumentType eval(T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDocumentType();
      }
    };
  }

  public com.doublechaintech.retailscm.originalvoucher.OriginalVoucherSmartListExpression<T>
      getOriginalVoucherList() {
    return new com.doublechaintech.retailscm.originalvoucher.OriginalVoucherSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return AccountingDocumentExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<OriginalVoucher> eval(T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOriginalVoucherList();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingdocumentline
              .AccountingDocumentLineSmartListExpression<
          T>
      getAccountingDocumentLineList() {
    return new com.doublechaintech.retailscm.accountingdocumentline
            .AccountingDocumentLineSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return AccountingDocumentExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountingDocumentLine> eval(
          T accountingDocument) {
        AccountingDocument parent = AccountingDocumentExpression.this.eval(accountingDocument);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingDocumentLineList();
      }
    };
  }
}
