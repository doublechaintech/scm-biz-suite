package com.doublechaintech.retailscm.goodssupplier;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class GoodsSupplierSmartListExpression<T>
    extends SmartListExpression<T, GoodsSupplier> {
  public GoodsSupplierExpression<T> first() {
    return new GoodsSupplierExpression<T>() {
      @Override
      public GoodsSupplier eval(T l) {
        List<GoodsSupplier> list = GoodsSupplierSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return GoodsSupplierSmartListExpression.this.$getRoot();
      }
    };
  }

  public GoodsSupplierExpression<T> get(int index) {
    return new GoodsSupplierExpression<T>() {
      @Override
      public GoodsSupplier eval(T l) {
        List<GoodsSupplier> list = GoodsSupplierSmartListExpression.this.eval(l);
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
        return GoodsSupplierSmartListExpression.this.$getRoot();
      }
    };
  }
}
