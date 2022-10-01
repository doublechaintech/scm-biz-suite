package com.doublechaintech.retailscm.provincecenterdepartment;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class ProvinceCenterDepartmentSmartListExpression<T>
    extends SmartListExpression<T, ProvinceCenterDepartment> {
  public ProvinceCenterDepartmentExpression<T> first() {
    return new ProvinceCenterDepartmentExpression<T>() {
      @Override
      public ProvinceCenterDepartment eval(T l) {
        List<ProvinceCenterDepartment> list =
            ProvinceCenterDepartmentSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return ProvinceCenterDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }

  public ProvinceCenterDepartmentExpression<T> get(int index) {
    return new ProvinceCenterDepartmentExpression<T>() {
      @Override
      public ProvinceCenterDepartment eval(T l) {
        List<ProvinceCenterDepartment> list =
            ProvinceCenterDepartmentSmartListExpression.this.eval(l);
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
        return ProvinceCenterDepartmentSmartListExpression.this.$getRoot();
      }
    };
  }
}
