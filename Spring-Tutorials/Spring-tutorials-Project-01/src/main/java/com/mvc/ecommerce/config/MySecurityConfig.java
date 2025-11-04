package com.mvc.ecommerce.config;

import com.mvc.ecommerce.provider.UsernameAuthenticationProvider;
import com.mvc.ecommerce.service.impl.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity(debug = true)
public class MySecurityConfig{

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
            return httpSecurity.authorizeHttpRequests(auth -> auth
                            .requestMatchers("/WEB-INF/views/**","/resources/**").permitAll()
                            .requestMatchers("/register","/login","/process-register","/process-login").permitAll()
                            .anyRequest().authenticated())
                    .formLogin(customizer -> {
                        customizer.loginPage("/login");
                        customizer.defaultSuccessUrl("/home", true);  // redirect after success
                    })
                    .csrf(AbstractHttpConfigurer::disable)
                    .httpBasic(Customizer.withDefaults())
                    .build();
        }

//    @Bean
//    public JdbcUserDetailsManager userDetailsManager() {
////        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");
////        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
////        grantedAuthorities.add(admin);
////        UserDetails user = new CustomUser("test","$2a$12$98KluwnLEv6iiuMlI6OsTeQi36/RX07JlAiXaBkZyv792xJHn93Hq",grantedAuthorities,true);
//        return new JdbcUserDetailsManager(dataSource());
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DataSource dataSource(){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setPassword("password");
            dataSource.setUrl("jdbc:mysql://localhost:3306/ecommerce");
            dataSource.setUsername("user");

            return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(customUserDetailService);
//            authProvider.setPasswordEncoder(passwordEncoder());
//            return authProvider;
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        return new UsernameAuthenticationProvider();
    }

    @Bean
    public AuthenticationManager authenticationManager(){
        List<AuthenticationProvider> providers = new ArrayList<AuthenticationProvider>();
        providers.add(authenticationProvider());
        return new ProviderManager(providers);

    }

    @Bean
    public TransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
