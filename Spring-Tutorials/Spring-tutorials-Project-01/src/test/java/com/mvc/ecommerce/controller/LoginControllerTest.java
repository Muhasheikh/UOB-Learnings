package com.mvc.ecommerce.controller;

import com.mvc.ecommerce.dto.CustomUser;
import com.mvc.ecommerce.provider.UsernameAuthenticationProvider;
import jakarta.validation.constraints.AssertTrue;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();




    @InjectMocks
    private UsernameAuthenticationProvider provider;

    private CustomUser user;


    @Test
    void processLogin() {
        String rawpassword = "test123";
        //before
        List<CustomUser> customUsers = List.of(user);

        //when
        when(jdbcTemplate.query(
                eq("SELECT * FROM USERS WHERE USERNAME = ?"),
                any(BeanPropertyRowMapper.class),
                eq(user.getUsername()))
        ).thenReturn(customUsers);

//          when(passwordEncoder.matches(rawpassword, user.getPassword())).thenReturn(true);
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),rawpassword,user.getAuthorities());
        Authentication result = provider.authenticate(authentication);
        //then
        Assertions.assertTrue(authentication.isAuthenticated());
        Assertions.assertEquals(result.getPrincipal(),user.getUsername());
       // Assertions.assertEquals(result.getCredentials(),user.getPassword());
    }

    @BeforeEach
    public void init(){

        provider = new UsernameAuthenticationProvider();
        provider.setJdbcTemplate(jdbcTemplate);
        provider.setPasswordEncoder(passwordEncoder);
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("ROLE_USER");
        List<GrantedAuthority> authorities = List.of(role);
        user = new CustomUser("Muhassan","$2a$12$PfOa8Qz2Nuau6DnfNYVDlOCaulikeVL5YBHz26ffBHDrIFQEMNFZq",authorities);
    }
}