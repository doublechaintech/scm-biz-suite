package com.doublechaintech.retailscm.publicholiday;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PublicHolidaySmartListExpression<T>
    extends SmartListExpression<T, PublicHoliday> {
  public PublicHolidayExpression<T> first() {
    return new PublicHolidayExpression<T>() {
      @Override
      public PublicHoliday eval(T l) {
        List<PublicHoliday> list = PublicHolidaySmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PublicHolidaySmartListExpression.this.$getRoot();
      }
    };
  }

  public PublicHolidayExpression<T> get(int index) {
    return new PublicHolidayExpression<T>() {
      @Override
      public PublicHoliday eval(T l) {
        List<PublicHoliday> list = PublicHolidaySmartListExpression.this.eval(l);
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
        return PublicHolidaySmartListExpression.this.$getRoot();
      }
    };
  }
}
