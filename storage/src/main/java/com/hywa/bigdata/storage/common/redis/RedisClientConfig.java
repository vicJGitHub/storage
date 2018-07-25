package com.hywa.bigdata.storage.common.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class RedisClientConfig {

    @Value("${redis.config.url}")
    private String ip;
    @Value("${redis.config.port}")
    private int port;
    @Value("${redis.config.pool.maxActive}") //最大活动的对象个数
    private int maxTotal;
    @Value("${redis.config.pool.maxIdle}")//对象最大空闲时间
    private int maxIdle;
    @Value("${redis.config.pool.maxWait}") //获取对象时最大等待时间
    private long maxWaitmillis;
    @Value("${redis.config.testOnborrow}")
    private boolean testOnborrow;

    public ShardedJedisPool getShardedJedisPool(ShardedJedisPool pool) {
        System.out.println("================启动redis==============");
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMaxWaitMillis(maxWaitmillis);
            config.setTestOnBorrow(testOnborrow);
            // slave链接
            List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
            shards.add(new JedisShardInfo(ip, port, "master"));
            // 构造池
            pool = new ShardedJedisPool(config, shards);
        }
        return pool;
    }
}
