package com.doublechaintech.retailscm.listaccess;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ListAccessSmartListExpression<T> extends SmartListExpression<T, ListAccess> {
  public ListAccessExpression<T> first() {
    return new ListAccessExpression<T>() {
      @Override
      public ListAccess eval(T l) {
        List<ListAccess> list = ListAccessSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ListAccessSmartListExpression.this.$getRoot();
      }
    };
  }

  public ListAccessExpression<T> get(int index) {
    return new ListAccessExpression<T>() {
      @Override
      public ListAccess eval(T l) {
        List<ListAccess> list = ListAccessSmartListExpression.this.eval(l);
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
        return ListAccessSmartListExpression.this.$getRoot();
      }
    };
  }
}
