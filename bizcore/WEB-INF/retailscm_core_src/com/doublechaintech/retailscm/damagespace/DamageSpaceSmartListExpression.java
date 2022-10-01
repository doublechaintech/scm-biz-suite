package com.doublechaintech.retailscm.damagespace;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class DamageSpaceSmartListExpression<T>
    extends SmartListExpression<T, DamageSpace> {
  public DamageSpaceExpression<T> first() {
    return new DamageSpaceExpression<T>() {
      @Override
      public DamageSpace eval(T l) {
        List<DamageSpace> list = DamageSpaceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return DamageSpaceSmartListExpression.this.$getRoot();
      }
    };
  }

  public DamageSpaceExpression<T> get(int index) {
    return new DamageSpaceExpression<T>() {
      @Override
      public DamageSpace eval(T l) {
        List<DamageSpace> list = DamageSpaceSmartListExpression.this.eval(l);
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
        return DamageSpaceSmartListExpression.this.$getRoot();
      }
    };
  }
}
