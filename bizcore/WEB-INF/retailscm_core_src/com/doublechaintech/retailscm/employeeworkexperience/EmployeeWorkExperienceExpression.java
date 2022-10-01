package com.doublechaintech.retailscm.employeeworkexperience;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeWorkExperienceExpression<T>
    implements Expression<T, EmployeeWorkExperience> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeWorkExperienceExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeWorkExperience) {
        EmployeeWorkExperience parent =
            EmployeeWorkExperienceExpression.this.eval(employeeWorkExperience);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getStart() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return EmployeeWorkExperienceExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employeeWorkExperience) {
        EmployeeWorkExperience parent =
            EmployeeWorkExperienceExpression.this.eval(employeeWorkExperience);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStart();
      }
    };
  }

  public Expression<T, DateTime> getEnd() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return EmployeeWorkExperienceExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T employeeWorkExperience) {
        EmployeeWorkExperience parent =
            EmployeeWorkExperienceExpression.this.eval(employeeWorkExperience);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEnd();
      }
    };
  }

  public Expression<T, String> getCompany() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeWorkExperienceExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeWorkExperience) {
        EmployeeWorkExperience parent =
            EmployeeWorkExperienceExpression.this.eval(employeeWorkExperience);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeWorkExperienceExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeWorkExperience) {
        EmployeeWorkExperience parent =
            EmployeeWorkExperienceExpression.this.eval(employeeWorkExperience);
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
        return EmployeeWorkExperienceExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeWorkExperience) {
        EmployeeWorkExperience parent =
            EmployeeWorkExperienceExpression.this.eval(employeeWorkExperience);
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
        return EmployeeWorkExperienceExpression.this.$getRoot();
      }

      public Employee eval(T employeeWorkExperience) {
        EmployeeWorkExperience parent =
            EmployeeWorkExperienceExpression.this.eval(employeeWorkExperience);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }
}
