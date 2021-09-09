package com.doublechaintech.retailscm.cache;

public interface CacheOperator {
  boolean clear(String pEntityCache);

  <T> T get(String pEntityCache, Object pCacheKey);

  boolean contains(String pEntityCache, Object pKey);

  Object put(String pEntityCache, Object pCacheKey, Object pEntity);

  boolean clear(String pEntityCache, Object pCacheKey);
}

