package com.doublechaintech.retailscm.transporttruck;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TransportTruckExpression<T> implements Expression<T, TransportTruck> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
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
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getPlateNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getPlateNumber();
      }
    };
  }

  public Expression<T, String> getContactNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactNumber();
      }
    };
  }

  public Expression<T, String> getVehicleLicenseNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVehicleLicenseNumber();
      }
    };
  }

  public Expression<T, String> getEngineNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEngineNumber();
      }
    };
  }

  public Expression<T, DateTime> getMakeDate() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMakeDate();
      }
    };
  }

  public Expression<T, String> getMileage() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMileage();
      }
    };
  }

  public Expression<T, String> getBodyColor() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBodyColor();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.transportfleet.TransportFleetExpression<T> getOwner() {
    return new com.doublechaintech.retailscm.transportfleet.TransportFleetExpression<T>() {
      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      public TransportFleet eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>
      getTransportTaskList() {
    return new com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return TransportTruckExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TransportTask> eval(T transportTruck) {
        TransportTruck parent = TransportTruckExpression.this.eval(transportTruck);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportTaskList();
      }
    };
  }
}
