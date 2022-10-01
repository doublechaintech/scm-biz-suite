package com.doublechaintech.retailscm.memberrewardpointredemption;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class MemberRewardPointRedemptionSmartListExpression<T>
    extends SmartListExpression<T, MemberRewardPointRedemption> {
  public MemberRewardPointRedemptionExpression<T> first() {
    return new MemberRewardPointRedemptionExpression<T>() {
      @Override
      public MemberRewardPointRedemption eval(T l) {
        List<MemberRewardPointRedemption> list =
            MemberRewardPointRedemptionSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return MemberRewardPointRedemptionSmartListExpression.this.$getRoot();
      }
    };
  }

  public MemberRewardPointRedemptionExpression<T> get(int index) {
    return new MemberRewardPointRedemptionExpression<T>() {
      @Override
      public MemberRewardPointRedemption eval(T l) {
        List<MemberRewardPointRedemption> list =
            MemberRewardPointRedemptionSmartListExpression.this.eval(l);
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
        return MemberRewardPointRedemptionSmartListExpression.this.$getRoot();
      }
    };
  }
}
