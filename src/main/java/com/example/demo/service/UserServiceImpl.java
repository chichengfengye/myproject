package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public User getUser(User user){
        return userMapper.getUser(user);
    }

    public User updateUser(User user){
        Integer result = userMapper.updateUser(user);
        return user;
    }

    public Long createUser(User user) {
        Long result = userMapper.createUser(user);
        return user.getId();
    }

    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }
}
