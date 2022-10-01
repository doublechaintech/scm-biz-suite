package com.doublechaintech.retailscm.section;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SectionSmartListExpression<T> extends SmartListExpression<T, Section> {
  public SectionExpression<T> first() {
    return new SectionExpression<T>() {
      @Override
      public Section eval(T l) {
        List<Section> list = SectionSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SectionSmartListExpression.this.$getRoot();
      }
    };
  }

  public SectionExpression<T> get(int index) {
    return new SectionExpression<T>() {
      @Override
      public Section eval(T l) {
        List<Section> list = SectionSmartListExpression.this.eval(l);
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
        return SectionSmartListExpression.this.$getRoot();
      }
    };
  }
}
