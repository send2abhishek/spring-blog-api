package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.User;
import com.spring.blog.blogrestapi.web.model.UserDto;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User saveUser(UserDto userDto);

    User updateUser(UserDto userDto, Long id);
}
