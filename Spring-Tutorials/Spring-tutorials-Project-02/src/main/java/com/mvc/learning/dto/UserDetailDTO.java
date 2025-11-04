package com.mvc.learning.dto;

import com.mvc.learning.utils.validators.AgeValidator;
import com.mvc.learning.utils.validators.CoutrySelectValidator;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDetailDTO {

    @NotBlank(message = "UserName cannot be blank")
    @Size(min = 2, max = 10, message = "Username has to be between 2 and 15")
    private String firstName;
    private String lastName;
    private String password;
    @CoutrySelectValidator()
    private String country;
    private List<String> hobby;
    @AssertTrue(message = "Accept the terms and Conditions")
    private boolean isAgree;

    @AgeValidator(upper = 50, lower = 18, message = "{invalid.message}")
    private Integer age;

    @Valid
    private CommunicationDTO communication;

    public UserDetailDTO(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }

    public UserDetailDTO() {};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public CommunicationDTO getCommunication() {
        return communication;
    }

    public void setCommunication(CommunicationDTO communication) {
        this.communication = communication;
    }

    public boolean getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(boolean agree) {
        isAgree = agree;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
