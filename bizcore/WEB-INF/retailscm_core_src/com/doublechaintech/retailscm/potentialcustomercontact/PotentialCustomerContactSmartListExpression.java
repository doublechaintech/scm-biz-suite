package com.doublechaintech.retailscm.potentialcustomercontact;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PotentialCustomerContactSmartListExpression<T>
    extends SmartListExpression<T, PotentialCustomerContact> {
  public PotentialCustomerContactExpression<T> first() {
    return new PotentialCustomerContactExpression<T>() {
      @Override
      public PotentialCustomerContact eval(T l) {
        List<PotentialCustomerContact> list =
            PotentialCustomerContactSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PotentialCustomerContactSmartListExpression.this.$getRoot();
      }
    };
  }

  public PotentialCustomerContactExpression<T> get(int index) {
    return new PotentialCustomerContactExpression<T>() {
      @Override
      public PotentialCustomerContact eval(T l) {
        List<PotentialCustomerContact> list =
            PotentialCustomerContactSmartListExpression.this.eval(l);
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
        return PotentialCustomerContactSmartListExpression.this.$getRoot();
      }
    };
  }
}
