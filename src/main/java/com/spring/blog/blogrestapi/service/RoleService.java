package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Role;
import com.spring.blog.blogrestapi.web.model.RoleDto;

import java.util.List;

public interface RoleService {

    Object saveRole(RoleDto roleDto);
    Object updateRole(RoleDto roleDto,Long roleId);
    List<Role> findAllRoles();
}
