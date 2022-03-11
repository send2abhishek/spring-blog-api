package com.spring.blog.blogrestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @NotNull(message = "username can't be blank")
    private String userName;
    @NotNull(message = "password can't be blank")
    private String password;
    @NotNull(message = "email can't be blank")
    private String email;
    @NotNull(message = "phone number can't be blank")
    private int phoneNumber;
    @NotNull(message = "role id can't be blank")
    private Long roleId;
    @NotNull(message = "designation can't be blank")
    private String designation;
}
