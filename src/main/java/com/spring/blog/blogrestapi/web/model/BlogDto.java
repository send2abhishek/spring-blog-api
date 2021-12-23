package com.spring.blog.blogrestapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogDto implements Serializable {

    static final long serialVersionUID= -4908854647353847926L;

    @NotNull(message = "user id can't be blank")
    private Long userId;
    @NotNull(message = "post title can't be null")
    @Size(min = 2,message = "title should be greater than 2")
    private String title;
    @NotBlank(message = "blog post description is needed")
    private String post;
}
