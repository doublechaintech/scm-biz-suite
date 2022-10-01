package com.doublechaintech.retailscm.consumerorderpriceadjustment;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ConsumerOrderPriceAdjustmentExpression<T>
    implements Expression<T, ConsumerOrderPriceAdjustment> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderPriceAdjustmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderPriceAdjustment) {
        ConsumerOrderPriceAdjustment parent =
            ConsumerOrderPriceAdjustmentExpression.this.eval(consumerOrderPriceAdjustment);
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
        return ConsumerOrderPriceAdjustmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderPriceAdjustment) {
        ConsumerOrderPriceAdjustment parent =
            ConsumerOrderPriceAdjustmentExpression.this.eval(consumerOrderPriceAdjustment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, BigDecimal> getAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderPriceAdjustmentExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T consumerOrderPriceAdjustment) {
        ConsumerOrderPriceAdjustment parent =
            ConsumerOrderPriceAdjustmentExpression.this.eval(consumerOrderPriceAdjustment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAmount();
      }
    };
  }

  public Expression<T, String> getProvider() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderPriceAdjustmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderPriceAdjustment) {
        ConsumerOrderPriceAdjustment parent =
            ConsumerOrderPriceAdjustmentExpression.this.eval(consumerOrderPriceAdjustment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getProvider();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderPriceAdjustmentExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T consumerOrderPriceAdjustment) {
        ConsumerOrderPriceAdjustment parent =
            ConsumerOrderPriceAdjustmentExpression.this.eval(consumerOrderPriceAdjustment);
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
        return ConsumerOrderPriceAdjustmentExpression.this.$getRoot();
      }

      public ConsumerOrder eval(T consumerOrderPriceAdjustment) {
        ConsumerOrderPriceAdjustment parent =
            ConsumerOrderPriceAdjustmentExpression.this.eval(consumerOrderPriceAdjustment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
