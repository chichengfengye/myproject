package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableConfigurationProperties(RedisClusterProps.class)
public class RedisClusterConfig {

    @Value("${redis.timeout}")
    private String timeout;


/*    @Bean
    public String MyTest(RedisClusterProps array){
        System.out.println(array);
        return "SS";
    }*/
    @Bean
    public JedisPoolConfig jedisPoolConfig(RedisClusterProps redisClusterProps) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisClusterProps.getPool().getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisClusterProps.getPool().getMaxIdle());
        jedisPoolConfig.setMinIdle(redisClusterProps.getPool().getMinIdle());
        jedisPoolConfig.setMaxWaitMillis(redisClusterProps.getPool().getMaxWaitMillis());
        jedisPoolConfig.setTestWhileIdle(redisClusterProps.getPool().isTestWhileIdle());
        jedisPoolConfig.setTestOnBorrow(redisClusterProps.getPool().isTestOnBorrow());
        jedisPoolConfig.setTestOnReturn(redisClusterProps.getPool().isTestOnReturn());
        return jedisPoolConfig;
    }

@Bean
public Set<HostAndPort> Hosts(RedisClusterProps redisClusterProps){
    List<RedisClusterProps.Name> nodes = redisClusterProps.getNodes();
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        for (RedisClusterProps.Name name:nodes) {
            HostAndPort hostAndPort = new HostAndPort(name.getHost(), name.getPort());
            hostAndPortSet.add(hostAndPort);
        }

        return hostAndPortSet;
}


    @Bean
    public JedisCluster jedisCluster(Set<HostAndPort> hosts,
                                        JedisPoolConfig jedisPoolConfig,
                                     RedisClusterProps redisClusterProps){
        JedisCluster jedisCluster = new JedisCluster(hosts, redisClusterProps.getTimeout(),
                6, jedisPoolConfig);
        return jedisCluster;
    }



    /*@Bean
    public JedisPool jdisPool(JedisPoolConfig jedisPoolConfig, RedisProperties redisProperties) {
        return new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(),
                redisProperties.getTimeout(), redisProperties.getPassword());
    }

    @Bean
    public MemCache memCache(JedisPool jedisPool) {
        MemCache memCache = new MemCache();
        memCache.setJedisPool(jedisPool);
        return memCache;
    }*/
}
