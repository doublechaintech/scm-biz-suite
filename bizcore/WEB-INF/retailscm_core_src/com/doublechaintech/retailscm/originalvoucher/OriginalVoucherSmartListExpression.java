package com.doublechaintech.retailscm.originalvoucher;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class OriginalVoucherSmartListExpression<T>
    extends SmartListExpression<T, OriginalVoucher> {
  public OriginalVoucherExpression<T> first() {
    return new OriginalVoucherExpression<T>() {
      @Override
      public OriginalVoucher eval(T l) {
        List<OriginalVoucher> list = OriginalVoucherSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return OriginalVoucherSmartListExpression.this.$getRoot();
      }
    };
  }

  public OriginalVoucherExpression<T> get(int index) {
    return new OriginalVoucherExpression<T>() {
      @Override
      public OriginalVoucher eval(T l) {
        List<OriginalVoucher> list = OriginalVoucherSmartListExpression.this.eval(l);
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
        return OriginalVoucherSmartListExpression.this.$getRoot();
      }
    };
  }
}
