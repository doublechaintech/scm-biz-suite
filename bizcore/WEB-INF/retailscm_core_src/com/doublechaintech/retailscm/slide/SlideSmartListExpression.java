package com.doublechaintech.retailscm.slide;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SlideSmartListExpression<T> extends SmartListExpression<T, Slide> {
  public SlideExpression<T> first() {
    return new SlideExpression<T>() {
      @Override
      public Slide eval(T l) {
        List<Slide> list = SlideSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SlideSmartListExpression.this.$getRoot();
      }
    };
  }

  public SlideExpression<T> get(int index) {
    return new SlideExpression<T>() {
      @Override
      public Slide eval(T l) {
        List<Slide> list = SlideSmartListExpression.this.eval(l);
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
        return SlideSmartListExpression.this.$getRoot();
      }
    };
  }
}
