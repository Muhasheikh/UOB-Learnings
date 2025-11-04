package com.mvc.learning.controller;

import com.mvc.learning.dto.UserDetailDTO;
import com.mvc.learning.utils.error.UserDetailsNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userDetailDTO")
public class SessionController {


    @GetMapping("/user-info")
    public String setUserDetailsPage(Model model){

        UserDetailDTO detailDTO = new UserDetailDTO();
        UserDetailDTO userDetailDTO = (UserDetailDTO) model.getAttribute("userDetailDTO");
        if(userDetailDTO!=null){
//            model.addAttribute("userDetailDTO",userDetailDTO);
            throw new UserDetailsNotFoundException("User Details not found");
        }else {
            model.addAttribute("userDetailDTO",detailDTO);
        }
        return "user-info";
    }


    @GetMapping("/show-user-details")
    public String getUserDetailsPage(@ModelAttribute("userDetailDTO") UserDetailDTO detailDTO){
        return "user-info-show";
    }



}
