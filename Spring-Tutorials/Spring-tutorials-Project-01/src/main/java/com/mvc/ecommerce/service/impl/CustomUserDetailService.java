package com.mvc.ecommerce.service.impl;

import com.mvc.ecommerce.dto.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            String sql = "select * from users where username = ?";
            List<CustomUser> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(CustomUser.class),username);
            if(userList.isEmpty()){
                throw new UsernameNotFoundException("User not found");
            }

            return userList.get(0);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }
}
