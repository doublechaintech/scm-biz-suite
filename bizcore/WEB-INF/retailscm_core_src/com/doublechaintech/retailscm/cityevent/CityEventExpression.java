package com.doublechaintech.retailscm.cityevent;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class CityEventExpression<T> implements Expression<T, CityEvent> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CityEventExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
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
        return CityEventExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getMobile() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CityEventExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMobile();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return CityEventExpression.this.$getRoot();
      }

      @Override
      public String eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return CityEventExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLastUpdateTime();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return CityEventExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecityservicecenter
              .RetailStoreCityServiceCenterExpression<
          T>
      getCityServiceCenter() {
    return new com.doublechaintech.retailscm.retailstorecityservicecenter
            .RetailStoreCityServiceCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return CityEventExpression.this.$getRoot();
      }

      public RetailStoreCityServiceCenter eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCityServiceCenter();
      }
    };
  }

  public com.doublechaintech.retailscm.eventattendance.EventAttendanceSmartListExpression<T>
      getEventAttendanceList() {
    return new com.doublechaintech.retailscm.eventattendance.EventAttendanceSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return CityEventExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<EventAttendance> eval(T cityEvent) {
        CityEvent parent = CityEventExpression.this.eval(cityEvent);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEventAttendanceList();
      }
    };
  }
}
