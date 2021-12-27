package com.spring.blog.blogrestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class PermissionDto {

    private Long id;
    @NotNull(message = "permission can't be null")
    private String permission;
}
