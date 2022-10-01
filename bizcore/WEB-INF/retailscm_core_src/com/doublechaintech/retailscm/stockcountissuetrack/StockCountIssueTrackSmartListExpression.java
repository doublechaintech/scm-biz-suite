package com.doublechaintech.retailscm.stockcountissuetrack;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.expression.SmartListExpression;

import java.util.List;

public abstract class StockCountIssueTrackSmartListExpression<T>
    extends SmartListExpression<T, StockCountIssueTrack> {
  public StockCountIssueTrackExpression<T> first() {
    return new StockCountIssueTrackExpression<T>() {
      @Override
      public StockCountIssueTrack eval(T l) {
        List<StockCountIssueTrack> list = StockCountIssueTrackSmartListExpression.this.eval(l);
        return CollectionUtil.getFirst(list);
      }

      @Override
      public T $getRoot() {
        return StockCountIssueTrackSmartListExpression.this.$getRoot();
      }
    };
  }

  public StockCountIssueTrackExpression<T> get(int index) {
    return new StockCountIssueTrackExpression<T>() {
      @Override
      public StockCountIssueTrack eval(T l) {
        List<StockCountIssueTrack> list = StockCountIssueTrackSmartListExpression.this.eval(l);
        if (ObjectUtil.isEmpty(list)) {
          return null;
        }

        if (index < 0 || index > list.size() - 1) {
          return null;
        }
        return list.get(index);
      }

      @Override
      public T $getRoot() {
        return StockCountIssueTrackSmartListExpression.this.$getRoot();
      }
    };
  }
}
