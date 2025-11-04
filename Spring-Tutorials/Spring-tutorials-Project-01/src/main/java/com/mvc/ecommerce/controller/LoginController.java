package com.mvc.ecommerce.controller;

import com.mvc.ecommerce.dto.LoginDetailsDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String home(Principal principal, @ModelAttribute("user") LoginDetailsDTO user) {
        String username = principal.getName();
        System.out.println(username);
        user.setUserName(username);
        return "index";
    }

    public LoginController() {
        System.out.println("Login COntroller");
    }

    @GetMapping("/login")
    public String getLoginPage( Model model,HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("loginUserCookie")) {
               LoginDetailsDTO loginDetailsDTO = new LoginDetailsDTO();
                loginDetailsDTO.setUserName(cookie.getValue());
                model.addAttribute("loginDetails", loginDetailsDTO);
            }
        }
        return "login-page";
    }

    @PostMapping("/process-login")
    public String processLogin(@Valid @ModelAttribute("loginDetails") LoginDetailsDTO loginDetailsDTO,
                               BindingResult result,
                               HttpServletRequest request) {

        if (result.hasErrors()) {
            return "login-page";

        }
        Object principal = loginDetailsDTO.getUserName();
        Object credentials = loginDetailsDTO.getPassword();

        Authentication authentication = new UsernamePasswordAuthenticationToken(principal,credentials);
        try {
            Authentication authenticate = authenticationManager.authenticate(authentication);
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticate);
            SecurityContextHolder.setContext(securityContext);

            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
            return "redirect:/home";
        } catch (AuthenticationException e) {
            return "redirect:/login?error=true";
        }
    }



}
