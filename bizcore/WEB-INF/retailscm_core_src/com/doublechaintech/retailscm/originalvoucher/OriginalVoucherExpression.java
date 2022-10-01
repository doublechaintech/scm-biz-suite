package com.doublechaintech.retailscm.originalvoucher;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class OriginalVoucherExpression<T> implements Expression<T, OriginalVoucher> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return OriginalVoucherExpression.this.$getRoot();
      }

      @Override
      public String eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return OriginalVoucherExpression.this.$getRoot();
      }

      @Override
      public String eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, String> getMadeBy() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return OriginalVoucherExpression.this.$getRoot();
      }

      @Override
      public String eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMadeBy();
      }
    };
  }

  public Expression<T, String> getReceivedBy() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return OriginalVoucherExpression.this.$getRoot();
      }

      @Override
      public String eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getReceivedBy();
      }
    };
  }

  public Expression<T, String> getVoucherType() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return OriginalVoucherExpression.this.$getRoot();
      }

      @Override
      public String eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVoucherType();
      }
    };
  }

  public Expression<T, String> getVoucherImage() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return OriginalVoucherExpression.this.$getRoot();
      }

      @Override
      public String eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVoucherImage();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return OriginalVoucherExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
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
        return OriginalVoucherExpression.this.$getRoot();
      }

      public AccountingDocument eval(T originalVoucher) {
        OriginalVoucher parent = OriginalVoucherExpression.this.eval(originalVoucher);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }
}
