package com.doublechaintech.retailscm.retailstoredecoration;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstore.RetailStore;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class RetailStoreDecorationExpression<T>
    implements Expression<T, RetailStoreDecoration> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return RetailStoreDecorationExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreDecoration) {
        RetailStoreDecoration parent =
            RetailStoreDecorationExpression.this.eval(retailStoreDecoration);
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
        return RetailStoreDecorationExpression.this.$getRoot();
      }

      @Override
      public String eval(T retailStoreDecoration) {
        RetailStoreDecoration parent =
            RetailStoreDecorationExpression.this.eval(retailStoreDecoration);
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
        return RetailStoreDecorationExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T retailStoreDecoration) {
        RetailStoreDecoration parent =
            RetailStoreDecorationExpression.this.eval(retailStoreDecoration);
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
        return RetailStoreDecorationExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<RetailStore> eval(T retailStoreDecoration) {
        RetailStoreDecoration parent =
            RetailStoreDecorationExpression.this.eval(retailStoreDecoration);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getRetailStoreList();
      }
    };
  }
}
