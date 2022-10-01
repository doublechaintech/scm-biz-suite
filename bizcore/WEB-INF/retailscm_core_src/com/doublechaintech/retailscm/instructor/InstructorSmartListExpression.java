package com.doublechaintech.retailscm.instructor;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class InstructorSmartListExpression<T> extends SmartListExpression<T, Instructor> {
  public InstructorExpression<T> first() {
    return new InstructorExpression<T>() {
      @Override
      public Instructor eval(T l) {
        List<Instructor> list = InstructorSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return InstructorSmartListExpression.this.$getRoot();
      }
    };
  }

  public InstructorExpression<T> get(int index) {
    return new InstructorExpression<T>() {
      @Override
      public Instructor eval(T l) {
        List<Instructor> list = InstructorSmartListExpression.this.eval(l);
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
        return InstructorSmartListExpression.this.$getRoot();
      }
    };
  }
}
