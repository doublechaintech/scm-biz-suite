package com.doublechaintech.retailscm.employeeworkexperience;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeWorkExperienceSmartListExpression<T>
    extends SmartListExpression<T, EmployeeWorkExperience> {
  public EmployeeWorkExperienceExpression<T> first() {
    return new EmployeeWorkExperienceExpression<T>() {
      @Override
      public EmployeeWorkExperience eval(T l) {
        List<EmployeeWorkExperience> list = EmployeeWorkExperienceSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeWorkExperienceSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeWorkExperienceExpression<T> get(int index) {
    return new EmployeeWorkExperienceExpression<T>() {
      @Override
      public EmployeeWorkExperience eval(T l) {
        List<EmployeeWorkExperience> list = EmployeeWorkExperienceSmartListExpression.this.eval(l);
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
        return EmployeeWorkExperienceSmartListExpression.this.$getRoot();
      }
    };
  }
}
