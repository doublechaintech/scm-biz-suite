package com.doublechaintech.retailscm.retailstoremembergiftcard;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreMemberGiftCardExpression<T>
    implements Expression<T, RetailStoreMemberGiftCard> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberGiftCard) {
        RetailStoreMemberGiftCard parent =
            RetailStoreMemberGiftCardExpression.this.eval(retailStoreMemberGiftCard);
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
        return RetailStoreMemberGiftCardExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberGiftCard) {
        RetailStoreMemberGiftCard parent =
            RetailStoreMemberGiftCardExpression.this.eval(retailStoreMemberGiftCard);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreMemberGiftCard) {
        RetailStoreMemberGiftCard parent =
            RetailStoreMemberGiftCardExpression.this.eval(retailStoreMemberGiftCard);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getNumber();
      }
    };
  }

  public Expression<T, BigDecimal> getRemain() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T retailStoreMemberGiftCard) {
        RetailStoreMemberGiftCard parent =
            RetailStoreMemberGiftCardExpression.this.eval(retailStoreMemberGiftCard);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRemain();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreMemberGiftCard) {
        RetailStoreMemberGiftCard parent =
            RetailStoreMemberGiftCardExpression.this.eval(retailStoreMemberGiftCard);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T> getOwner() {
    return new com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T>() {
      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardExpression.this.$getRoot();
      }

      public RetailStoreMember eval(T retailStoreMemberGiftCard) {
        RetailStoreMemberGiftCard parent =
            RetailStoreMemberGiftCardExpression.this.eval(retailStoreMemberGiftCard);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
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
        return RetailStoreMemberGiftCardExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStoreMemberGiftCardConsumeRecord> eval(
          T retailStoreMemberGiftCard) {
        RetailStoreMemberGiftCard parent =
            RetailStoreMemberGiftCardExpression.this.eval(retailStoreMemberGiftCard);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreMemberGiftCardConsumeRecordList();
      }
    };
  }
}
