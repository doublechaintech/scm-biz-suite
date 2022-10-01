package com.doublechaintech.retailscm.transporttask;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TransportTaskExpression<T> implements Expression<T, TransportTask> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
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
        return TransportTaskExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getName();
      }
    };
  }

  public Expression<T, String> getStart() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStart();
      }
    };
  }

  public Expression<T, DateTime> getBeginTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBeginTime();
      }
    };
  }

  public Expression<T, BigDecimal> getLatitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLatitude();
      }
    };
  }

  public Expression<T, BigDecimal> getLongitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLongitude();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T> getEnd() {
    return new com.doublechaintech.retailscm.retailstore.RetailStoreExpression<T>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      public RetailStore eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getEnd();
      }
    };
  }

  public com.doublechaintech.retailscm.truckdriver.TruckDriverExpression<T> getDriver() {
    return new com.doublechaintech.retailscm.truckdriver.TruckDriverExpression<T>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      public TruckDriver eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDriver();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttruck.TransportTruckExpression<T> getTruck() {
    return new com.doublechaintech.retailscm.transporttruck.TransportTruckExpression<T>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      public TransportTruck eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTruck();
      }
    };
  }

  public com.doublechaintech.retailscm.transportfleet.TransportFleetExpression<T> getBelongsTo() {
    return new com.doublechaintech.retailscm.transportfleet.TransportFleetExpression<T>() {
      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      public TransportFleet eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getBelongsTo();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T> getGoodsList() {
    return new com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Goods> eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsList();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackSmartListExpression<T>
      getTransportTaskTrackList() {
    return new com.doublechaintech.retailscm.transporttasktrack
            .TransportTaskTrackSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return TransportTaskExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<TransportTaskTrack> eval(T transportTask) {
        TransportTask parent = TransportTaskExpression.this.eval(transportTask);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTransportTaskTrackList();
      }
    };
  }
}
