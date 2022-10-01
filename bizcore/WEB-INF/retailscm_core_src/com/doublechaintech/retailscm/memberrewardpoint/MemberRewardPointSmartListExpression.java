package com.doublechaintech.retailscm.memberrewardpoint;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class MemberRewardPointSmartListExpression<T>
    extends SmartListExpression<T, MemberRewardPoint> {
  public MemberRewardPointExpression<T> first() {
    return new MemberRewardPointExpression<T>() {
      @Override
      public MemberRewardPoint eval(T l) {
        List<MemberRewardPoint> list = MemberRewardPointSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return MemberRewardPointSmartListExpression.this.$getRoot();
      }
    };
  }

  public MemberRewardPointExpression<T> get(int index) {
    return new MemberRewardPointExpression<T>() {
      @Override
      public MemberRewardPoint eval(T l) {
        List<MemberRewardPoint> list = MemberRewardPointSmartListExpression.this.eval(l);
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
        return MemberRewardPointSmartListExpression.this.$getRoot();
      }
    };
  }
}
