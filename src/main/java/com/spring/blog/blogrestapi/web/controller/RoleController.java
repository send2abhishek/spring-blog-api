package com.spring.blog.blogrestapi.web.controller;

import com.spring.blog.blogrestapi.service.RoleService;
import com.spring.blog.blogrestapi.web.model.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
