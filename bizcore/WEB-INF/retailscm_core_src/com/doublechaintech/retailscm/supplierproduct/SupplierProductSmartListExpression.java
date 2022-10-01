package com.doublechaintech.retailscm.supplierproduct;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SupplierProductSmartListExpression<T>
    extends SmartListExpression<T, SupplierProduct> {
  public SupplierProductExpression<T> first() {
    return new SupplierProductExpression<T>() {
      @Override
      public SupplierProduct eval(T l) {
        List<SupplierProduct> list = SupplierProductSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SupplierProductSmartListExpression.this.$getRoot();
      }
    };
  }

  public SupplierProductExpression<T> get(int index) {
    return new SupplierProductExpression<T>() {
      @Override
      public SupplierProduct eval(T l) {
        List<SupplierProduct> list = SupplierProductSmartListExpression.this.eval(l);
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
        return SupplierProductSmartListExpression.this.$getRoot();
      }
    };
  }
}
