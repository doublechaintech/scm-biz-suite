package com.doublechaintech.retailscm.consumerorderlineitem;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ConsumerOrderLineItemExpression<T>
    implements Expression<T, ConsumerOrderLineItem> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getSkuId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSkuId();
      }
    };
  }

  public Expression<T, String> getSkuName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSkuName();
      }
    };
  }

  public Expression<T, BigDecimal> getPrice() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPrice();
      }
    };
  }

  public Expression<T, BigDecimal> getQuantity() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getQuantity();
      }
    };
  }

  public Expression<T, BigDecimal> getAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAmount();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastUpdateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
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
        return ConsumerOrderLineItemExpression.this.$getRoot();
      }

      public ConsumerOrder eval(T consumerOrderLineItem) {
        ConsumerOrderLineItem parent =
            ConsumerOrderLineItemExpression.this.eval(consumerOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
