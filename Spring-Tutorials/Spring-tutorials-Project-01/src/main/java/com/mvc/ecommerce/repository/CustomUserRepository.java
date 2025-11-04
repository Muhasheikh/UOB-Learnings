package com.mvc.ecommerce.repository;

import com.mvc.ecommerce.dto.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomUserRepository  {

    private static final   String CREATE_USER_SQL = "insert into users (username, password, enabled) values (?,?,?)";
    private static final String CREATE_AUTHORITY_SQL = "insert into authorities (username, authority) values (?,?)";
    private static final String GET_USER_SQL = "select * from users where username=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<CustomUser> findUserByUserName(String username){
        return jdbcTemplate.query(GET_USER_SQL, new BeanPropertyRowMapper<>(CustomUser.class), username);
    }

    @Transactional
    public void insertUser(CustomUser customUser){
        jdbcTemplate.update(CREATE_USER_SQL, ps -> {
            ps.setString(1, customUser.getUsername());
            ps.setString(2, customUser.getPassword());
            ps.setBoolean(3, true);

        });

        insertAuthorities(customUser);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void insertAuthorities(CustomUser customUser){
        jdbcTemplate.update(CREATE_AUTHORITY_SQL, ps -> {
            ps.setString(1, customUser.getUsername());
            for(GrantedAuthority authority : customUser.getAuthorities()){
                ps.setString(2, authority.getAuthority());
            }
        });
    }
}
