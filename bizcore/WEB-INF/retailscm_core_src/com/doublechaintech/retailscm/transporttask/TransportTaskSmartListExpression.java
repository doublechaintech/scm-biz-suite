package com.doublechaintech.retailscm.transporttask;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class TransportTaskSmartListExpression<T>
    extends SmartListExpression<T, TransportTask> {
  public TransportTaskExpression<T> first() {
    return new TransportTaskExpression<T>() {
      @Override
      public TransportTask eval(T l) {
        List<TransportTask> list = TransportTaskSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return TransportTaskSmartListExpression.this.$getRoot();
      }
    };
  }

  public TransportTaskExpression<T> get(int index) {
    return new TransportTaskExpression<T>() {
      @Override
      public TransportTask eval(T l) {
        List<TransportTask> list = TransportTaskSmartListExpression.this.eval(l);
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
        return TransportTaskSmartListExpression.this.$getRoot();
      }
    };
  }
}
