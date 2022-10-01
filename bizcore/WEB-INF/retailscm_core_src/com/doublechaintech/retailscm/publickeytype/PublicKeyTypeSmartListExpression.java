package com.doublechaintech.retailscm.publickeytype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class PublicKeyTypeSmartListExpression<T>
    extends SmartListExpression<T, PublicKeyType> {
  public PublicKeyTypeExpression<T> first() {
    return new PublicKeyTypeExpression<T>() {
      @Override
      public PublicKeyType eval(T l) {
        List<PublicKeyType> list = PublicKeyTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return PublicKeyTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public PublicKeyTypeExpression<T> get(int index) {
    return new PublicKeyTypeExpression<T>() {
      @Override
      public PublicKeyType eval(T l) {
        List<PublicKeyType> list = PublicKeyTypeSmartListExpression.this.eval(l);
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
        return PublicKeyTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
