package com.doublechaintech.retailscm.catalog;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class CatalogSmartListExpression<T> extends SmartListExpression<T, Catalog> {
  public CatalogExpression<T> first() {
    return new CatalogExpression<T>() {
      @Override
      public Catalog eval(T l) {
        List<Catalog> list = CatalogSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return CatalogSmartListExpression.this.$getRoot();
      }
    };
  }

  public CatalogExpression<T> get(int index) {
    return new CatalogExpression<T>() {
      @Override
      public Catalog eval(T l) {
        List<Catalog> list = CatalogSmartListExpression.this.eval(l);
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
        return CatalogSmartListExpression.this.$getRoot();
      }
    };
  }
}
