package com.doublechaintech.retailscm.salarygrade;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class SalaryGradeSmartListExpression<T>
    extends SmartListExpression<T, SalaryGrade> {
  public SalaryGradeExpression<T> first() {
    return new SalaryGradeExpression<T>() {
      @Override
      public SalaryGrade eval(T l) {
        List<SalaryGrade> list = SalaryGradeSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return SalaryGradeSmartListExpression.this.$getRoot();
      }
    };
  }

  public SalaryGradeExpression<T> get(int index) {
    return new SalaryGradeExpression<T>() {
      @Override
      public SalaryGrade eval(T l) {
        List<SalaryGrade> list = SalaryGradeSmartListExpression.this.eval(l);
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
        return SalaryGradeSmartListExpression.this.$getRoot();
      }
    };
  }
}
