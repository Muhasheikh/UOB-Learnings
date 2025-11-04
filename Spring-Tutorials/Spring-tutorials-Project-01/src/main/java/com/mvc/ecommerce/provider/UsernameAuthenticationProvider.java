package com.mvc.ecommerce.provider;

import com.mvc.ecommerce.dto.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsernameAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String FIND_USERBY_USERNAME_SQL = "SELECT * FROM USERS WHERE USERNAME = ?";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<CustomUser> user = jdbcTemplate.query(FIND_USERBY_USERNAME_SQL,new BeanPropertyRowMapper<>(CustomUser.class),username);
        List<GrantedAuthority> authorities = new ArrayList<>(user.get(0).getAuthorities());

        if(user.isEmpty()){
            throw new BadCredentialsException("Invalid username or password");
        }

        boolean isValidPassword = passwordEncoder.matches(password, user.get(0).getPassword());

        if(!isValidPassword){
            throw new BadCredentialsException("Invalid username or password");
        }

        return new UsernamePasswordAuthenticationToken(user.get(0).getUsername(), user.get(0).getPassword(),authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
