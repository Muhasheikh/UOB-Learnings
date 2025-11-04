package com.mvc.ecommerce.dto;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CustomUser implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;
    private boolean isEnabled = true;

    public CustomUser(String username, String password, List<GrantedAuthority> authorities, boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isEnabled = isEnabled;
    }

    public CustomUser() {
    }

    public CustomUser(String username, String password, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities == null){
            authorities = new ArrayList<>();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {

        this.authorities = authorities;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
