package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreInvestmentInvitationSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreInvestmentInvitation> {
  public RetailStoreInvestmentInvitationExpression<T> first() {
    return new RetailStoreInvestmentInvitationExpression<T>() {
      @Override
      public RetailStoreInvestmentInvitation eval(T l) {
        List<RetailStoreInvestmentInvitation> list =
            RetailStoreInvestmentInvitationSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreInvestmentInvitationSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreInvestmentInvitationExpression<T> get(int index) {
    return new RetailStoreInvestmentInvitationExpression<T>() {
      @Override
      public RetailStoreInvestmentInvitation eval(T l) {
        List<RetailStoreInvestmentInvitation> list =
            RetailStoreInvestmentInvitationSmartListExpression.this.eval(l);
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
        return RetailStoreInvestmentInvitationSmartListExpression.this.$getRoot();
      }
    };
  }
}
