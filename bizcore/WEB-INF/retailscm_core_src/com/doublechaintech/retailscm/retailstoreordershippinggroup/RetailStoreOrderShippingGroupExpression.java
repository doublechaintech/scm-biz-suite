package com.doublechaintech.retailscm.retailstoreordershippinggroup;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreOrderShippingGroupExpression<T>
    implements Expression<T, RetailStoreOrderShippingGroup> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderShippingGroup) {
        RetailStoreOrderShippingGroup parent =
            RetailStoreOrderShippingGroupExpression.this.eval(retailStoreOrderShippingGroup);
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
        return RetailStoreOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrderShippingGroup) {
        RetailStoreOrderShippingGroup parent =
            RetailStoreOrderShippingGroupExpression.this.eval(retailStoreOrderShippingGroup);
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
        return RetailStoreOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T retailStoreOrderShippingGroup) {
        RetailStoreOrderShippingGroup parent =
            RetailStoreOrderShippingGroupExpression.this.eval(retailStoreOrderShippingGroup);
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
        return RetailStoreOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreOrderShippingGroup) {
        RetailStoreOrderShippingGroup parent =
            RetailStoreOrderShippingGroupExpression.this.eval(retailStoreOrderShippingGroup);
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
        return RetailStoreOrderShippingGroupExpression.this.$getRoot();
      }

      public RetailStoreOrder eval(T retailStoreOrderShippingGroup) {
        RetailStoreOrderShippingGroup parent =
            RetailStoreOrderShippingGroupExpression.this.eval(retailStoreOrderShippingGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
