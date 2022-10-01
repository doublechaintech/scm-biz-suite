package com.doublechaintech.retailscm.trainingcoursetype;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TrainingCourseTypeSmartListExpression<T>
    extends SmartListExpression<T, TrainingCourseType> {
  public TrainingCourseTypeExpression<T> first() {
    return new TrainingCourseTypeExpression<T>() {
      @Override
      public TrainingCourseType eval(T l) {
        List<TrainingCourseType> list = TrainingCourseTypeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TrainingCourseTypeSmartListExpression.this.$getRoot();
      }
    };
  }

  public TrainingCourseTypeExpression<T> get(int index) {
    return new TrainingCourseTypeExpression<T>() {
      @Override
      public TrainingCourseType eval(T l) {
        List<TrainingCourseType> list = TrainingCourseTypeSmartListExpression.this.eval(l);
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
        return TrainingCourseTypeSmartListExpression.this.$getRoot();
      }
    };
  }
}
