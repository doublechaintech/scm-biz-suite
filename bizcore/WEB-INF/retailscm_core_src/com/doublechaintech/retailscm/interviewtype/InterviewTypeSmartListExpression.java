package com.doublechaintech.retailscm.interviewtype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class InterviewTypeSmartListExpression<T>
    extends SmartListExpression<T, InterviewType> {
  public InterviewTypeExpression<T> first() {
    return new InterviewTypeExpression<T>() {
      @Override
      public InterviewType eval(T l) {
        List<InterviewType> list = InterviewTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return InterviewTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public InterviewTypeExpression<T> get(int index) {
    return new InterviewTypeExpression<T>() {
      @Override
      public InterviewType eval(T l) {
        List<InterviewType> list = InterviewTypeSmartListExpression.this.eval(l);
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
        return InterviewTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
