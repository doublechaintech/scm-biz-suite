package com.doublechaintech.retailscm.memberwishlist;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class MemberWishlistSmartListExpression<T>
    extends SmartListExpression<T, MemberWishlist> {
  public MemberWishlistExpression<T> first() {
    return new MemberWishlistExpression<T>() {
      @Override
      public MemberWishlist eval(T l) {
        List<MemberWishlist> list = MemberWishlistSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return MemberWishlistSmartListExpression.this.$getRoot();
      }
    };
  }

  public MemberWishlistExpression<T> get(int index) {
    return new MemberWishlistExpression<T>() {
      @Override
      public MemberWishlist eval(T l) {
        List<MemberWishlist> list = MemberWishlistSmartListExpression.this.eval(l);
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
        return MemberWishlistSmartListExpression.this.$getRoot();
      }
    };
  }
}
