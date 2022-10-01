package com.doublechaintech.retailscm.eventattendance;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EventAttendanceSmartListExpression<T>
    extends SmartListExpression<T, EventAttendance> {
  public EventAttendanceExpression<T> first() {
    return new EventAttendanceExpression<T>() {
      @Override
      public EventAttendance eval(T l) {
        List<EventAttendance> list = EventAttendanceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EventAttendanceSmartListExpression.this.$getRoot();
      }
    };
  }

  public EventAttendanceExpression<T> get(int index) {
    return new EventAttendanceExpression<T>() {
      @Override
      public EventAttendance eval(T l) {
        List<EventAttendance> list = EventAttendanceSmartListExpression.this.eval(l);
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
        return EventAttendanceSmartListExpression.this.$getRoot();
      }
    };
  }
}
