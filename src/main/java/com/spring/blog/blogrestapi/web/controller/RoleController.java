package com.spring.blog.blogrestapi.web.controller;

import com.spring.blog.blogrestapi.domain.Role;
import com.spring.blog.blogrestapi.service.RoleService;
import com.spring.blog.blogrestapi.web.model.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Object> saveRole(@Valid @RequestBody RoleDto roleDto) {
        return new ResponseEntity<>(roleService.saveRole(roleDto), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Role>> fetchRole(){
        return new ResponseEntity<>(roleService.findAllRoles(),HttpStatus.OK);
    }
}
