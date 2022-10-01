package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreOrderPaymentGroupExpression<T>
    implements Expression<T, RetailStoreOrderPaymentGroup> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderPaymentGroup) {
        RetailStoreOrderPaymentGroup parent =
            RetailStoreOrderPaymentGroupExpression.this.eval(retailStoreOrderPaymentGroup);
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
        return RetailStoreOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderPaymentGroup) {
        RetailStoreOrderPaymentGroup parent =
            RetailStoreOrderPaymentGroupExpression.this.eval(retailStoreOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getCardNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderPaymentGroup) {
        RetailStoreOrderPaymentGroup parent =
            RetailStoreOrderPaymentGroupExpression.this.eval(retailStoreOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCardNumber();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreOrderPaymentGroup) {
        RetailStoreOrderPaymentGroup parent =
            RetailStoreOrderPaymentGroupExpression.this.eval(retailStoreOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderExpression<T>
      getBizOrder() {
    return new com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderExpression<T>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderPaymentGroupExpression.this.$getRoot();
      }

      public RetailStoreOrder eval(T retailStoreOrderPaymentGroup) {
        RetailStoreOrderPaymentGroup parent =
            RetailStoreOrderPaymentGroupExpression.this.eval(retailStoreOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
