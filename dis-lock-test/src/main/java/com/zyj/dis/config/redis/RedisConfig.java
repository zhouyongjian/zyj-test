package com.zyj.dis.config.redis;


import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {


    @Bean
    public Jedis getJedis(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
       return jedis;
    }

//    @Bean
//    public JedisTem getJedis(){
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        return jedis;
//    }

    @Bean
    public Redisson getRedisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://locolhost:6379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}
