package com.doublechaintech.retailscm.leveltwodepartment;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LevelTwoDepartmentExpression<T> implements Expression<T, LevelTwoDepartment> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelTwoDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelTwoDepartment) {
        LevelTwoDepartment parent = LevelTwoDepartmentExpression.this.eval(levelTwoDepartment);
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
        return LevelTwoDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelTwoDepartment) {
        LevelTwoDepartment parent = LevelTwoDepartmentExpression.this.eval(levelTwoDepartment);
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
        return LevelTwoDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelTwoDepartment) {
        LevelTwoDepartment parent = LevelTwoDepartmentExpression.this.eval(levelTwoDepartment);
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
        return LevelTwoDepartmentExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T levelTwoDepartment) {
        LevelTwoDepartment parent = LevelTwoDepartmentExpression.this.eval(levelTwoDepartment);
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
        return LevelTwoDepartmentExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T levelTwoDepartment) {
        LevelTwoDepartment parent = LevelTwoDepartmentExpression.this.eval(levelTwoDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentExpression<T>
      getBelongsTo() {
    return new com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentExpression<T>() {
      @Override
      public T $getRoot() {
        return LevelTwoDepartmentExpression.this.$getRoot();
      }

      public LevelOneDepartment eval(T levelTwoDepartment) {
        LevelTwoDepartment parent = LevelTwoDepartmentExpression.this.eval(levelTwoDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }

  public com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentSmartListExpression<
          T>
      getLevelThreeDepartmentList() {
    return new com.doublechaintech.retailscm.levelthreedepartment
            .LevelThreeDepartmentSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return LevelTwoDepartmentExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LevelThreeDepartment> eval(
          T levelTwoDepartment) {
        LevelTwoDepartment parent = LevelTwoDepartmentExpression.this.eval(levelTwoDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLevelThreeDepartmentList();
      }
    };
  }
}
