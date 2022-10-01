package com.doublechaintech.retailscm.companytraining;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class CompanyTrainingSmartListExpression<T>
    extends SmartListExpression<T, CompanyTraining> {
  public CompanyTrainingExpression<T> first() {
    return new CompanyTrainingExpression<T>() {
      @Override
      public CompanyTraining eval(T l) {
        List<CompanyTraining> list = CompanyTrainingSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return CompanyTrainingSmartListExpression.this.$getRoot();
      }
    };
  }

  public CompanyTrainingExpression<T> get(int index) {
    return new CompanyTrainingExpression<T>() {
      @Override
      public CompanyTraining eval(T l) {
        List<CompanyTraining> list = CompanyTrainingSmartListExpression.this.eval(l);
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
        return CompanyTrainingSmartListExpression.this.$getRoot();
      }
    };
  }
}
