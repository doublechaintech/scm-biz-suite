package com.doublechaintech.retailscm.employeecompanytraining;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeCompanyTrainingSmartListExpression<T>
    extends SmartListExpression<T, EmployeeCompanyTraining> {
  public EmployeeCompanyTrainingExpression<T> first() {
    return new EmployeeCompanyTrainingExpression<T>() {
      @Override
      public EmployeeCompanyTraining eval(T l) {
        List<EmployeeCompanyTraining> list =
            EmployeeCompanyTrainingSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeCompanyTrainingSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeCompanyTrainingExpression<T> get(int index) {
    return new EmployeeCompanyTrainingExpression<T>() {
      @Override
      public EmployeeCompanyTraining eval(T l) {
        List<EmployeeCompanyTraining> list =
            EmployeeCompanyTrainingSmartListExpression.this.eval(l);
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
        return EmployeeCompanyTrainingSmartListExpression.this.$getRoot();
      }
    };
  }
}
