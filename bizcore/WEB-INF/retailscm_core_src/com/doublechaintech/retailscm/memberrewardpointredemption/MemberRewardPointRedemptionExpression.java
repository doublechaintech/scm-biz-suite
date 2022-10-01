package com.doublechaintech.retailscm.memberrewardpointredemption;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class MemberRewardPointRedemptionExpression<T>
    implements Expression<T, MemberRewardPointRedemption> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return MemberRewardPointRedemptionExpression.this.$getRoot();
      }

      @Override
      public String eval(T memberRewardPointRedemption) {
        MemberRewardPointRedemption parent =
            MemberRewardPointRedemptionExpression.this.eval(memberRewardPointRedemption);
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
        return MemberRewardPointRedemptionExpression.this.$getRoot();
      }

      @Override
      public String eval(T memberRewardPointRedemption) {
        MemberRewardPointRedemption parent =
            MemberRewardPointRedemptionExpression.this.eval(memberRewardPointRedemption);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, Integer> getPoint() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return MemberRewardPointRedemptionExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T memberRewardPointRedemption) {
        MemberRewardPointRedemption parent =
            MemberRewardPointRedemptionExpression.this.eval(memberRewardPointRedemption);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPoint();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return MemberRewardPointRedemptionExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T memberRewardPointRedemption) {
        MemberRewardPointRedemption parent =
            MemberRewardPointRedemptionExpression.this.eval(memberRewardPointRedemption);
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
        return MemberRewardPointRedemptionExpression.this.$getRoot();
      }

      public RetailStoreMember eval(T memberRewardPointRedemption) {
        MemberRewardPointRedemption parent =
            MemberRewardPointRedemptionExpression.this.eval(memberRewardPointRedemption);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }
}
