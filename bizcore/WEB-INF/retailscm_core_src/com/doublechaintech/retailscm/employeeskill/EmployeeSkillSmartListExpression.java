package com.doublechaintech.retailscm.employeeskill;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class EmployeeSkillSmartListExpression<T>
    extends SmartListExpression<T, EmployeeSkill> {
  public EmployeeSkillExpression<T> first() {
    return new EmployeeSkillExpression<T>() {
      @Override
      public EmployeeSkill eval(T l) {
        List<EmployeeSkill> list = EmployeeSkillSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return EmployeeSkillSmartListExpression.this.$getRoot();
      }
    };
  }

  public EmployeeSkillExpression<T> get(int index) {
    return new EmployeeSkillExpression<T>() {
      @Override
      public EmployeeSkill eval(T l) {
        List<EmployeeSkill> list = EmployeeSkillSmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return EmployeeSkillSmartListExpression.this.$getRoot();
      }
    };
  }
}
