package com.spring.blog.blogrestapi;

import com.spring.blog.blogrestapi.configuration.FilePropertyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FilePropertyConfiguration.class)
public class BlogRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogRestApiApplication.class, args);
    }

}
