package com.doublechaintech.retailscm.occupationtype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class OccupationTypeSmartListExpression<T>
    extends SmartListExpression<T, OccupationType> {
  public OccupationTypeExpression<T> first() {
    return new OccupationTypeExpression<T>() {
      @Override
      public OccupationType eval(T l) {
        List<OccupationType> list = OccupationTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return OccupationTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public OccupationTypeExpression<T> get(int index) {
    return new OccupationTypeExpression<T>() {
      @Override
      public OccupationType eval(T l) {
        List<OccupationType> list = OccupationTypeSmartListExpression.this.eval(l);
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
        return OccupationTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
