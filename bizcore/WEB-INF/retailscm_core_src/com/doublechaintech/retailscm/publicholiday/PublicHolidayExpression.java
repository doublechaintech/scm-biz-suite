package com.doublechaintech.retailscm.publicholiday;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class PublicHolidayExpression<T> implements Expression<T, PublicHoliday> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return PublicHolidayExpression.this.$getRoot();
      }

      @Override
      public String eval(T publicHoliday) {
        PublicHoliday parent = PublicHolidayExpression.this.eval(publicHoliday);
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
        return PublicHolidayExpression.this.$getRoot();
      }

      @Override
      public String eval(T publicHoliday) {
        PublicHoliday parent = PublicHolidayExpression.this.eval(publicHoliday);
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
        return PublicHolidayExpression.this.$getRoot();
      }

      @Override
      public String eval(T publicHoliday) {
        PublicHoliday parent = PublicHolidayExpression.this.eval(publicHoliday);
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
        return PublicHolidayExpression.this.$getRoot();
      }

      @Override
      public String eval(T publicHoliday) {
        PublicHoliday parent = PublicHolidayExpression.this.eval(publicHoliday);
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
        return PublicHolidayExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T publicHoliday) {
        PublicHoliday parent = PublicHolidayExpression.this.eval(publicHoliday);
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
        return PublicHolidayExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T publicHoliday) {
        PublicHoliday parent = PublicHolidayExpression.this.eval(publicHoliday);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCompany();
      }
    };
  }
}
