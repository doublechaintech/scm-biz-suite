package com.doublechaintech.retailscm.goods;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class GoodsSmartListExpression<T> extends SmartListExpression<T, Goods> {
  public GoodsExpression<T> first() {
    return new GoodsExpression<T>() {
      @Override
      public Goods eval(T l) {
        List<Goods> list = GoodsSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return GoodsSmartListExpression.this.$getRoot();
      }
    };
  }

  public GoodsExpression<T> get(int index) {
    return new GoodsExpression<T>() {
      @Override
      public Goods eval(T l) {
        List<Goods> list = GoodsSmartListExpression.this.eval(l);
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
        return GoodsSmartListExpression.this.$getRoot();
      }
    };
  }
}
