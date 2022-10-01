package com.doublechaintech.retailscm.cityevent;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class CityEventSmartListExpression<T> extends SmartListExpression<T, CityEvent> {
  public CityEventExpression<T> first() {
    return new CityEventExpression<T>() {
      @Override
      public CityEvent eval(T l) {
        List<CityEvent> list = CityEventSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return CityEventSmartListExpression.this.$getRoot();
      }
    };
  }

  public CityEventExpression<T> get(int index) {
    return new CityEventExpression<T>() {
      @Override
      public CityEvent eval(T l) {
        List<CityEvent> list = CityEventSmartListExpression.this.eval(l);
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
        return CityEventSmartListExpression.this.$getRoot();
      }
    };
  }
}
