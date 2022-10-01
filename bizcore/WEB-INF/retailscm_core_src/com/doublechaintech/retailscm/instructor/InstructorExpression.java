package com.doublechaintech.retailscm.instructor;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class InstructorExpression<T> implements Expression<T, Instructor> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public String eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
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
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public String eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, String> getFamilyName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public String eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFamilyName();
      }
    };
  }

  public Expression<T, String> getGivenName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public String eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGivenName();
      }
    };
  }

  public Expression<T, String> getCellPhone() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public String eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCellPhone();
      }
    };
  }

  public Expression<T, String> getEmail() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public String eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmail();
      }
    };
  }

  public Expression<T, String> getIntroduction() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public String eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getIntroduction();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
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
        return InstructorExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
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
        return InstructorExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
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
        return InstructorExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<CompanyTraining> eval(T instructor) {
        Instructor parent = InstructorExpression.this.eval(instructor);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompanyTrainingList();
      }
    };
  }
}
