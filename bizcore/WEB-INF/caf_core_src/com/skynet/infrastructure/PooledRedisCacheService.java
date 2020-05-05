package com.skynet.infrastructure;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class PooledRedisCacheService extends RedisCacheService implements CacheService {
    private JedisPool pool;
    private String host;
    private int port;
    private int database = 0;
    private int timeout = 6000;
    private String password;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public synchronized void ensurePool() {
        if (pool != null) {
        	if(!pool.isClosed()) {
        		return;
        	}
            
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(2);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setMaxWaitMillis(1000);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(60);
        pool = new JedisPool(jedisPoolConfig, host, port, timeout, StringUtils.isEmpty(password) ? null : password, database);
    }
    public void destoryPool() {
    	ensurePool();
    	pool.close();
    }
    protected Jedis getJedis() {


        ensurePool();
        return pool.getResource();
    }
    
    
    public void report() {
    	 ensurePool();
    	 System.out.print(pool.getNumActive());
    }
    
    public static void main(String args[]) {
    	
    	PooledRedisCacheService cache=new PooledRedisCacheService();
    	
    	cache.setHost("127.0.0.1");
    	cache.setPort(6379);
    	
    	for(int i=0;i<100000;i++) {
    		cache.put("yes", "no", 10000);
    		cache.get("yes", String.class);
    		//System.out.println(i);
    	}
    	
    	
    	//System.out.println("done");
    	cache.report();
    	cache.destoryPool();
    	
    	
    	
    	
    }


}
