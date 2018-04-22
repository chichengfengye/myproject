package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUser(User user);

    Long createUser(User user);

    Integer updateUser(User user);

    User getUserById(@Param("id") Long id);
}
