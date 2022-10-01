package com.doublechaintech.retailscm.transporttasktrack;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TransportTaskTrackSmartListExpression<T>
    extends SmartListExpression<T, TransportTaskTrack> {
  public TransportTaskTrackExpression<T> first() {
    return new TransportTaskTrackExpression<T>() {
      @Override
      public TransportTaskTrack eval(T l) {
        List<TransportTaskTrack> list = TransportTaskTrackSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TransportTaskTrackSmartListExpression.this.$getRoot();
      }
    };
  }

  public TransportTaskTrackExpression<T> get(int index) {
    return new TransportTaskTrackExpression<T>() {
      @Override
      public TransportTaskTrack eval(T l) {
        List<TransportTaskTrack> list = TransportTaskTrackSmartListExpression.this.eval(l);
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
        return TransportTaskTrackSmartListExpression.this.$getRoot();
      }
    };
  }
}
