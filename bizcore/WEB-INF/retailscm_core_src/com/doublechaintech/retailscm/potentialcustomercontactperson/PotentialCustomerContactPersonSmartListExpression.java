package com.doublechaintech.retailscm.potentialcustomercontactperson;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PotentialCustomerContactPersonSmartListExpression<T>
    extends SmartListExpression<T, PotentialCustomerContactPerson> {
  public PotentialCustomerContactPersonExpression<T> first() {
    return new PotentialCustomerContactPersonExpression<T>() {
      @Override
      public PotentialCustomerContactPerson eval(T l) {
        List<PotentialCustomerContactPerson> list =
            PotentialCustomerContactPersonSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PotentialCustomerContactPersonSmartListExpression.this.$getRoot();
      }
    };
  }

  public PotentialCustomerContactPersonExpression<T> get(int index) {
    return new PotentialCustomerContactPersonExpression<T>() {
      @Override
      public PotentialCustomerContactPerson eval(T l) {
        List<PotentialCustomerContactPerson> list =
            PotentialCustomerContactPersonSmartListExpression.this.eval(l);
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
        return PotentialCustomerContactPersonSmartListExpression.this.$getRoot();
      }
    };
  }
}
