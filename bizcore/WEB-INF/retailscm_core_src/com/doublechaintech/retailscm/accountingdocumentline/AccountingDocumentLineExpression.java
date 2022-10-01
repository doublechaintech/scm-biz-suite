package com.doublechaintech.retailscm.accountingdocumentline;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class AccountingDocumentLineExpression<T>
    implements Expression<T, AccountingDocumentLine> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
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
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getDirect() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      @Override
      public String eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDirect();
      }
    };
  }

  public Expression<T, BigDecimal> getAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAmount();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingdocument.AccountingDocumentExpression<T>
      getBelongsTo() {
    return new com.doublechaintech.retailscm.accountingdocument.AccountingDocumentExpression<T>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      public AccountingDocument eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }

  public com.doublechaintech.retailscm.accountingsubject.AccountingSubjectExpression<T>
      getAccountingSubject() {
    return new com.doublechaintech.retailscm.accountingsubject.AccountingSubjectExpression<T>() {
      @Override
      public T $getRoot() {
        return AccountingDocumentLineExpression.this.$getRoot();
      }

      public AccountingSubject eval(T accountingDocumentLine) {
        AccountingDocumentLine parent =
            AccountingDocumentLineExpression.this.eval(accountingDocumentLine);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAccountingSubject();
      }
    };
  }
}
