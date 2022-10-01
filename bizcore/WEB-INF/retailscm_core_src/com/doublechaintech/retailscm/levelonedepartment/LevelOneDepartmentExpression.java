package com.doublechaintech.retailscm.levelonedepartment;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class LevelOneDepartmentExpression<T> implements Expression<T, LevelOneDepartment> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
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
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
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
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, String> getManager() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      @Override
      public String eval(T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getManager();
      }
    };
  }

  public Expression<T, DateTime> getFounded() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
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
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getBelongsTo() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }

  public com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentSmartListExpression<T>
      getLevelTwoDepartmentList() {
    return new com.doublechaintech.retailscm.leveltwodepartment
            .LevelTwoDepartmentSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return LevelOneDepartmentExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<LevelTwoDepartment> eval(
          T levelOneDepartment) {
        LevelOneDepartment parent = LevelOneDepartmentExpression.this.eval(levelOneDepartment);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLevelTwoDepartmentList();
      }
    };
  }
}
