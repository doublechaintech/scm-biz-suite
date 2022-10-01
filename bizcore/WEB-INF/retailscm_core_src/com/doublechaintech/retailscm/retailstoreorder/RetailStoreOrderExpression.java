package com.doublechaintech.retailscm.retailstoreorder;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreOrderExpression<T> implements Expression<T, RetailStoreOrder> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, BigDecimal> getTotalAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTotalAmount();
      }
    };
  }

  public Expression<T, String> getContract() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContract();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
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
        return RetailStoreOrderExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T> getBuyer() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      public RetailStore eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBuyer();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getSeller() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSeller();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreorderlineitem
              .RetailStoreOrderLineItemSmartListExpression<
          T>
      getRetailStoreOrderLineItemList() {
    return new com.doublechaintech.retailscm.retailstoreorderlineitem
            .RetailStoreOrderLineItemSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreOrderLineItem> eval(
          T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreOrderLineItemList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreordershippinggroup
              .RetailStoreOrderShippingGroupSmartListExpression<
          T>
      getRetailStoreOrderShippingGroupList() {
    return new com.doublechaintech.retailscm.retailstoreordershippinggroup
            .RetailStoreOrderShippingGroupSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreOrderShippingGroup> eval(
          T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreOrderShippingGroupList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoreorderpaymentgroup
              .RetailStoreOrderPaymentGroupSmartListExpression<
          T>
      getRetailStoreOrderPaymentGroupList() {
    return new com.doublechaintech.retailscm.retailstoreorderpaymentgroup
            .RetailStoreOrderPaymentGroupSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreOrderPaymentGroup> eval(
          T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreOrderPaymentGroupList();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T> getGoodsList() {
    return new com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Goods> eval(T retailStoreOrder) {
        RetailStoreOrder parent = RetailStoreOrderExpression.this.eval(retailStoreOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsList();
      }
    };
  }
}
