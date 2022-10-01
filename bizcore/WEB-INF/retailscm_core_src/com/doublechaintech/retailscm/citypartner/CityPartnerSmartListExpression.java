package com.doublechaintech.retailscm.citypartner;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class CityPartnerSmartListExpression<T>
    extends SmartListExpression<T, CityPartner> {
  public CityPartnerExpression<T> first() {
    return new CityPartnerExpression<T>() {
      @Override
      public CityPartner eval(T l) {
        List<CityPartner> list = CityPartnerSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return CityPartnerSmartListExpression.this.$getRoot();
      }
    };
  }

  public CityPartnerExpression<T> get(int index) {
    return new CityPartnerExpression<T>() {
      @Override
      public CityPartner eval(T l) {
        List<CityPartner> list = CityPartnerSmartListExpression.this.eval(l);
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
        return CityPartnerSmartListExpression.this.$getRoot();
      }
    };
  }
}
