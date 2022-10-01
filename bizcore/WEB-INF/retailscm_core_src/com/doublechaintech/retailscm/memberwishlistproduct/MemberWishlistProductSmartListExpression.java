package com.doublechaintech.retailscm.memberwishlistproduct;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class MemberWishlistProductSmartListExpression<T>
    extends SmartListExpression<T, MemberWishlistProduct> {
  public MemberWishlistProductExpression<T> first() {
    return new MemberWishlistProductExpression<T>() {
      @Override
      public MemberWishlistProduct eval(T l) {
        List<MemberWishlistProduct> list = MemberWishlistProductSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return MemberWishlistProductSmartListExpression.this.$getRoot();
      }
    };
  }

  public MemberWishlistProductExpression<T> get(int index) {
    return new MemberWishlistProductExpression<T>() {
      @Override
      public MemberWishlistProduct eval(T l) {
        List<MemberWishlistProduct> list = MemberWishlistProductSmartListExpression.this.eval(l);
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
        return MemberWishlistProductSmartListExpression.this.$getRoot();
      }
    };
  }
}
