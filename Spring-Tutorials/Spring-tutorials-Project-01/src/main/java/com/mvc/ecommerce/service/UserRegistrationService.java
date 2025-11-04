package com.mvc.ecommerce.service;

import com.mvc.ecommerce.dto.LoginDetailsDTO;
import com.mvc.ecommerce.util.exceptions.UserExistsException;

public interface UserRegistrationService {

     void registerUser(LoginDetailsDTO loginDetailsDTO) throws UserExistsException;
}
