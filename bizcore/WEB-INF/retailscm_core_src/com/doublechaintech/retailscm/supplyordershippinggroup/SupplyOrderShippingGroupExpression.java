package com.doublechaintech.retailscm.supplyordershippinggroup;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SupplyOrderShippingGroupExpression<T>
    implements Expression<T, SupplyOrderShippingGroup> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplyOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderShippingGroup) {
        SupplyOrderShippingGroup parent =
            SupplyOrderShippingGroupExpression.this.eval(supplyOrderShippingGroup);
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
        return SupplyOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrderShippingGroup) {
        SupplyOrderShippingGroup parent =
            SupplyOrderShippingGroupExpression.this.eval(supplyOrderShippingGroup);
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
        return SupplyOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T supplyOrderShippingGroup) {
        SupplyOrderShippingGroup parent =
            SupplyOrderShippingGroupExpression.this.eval(supplyOrderShippingGroup);
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
        return SupplyOrderShippingGroupExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T supplyOrderShippingGroup) {
        SupplyOrderShippingGroup parent =
            SupplyOrderShippingGroupExpression.this.eval(supplyOrderShippingGroup);
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
        return SupplyOrderShippingGroupExpression.this.$getRoot();
      }

      public SupplyOrder eval(T supplyOrderShippingGroup) {
        SupplyOrderShippingGroup parent =
            SupplyOrderShippingGroupExpression.this.eval(supplyOrderShippingGroup);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
