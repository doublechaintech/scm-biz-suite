package com.doublechaintech.retailscm.sku;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SkuSmartListExpression<T> extends SmartListExpression<T, Sku> {
  public SkuExpression<T> first() {
    return new SkuExpression<T>() {
      @Override
      public Sku eval(T l) {
        List<Sku> list = SkuSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SkuSmartListExpression.this.$getRoot();
      }
    };
  }

  public SkuExpression<T> get(int index) {
    return new SkuExpression<T>() {
      @Override
      public Sku eval(T l) {
        List<Sku> list = SkuSmartListExpression.this.eval(l);
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
        return SkuSmartListExpression.this.$getRoot();
      }
    };
  }
}
