package com.doublechaintech.retailscm.accountingsubject;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountset.AccountSet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class AccountingSubjectExpression<T> implements Expression<T, AccountingSubject> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingSubjectExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getAccountingSubjectCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingSubjectExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingSubjectCode();
      }
    };
  }

  public Expression<T, String> getAccountingSubjectName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingSubjectExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingSubjectName();
      }
    };
  }

  public Expression<T, Integer> getAccountingSubjectClassCode() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return AccountingSubjectExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingSubjectClassCode();
      }
    };
  }

  public Expression<T, String> getAccountingSubjectClassName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingSubjectExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingSubjectClassName();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return AccountingSubjectExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
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
        return AccountingSubjectExpression.this.$getRoot();
      }

      public AccountSet eval(T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountSet();
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
        return AccountingSubjectExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<AccountingDocumentLine> eval(
          T accountingSubject) {
        AccountingSubject parent = AccountingSubjectExpression.this.eval(accountingSubject);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingDocumentLineList();
      }
    };
  }
}
