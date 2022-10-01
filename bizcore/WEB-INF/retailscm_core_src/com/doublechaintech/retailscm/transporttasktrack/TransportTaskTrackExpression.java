package com.doublechaintech.retailscm.transporttasktrack;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class TransportTaskTrackExpression<T> implements Expression<T, TransportTaskTrack> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return TransportTaskTrackExpression.this.$getRoot();
      }

      @Override
      public String eval(T transportTaskTrack) {
        TransportTaskTrack parent = TransportTaskTrackExpression.this.eval(transportTaskTrack);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getTrackTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return TransportTaskTrackExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T transportTaskTrack) {
        TransportTaskTrack parent = TransportTaskTrackExpression.this.eval(transportTaskTrack);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTrackTime();
      }
    };
  }

  public Expression<T, BigDecimal> getLatitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return TransportTaskTrackExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T transportTaskTrack) {
        TransportTaskTrack parent = TransportTaskTrackExpression.this.eval(transportTaskTrack);
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
        return TransportTaskTrackExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T transportTaskTrack) {
        TransportTaskTrack parent = TransportTaskTrackExpression.this.eval(transportTaskTrack);
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
        return TransportTaskTrackExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T transportTaskTrack) {
        TransportTaskTrack parent = TransportTaskTrackExpression.this.eval(transportTaskTrack);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.transporttask.TransportTaskExpression<T> getMovement() {
    return new com.doublechaintech.retailscm.transporttask.TransportTaskExpression<T>() {
      @Override
      public T $getRoot() {
        return TransportTaskTrackExpression.this.$getRoot();
      }

      public TransportTask eval(T transportTaskTrack) {
        TransportTaskTrack parent = TransportTaskTrackExpression.this.eval(transportTaskTrack);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMovement();
      }
    };
  }
}
