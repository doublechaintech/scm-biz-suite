package com.doublechaintech.retailscm.quicklink;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class QuickLinkSmartListExpression<T> extends SmartListExpression<T, QuickLink> {
  public QuickLinkExpression<T> first() {
    return new QuickLinkExpression<T>() {
      @Override
      public QuickLink eval(T l) {
        List<QuickLink> list = QuickLinkSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return QuickLinkSmartListExpression.this.$getRoot();
      }
    };
  }

  public QuickLinkExpression<T> get(int index) {
    return new QuickLinkExpression<T>() {
      @Override
      public QuickLink eval(T l) {
        List<QuickLink> list = QuickLinkSmartListExpression.this.eval(l);
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
        return QuickLinkSmartListExpression.this.$getRoot();
      }
    };
  }
}
