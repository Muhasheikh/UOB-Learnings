package com.mvc.ecommerce.controller;

import com.mvc.ecommerce.dto.LoginDetailsDTO;
import com.mvc.ecommerce.service.UserRegistrationService;
import com.mvc.ecommerce.util.exceptions.UserExistsException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {

    private final UserRegistrationService userRegistrationService;

    public RegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }


    @GetMapping("/register")
    public String register(@ModelAttribute("registerDTO") LoginDetailsDTO loginDetailsDTO){

        return "register";
    }


    @PostMapping("/process-register")
    public String processRegister(@Valid @ModelAttribute("registerDTO") LoginDetailsDTO loginDetailsDTO, BindingResult result,
                                  HttpServletResponse response, Model model) throws UserExistsException {
        if(result.hasErrors()){
            return "register";
        }

            try {
                userRegistrationService.registerUser(loginDetailsDTO);
            }
           catch (UserExistsException e) {
                model.addAttribute("errorMessage", e.getMessage()); // pass message
                return "register";
           }
        Cookie cookie =new Cookie("loginUserCookie",loginDetailsDTO.getUserName());
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);

        return "redirect:/login";
    }



}
