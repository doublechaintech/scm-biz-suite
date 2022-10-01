package com.doublechaintech.retailscm.goodsshelf;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class GoodsShelfSmartListExpression<T> extends SmartListExpression<T, GoodsShelf> {
  public GoodsShelfExpression<T> first() {
    return new GoodsShelfExpression<T>() {
      @Override
      public GoodsShelf eval(T l) {
        List<GoodsShelf> list = GoodsShelfSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return GoodsShelfSmartListExpression.this.$getRoot();
      }
    };
  }

  public GoodsShelfExpression<T> get(int index) {
    return new GoodsShelfExpression<T>() {
      @Override
      public GoodsShelf eval(T l) {
        List<GoodsShelf> list = GoodsShelfSmartListExpression.this.eval(l);
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
        return GoodsShelfSmartListExpression.this.$getRoot();
      }
    };
  }
}
