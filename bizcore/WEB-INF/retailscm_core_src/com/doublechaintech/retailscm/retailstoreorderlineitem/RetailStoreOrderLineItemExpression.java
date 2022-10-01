package com.doublechaintech.retailscm.retailstoreorderlineitem;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreOrderLineItemExpression<T>
    implements Expression<T, RetailStoreOrderLineItem> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
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
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
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
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
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
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
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
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
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
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
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
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
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
        return RetailStoreOrderLineItemExpression.this.$getRoot();
      }

      public RetailStoreOrder eval(T retailStoreOrderLineItem) {
        RetailStoreOrderLineItem parent =
            RetailStoreOrderLineItemExpression.this.eval(retailStoreOrderLineItem);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
