package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreMemberGiftCardConsumeRecordExpression<T>
    implements Expression<T, RetailStoreMemberGiftCardConsumeRecord> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberGiftCardConsumeRecord) {
        RetailStoreMemberGiftCardConsumeRecord parent =
            RetailStoreMemberGiftCardConsumeRecordExpression.this.eval(
                retailStoreMemberGiftCardConsumeRecord);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getOccureTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T retailStoreMemberGiftCardConsumeRecord) {
        RetailStoreMemberGiftCardConsumeRecord parent =
            RetailStoreMemberGiftCardConsumeRecordExpression.this.eval(
                retailStoreMemberGiftCardConsumeRecord);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOccureTime();
      }
    };
  }

  public Expression<T, String> getNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberGiftCardConsumeRecord) {
        RetailStoreMemberGiftCardConsumeRecord parent =
            RetailStoreMemberGiftCardConsumeRecordExpression.this.eval(
                retailStoreMemberGiftCardConsumeRecord);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getNumber();
      }
    };
  }

  public Expression<T, BigDecimal> getAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T retailStoreMemberGiftCardConsumeRecord) {
        RetailStoreMemberGiftCardConsumeRecord parent =
            RetailStoreMemberGiftCardConsumeRecordExpression.this.eval(
                retailStoreMemberGiftCardConsumeRecord);
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
        return RetailStoreMemberGiftCardConsumeRecordExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreMemberGiftCardConsumeRecord) {
        RetailStoreMemberGiftCardConsumeRecord parent =
            RetailStoreMemberGiftCardConsumeRecordExpression.this.eval(
                retailStoreMemberGiftCardConsumeRecord);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremembergiftcard
              .RetailStoreMemberGiftCardExpression<
          T>
      getOwner() {
    return new com.doublechaintech.retailscm.retailstoremembergiftcard
            .RetailStoreMemberGiftCardExpression<
        T>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordExpression.this.$getRoot();
      }

      public RetailStoreMemberGiftCard eval(T retailStoreMemberGiftCardConsumeRecord) {
        RetailStoreMemberGiftCardConsumeRecord parent =
            RetailStoreMemberGiftCardConsumeRecordExpression.this.eval(
                retailStoreMemberGiftCardConsumeRecord);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public com.doublechaintech.retailscm.consumerorder.ConsumerOrderExpression<T> getBizOrder() {
    return new com.doublechaintech.retailscm.consumerorder.ConsumerOrderExpression<T>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordExpression.this.$getRoot();
      }

      public ConsumerOrder eval(T retailStoreMemberGiftCardConsumeRecord) {
        RetailStoreMemberGiftCardConsumeRecord parent =
            RetailStoreMemberGiftCardConsumeRecordExpression.this.eval(
                retailStoreMemberGiftCardConsumeRecord);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBizOrder();
      }
    };
  }
}
