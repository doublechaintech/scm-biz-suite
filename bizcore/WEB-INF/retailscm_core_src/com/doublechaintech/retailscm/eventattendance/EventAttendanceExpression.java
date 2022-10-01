package com.doublechaintech.retailscm.eventattendance;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class EventAttendanceExpression<T> implements Expression<T, EventAttendance> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return EventAttendanceExpression.this.$getRoot();
      }

      @Override
      public String eval(T eventAttendance) {
        EventAttendance parent = EventAttendanceExpression.this.eval(eventAttendance);
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
        return EventAttendanceExpression.this.$getRoot();
      }

      @Override
      public String eval(T eventAttendance) {
        EventAttendance parent = EventAttendanceExpression.this.eval(eventAttendance);
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
        return EventAttendanceExpression.this.$getRoot();
      }

      @Override
      public String eval(T eventAttendance) {
        EventAttendance parent = EventAttendanceExpression.this.eval(eventAttendance);
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
        return EventAttendanceExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T eventAttendance) {
        EventAttendance parent = EventAttendanceExpression.this.eval(eventAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerExpression<T>
      getPotentialCustomer() {
    return new com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerExpression<T>() {
      @Override
      public T $getRoot() {
        return EventAttendanceExpression.this.$getRoot();
      }

      public PotentialCustomer eval(T eventAttendance) {
        EventAttendance parent = EventAttendanceExpression.this.eval(eventAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPotentialCustomer();
      }
    };
  }

  public com.doublechaintech.retailscm.cityevent.CityEventExpression<T> getCityEvent() {
    return new com.doublechaintech.retailscm.cityevent.CityEventExpression<T>() {
      @Override
      public T $getRoot() {
        return EventAttendanceExpression.this.$getRoot();
      }

      public CityEvent eval(T eventAttendance) {
        EventAttendance parent = EventAttendanceExpression.this.eval(eventAttendance);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityEvent();
      }
    };
  }
}
