package com.doublechaintech.retailscm.employeesalarysheet;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeSalarySheetSmartListExpression<T>
    extends SmartListExpression<T, EmployeeSalarySheet> {
  public EmployeeSalarySheetExpression<T> first() {
    return new EmployeeSalarySheetExpression<T>() {
      @Override
      public EmployeeSalarySheet eval(T l) {
        List<EmployeeSalarySheet> list = EmployeeSalarySheetSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeSalarySheetSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeSalarySheetExpression<T> get(int index) {
    return new EmployeeSalarySheetExpression<T>() {
      @Override
      public EmployeeSalarySheet eval(T l) {
        List<EmployeeSalarySheet> list = EmployeeSalarySheetSmartListExpression.this.eval(l);
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
        return EmployeeSalarySheetSmartListExpression.this.$getRoot();
      }
    };
  }
}
