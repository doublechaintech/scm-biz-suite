package com.doublechaintech.retailscm.trainingcoursetype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TrainingCourseTypeExpression<T> implements Expression<T, TrainingCourseType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TrainingCourseTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T trainingCourseType) {
        TrainingCourseType parent = TrainingCourseTypeExpression.this.eval(trainingCourseType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getCode() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TrainingCourseTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T trainingCourseType) {
        TrainingCourseType parent = TrainingCourseTypeExpression.this.eval(trainingCourseType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TrainingCourseTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T trainingCourseType) {
        TrainingCourseType parent = TrainingCourseTypeExpression.this.eval(trainingCourseType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TrainingCourseTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T trainingCourseType) {
        TrainingCourseType parent = TrainingCourseTypeExpression.this.eval(trainingCourseType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TrainingCourseTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T trainingCourseType) {
        TrainingCourseType parent = TrainingCourseTypeExpression.this.eval(trainingCourseType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getCompany() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return TrainingCourseTypeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T trainingCourseType) {
        TrainingCourseType parent = TrainingCourseTypeExpression.this.eval(trainingCourseType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.companytraining.CompanyTrainingSmartListExpression<T>
      getCompanyTrainingList() {
    return new com.doublechaintech.retailscm.companytraining.CompanyTrainingSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return TrainingCourseTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<CompanyTraining> eval(T trainingCourseType) {
        TrainingCourseType parent = TrainingCourseTypeExpression.this.eval(trainingCourseType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompanyTrainingList();
      }
    };
  }
}
