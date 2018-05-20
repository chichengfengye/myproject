package com.example.demo.service;

import com.example.demo.redis.MemCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
public class RedisServiceImpl {
    @Autowired
    private JedisCluster jedisCluster;

    public String setNameString(String name){
        return jedisCluster.set("name", name);
    }

    public String getNameSring() {
        return jedisCluster.get("name");
    }

   /* @Autowired
    private MemCache memCache;

    public String setNameString(String name){
        if(memCache.setNoExpire("name", name)){
            return  "SUCCESS!";
        }
        return "ERROR!";
    }

    public String getNameSring() {
        return memCache.get("name");
    }*/
}
