package com.doublechaintech.retailscm.view;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ViewSmartListExpression<T> extends SmartListExpression<T, View> {
  public ViewExpression<T> first() {
    return new ViewExpression<T>() {
      @Override
      public View eval(T l) {
        List<View> list = ViewSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ViewSmartListExpression.this.$getRoot();
      }
    };
  }

  public ViewExpression<T> get(int index) {
    return new ViewExpression<T>() {
      @Override
      public View eval(T l) {
        List<View> list = ViewSmartListExpression.this.eval(l);
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
        return ViewSmartListExpression.this.$getRoot();
      }
    };
  }
}
