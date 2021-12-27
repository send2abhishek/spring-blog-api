package com.spring.blog.blogrestapi.web.controller;

import com.spring.blog.blogrestapi.domain.Permission;
import com.spring.blog.blogrestapi.service.PermissionService;
import com.spring.blog.blogrestapi.web.model.PermissionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public ResponseEntity<List<Permission>> findPermission() {
        return new ResponseEntity<>(permissionService.findAllPermission(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> savePermission(@Valid @RequestBody PermissionDto permissionDto) {
        return new ResponseEntity<>(permissionService.savePermission(permissionDto), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePermission(@Valid @RequestBody PermissionDto permissionDto,@PathVariable Long id) {
        return new ResponseEntity<>(permissionService.updatePermission(permissionDto, id), HttpStatus.ACCEPTED);
    }

}
