package com.doublechaintech.retailscm.employeeskill;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EmployeeSkillExpression<T> implements Expression<T, EmployeeSkill> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeSkillExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeSkill) {
        EmployeeSkill parent = EmployeeSkillExpression.this.eval(employeeSkill);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EmployeeSkillExpression.this.$getRoot();
      }

      @Override
      public String eval(T employeeSkill) {
        EmployeeSkill parent = EmployeeSkillExpression.this.eval(employeeSkill);
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
        return EmployeeSkillExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T employeeSkill) {
        EmployeeSkill parent = EmployeeSkillExpression.this.eval(employeeSkill);
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
        return EmployeeSkillExpression.this.$getRoot();
      }

      public Employee eval(T employeeSkill) {
        EmployeeSkill parent = EmployeeSkillExpression.this.eval(employeeSkill);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployee();
      }
    };
  }

  public com.doublechaintech.retailscm.skilltype.SkillTypeExpression<T> getSkillType() {
    return new com.doublechaintech.retailscm.skilltype.SkillTypeExpression<T>() {
      @Override
      public T $getRoot() {
        return EmployeeSkillExpression.this.$getRoot();
      }

      public SkillType eval(T employeeSkill) {
        EmployeeSkill parent = EmployeeSkillExpression.this.eval(employeeSkill);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSkillType();
      }
    };
  }
}
