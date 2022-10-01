package com.doublechaintech.retailscm.goodsmovement;

import cn.hutool.core.util.ObjectUtil;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class GoodsMovementExpression<T> implements Expression<T, GoodsMovement> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, DateTime> getMoveTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getMoveTime();
      }
    };
  }

  public Expression<T, String> getFacility() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFacility();
      }
    };
  }

  public Expression<T, String> getFacilityId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFacilityId();
      }
    };
  }

  public Expression<T, String> getFromIp() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getFromIp();
      }
    };
  }

  public Expression<T, String> getUserAgent() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getUserAgent();
      }
    };
  }

  public Expression<T, String> getSessionId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSessionId();
      }
    };
  }

  public Expression<T, BigDecimal> getLatitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
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
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
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
        return GoodsMovementExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsExpression<T> getGoods() {
    return new com.doublechaintech.retailscm.goods.GoodsExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsMovementExpression.this.$getRoot();
      }

      public Goods eval(T goodsMovement) {
        GoodsMovement parent = GoodsMovementExpression.this.eval(goodsMovement);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoods();
      }
    };
  }
}
