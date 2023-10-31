package com.zhulang.xfxhsimple.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

    public JedisPool jedisPool = null;

    public JedisPool getJedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(8);
        config.setMaxIdle(2);
        config.setMinIdle(0);
        config.setMaxWaitMillis(3000);
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config,"127.0.0.1", 6379);
        return jedisPool;
    }

    public Jedis getJedis(){
        JedisPool jedisPool = getJedisPool();
        if (jedisPool != null){
            return jedisPool.getResource();
        }else {
            return null;
        }
    }

    public void close(Jedis jedis){
        if (jedis != null){
            jedis.close();
        }
    }

}
