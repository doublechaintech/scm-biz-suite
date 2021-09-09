package com.skynet.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedisCacheService implements CacheService {
    private String host;
    private int port;
    private int timeout;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    protected Jedis getJedis() {
    	
        Jedis jedis = new Jedis(host, port, timeout);
        if (StringUtils.isNotEmpty(password)) {
            jedis.auth(password);
        }
        return jedis;
    }
    

    protected ObjectMapper getMapper() {
        ObjectMapper mapper;
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
  
    }
    protected Class<?> classAt(Class<?>[] clazzes, int index){
    	return clazzes[index];
    }
    public Object[] mget(String keys[], Class<?>[] clazzes) {
        if (keys == null) {
            return new Object[0];
        }
        if (keys.length == 0) {
            return new Object[0];
        }
        // Ticker ticker = new Ticker();
        Jedis jedis = null;
        try {
            jedis = getJedis();
            log("class" + jedis.getClass());
            // ticker.tick("init getJedis();");
            
            List<String> values = jedis.mget(keys);
            if (values == null) {
            	log("jedis.mget(keys) return null!!!");
                return null;
            }
            // ticker.tick("jedis.get(key);");
            ObjectMapper mapper = getMapper();
            // ticker.tick(" new ObjectMapper();");


            Object[] result = new Object[keys.length];
            for (int i = 0; i < keys.length; i++) {

                result[i] = mapper.readValue(values.get(i), clazzes[i]);
                // ticker.tick(" mapper.readValue(value,clazz);");

            }
            return result;

        } catch (Exception e) {
            return null;
        } finally {
            closeConnection(jedis);

        }
        
    }

    public Object get(String key, Class<?> clazz) {
        // Ticker ticker = new Ticker();

        // log("getting " + clazz + " with key: " + key);
        Jedis jedis = null;
        try {
            jedis = getJedis();
            // ticker.tick("init getJedis();");
            String value = jedis.get(key);
            if (value == null) {
                // log("getting " + clazz + " with key: " + key + " fail (null)");
                return null;
            }
            // ticker.tick("jedis.get(key);");
            ObjectMapper mapper = getMapper();
            // ticker.tick(" new ObjectMapper();");
            Object object = mapper.readValue(value, clazz);
            // ticker.tick(" mapper.readValue(value,clazz);");
            return object;

        } catch (Exception e) {
            log("getting " + clazz + " with key: " + key + " with an exception" + e.getMessage());
            return null;
        } finally {

        	closeConnection(jedis);
        }

    }

    private void log(String string) {
        System.out.println(string);
    }

    public void put(String key, Object value, int ttlInSeconds) {
        // Silly impl just for POC
        // Jedis jedis = new Jedis("localhost");
        // Ticker ticker = new Ticker();
        Jedis jedis = null;
        try {
            jedis = getJedis();
            // ticker.tick("init getJedis();");
            ObjectMapper mapper = getMapper();
            // ticker.tick(" new ObjectMapper();");
            String json = mapper.writeValueAsString(value);
            // ticker.tick("mapper.writeValueAsString(value)");
            jedis.set(key, json);
            if (ttlInSeconds >= 0) {
                jedis.expire(key, ttlInSeconds);
            }
            // ticker.tick("jedis.set(key, json);jedis.expire(key, ttlInSeconds);");

        }catch (JsonProcessingException e) {
            // is fine
        }catch(Exception e) {
        	String errorMessage = String.format("Redis Connection Error to server @ %s:%d -> %s", this.host,this.port,e.getMessage());
        	throw new IllegalStateException(errorMessage);
        } finally {
            closeConnection(jedis);
        }
        
    }


    protected void closeConnection(Jedis jedis) {
    	
    	if (jedis == null) {
            return;
        }
    	jedis.close();
    }

    public void remove(String key)  {

        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.del(key);
        }catch(Exception e) {
        	String errorMessage = String.format("Redis Connection Error to server @ %s:%d -> %s", this.host,this.port,e.getMessage());
        	throw new IllegalStateException(errorMessage);
        } finally {

            closeConnection(jedis);
        }
    }

    @Override
    public void lpush(String key, Object value, int ttlInSeconds) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            try {
                ObjectMapper mapper = getMapper();
                String json = mapper.writeValueAsString(value);
                jedis.lpush(key, json);

                if (ttlInSeconds >= 0) {
                    jedis.expire(key, ttlInSeconds);
                }
            } catch (JsonProcessingException pE) {
                jedis.lpush(key, String.valueOf(value));
                if (ttlInSeconds >= 0) {
                    jedis.expire(key, ttlInSeconds);
                }
            }
        } finally {
            closeConnection(jedis);
        }
    }


    @Override
    public void rpush(String key, Object value, int ttlInSeconds) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            try {
                ObjectMapper mapper = getMapper();
                String json = mapper.writeValueAsString(value);
                jedis.rpush(key, json);

                if (ttlInSeconds >= 0) {
                    jedis.expire(key, ttlInSeconds);
                }
            } catch (JsonProcessingException pE) {
                jedis.rpush(key, String.valueOf(value));
            }
        } finally {
            closeConnection(jedis);
        }
    }

    @Override
    public void ltrime(String key, int start, int end) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.ltrim(key, start, end);
        } finally {
            closeConnection(jedis);
        }
    }

    @Override
    public <T> List<T> lget(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = getJedis();

            String type = jedis.type(key);
            switch (type) {
                case "string":
                    return convertStringToList(jedis.get(key), clazz);
                case "list":
                    return convertListStringToList(jedis.lrange(key, 0, jedis.llen(key)), clazz);
                default:
                    return null;
            }
        } finally {
            closeConnection(jedis);
        }
    }

    private <T> List<T> convertListStringToList(List<String> pListString, Class<T> pClazz) {

        if (pListString == null) {
            return null;
        }

        List<T> list = new ArrayList<>();
        for (String s : pListString) {
            if (s == null) {
                continue;
            }
            ObjectMapper mapper = getMapper();
            try {
                T v = mapper.readValue(s, pClazz);
                list.add(v);
            } catch (IOException pE) {
            }
        }
        return list;
    }

    private <T> List<T> convertStringToList(String pS, Class<T> pClazz) {
        ObjectMapper mapper = getMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, pClazz);
        try {
            return (List<T>) mapper.readValue(pS, javaType);
        } catch (IOException pE) {
        	//closeConnection(jedis);

        }
        return null;
    }

	@Override
	public List<Object> mget(List<String> keys, Class<?> clazz) {
		Class<?>[] clazzes = new Class<?>[keys.size()];
		for(int i=0;i<clazzes.length;i++) {
			clazzes[i] = clazz;
		}
		Object [] mObjects = this.mget(keys.toArray(new String[] {}), clazzes);
		
		if(mObjects==null) {
			return new ArrayList<Object>();
		}
		
		return Arrays.asList(mObjects);
	}

    @Override
    public <T> T lpop(String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            // ticker.tick("init getJedis();");
            String value = jedis.lpop(key);
            if (value == null) {
                // log("getting " + clazz + " with key: " + key + " fail (null)");
                return null;
            }
            // ticker.tick("jedis.get(key);");
            ObjectMapper mapper = getMapper();
            // ticker.tick(" new ObjectMapper();");
            T object = mapper.readValue(value, clazz);
            // ticker.tick(" mapper.readValue(value,clazz);");
            return object;

        } catch (Exception e) {
            log("getting " + clazz + " with key: " + key + " with an exception" + e.getMessage());
            return null;
        } finally {
            closeConnection(jedis);
        }
    }
}
