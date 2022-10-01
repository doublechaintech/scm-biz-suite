package com.doublechaintech.retailscm.transportfleet;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TransportFleetExpression<T> implements Expression<T, TransportFleet> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
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
        return TransportFleetExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getContactNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactNumber();
      }
    };
  }

  public Expression<T, String> getContract() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContract();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
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
        return TransportFleetExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterExpression<
          T>
      getOwner() {
    return new com.doublechaintech.retailscm.retailstorecountrycenter
            .RetailStoreCountryCenterExpression<
        T>() {
      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      public RetailStoreCountryCenter eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getOwner();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttruck.TransportTruckSmartListExpression<T>
      getTransportTruckList() {
    return new com.doublechaintech.retailscm.transporttruck.TransportTruckSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TransportTruck> eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportTruckList();
      }
    };
  }

  public com.doublechaintech.retailscm.truckdriver.TruckDriverSmartListExpression<T>
      getTruckDriverList() {
    return new com.doublechaintech.retailscm.truckdriver.TruckDriverSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TruckDriver> eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTruckDriverList();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>
      getTransportTaskList() {
    return new com.doublechaintech.retailscm.transporttask.TransportTaskSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return TransportFleetExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TransportTask> eval(T transportFleet) {
        TransportFleet parent = TransportFleetExpression.this.eval(transportFleet);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportTaskList();
      }
    };
  }
}
