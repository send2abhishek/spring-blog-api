package com.spring.blog.blogrestapi.service.impl;

import com.spring.blog.blogrestapi.domain.Permission;
import com.spring.blog.blogrestapi.domain.Role;
import com.spring.blog.blogrestapi.repository.RoleRepository;
import com.spring.blog.blogrestapi.service.RoleService;
import com.spring.blog.blogrestapi.web.exceptionHandler.NotFoundException;
import com.spring.blog.blogrestapi.web.model.RoleDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Object saveRole(RoleDto roleDto) {
        Role role = null;
        if (roleDto.getPermissions() == null) {
            role = Role.builder().roleName(roleDto.getRoleName()).build();
        } else if (roleDto.getPermissions() != null) {

            Set<Permission> permissionSet = new HashSet<>();
            roleDto.getPermissions().forEach(permissionInput -> {
                // permission already exists
                if (permissionInput != null) {
                    permissionSet.add(Permission.builder().id(permissionInput).build());
                }
            });

            role = Role.builder().roleName(roleDto.getRoleName()).permissions(permissionSet).build();
        }

        // prepareResponse Object

        HashMap<String, Object> response = new HashMap<>();

        if (role != null) {
            Role savedRole = roleRepository.save(role);
            response.put("message", "Role Added");
            response.put("roleId",savedRole.getId());
            response.put("roleName", savedRole.getRoleName());
            // save role to database

        } else {
            response.put("error", "Something Went wrong");
        }

        return response;
    }

    @Transactional
    @Override
    public Object updateRole(RoleDto roleDto, Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new NotFoundException("role doesn't exist given role id"));

        role.setRoleName(roleDto.getRoleName());
        Set<Permission> permissions = role.getPermissions();
        permissions.clear();
        roleDto.getPermissions().forEach(permissionInput -> {
            if (permissionInput != null) {
                permissions.add(Permission.builder().id(permissionInput).build());
            }
        });
        role.setPermissions(permissions);
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Role updated");
        response.put("roleName", roleDto.getRoleName());
        // save role to database
        roleRepository.save(role);

        return response;
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }
}
