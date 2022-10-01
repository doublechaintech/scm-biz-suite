package com.doublechaintech.retailscm.employeesalarysheet;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeSalarySheetExpression<T>
    implements Expression<T, EmployeeSalarySheet> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, BigDecimal> getBaseSalary() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBaseSalary();
      }
    };
  }

  public Expression<T, BigDecimal> getBonus() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBonus();
      }
    };
  }

  public Expression<T, BigDecimal> getReward() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getReward();
      }
    };
  }

  public Expression<T, BigDecimal> getPersonalTax() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPersonalTax();
      }
    };
  }

  public Expression<T, BigDecimal> getSocialSecurity() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSocialSecurity();
      }
    };
  }

  public Expression<T, BigDecimal> getHousingFound() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getHousingFound();
      }
    };
  }

  public Expression<T, BigDecimal> getJobInsurance() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getJobInsurance();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
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
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      public Employee eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }

  public com.doublechaintech.retailscm.salarygrade.SalaryGradeExpression<T>
      getCurrentSalaryGrade() {
    return new com.doublechaintech.retailscm.salarygrade.SalaryGradeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      public SalaryGrade eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCurrentSalaryGrade();
      }
    };
  }

  public com.doublechaintech.retailscm.payingoff.PayingOffExpression<T> getPayingOff() {
    return new com.doublechaintech.retailscm.payingoff.PayingOffExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeSalarySheetExpression.this.$getRoot();
      }

      public PayingOff eval(T employeeSalarySheet) {
        EmployeeSalarySheet parent = EmployeeSalarySheetExpression.this.eval(employeeSalarySheet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPayingOff();
      }
    };
  }
}
