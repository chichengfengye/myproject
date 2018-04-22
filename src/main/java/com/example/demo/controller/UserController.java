package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.POST)
    public User getUserInfo(@PathVariable String name,
                        @RequestParam String password) throws Exception{
        User user = new User(name,password);
        return userService.getUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Long createUser(User user) throws Exception{
        return userService.createUser(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public User updateUser(User user) throws Exception{
        return userService.updateUser(user);
    }
}
