package com.doublechaintech.retailscm.companytraining;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class CompanyTrainingExpression<T> implements Expression<T, CompanyTraining> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public String eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public String eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, DateTime> getTimeStart() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTimeStart();
      }
    };
  }

  public Expression<T, Integer> getDurationHours() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDurationHours();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastUpdateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
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
        return CompanyTrainingExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.instructor.InstructorExpression<T> getInstructor() {
    return new com.doublechaintech.retailscm.instructor.InstructorExpression<T>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      public Instructor eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getInstructor();
      }
    };
  }

  public com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeExpression<T>
      getTrainingCourseType() {
    return new com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      public TrainingCourseType eval(T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTrainingCourseType();
      }
    };
  }

  public com.doublechaintech.retailscm.employeecompanytraining
              .EmployeeCompanyTrainingSmartListExpression<
          T>
      getEmployeeCompanyTrainingList() {
    return new com.doublechaintech.retailscm.employeecompanytraining
            .EmployeeCompanyTrainingSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return CompanyTrainingExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeCompanyTraining> eval(
          T companyTraining) {
        CompanyTraining parent = CompanyTrainingExpression.this.eval(companyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeCompanyTrainingList();
      }
    };
  }
}
