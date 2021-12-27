package com.spring.blog.blogrestapi.service.impl;

import com.spring.blog.blogrestapi.domain.Role;
import com.spring.blog.blogrestapi.domain.User;
import com.spring.blog.blogrestapi.repository.UserRepository;
import com.spring.blog.blogrestapi.service.UserService;
import com.spring.blog.blogrestapi.web.exceptionHandler.NotFoundException;
import com.spring.blog.blogrestapi.web.mapper.UserMapper;
import com.spring.blog.blogrestapi.web.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserDto userDto) {
        return userRepository.save(userMapper.userDtoToUser(userDto));
    }

    @Transactional
    @Override
    public User updateUser(UserDto userDto, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found"));

        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setRole(Role.builder().id(userDto.getRoleId()).build());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }
}
