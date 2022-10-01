package com.doublechaintech.retailscm.goodsallocation;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class GoodsAllocationExpression<T> implements Expression<T, GoodsAllocation> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsAllocationExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsAllocation) {
        GoodsAllocation parent = GoodsAllocationExpression.this.eval(goodsAllocation);
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
        return GoodsAllocationExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsAllocation) {
        GoodsAllocation parent = GoodsAllocationExpression.this.eval(goodsAllocation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getLocation();
      }
    };
  }

  public Expression<T, BigDecimal> getLatitude() {
    return new Expression<T, BigDecimal>() {
      @Override
      public T $getRoot() {
        return GoodsAllocationExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T goodsAllocation) {
        GoodsAllocation parent = GoodsAllocationExpression.this.eval(goodsAllocation);
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
        return GoodsAllocationExpression.this.$getRoot();
      }

      @Override
      public BigDecimal eval(T goodsAllocation) {
        GoodsAllocation parent = GoodsAllocationExpression.this.eval(goodsAllocation);
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
        return GoodsAllocationExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T goodsAllocation) {
        GoodsAllocation parent = GoodsAllocationExpression.this.eval(goodsAllocation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsshelf.GoodsShelfExpression<T> getGoodsShelf() {
    return new com.doublechaintech.retailscm.goodsshelf.GoodsShelfExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsAllocationExpression.this.$getRoot();
      }

      public GoodsShelf eval(T goodsAllocation) {
        GoodsAllocation parent = GoodsAllocationExpression.this.eval(goodsAllocation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsShelf();
      }
    };
  }

  public com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T> getGoodsList() {
    return new com.doublechaintech.retailscm.goods.GoodsSmartListExpression<T>() {

      @Override
      public T $getRoot() {
        return GoodsAllocationExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<Goods> eval(T goodsAllocation) {
        GoodsAllocation parent = GoodsAllocationExpression.this.eval(goodsAllocation);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getGoodsList();
      }
    };
  }
}
