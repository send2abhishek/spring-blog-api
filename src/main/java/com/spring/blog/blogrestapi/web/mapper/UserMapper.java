package com.spring.blog.blogrestapi.web.mapper;

import com.spring.blog.blogrestapi.domain.User;
import com.spring.blog.blogrestapi.web.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role.id", source = "roleId")
    User userDtoToUser(UserDto userDto);

}
