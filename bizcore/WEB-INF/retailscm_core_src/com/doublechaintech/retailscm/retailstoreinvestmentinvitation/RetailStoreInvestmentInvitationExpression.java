package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstore.RetailStore;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreInvestmentInvitationExpression<T>
    implements Expression<T, RetailStoreInvestmentInvitation> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreInvestmentInvitationExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreInvestmentInvitation) {
        RetailStoreInvestmentInvitation parent =
            RetailStoreInvestmentInvitationExpression.this.eval(retailStoreInvestmentInvitation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getComment() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreInvestmentInvitationExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreInvestmentInvitation) {
        RetailStoreInvestmentInvitation parent =
            RetailStoreInvestmentInvitationExpression.this.eval(retailStoreInvestmentInvitation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getComment();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return RetailStoreInvestmentInvitationExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreInvestmentInvitation) {
        RetailStoreInvestmentInvitation parent =
            RetailStoreInvestmentInvitationExpression.this.eval(retailStoreInvestmentInvitation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreSmartListExpression<T>
      getRetailStoreList() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return RetailStoreInvestmentInvitationExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStore> eval(
          T retailStoreInvestmentInvitation) {
        RetailStoreInvestmentInvitation parent =
            RetailStoreInvestmentInvitationExpression.this.eval(retailStoreInvestmentInvitation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreList();
      }
    };
  }
}
