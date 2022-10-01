package com.doublechaintech.retailscm.pagetype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PageTypeSmartListExpression<T> extends SmartListExpression<T, PageType> {
  public PageTypeExpression<T> first() {
    return new PageTypeExpression<T>() {
      @Override
      public PageType eval(T l) {
        List<PageType> list = PageTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PageTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public PageTypeExpression<T> get(int index) {
    return new PageTypeExpression<T>() {
      @Override
      public PageType eval(T l) {
        List<PageType> list = PageTypeSmartListExpression.this.eval(l);
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
        return PageTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
