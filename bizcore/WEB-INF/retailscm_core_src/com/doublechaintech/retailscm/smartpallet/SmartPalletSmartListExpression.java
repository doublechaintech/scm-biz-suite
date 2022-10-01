package com.doublechaintech.retailscm.smartpallet;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SmartPalletSmartListExpression<T>
    extends SmartListExpression<T, SmartPallet> {
  public SmartPalletExpression<T> first() {
    return new SmartPalletExpression<T>() {
      @Override
      public SmartPallet eval(T l) {
        List<SmartPallet> list = SmartPalletSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SmartPalletSmartListExpression.this.$getRoot();
      }
    };
  }

  public SmartPalletExpression<T> get(int index) {
    return new SmartPalletExpression<T>() {
      @Override
      public SmartPallet eval(T l) {
        List<SmartPallet> list = SmartPalletSmartListExpression.this.eval(l);
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
        return SmartPalletSmartListExpression.this.$getRoot();
      }
    };
  }
}
