package com.mvc.learning.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class CommunicationDTO {
    @NotBlank(message = "Email cannot be Blank")
    private String email;

    @Valid
    private MobileNumberDTO mobileNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MobileNumberDTO getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(MobileNumberDTO mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
