package com.doublechaintech.retailscm.payingoff;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class PayingOffExpression<T> implements Expression<T, PayingOff> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PayingOffExpression.this.$getRoot();
      }

      @Override
      public String eval(T payingOff) {
        PayingOff parent = PayingOffExpression.this.eval(payingOff);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getWho() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PayingOffExpression.this.$getRoot();
      }

      @Override
      public String eval(T payingOff) {
        PayingOff parent = PayingOffExpression.this.eval(payingOff);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWho();
      }
    };
  }

  public Expression<T, DateTime> getPaidTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return PayingOffExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T payingOff) {
        PayingOff parent = PayingOffExpression.this.eval(payingOff);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPaidTime();
      }
    };
  }

  public Expression<T, BigDecimal> getAmount() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return PayingOffExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T payingOff) {
        PayingOff parent = PayingOffExpression.this.eval(payingOff);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getAmount();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return PayingOffExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T payingOff) {
        PayingOff parent = PayingOffExpression.this.eval(payingOff);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeExpression<T> getPaidFor() {
    return new com.doublechaintech.retailscm.employee.EmployeeExpression<T>() {
      @Override
      public T $getRoot() {
        return PayingOffExpression.this.$getRoot();
      }

      public Employee eval(T payingOff) {
        PayingOff parent = PayingOffExpression.this.eval(payingOff);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPaidFor();
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
        return PayingOffExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeSalarySheet> eval(T payingOff) {
        PayingOff parent = PayingOffExpression.this.eval(payingOff);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeSalarySheetList();
      }
    };
  }
}
