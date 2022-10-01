package com.doublechaintech.retailscm.memberwishlist;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class MemberWishlistExpression<T> implements Expression<T, MemberWishlist> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return MemberWishlistExpression.this.$getRoot();
      }

      @Override
      public String eval(T memberWishlist) {
        MemberWishlist parent = MemberWishlistExpression.this.eval(memberWishlist);
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
        return MemberWishlistExpression.this.$getRoot();
      }

      @Override
      public String eval(T memberWishlist) {
        MemberWishlist parent = MemberWishlistExpression.this.eval(memberWishlist);
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
        return MemberWishlistExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T memberWishlist) {
        MemberWishlist parent = MemberWishlistExpression.this.eval(memberWishlist);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T> getOwner() {
    return new com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberExpression<T>() {
      @Override
      public T $getRoot() {
        return MemberWishlistExpression.this.$getRoot();
      }

      public RetailStoreMember eval(T memberWishlist) {
        MemberWishlist parent = MemberWishlistExpression.this.eval(memberWishlist);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public com.doublechaintech.retailscm.memberwishlistproduct
              .MemberWishlistProductSmartListExpression<
          T>
      getMemberWishlistProductList() {
    return new com.doublechaintech.retailscm.memberwishlistproduct
            .MemberWishlistProductSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return MemberWishlistExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<MemberWishlistProduct> eval(T memberWishlist) {
        MemberWishlist parent = MemberWishlistExpression.this.eval(memberWishlist);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMemberWishlistProductList();
      }
    };
  }
}
