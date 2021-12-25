package com.spring.blog.blogrestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto implements Serializable {

    static final long serialVersionUID= 1518744216947238300L;

    @NotNull(message = "Role can't be null")
    private String roleName;
    private Set<Long> permissions;


}
