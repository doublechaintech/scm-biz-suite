package com.doublechaintech.retailscm.retailstoremember;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class RetailStoreMemberSmartListExpression<T>
    extends SmartListExpression<T, RetailStoreMember> {
  public RetailStoreMemberExpression<T> first() {
    return new RetailStoreMemberExpression<T>() {
      @Override
      public RetailStoreMember eval(T l) {
        List<RetailStoreMember> list = RetailStoreMemberSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return RetailStoreMemberSmartListExpression.this.$getRoot();
      }
    };
  }

  public RetailStoreMemberExpression<T> get(int index) {
    return new RetailStoreMemberExpression<T>() {
      @Override
      public RetailStoreMember eval(T l) {
        List<RetailStoreMember> list = RetailStoreMemberSmartListExpression.this.eval(l);
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
        return RetailStoreMemberSmartListExpression.this.$getRoot();
      }
    };
  }
}
