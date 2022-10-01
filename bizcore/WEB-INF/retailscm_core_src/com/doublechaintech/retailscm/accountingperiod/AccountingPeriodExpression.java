package com.doublechaintech.retailscm.accountingperiod;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class AccountingPeriodExpression<T> implements Expression<T, AccountingPeriod> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingPeriodExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingPeriod) {
        AccountingPeriod parent = AccountingPeriodExpression.this.eval(accountingPeriod);
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
        return AccountingPeriodExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingPeriod) {
        AccountingPeriod parent = AccountingPeriodExpression.this.eval(accountingPeriod);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, DateTime> getStartDate() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return AccountingPeriodExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T accountingPeriod) {
        AccountingPeriod parent = AccountingPeriodExpression.this.eval(accountingPeriod);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStartDate();
      }
    };
  }

  public Expression<T, DateTime> getEndDate() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return AccountingPeriodExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T accountingPeriod) {
        AccountingPeriod parent = AccountingPeriodExpression.this.eval(accountingPeriod);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEndDate();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return AccountingPeriodExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T accountingPeriod) {
        AccountingPeriod parent = AccountingPeriodExpression.this.eval(accountingPeriod);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.accountset.AccountSetExpression<T> getAccountSet() {
    return new com.doublechaintech.retailscm.accountset.AccountSetExpression<T>() {
      @Override
      public T $getRoot() {
        return AccountingPeriodExpression.this.$getRoot();
      }

      public AccountSet eval(T accountingPeriod) {
        AccountingPeriod parent = AccountingPeriodExpression.this.eval(accountingPeriod);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountSet();
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
        return AccountingPeriodExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountingDocument> eval(T accountingPeriod) {
        AccountingPeriod parent = AccountingPeriodExpression.this.eval(accountingPeriod);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingDocumentList();
      }
    };
  }
}
