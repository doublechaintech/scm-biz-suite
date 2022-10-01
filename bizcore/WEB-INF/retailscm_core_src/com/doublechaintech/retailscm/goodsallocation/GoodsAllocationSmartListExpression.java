package com.doublechaintech.retailscm.goodsallocation;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class GoodsAllocationSmartListExpression<T>
    extends SmartListExpression<T, GoodsAllocation> {
  public GoodsAllocationExpression<T> first() {
    return new GoodsAllocationExpression<T>() {
      @Override
      public GoodsAllocation eval(T l) {
        List<GoodsAllocation> list = GoodsAllocationSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return GoodsAllocationSmartListExpression.this.$getRoot();
      }
    };
  }

  public GoodsAllocationExpression<T> get(int index) {
    return new GoodsAllocationExpression<T>() {
      @Override
      public GoodsAllocation eval(T l) {
        List<GoodsAllocation> list = GoodsAllocationSmartListExpression.this.eval(l);
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
        return GoodsAllocationSmartListExpression.this.$getRoot();
      }
    };
  }
}
