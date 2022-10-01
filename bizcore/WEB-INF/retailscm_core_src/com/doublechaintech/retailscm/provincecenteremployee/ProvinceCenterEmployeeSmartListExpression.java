package com.doublechaintech.retailscm.provincecenteremployee;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ProvinceCenterEmployeeSmartListExpression<T>
    extends SmartListExpression<T, ProvinceCenterEmployee> {
  public ProvinceCenterEmployeeExpression<T> first() {
    return new ProvinceCenterEmployeeExpression<T>() {
      @Override
      public ProvinceCenterEmployee eval(T l) {
        List<ProvinceCenterEmployee> list = ProvinceCenterEmployeeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ProvinceCenterEmployeeSmartListExpression.this.$getRoot();
      }
    };
  }

  public ProvinceCenterEmployeeExpression<T> get(int index) {
    return new ProvinceCenterEmployeeExpression<T>() {
      @Override
      public ProvinceCenterEmployee eval(T l) {
        List<ProvinceCenterEmployee> list = ProvinceCenterEmployeeSmartListExpression.this.eval(l);
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
        return ProvinceCenterEmployeeSmartListExpression.this.$getRoot();
      }
    };
  }
}
