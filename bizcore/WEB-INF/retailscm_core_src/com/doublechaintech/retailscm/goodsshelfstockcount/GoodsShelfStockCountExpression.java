package com.doublechaintech.retailscm.goodsshelfstockcount;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class GoodsShelfStockCountExpression<T>
    implements Expression<T, GoodsShelfStockCount> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsShelfStockCountExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsShelfStockCount) {
        GoodsShelfStockCount parent =
            GoodsShelfStockCountExpression.this.eval(goodsShelfStockCount);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getId();
      }
    };
  }

  public Expression<T, String> getTitle() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsShelfStockCountExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsShelfStockCount) {
        GoodsShelfStockCount parent =
            GoodsShelfStockCountExpression.this.eval(goodsShelfStockCount);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getTitle();
      }
    };
  }

  public Expression<T, DateTime> getCountTime() {
    return new Expression<T, DateTime>() {
      @Override
      public T $getRoot() {
        return GoodsShelfStockCountExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T goodsShelfStockCount) {
        GoodsShelfStockCount parent =
            GoodsShelfStockCountExpression.this.eval(goodsShelfStockCount);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getCountTime();
      }
    };
  }

  public Expression<T, String> getSummary() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return GoodsShelfStockCountExpression.this.$getRoot();
      }

      @Override
      public String eval(T goodsShelfStockCount) {
        GoodsShelfStockCount parent =
            GoodsShelfStockCountExpression.this.eval(goodsShelfStockCount);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getSummary();
      }
    };
  }

  public Expression<T, Integer> getVersion() {
    return new Expression<T, Integer>() {
      @Override
      public T $getRoot() {
        return GoodsShelfStockCountExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T goodsShelfStockCount) {
        GoodsShelfStockCount parent =
            GoodsShelfStockCountExpression.this.eval(goodsShelfStockCount);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsshelf.GoodsShelfExpression<T> getShelf() {
    return new com.doublechaintech.retailscm.goodsshelf.GoodsShelfExpression<T>() {
      @Override
      public T $getRoot() {
        return GoodsShelfStockCountExpression.this.$getRoot();
      }

      public GoodsShelf eval(T goodsShelfStockCount) {
        GoodsShelfStockCount parent =
            GoodsShelfStockCountExpression.this.eval(goodsShelfStockCount);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getShelf();
      }
    };
  }

  public com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackSmartListExpression<
          T>
      getStockCountIssueTrackList() {
    return new com.doublechaintech.retailscm.stockcountissuetrack
            .StockCountIssueTrackSmartListExpression<
        T>() {

      @Override
      public T $getRoot() {
        return GoodsShelfStockCountExpression.this.$getRoot();
      }

      public com.doublechaintech.retailscm.SmartList<StockCountIssueTrack> eval(
          T goodsShelfStockCount) {
        GoodsShelfStockCount parent =
            GoodsShelfStockCountExpression.this.eval(goodsShelfStockCount);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStockCountIssueTrackList();
      }
    };
  }
}
