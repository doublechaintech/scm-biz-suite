package com.doublechaintech.retailscm.potentialcustomer;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PotentialCustomerSmartListExpression<T>
    extends SmartListExpression<T, PotentialCustomer> {
  public PotentialCustomerExpression<T> first() {
    return new PotentialCustomerExpression<T>() {
      @Override
      public PotentialCustomer eval(T l) {
        List<PotentialCustomer> list = PotentialCustomerSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PotentialCustomerSmartListExpression.this.$getRoot();
      }
    };
  }

  public PotentialCustomerExpression<T> get(int index) {
    return new PotentialCustomerExpression<T>() {
      @Override
      public PotentialCustomer eval(T l) {
        List<PotentialCustomer> list = PotentialCustomerSmartListExpression.this.eval(l);
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
        return PotentialCustomerSmartListExpression.this.$getRoot();
      }
    };
  }
}
