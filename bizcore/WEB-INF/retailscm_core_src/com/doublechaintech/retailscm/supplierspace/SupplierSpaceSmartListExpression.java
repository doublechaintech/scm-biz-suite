package com.doublechaintech.retailscm.supplierspace;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SupplierSpaceSmartListExpression<T>
    extends SmartListExpression<T, SupplierSpace> {
  public SupplierSpaceExpression<T> first() {
    return new SupplierSpaceExpression<T>() {
      @Override
      public SupplierSpace eval(T l) {
        List<SupplierSpace> list = SupplierSpaceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SupplierSpaceSmartListExpression.this.$getRoot();
      }
    };
  }

  public SupplierSpaceExpression<T> get(int index) {
    return new SupplierSpaceExpression<T>() {
      @Override
      public SupplierSpace eval(T l) {
        List<SupplierSpace> list = SupplierSpaceSmartListExpression.this.eval(l);
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
        return SupplierSpaceSmartListExpression.this.$getRoot();
      }
    };
  }
}
