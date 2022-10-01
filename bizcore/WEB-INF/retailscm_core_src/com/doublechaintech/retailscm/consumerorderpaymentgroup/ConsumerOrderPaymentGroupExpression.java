package com.doublechaintech.retailscm.consumerorderpaymentgroup;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ConsumerOrderPaymentGroupExpression<T>
    implements Expression<T, ConsumerOrderPaymentGroup> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderPaymentGroup) {
        ConsumerOrderPaymentGroup parent =
            ConsumerOrderPaymentGroupExpression.this.eval(consumerOrderPaymentGroup);
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
        return ConsumerOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderPaymentGroup) {
        ConsumerOrderPaymentGroup parent =
            ConsumerOrderPaymentGroupExpression.this.eval(consumerOrderPaymentGroup);
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
        return ConsumerOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderPaymentGroup) {
        ConsumerOrderPaymentGroup parent =
            ConsumerOrderPaymentGroupExpression.this.eval(consumerOrderPaymentGroup);
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
        return ConsumerOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T consumerOrderPaymentGroup) {
        ConsumerOrderPaymentGroup parent =
            ConsumerOrderPaymentGroupExpression.this.eval(consumerOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerorder.ConsumerOrderExpression<T> getBizOrder() {
    return new com.doublechaintech.retailscm.consumerorder.ConsumerOrderExpression<T>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderPaymentGroupExpression.this.$getRoot();
      }

      public ConsumerOrder eval(T consumerOrderPaymentGroup) {
        ConsumerOrderPaymentGroup parent =
            ConsumerOrderPaymentGroupExpression.this.eval(consumerOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
