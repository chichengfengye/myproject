package com.example.demo.controller;

import com.example.demo.service.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping("/redis/{name}")
    public String redisTesy(@PathVariable String name) {
        return redisService.setNameString(name);
    }

    @RequestMapping("/getname")
    public String getName () {
        return redisService.getNameSring();
    }
}
