package com.doublechaintech.retailscm.supplyorder;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SupplyOrderExpression<T> implements Expression<T, SupplyOrder> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
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
        return SupplyOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, String> getContract() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContract();
      }
    };
  }

  public Expression<T, BigDecimal> getTotalAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTotalAmount();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
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
        return SupplyOrderExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getBuyer() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBuyer();
      }
    };
  }

  public com.doublechaintech.retailscm.goodssupplier.GoodsSupplierExpression<T> getSeller() {
    return new com.doublechaintech.retailscm.goodssupplier.GoodsSupplierExpression<T>() {
      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      public GoodsSupplier eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSeller();
      }
    };
  }

  public com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemSmartListExpression<T>
      getSupplyOrderLineItemList() {
    return new com.doublechaintech.retailscm.supplyorderlineitem
            .SupplyOrderLineItemSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SupplyOrderLineItem> eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplyOrderLineItemList();
      }
    };
  }

  public com.doublechaintech.retailscm.supplyordershippinggroup
              .SupplyOrderShippingGroupSmartListExpression<
          T>
      getSupplyOrderShippingGroupList() {
    return new com.doublechaintech.retailscm.supplyordershippinggroup
            .SupplyOrderShippingGroupSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SupplyOrderShippingGroup> eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplyOrderShippingGroupList();
      }
    };
  }

  public com.doublechaintech.retailscm.supplyorderpaymentgroup
              .SupplyOrderPaymentGroupSmartListExpression<
          T>
      getSupplyOrderPaymentGroupList() {
    return new com.doublechaintech.retailscm.supplyorderpaymentgroup
            .SupplyOrderPaymentGroupSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<SupplyOrderPaymentGroup> eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSupplyOrderPaymentGroupList();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T> getGoodsList() {
    return new com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SupplyOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Goods> eval(T supplyOrder) {
        SupplyOrder parent = SupplyOrderExpression.this.eval(supplyOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsList();
      }
    };
  }
}
