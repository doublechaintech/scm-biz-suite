package com.doublechaintech.retailscm.memberwishlistproduct;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class MemberWishlistProductExpression<T>
    implements Expression<T, MemberWishlistProduct> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return MemberWishlistProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T memberWishlistProduct) {
        MemberWishlistProduct parent =
            MemberWishlistProductExpression.this.eval(memberWishlistProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return MemberWishlistProductExpression.this.$getRoot();
      }

      @Override
      public String eval(T memberWishlistProduct) {
        MemberWishlistProduct parent =
            MemberWishlistProductExpression.this.eval(memberWishlistProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return MemberWishlistProductExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T memberWishlistProduct) {
        MemberWishlistProduct parent =
            MemberWishlistProductExpression.this.eval(memberWishlistProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.memberwishlist.MemberWishlistExpression<T> getOwner() {
    return new com.doublechaintech.retailscm.memberwishlist.MemberWishlistExpression<T>() {
      @Override
      public T $getRoot() {
        return MemberWishlistProductExpression.this.$getRoot();
      }

      public MemberWishlist eval(T memberWishlistProduct) {
        MemberWishlistProduct parent =
            MemberWishlistProductExpression.this.eval(memberWishlistProduct);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }
}
