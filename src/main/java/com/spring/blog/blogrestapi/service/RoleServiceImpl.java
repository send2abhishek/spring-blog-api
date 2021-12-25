package com.spring.blog.blogrestapi.service;

import com.spring.blog.blogrestapi.domain.Permission;
import com.spring.blog.blogrestapi.domain.Role;
import com.spring.blog.blogrestapi.repository.RoleRepository;
import com.spring.blog.blogrestapi.web.model.RoleDto;
import org.springframework.stereotype.Service;

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
                if (permissionInput!= null) {
                    permissionSet.add(Permission.builder().id(permissionInput).build());
                }
            });

            role = Role.builder().roleName(roleDto.getRoleName()).permissions(permissionSet).build();
        }

        // prepareResponse Object

        HashMap<String,Object> response=new HashMap<>();

        if(role!=null){
            response.put("message","Role Added");
            response.put("roleName",roleDto.getRoleName());
            // save role to database
            roleRepository.save(role);
        }
        else {
            response.put("error","Something Went wrong");
        }

        return response;
    }

    @Override
    public Object updateRole(RoleDto roleDto, Long roleId) {
        return null;
    }

    @Override
    public List<Role> findAllRoles() {
        return null;
    }
}
