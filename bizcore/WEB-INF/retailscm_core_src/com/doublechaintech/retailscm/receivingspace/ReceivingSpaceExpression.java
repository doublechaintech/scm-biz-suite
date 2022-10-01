package com.doublechaintech.retailscm.receivingspace;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class ReceivingSpaceExpression<T> implements Expression<T, ReceivingSpace> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getLocation() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLocation();
      }
    };
  }

  public Expression<T, String> getContactNumber() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getContactNumber();
      }
    };
  }

  public Expression<T, String> getDescription() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getDescription();
      }
    };
  }

  public Expression<T, String> getTotalArea() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public String eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTotalArea();
      }
    };
  }

  public Expression<T, BigDecimal> getLatitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
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
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLongitude();
      }
    };
  }

  public Expression<T, DateTime> getLastUpdateTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
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
        return ReceivingSpaceExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.warehouse.WarehouseExpression<T> getWarehouse() {
    return new com.doublechaintech.retailscm.warehouse.WarehouseExpression<T>() {
      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      public Warehouse eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getWarehouse();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T> getGoodsList() {
    return new com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return ReceivingSpaceExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Goods> eval(T receivingSpace) {
        ReceivingSpace parent = ReceivingSpaceExpression.this.eval(receivingSpace);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsList();
      }
    };
  }
}
