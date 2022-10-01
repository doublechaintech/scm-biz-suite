package com.doublechaintech.retailscm.stockcountissuetrack;

import cn.hutool.core.util.ObjectUtil;
import java.util.Date;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

import com.doublechaintech.retailscm.expression.Expression;

public abstract class StockCountIssueTrackExpression<T>
    implements Expression<T, StockCountIssueTrack> {

  public Expression<T, String> getId() {
    return new Expression<T, String>() {
      @Override
      public T $getRoot() {
        return StockCountIssueTrackExpression.this.$getRoot();
      }

      @Override
      public String eval(T stockCountIssueTrack) {
        StockCountIssueTrack parent =
            StockCountIssueTrackExpression.this.eval(stockCountIssueTrack);
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
        return StockCountIssueTrackExpression.this.$getRoot();
      }

      @Override
      public String eval(T stockCountIssueTrack) {
        StockCountIssueTrack parent =
            StockCountIssueTrackExpression.this.eval(stockCountIssueTrack);
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
        return StockCountIssueTrackExpression.this.$getRoot();
      }

      @Override
      public DateTime eval(T stockCountIssueTrack) {
        StockCountIssueTrack parent =
            StockCountIssueTrackExpression.this.eval(stockCountIssueTrack);
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
        return StockCountIssueTrackExpression.this.$getRoot();
      }

      @Override
      public String eval(T stockCountIssueTrack) {
        StockCountIssueTrack parent =
            StockCountIssueTrackExpression.this.eval(stockCountIssueTrack);
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
        return StockCountIssueTrackExpression.this.$getRoot();
      }

      @Override
      public Integer eval(T stockCountIssueTrack) {
        StockCountIssueTrack parent =
            StockCountIssueTrackExpression.this.eval(stockCountIssueTrack);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getVersion();
      }
    };
  }

  public com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountExpression<T>
      getStockCount() {
    return new com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountExpression<
        T>() {
      @Override
      public T $getRoot() {
        return StockCountIssueTrackExpression.this.$getRoot();
      }

      public GoodsShelfStockCount eval(T stockCountIssueTrack) {
        StockCountIssueTrack parent =
            StockCountIssueTrackExpression.this.eval(stockCountIssueTrack);
        if (ObjectUtil.isEmpty(parent)) {
          return null;
        }
        return parent.getStockCount();
      }
    };
  }
}
