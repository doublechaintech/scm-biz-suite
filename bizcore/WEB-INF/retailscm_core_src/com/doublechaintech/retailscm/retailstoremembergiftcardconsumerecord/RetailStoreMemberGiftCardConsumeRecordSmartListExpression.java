package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreMemberGiftCardConsumeRecordSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreMemberGiftCardConsumeRecord> {
  public RetailStoreMemberGiftCardConsumeRecordExpression<T> first() {
    return new RetailStoreMemberGiftCardConsumeRecordExpression<T>() {
      @Override
      public RetailStoreMemberGiftCardConsumeRecord eval(T l) {
        List<RetailStoreMemberGiftCardConsumeRecord> list =
            RetailStoreMemberGiftCardConsumeRecordSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreMemberGiftCardConsumeRecordExpression<T> get(int index) {
    return new RetailStoreMemberGiftCardConsumeRecordExpression<T>() {
      @Override
      public RetailStoreMemberGiftCardConsumeRecord eval(T l) {
        List<RetailStoreMemberGiftCardConsumeRecord> list =
            RetailStoreMemberGiftCardConsumeRecordSmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardConsumeRecordSmartListExpression.this.$getRoot();
      }
    };
  }
}
