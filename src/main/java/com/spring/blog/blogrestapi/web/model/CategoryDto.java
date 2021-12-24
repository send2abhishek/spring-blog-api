package com.spring.blog.blogrestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

    @NotNull(message = "category can't be null")
    @Size(min = 2, message = "category should be min of 2 character")
    private String categoryName;
    @NotNull(message = "user id can't be blank")
    private Long userId;
}
