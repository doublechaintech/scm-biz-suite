package com.doublechaintech.retailscm.search;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.BaseEntity;

import java.util.Iterator;
import java.util.List;

public class RequestIterable<T extends BaseEntity> implements Iterable<T> {
  Object userContext;
  BaseRequest<T> request;
  int requestSize;
  int maxStart;
  int batch = 1000;
  int currentStart;
  List<T> currentBatch = null;
  int nextIndex = 0;

  private boolean hasMore() {
    // 刚开始获取数据
    if (currentBatch == null) {
      BaseRequest<T> clone = ObjectUtil.clone(request);
      clone.setOffset(currentStart);
      clone.setSize(batch);
      currentBatch = Searcher.search(userContext, clone);
      nextIndex = 0;
    }

    // 没有数据
    if (currentBatch.size() == 0) {
      return false;
    }

    // 还有数据直接取
    if (nextIndex < currentBatch.size()) {
      return true;
    } else {
      // 前一次结果不够batch数，数据库中应该没有了
      if (currentBatch.size() < batch) {
        return false;
      }

      // 已经取了足够的数据
      if (currentStart >= maxStart) {
        return false;
      }

      currentStart = currentStart + batch;
      // 期望取的数据量
      batch = NumberUtil.min(maxStart - currentStart, batch);
      if (batch <= 0) {
        return false;
      }
      BaseRequest<T> clone = ObjectUtil.clone(request);
      clone.setOffset(currentStart);
      clone.setSize(batch);
      currentBatch = Searcher.search(userContext, clone);
      nextIndex = 0;
    }

    // 没有数据
    if (currentBatch.size() == 0) {
      return false;
    }
    return true;
  }

  public RequestIterable(Object userContext, BaseRequest<T> request) {
    this(userContext, request, 1000);
  }

  public RequestIterable(Object userContext, BaseRequest<T> request, int batch) {
    this.userContext = userContext;
    this.request = ObjectUtil.clone(request);
    this.currentStart = this.request.getOffset();
    this.requestSize = this.request.getSize();
    this.batch = NumberUtil.min(requestSize, batch);
    this.maxStart = currentStart + requestSize;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      @Override
      public boolean hasNext() {
        return hasMore();
      }

      @Override
      public T next() {
        return currentBatch.get(nextIndex++);
      }
    };
  }
}
