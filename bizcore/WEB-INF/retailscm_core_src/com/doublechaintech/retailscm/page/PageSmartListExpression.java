package com.doublechaintech.retailscm.page;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PageSmartListExpression<T> extends SmartListExpression<T, Page> {
  public PageExpression<T> first() {
    return new PageExpression<T>() {
      @Override
      public Page eval(T l) {
        List<Page> list = PageSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PageSmartListExpression.this.$getRoot();
      }
    };
  }

  public PageExpression<T> get(int index) {
    return new PageExpression<T>() {
      @Override
      public Page eval(T l) {
        List<Page> list = PageSmartListExpression.this.eval(l);
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
        return PageSmartListExpression.this.$getRoot();
      }
    };
  }
}
