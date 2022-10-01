package com.doublechaintech.retailscm.goodsshelfstockcount;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class GoodsShelfStockCountSmartListExpression<T>
    extends SmartListExpression<T, GoodsShelfStockCount> {
  public GoodsShelfStockCountExpression<T> first() {
    return new GoodsShelfStockCountExpression<T>() {
      @Override
      public GoodsShelfStockCount eval(T l) {
        List<GoodsShelfStockCount> list = GoodsShelfStockCountSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return GoodsShelfStockCountSmartListExpression.this.$getRoot();
      }
    };
  }

  public GoodsShelfStockCountExpression<T> get(int index) {
    return new GoodsShelfStockCountExpression<T>() {
      @Override
      public GoodsShelfStockCount eval(T l) {
        List<GoodsShelfStockCount> list = GoodsShelfStockCountSmartListExpression.this.eval(l);
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
        return GoodsShelfStockCountSmartListExpression.this.$getRoot();
      }
    };
  }
}
