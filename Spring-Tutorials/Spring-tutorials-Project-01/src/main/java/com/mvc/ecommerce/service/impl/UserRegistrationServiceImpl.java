package com.mvc.ecommerce.service.impl;

import com.mvc.ecommerce.dto.CustomUser;
import com.mvc.ecommerce.dto.LoginDetailsDTO;
import com.mvc.ecommerce.repository.CustomUserRepository;
import com.mvc.ecommerce.service.UserRegistrationService;
import com.mvc.ecommerce.util.exceptions.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final PasswordEncoder passwordEncoder;

    private final CustomUserRepository userRepository;

    @Autowired
    @Lazy
    public UserRegistrationServiceImpl(PasswordEncoder passwordEncoder, CustomUserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void registerUser(LoginDetailsDTO loginDetailsDTO) throws UserExistsException {
//     if(registrationDetailRepo.existsCustomUserByUsername(loginDetailsDTO.getUserName())){
//         throw new UserExistsException(loginDetailsDTO.getUserName() + " already exists");
//     }
        String username = loginDetailsDTO.getUserName().trim();
        String password = passwordEncoder.encode(loginDetailsDTO.getPassword().trim());
        CustomUser user = new CustomUser(username, password, null);
//        jdbcUserDetailsManager.createUser(user);

        List<CustomUser> userList = userRepository.findUserByUserName(username);
        if (!userList.isEmpty()) {
            throw new UserExistsException("User already exists");
        }

        userRepository.insertUser(user);


    }


}
