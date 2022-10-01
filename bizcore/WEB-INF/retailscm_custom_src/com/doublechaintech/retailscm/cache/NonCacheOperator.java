package com.doublechaintech.retailscm.cache;

public class NonCacheOperator implements CacheOperator {
  @Override
  public boolean clear(String pEntityCache) {
    return false;
  }

  @Override
  public <T> T get(String pEntityCache, Object pCacheKey) {
    return null;
  }

  @Override
  public boolean contains(String pEntityCache, Object pKey) {
    return false;
  }

  @Override
  public Object put(String pEntityCache, Object pCacheKey, Object pEntity) {
    return null;
  }

  @Override
  public boolean clear(String pEntityCache, Object pCacheKey) {
    return false;
  }
}
