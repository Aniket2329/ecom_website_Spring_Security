package com.website.ecom_web.service;

import com.website.ecom_web.Repository.UserRepo;
import com.website.ecom_web.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class userServiceTest {

    @Autowired
    UserRepo userRepo;

    @Test
    public void testUsername() {

        Optional<User> user = userRepo.findByUsername("aniket");
        assert(user.isPresent());


    }

}
