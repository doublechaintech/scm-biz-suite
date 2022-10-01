package com.doublechaintech.retailscm.salarygrade;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SalaryGradeExpression<T> implements Expression<T, SalaryGrade> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SalaryGradeExpression.this.$getRoot();
      }

      @Override
      public String eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
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
        return SalaryGradeExpression.this.$getRoot();
      }

      @Override
      public String eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
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
        return SalaryGradeExpression.this.$getRoot();
      }

      @Override
      public String eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getDetailDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SalaryGradeExpression.this.$getRoot();
      }

      @Override
      public String eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDetailDescription();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return SalaryGradeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
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
        return SalaryGradeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T> getEmployeeList() {
    return new com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SalaryGradeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Employee> eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeList();
      }
    };
  }

  public com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetSmartListExpression<T>
      getEmployeeSalarySheetList() {
    return new com.doublechaintech.retailscm.employeesalarysheet
            .EmployeeSalarySheetSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return SalaryGradeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeSalarySheet> eval(T salaryGrade) {
        SalaryGrade parent = SalaryGradeExpression.this.eval(salaryGrade);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeSalarySheetList();
      }
    };
  }
}
