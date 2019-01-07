package com.skynet.infrastructure;

public interface CacheService {
	public Object get(String key, Class<?> clazz) ;
	public void put(String key, Object value, int ttlInSeconds) ;
	public void remove(String key) ;
	
}
