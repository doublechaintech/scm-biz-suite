package com.doublechaintech.retailscm.consumerorder;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ConsumerOrderExpression<T> implements Expression<T, ConsumerOrder> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
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
        return ConsumerOrderExpression.this.$getRoot();
      }

      @Override
      public String eval(T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
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
        return ConsumerOrderExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T>
      getConsumer() {
    return new com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      public RetailStoreMember eval(T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getConsumer();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T> getStore() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T>() {
      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      public RetailStore eval(T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStore();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerorderlineitem
              .ConsumerOrderLineItemSmartListExpression<
          T>
      getConsumerOrderLineItemList() {
    return new com.doublechaintech.retailscm.consumerorderlineitem
            .ConsumerOrderLineItemSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ConsumerOrderLineItem> eval(T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getConsumerOrderLineItemList();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerordershippinggroup
              .ConsumerOrderShippingGroupSmartListExpression<
          T>
      getConsumerOrderShippingGroupList() {
    return new com.doublechaintech.retailscm.consumerordershippinggroup
            .ConsumerOrderShippingGroupSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ConsumerOrderShippingGroup> eval(
          T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getConsumerOrderShippingGroupList();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerorderpaymentgroup
              .ConsumerOrderPaymentGroupSmartListExpression<
          T>
      getConsumerOrderPaymentGroupList() {
    return new com.doublechaintech.retailscm.consumerorderpaymentgroup
            .ConsumerOrderPaymentGroupSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ConsumerOrderPaymentGroup> eval(
          T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getConsumerOrderPaymentGroupList();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerorderpriceadjustment
              .ConsumerOrderPriceAdjustmentSmartListExpression<
          T>
      getConsumerOrderPriceAdjustmentList() {
    return new com.doublechaintech.retailscm.consumerorderpriceadjustment
            .ConsumerOrderPriceAdjustmentSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<ConsumerOrderPriceAdjustment> eval(
          T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getConsumerOrderPriceAdjustmentList();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord
              .RetailStoreMemberGiftCardConsumeRecordSmartListExpression<
          T>
      getRetailStoreMemberGiftCardConsumeRecordList() {
    return new com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord
            .RetailStoreMemberGiftCardConsumeRecordSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return ConsumerOrderExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreMemberGiftCardConsumeRecord> eval(
          T consumerOrder) {
        ConsumerOrder parent = ConsumerOrderExpression.this.eval(consumerOrder);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreMemberGiftCardConsumeRecordList();
      }
    };
  }
}
