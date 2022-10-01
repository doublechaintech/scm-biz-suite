package com.doublechaintech.retailscm.product;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ProductSmartListExpression<T> extends SmartListExpression<T, Product> {
  public ProductExpression<T> first() {
    return new ProductExpression<T>() {
      @Override
      public Product eval(T l) {
        List<Product> list = ProductSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ProductSmartListExpression.this.$getRoot();
      }
    };
  }

  public ProductExpression<T> get(int index) {
    return new ProductExpression<T>() {
      @Override
      public Product eval(T l) {
        List<Product> list = ProductSmartListExpression.this.eval(l);
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
        return ProductSmartListExpression.this.$getRoot();
      }
    };
  }
}
