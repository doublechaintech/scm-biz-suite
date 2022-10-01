package com.doublechaintech.retailscm.skilltype;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class SkillTypeExpression<T> implements Expression<T, SkillType> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkillTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T skillType) {
        SkillType parent = SkillTypeExpression.this.eval(skillType);
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
        return SkillTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T skillType) {
        SkillType parent = SkillTypeExpression.this.eval(skillType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCode();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return SkillTypeExpression.this.$getRoot();
      }

      @Override
      public String eval(T skillType) {
        SkillType parent = SkillTypeExpression.this.eval(skillType);
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
        return SkillTypeExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T skillType) {
        SkillType parent = SkillTypeExpression.this.eval(skillType);
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
        return SkillTypeExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T skillType) {
        SkillType parent = SkillTypeExpression.this.eval(skillType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }

  public com.doublechaintech.retailscm.employeeskill.EmployeeSkillSmartListExpression<T>
      getEmployeeSkillList() {
    return new com.doublechaintech.retailscm.employeeskill.EmployeeSkillSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return SkillTypeExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EmployeeSkill> eval(T skillType) {
        SkillType parent = SkillTypeExpression.this.eval(skillType);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEmployeeSkillList();
      }
    };
  }
}
