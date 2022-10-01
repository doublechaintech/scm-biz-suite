package com.doublechaintech.retailscm.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

public class BaseCacheOperator implements CacheOperator {

  private CacheManager cacheManager;

  public CacheManager getCacheManager() {
    return cacheManager;
  }

  public void setCacheManager(CacheManager pCacheManager) {
    cacheManager = pCacheManager;
  }

  public boolean contains(String name, Object key) {
    Cache cache = cacheManager.getCache(name);
    if (cache == null) {
      throw new RuntimeException("cache with name:" + name + " not existed");
    }

    ValueWrapper valueWrapper = cache.get(key);
    if (valueWrapper == null) {
      return false;
    }
    return true;
  }

  public boolean remove(String name, Object key) {
    Cache cache = cacheManager.getCache(name);
    if (cache == null) {
      throw new RuntimeException("cache with name:" + name + " not existed");
    }
    if (!contains(name, key)) {
      return false;
    }
    cache.evict(key);
    return true;
  }

  public <T> T get(String name, Object key) {
    Cache cache = cacheManager.getCache(name);
    if (cache == null) {
      throw new RuntimeException("cache with name:" + name + " not existed");
    }

    ValueWrapper valueWrapper = cache.get(key);
    if (valueWrapper == null) {
      return null;
    } else {
      return (T) valueWrapper.get();
    }
  }

  public Object put(String name, Object key, Object value) {
    Cache cache = cacheManager.getCache(name);
    if (cache == null) {
      throw new RuntimeException("cache with name:" + name + " not existed");
    }
    cache.put(key, value);
    return value;
  }

  public boolean clear(String name, Object key) {
    if (!contains(name, key)) {
      return false;
    }
    Cache cache = cacheManager.getCache(name);
    if (cache == null) {
      throw new RuntimeException("cache with name:" + name + " not existed");
    }
    cache.evict(key);
    return true;
  }

  public boolean clear(String name) {
    Cache cache = cacheManager.getCache(name);
    if (cache == null) {
      throw new RuntimeException("cache with name:" + name + " not existed");
    }
    cache.clear();
    return true;
  }
}
