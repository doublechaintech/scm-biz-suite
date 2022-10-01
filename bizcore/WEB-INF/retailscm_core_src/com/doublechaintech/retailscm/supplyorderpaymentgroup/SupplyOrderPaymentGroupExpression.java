package com.doublechaintech.retailscm.supplyorderpaymentgroup;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SupplyOrderPaymentGroupExpression<T>
    implements Expression<T, SupplyOrderPaymentGroup> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplyOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderPaymentGroup) {
        SupplyOrderPaymentGroup parent =
            SupplyOrderPaymentGroupExpression.this.eval(supplyOrderPaymentGroup);
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
        return SupplyOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderPaymentGroup) {
        SupplyOrderPaymentGroup parent =
            SupplyOrderPaymentGroupExpression.this.eval(supplyOrderPaymentGroup);
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
        return SupplyOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderPaymentGroup) {
        SupplyOrderPaymentGroup parent =
            SupplyOrderPaymentGroupExpression.this.eval(supplyOrderPaymentGroup);
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
        return SupplyOrderPaymentGroupExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T supplyOrderPaymentGroup) {
        SupplyOrderPaymentGroup parent =
            SupplyOrderPaymentGroupExpression.this.eval(supplyOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.supplyorder.SupplyOrderExpression<T> getBizOrder() {
    return new com.doublechaintech.retailscm.supplyorder.SupplyOrderExpression<T>() {
      @Override
      public T $getRoot() {
        return SupplyOrderPaymentGroupExpression.this.$getRoot();
      }

      public SupplyOrder eval(T supplyOrderPaymentGroup) {
        SupplyOrderPaymentGroup parent =
            SupplyOrderPaymentGroupExpression.this.eval(supplyOrderPaymentGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
