package com.spring.blog.blogrestapi.bootstrap;

import com.spring.blog.blogrestapi.domain.User;
import com.spring.blog.blogrestapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserDataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder().userName("Abhishek Aryan")
                    .password("12345")
                    .email("send2abhishek@live.com")
                    .phoneNumber(1234567890)
                    .build());
        }
    }
}

