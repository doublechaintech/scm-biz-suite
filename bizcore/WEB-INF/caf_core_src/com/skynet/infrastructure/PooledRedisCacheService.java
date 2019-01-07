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
            return;
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(2);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setMaxWaitMillis(1000);
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(60000);
        pool = new JedisPool(jedisPoolConfig, host, port, timeout, StringUtils.isEmpty(password) ? null : password, database);
    }

    protected Jedis getJedis() {


        ensurePool();
        return pool.getResource();
    }


}
