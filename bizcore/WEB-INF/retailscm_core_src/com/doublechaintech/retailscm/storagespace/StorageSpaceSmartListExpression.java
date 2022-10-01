package com.doublechaintech.retailscm.storagespace;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class StorageSpaceSmartListExpression<T>
    extends SmartListExpression<T, StorageSpace> {
  public StorageSpaceExpression<T> first() {
    return new StorageSpaceExpression<T>() {
      @Override
      public StorageSpace eval(T l) {
        List<StorageSpace> list = StorageSpaceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return StorageSpaceSmartListExpression.this.$getRoot();
      }
    };
  }

  public StorageSpaceExpression<T> get(int index) {
    return new StorageSpaceExpression<T>() {
      @Override
      public StorageSpace eval(T l) {
        List<StorageSpace> list = StorageSpaceSmartListExpression.this.eval(l);
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
        return StorageSpaceSmartListExpression.this.$getRoot();
      }
    };
  }
}
