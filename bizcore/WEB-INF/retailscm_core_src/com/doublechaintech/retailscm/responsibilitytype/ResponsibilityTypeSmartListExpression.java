package com.doublechaintech.retailscm.responsibilitytype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ResponsibilityTypeSmartListExpression<T>
    extends SmartListExpression<T, ResponsibilityType> {
  public ResponsibilityTypeExpression<T> first() {
    return new ResponsibilityTypeExpression<T>() {
      @Override
      public ResponsibilityType eval(T l) {
        List<ResponsibilityType> list = ResponsibilityTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ResponsibilityTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public ResponsibilityTypeExpression<T> get(int index) {
    return new ResponsibilityTypeExpression<T>() {
      @Override
      public ResponsibilityType eval(T l) {
        List<ResponsibilityType> list = ResponsibilityTypeSmartListExpression.this.eval(l);
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
        return ResponsibilityTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
