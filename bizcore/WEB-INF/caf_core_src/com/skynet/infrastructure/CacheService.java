package com.skynet.infrastructure;

import java.util.List;

public interface CacheService {
	public Object get(String key, Class<?> clazz) ;
	public void put(String key, Object value, int ttlInSeconds) ;
	public List<Object> mget(List<String> keys, Class<?> clazz) ;
	public void remove(String key) ;

	default void lpush(String key, Object value , int ttlInSeconds){};
	default void rpush(String key, Object value , int ttlInSeconds){};
	default void ltrime(String key, int start, int end){};
	default <T> List<T> lget(String key, Class<T> clazz){return  null;};
	default <T> T lpop(String key, Class<T> clazz) {return null;}
}
