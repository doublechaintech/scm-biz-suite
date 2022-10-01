package com.doublechaintech.retailscm.levelthreedepartment;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LevelThreeDepartmentExpression<T>
    implements Expression<T, LevelThreeDepartment> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelThreeDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelThreeDepartment) {
        LevelThreeDepartment parent =
            LevelThreeDepartmentExpression.this.eval(levelThreeDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getName() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelThreeDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelThreeDepartment) {
        LevelThreeDepartment parent =
            LevelThreeDepartmentExpression.this.eval(levelThreeDepartment);
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
        return LevelThreeDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelThreeDepartment) {
        LevelThreeDepartment parent =
            LevelThreeDepartmentExpression.this.eval(levelThreeDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, DateTime> getFounded() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return LevelThreeDepartmentExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T levelThreeDepartment) {
        LevelThreeDepartment parent =
            LevelThreeDepartmentExpression.this.eval(levelThreeDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFounded();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return LevelThreeDepartmentExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T levelThreeDepartment) {
        LevelThreeDepartment parent =
            LevelThreeDepartmentExpression.this.eval(levelThreeDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentExpression<T>
      getBelongsTo() {
    return new com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentExpression<T>() {
      @Override
      public T $getRoot() {
        return LevelThreeDepartmentExpression.this.$getRoot();
      }

      public LevelTwoDepartment eval(T levelThreeDepartment) {
        LevelThreeDepartment parent =
            LevelThreeDepartmentExpression.this.eval(levelThreeDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }

  public com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T> getEmployeeList() {
    return new com.doublechaintech.retailscm.employee.EmployeeSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return LevelThreeDepartmentExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Employee> eval(T levelThreeDepartment) {
        LevelThreeDepartment parent =
            LevelThreeDepartmentExpression.this.eval(levelThreeDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeList();
      }
    };
  }
}
