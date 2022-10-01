package com.doublechaintech.retailscm.goodsmovement;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class GoodsMovementSmartListExpression<T>
    extends SmartListExpression<T, GoodsMovement> {
  public GoodsMovementExpression<T> first() {
    return new GoodsMovementExpression<T>() {
      @Override
      public GoodsMovement eval(T l) {
        List<GoodsMovement> list = GoodsMovementSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return GoodsMovementSmartListExpression.this.$getRoot();
      }
    };
  }

  public GoodsMovementExpression<T> get(int index) {
    return new GoodsMovementExpression<T>() {
      @Override
      public GoodsMovement eval(T l) {
        List<GoodsMovement> list = GoodsMovementSmartListExpression.this.eval(l);
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
        return GoodsMovementSmartListExpression.this.$getRoot();
      }
    };
  }
}
