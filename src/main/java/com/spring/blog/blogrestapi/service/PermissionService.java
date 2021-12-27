package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Permission;
import com.spring.blog.blogrestapi.web.model.PermissionDto;

import java.util.List;

public interface PermissionService {

    List<Permission> findAllPermission();
    Object savePermission(PermissionDto permissionDto);
    Object updatePermission(PermissionDto permissionDto,Long permissionId);
}
