package com.doublechaintech.retailscm.consumerordershippinggroup;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ConsumerOrderShippingGroupExpression<T>
    implements Expression<T, ConsumerOrderShippingGroup> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderShippingGroup) {
        ConsumerOrderShippingGroup parent =
            ConsumerOrderShippingGroupExpression.this.eval(consumerOrderShippingGroup);
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
        return ConsumerOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrderShippingGroup) {
        ConsumerOrderShippingGroup parent =
            ConsumerOrderShippingGroupExpression.this.eval(consumerOrderShippingGroup);
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
        return ConsumerOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T consumerOrderShippingGroup) {
        ConsumerOrderShippingGroup parent =
            ConsumerOrderShippingGroupExpression.this.eval(consumerOrderShippingGroup);
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
        return ConsumerOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T consumerOrderShippingGroup) {
        ConsumerOrderShippingGroup parent =
            ConsumerOrderShippingGroupExpression.this.eval(consumerOrderShippingGroup);
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
        return ConsumerOrderShippingGroupExpression.this.$getRoot();
      }

      public ConsumerOrder eval(T consumerOrderShippingGroup) {
        ConsumerOrderShippingGroup parent =
            ConsumerOrderShippingGroupExpression.this.eval(consumerOrderShippingGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
