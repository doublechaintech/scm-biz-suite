package com.doublechaintech.retailscm.employeeeducation;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeEducationSmartListExpression<T>
    extends SmartListExpression<T, EmployeeEducation> {
  public EmployeeEducationExpression<T> first() {
    return new EmployeeEducationExpression<T>() {
      @Override
      public EmployeeEducation eval(T l) {
        List<EmployeeEducation> list = EmployeeEducationSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeEducationSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeEducationExpression<T> get(int index) {
    return new EmployeeEducationExpression<T>() {
      @Override
      public EmployeeEducation eval(T l) {
        List<EmployeeEducation> list = EmployeeEducationSmartListExpression.this.eval(l);
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
        return EmployeeEducationSmartListExpression.this.$getRoot();
      }
    };
  }
}
