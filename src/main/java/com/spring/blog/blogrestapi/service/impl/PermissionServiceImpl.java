package com.spring.blog.blogrestapi.service.impl;

import com.spring.blog.blogrestapi.domain.Permission;
import com.spring.blog.blogrestapi.repository.PermissionRepository;
import com.spring.blog.blogrestapi.service.PermissionService;
import com.spring.blog.blogrestapi.web.exceptionHandler.NotFoundException;
import com.spring.blog.blogrestapi.web.model.PermissionDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<Permission> findAllPermission() {
        return permissionRepository.findAll();
    }

    @Override
    public Object savePermission(PermissionDto permissionDto) {
        Permission savedPermission = permissionRepository.save(Permission.builder().permission(permissionDto.getPermission()).build());
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Permission saved");
        response.put("permission", savedPermission);
        return response;
    }

    @Transactional
    @Override
    public Object updatePermission(PermissionDto permissionDto, Long permissionId) {
        Permission permission = permissionRepository.findById(permissionId).orElseThrow(() -> new NotFoundException("permission not found with passed id"));
        permission.setPermission(permissionDto.getPermission());

        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Permission updated");
        response.put("permission", permissionRepository.save(permission));
        return response;
    }
}
