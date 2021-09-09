package com.doublechaintech.retailscm.utils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.secuser.SecUserCustomManagerImpl;
import com.terapico.utils.*;

public class BaseBizHelper {
	protected CustomRetailscmUserContextImpl userContext;
	protected static final Map<String, Object> EO = new HashMap<>();
	protected Map<String, Object> cache;

	public CustomRetailscmUserContextImpl getUserContext() {
		return userContext;
	}
	public void setUserContext(CustomRetailscmUserContextImpl userContext) {
		this.userContext = userContext;
	}

	protected static <T extends BaseBizHelper> T _OF(CustomRetailscmUserContextImpl ctx, Class<T> clazz) {
		return _OF(ctx, clazz, false);
	}

	protected static <T extends BaseBizHelper> T _OF(CustomRetailscmUserContextImpl ctx,
			Class<T> clazz, boolean forceNew) {
		String key = "thread_lvl_helper_" + clazz.getName();
		@SuppressWarnings("unchecked")
		T t = (T) ctx.getFromContextLocalStorage(key);
		if (t != null && !forceNew) {
			return t;
		}
		try {
			t = clazz.newInstance();
			t.setUserContext(ctx);
			ctx.putIntoContextLocalStorage(key, t);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected <T> T cache(String key, T value) {
		ensureCache();
		cache.put(key, value);
		return value;
	}
	protected <T> T cached(String key) {
		if (cache == null) {
			return null;
		}
		return (T)cache.get(key);
	}
	protected <T> T uncache(String key) {
		if (cache == null) {
			return null;
		}
		return (T)cache.remove(key);
	}
	protected <T> T withCache(String key, Callable<T> callable) throws Exception {
    T obj = cached(key);
    if (obj != null) {
      return obj;
    }
    obj = callable.call();
    return cache(key, obj);
  }
	protected <T> T withCacheNotNull(String key, Callable<T> callable) throws Exception {
    T obj = cached(key);
    if (obj != null) {
      return obj;
    }
    obj = callable.call();
    if (obj == null) {
      return null;
    }
    if (obj instanceof List && ((List) obj).isEmpty()) {
      return obj;
    }
    if (obj instanceof Map && ((Map) obj).isEmpty()) {
      return obj;
    }

    cache(key, obj);
    return obj;
  }
	protected void ensureCache() {
		if (cache == null) {
			cache = new HashMap<>();
		}
	}

	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		return mapper;
	}

	protected void notdone() {
		throw new UnsupportedOperationException("方法未实现");
	}

  protected void debug(Object format, Object ... params){
    if (this.getUserContext().isProductEnvironment()){
      return;
    }
    String tag = String.format("[DEBUG-%20s]: ", this.getClass().getSimpleName());
    if(format instanceof String){
      System.out.println(String.format(tag+format,params));
      return;
    }
    if (format != null) {
      if (params == null){
        System.out.println(tag + format);
      }else{
        System.out.println(tag + format+", params:" + Arrays.asList(params));
      }
      return;
    }

    if (params == null){
      System.out.println(tag + " [null]" );
    }else{
      System.out.println(tag + Arrays.asList(params));
    }
  }

  protected <R> R ifNull(R val, R other){
    return RetailscmBaseUtils.ifNull(val, other);
  }
  protected <R> R orNull(Callable<R> callable){
    return RetailscmBaseUtils.orNull(callable);
  }
  protected <R> R orElse(Callable<R> callable, R defaulVal){
    return RetailscmBaseUtils.orElse(callable, defaulVal);
  }
}
















