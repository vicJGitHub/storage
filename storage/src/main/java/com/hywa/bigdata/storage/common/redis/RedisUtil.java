package com.hywa.bigdata.storage.common.redis;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Set;


@Component
public class RedisUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);
    @Autowired
    private RedisClientConfig redisClientConfig;
    @Autowired
    private ShardedJedisPool pool;

    @Bean("shardedJedis")
    private ShardedJedisPool shardedJedis() {
        pool = redisClientConfig.getShardedJedisPool(pool);
        return pool;
    }

    /**
     * 设置缓存
     *
     * @param key   缓存key
     * @param value 缓存value
     */
    public void set(String key, String value) {
        try {
            ShardedJedis shardedJedis = pool.getResource();
            shardedJedis.set(key, value);
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.debug("RedisUtil:set cache key={},value={}", key, value);
    }

    /**
     * 设置缓存对象
     *
     * @param key 缓存key
     * @param obj 缓存value
     */
    public <T> void setObject(String key, T obj, int expireTime) {
        try {
            ShardedJedis shardedJedis = pool.getResource();
            shardedJedis.setex(key, expireTime, JSON.toJSONString(obj));
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定key的缓存
     *
     * @param key---JSON.parseObject(value, User.class);
     */
    public String getObject(String key) {
        String value = "";
        try {
            ShardedJedis shardedJedis = pool.getResource();
            value = shardedJedis.get(key);
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 判断当前key值 是否存在
     *
     * @param key
     */
    public boolean hasKey(String key) {
        boolean value = false;
        try {
            ShardedJedis shardedJedis = pool.getResource();
            value = shardedJedis.exists(key);
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    /**
     * 根据条件查询key
     */
    public Set<String> keys(String pattern) {
        Set<String> keys = null;
        try {
            ShardedJedis shardedJedis = pool.getResource();
            keys = shardedJedis.getShard("master").keys(pattern);
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keys;
    }


    /**
     * 根据条件查询key
     *
     * @param key
     */
    public Long setExpireTime(String key, int expireTime) {
        Long expire = null;
        try {
            ShardedJedis shardedJedis = pool.getResource();
            expire = shardedJedis.expire(key, expireTime);
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return expire;
    }


    /**
     * 设置缓存，并且自己指定过期时间
     *
     * @param key
     * @param value
     * @param expireTime 过期时间
     */
    public void setWithExpireTime(String key, String value, int expireTime) {
        try {
            ShardedJedis shardedJedis = pool.getResource();
            shardedJedis.setex(key, expireTime, value);
            shardedJedis.close();
            LOGGER.debug("RedisUtil:setWithExpireTime cache key={},value={},expireTime={}", key, value, expireTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取指定key的缓存
     *
     * @param key
     */
    public String get(String key) {
        String value = "";
        try {
            ShardedJedis shardedJedis = pool.getResource();
            value = shardedJedis.get(key);
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.debug("RedisUtil:get cache key={},value={}", key, value);
        return value;
    }

    /**
     * 删除指定key的缓存
     *
     * @param key
     */
    public void delete(String key) {
        try {
            ShardedJedis shardedJedis = pool.getResource();
            shardedJedis.del(key);
            LOGGER.debug("RedisUtil:delete cache key={}", key);
            shardedJedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
