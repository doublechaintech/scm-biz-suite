package com.doublechaintech.retailscm.retailstoremembergiftcard;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreMemberGiftCardSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreMemberGiftCard> {
  public RetailStoreMemberGiftCardExpression<T> first() {
    return new RetailStoreMemberGiftCardExpression<T>() {
      @Override
      public RetailStoreMemberGiftCard eval(T l) {
        List<RetailStoreMemberGiftCard> list =
            RetailStoreMemberGiftCardSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreMemberGiftCardSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreMemberGiftCardExpression<T> get(int index) {
    return new RetailStoreMemberGiftCardExpression<T>() {
      @Override
      public RetailStoreMemberGiftCard eval(T l) {
        List<RetailStoreMemberGiftCard> list =
            RetailStoreMemberGiftCardSmartListExpression.this.eval(l);
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
        return RetailStoreMemberGiftCardSmartListExpression.this.$getRoot();
      }
    };
  }
}
