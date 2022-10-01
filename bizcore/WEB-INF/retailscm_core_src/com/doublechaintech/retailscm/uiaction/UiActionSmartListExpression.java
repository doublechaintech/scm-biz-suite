package com.doublechaintech.retailscm.uiaction;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class UiActionSmartListExpression<T> extends SmartListExpression<T, UiAction> {
  public UiActionExpression<T> first() {
    return new UiActionExpression<T>() {
      @Override
      public UiAction eval(T l) {
        List<UiAction> list = UiActionSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return UiActionSmartListExpression.this.$getRoot();
      }
    };
  }

  public UiActionExpression<T> get(int index) {
    return new UiActionExpression<T>() {
      @Override
      public UiAction eval(T l) {
        List<UiAction> list = UiActionSmartListExpression.this.eval(l);
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
        return UiActionSmartListExpression.this.$getRoot();
      }
    };
  }
}
