package com.doublechaintech.retailscm.leavetype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class LeaveTypeSmartListExpression<T> extends SmartListExpression<T, LeaveType> {
  public LeaveTypeExpression<T> first() {
    return new LeaveTypeExpression<T>() {
      @Override
      public LeaveType eval(T l) {
        List<LeaveType> list = LeaveTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return LeaveTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public LeaveTypeExpression<T> get(int index) {
    return new LeaveTypeExpression<T>() {
      @Override
      public LeaveType eval(T l) {
        List<LeaveType> list = LeaveTypeSmartListExpression.this.eval(l);
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
        return LeaveTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
