package com.doublechaintech.retailscm.employeecompanytraining;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeCompanyTrainingExpression<T>
    implements Expression<T, EmployeeCompanyTraining> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeCompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeCompanyTraining) {
        EmployeeCompanyTraining parent =
            EmployeeCompanyTrainingExpression.this.eval(employeeCompanyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return EmployeeCompanyTrainingExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeCompanyTraining) {
        EmployeeCompanyTraining parent =
            EmployeeCompanyTrainingExpression.this.eval(employeeCompanyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeExpression<T> getEmployee() {
    return new com.doublechaintech.retailscm.employee.EmployeeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeCompanyTrainingExpression.this.$getRoot();
      }

      public Employee eval(T employeeCompanyTraining) {
        EmployeeCompanyTraining parent =
            EmployeeCompanyTrainingExpression.this.eval(employeeCompanyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }

  public com.doublechaintech.retailscm.companytraining.CompanyTrainingExpression<T> getTraining() {
    return new com.doublechaintech.retailscm.companytraining.CompanyTrainingExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeCompanyTrainingExpression.this.$getRoot();
      }

      public CompanyTraining eval(T employeeCompanyTraining) {
        EmployeeCompanyTraining parent =
            EmployeeCompanyTrainingExpression.this.eval(employeeCompanyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTraining();
      }
    };
  }

  public com.doublechaintech.retailscm.scoring.ScoringExpression<T> getScoring() {
    return new com.doublechaintech.retailscm.scoring.ScoringExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeCompanyTrainingExpression.this.$getRoot();
      }

      public Scoring eval(T employeeCompanyTraining) {
        EmployeeCompanyTraining parent =
            EmployeeCompanyTrainingExpression.this.eval(employeeCompanyTraining);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getScoring();
      }
    };
  }
}
