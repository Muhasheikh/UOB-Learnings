package com.mvc.learning.controller;


import com.mvc.learning.dto.CommunicationDTO;
import com.mvc.learning.dto.MobileNumberDTO;
import com.mvc.learning.dto.UserDetailDTO;
import com.mvc.learning.utils.propertyEditors.CustomUpperCaseEditor;
import com.mvc.learning.utils.validators.UserDetailsValidator;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import javax.validation.Valid;
import java.beans.PropertyEditor;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Controller
@SessionAttributes("userDetailDTO")
public class HelloWorldController {

    public HelloWorldController() {
        System.out.println("HelloWorldController");
    }


    @RequestMapping(method = RequestMethod.GET,value = "/hello-world")
    public String helloWorld(Model model) {

        UserDetailDTO userDetailDTO = new UserDetailDTO();
        MobileNumberDTO mobileNumberDTO = new MobileNumberDTO("94","762630824");
        CommunicationDTO communicationDTO = new CommunicationDTO();
        communicationDTO.setMobileNumber(mobileNumberDTO);
        userDetailDTO.setCommunication(communicationDTO);

        UserDetailDTO userDetailDTO1 = (UserDetailDTO) model.getAttribute("userDetailDTO");
        if(userDetailDTO1!=null){
            model.addAttribute("userDetailDTO", userDetailDTO1);
        }else{
            model.addAttribute("userDetailDTO", userDetailDTO);

        }

        //getting the value from the session
//        UserDetailDTO userDetail = (UserDetailDTO) request.getSession().getAttribute("username");
//        userDetailDTO.setFirstName(userDetail.getFirstName());



        return "hello";
    }

    @GetMapping("/process")
    public String process(@Valid @ModelAttribute("userDetailDTO") UserDetailDTO userDetailDTO, BindingResult result, HttpServletRequest request) {

//        Creating the session
//        HttpSession session = request.getSession();
//        session.setAttribute("username", userDetailDTO);
//        session.setMaxInactiveInterval(654);

        if(result.hasErrors()){
           System.out.println("Errors found");
           return "hello";
           }
        return "process";
    }


    @ModelAttribute("countryList")
    public Map<String, String> getCountryList() {
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("CH", "China");
        countryList.put("SG", "Singapore");
        countryList.put("MY", "Malaysia");
        return countryList;
    }

    @ModelAttribute("hobbies")
    public List<String> getHobbiesList() {
        List<String> hobbyList = new ArrayList<String>();
        hobbyList.add("Sports");
        hobbyList.add("Reading");
        hobbyList.add("Travelling");
        return hobbyList;
    }

    // will be called first whenever the class is loaded
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        // Do not bind the field value to the DTO
//        String[] disallowedFields = {"firstName"};
//        dataBinder.setDisallowedFields(disallowedFields);

        PropertyEditor editor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, "firstName",editor);

        CustomUpperCaseEditor customUpperCaseEditor = new CustomUpperCaseEditor();
        dataBinder.registerCustomEditor(String.class,"firstName", customUpperCaseEditor);

        dataBinder.addValidators(new UserDetailsValidator());

    }

}
