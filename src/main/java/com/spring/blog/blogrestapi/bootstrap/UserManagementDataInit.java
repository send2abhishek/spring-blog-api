package com.spring.blog.blogrestapi.bootstrap;

import com.spring.blog.blogrestapi.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserManagementDataInit implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public UserManagementDataInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        HashSet<Permission> permissions=new HashSet<>();
//        permissions.add(Permission.builder().id(16L).build());
//        roleRepository.save(Role.builder().roleName("user").permissions(permissions).build());
//        permissions.add(Permission.builder().permission("create").build());
//        permissions.add(Permission.builder().permission("edit").build());
//        permissions.removeAll();

//        Role role = roleRepository.findById(3L).get();
//        Set<Permission> permissions = role.getPermissions();
//        permissions.clear();
////        permissions.add(Permission.builder().id(14L).build());
////        permissions.add(Permission.builder().id(15L).build());
//        role.setPermissions(permissions);
//
//
//
//        roleRepository.save(role);
    }
}
