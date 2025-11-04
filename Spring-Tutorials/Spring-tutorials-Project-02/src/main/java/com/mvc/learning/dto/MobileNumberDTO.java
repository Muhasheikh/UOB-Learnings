package com.mvc.learning.dto;

import com.mvc.learning.utils.validators.MobileNumberValidator;

public class MobileNumberDTO {

    public MobileNumberDTO(String countryCode, String number) {
        this.countryCode = countryCode;
        this.number = number;
    }

    public MobileNumberDTO() {
    }

    private String countryCode;
    @MobileNumberValidator(max = 12)
    private String number;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return getCountryCode() + "-" + getNumber();
    }
}
