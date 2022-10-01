package com.doublechaintech.retailscm.supplyorderlineitem;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SupplyOrderLineItemExpression<T>
    implements Expression<T, SupplyOrderLineItem> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
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
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
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
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSkuName();
      }
    };
  }

  public Expression<T, BigDecimal> getAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAmount();
      }
    };
  }

  public Expression<T, Integer> getQuantity() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getQuantity();
      }
    };
  }

  public Expression<T, String> getUnitOfMeasurement() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUnitOfMeasurement();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
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
        return SupplyOrderLineItemExpression.this.$getRoot();
      }

      public SupplyOrder eval(T supplyOrderLineItem) {
        SupplyOrderLineItem parent = SupplyOrderLineItemExpression.this.eval(supplyOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
