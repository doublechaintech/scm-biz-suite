package com.doublechaintech.retailscm.truckdriver;

import cn.hutool.core.util.ObjectUtil;

import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TruckDriverExpression<T> implements Expression<T, TruckDriver> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TruckDriverExpression.this.$getRoot();
      }

      @Override
      public String eval(T truckDriver) {
        TruckDriver parent = TruckDriverExpression.this.eval(truckDriver);
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
        return TruckDriverExpression.this.$getRoot();
      }

      @Override
      public String eval(T truckDriver) {
        TruckDriver parent = TruckDriverExpression.this.eval(truckDriver);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getDriverLicenseNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TruckDriverExpression.this.$getRoot();
      }

      @Override
      public String eval(T truckDriver) {
        TruckDriver parent = TruckDriverExpression.this.eval(truckDriver);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDriverLicenseNumber();
      }
    };
  }

  public Expression<T, String> getContactNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TruckDriverExpression.this.$getRoot();
      }

      @Override
      public String eval(T truckDriver) {
        TruckDriver parent = TruckDriverExpression.this.eval(truckDriver);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactNumber();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TruckDriverExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T truckDriver) {
        TruckDriver parent = TruckDriverExpression.this.eval(truckDriver);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.transportfleet.TransportFleetExpression<T> getBelongsTo() {
    return new com.doublechaintech.retailscm.transportfleet.TransportFleetExpression<T>() {
      @Override
      public T $getRoot() {
        return TruckDriverExpression.this.$getRoot();
      }

      public TransportFleet eval(T truckDriver) {
        TruckDriver parent = TruckDriverExpression.this.eval(truckDriver);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>
      getTransportTaskList() {
    return new com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return TruckDriverExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TransportTask> eval(T truckDriver) {
        TruckDriver parent = TruckDriverExpression.this.eval(truckDriver);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportTaskList();
      }
    };
  }
}
