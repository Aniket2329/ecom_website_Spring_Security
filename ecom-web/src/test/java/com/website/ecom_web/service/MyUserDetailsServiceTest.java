package com.website.ecom_web.service;


import com.website.ecom_web.Repository.UserRepo;
import com.website.ecom_web.model.User;
import com.website.ecom_web.services.MyUserDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class MyUserDetailsServiceTest {

    @InjectMocks
    private MyUserDetailsService myUserDetailsService;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadUserByUsername(){

        when(userRepo.findByUsername(ArgumentMatchers.anyString()))
                        .thenReturn(Optional.ofNullable(User.builder()
                        .username("ram").password("dsiifsi").role(String.valueOf(new ArrayList<>())).build()));

        UserDetails user =  myUserDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);
    }
}
