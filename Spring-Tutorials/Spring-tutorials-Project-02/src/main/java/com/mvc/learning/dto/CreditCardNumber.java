package com.mvc.learning.dto;

import com.mvc.learning.utils.validators.CreditCardNumberValidator;

public class CreditCardNumber {

    @CreditCardNumberValidator(max = 4)
    private String firstFourDigits;
    @CreditCardNumberValidator(max = 4)
    private String secondFourDigits;
    @CreditCardNumberValidator(max = 4)
    private String thirdFourDigits;
    @CreditCardNumberValidator
    private String lastFourDigits;

    public CreditCardNumber(String firstFourDigits, String secondFourDigits, String thirdFourDigits, String lastFourDigits) {
        this.firstFourDigits = firstFourDigits;
        this.secondFourDigits = secondFourDigits;
        this.thirdFourDigits = thirdFourDigits;
        this.lastFourDigits = lastFourDigits;
    }

    public CreditCardNumber() {
    }

    public String getFirstFourDigits() {
        return firstFourDigits;
    }

    public void setFirstFourDigits(String firstFourDigits) {
        this.firstFourDigits = firstFourDigits;
    }

    public String getSecondFourDigits() {
        return secondFourDigits;
    }

    public void setSecondFourDigits(String secondFourDigits) {
        this.secondFourDigits = secondFourDigits;
    }

    public String getThirdFourDigits() {
        return thirdFourDigits;
    }

    public void setThirdFourDigits(String thirdFourDigits) {
        this.thirdFourDigits = thirdFourDigits;
    }

    public String getLastFourDigits() {
        return lastFourDigits;
    }

    public void setLastFourDigits(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public String toString() {
        return getFirstFourDigits() + "-" +
                getSecondFourDigits() + "-" +
                getThirdFourDigits() + "-" +
                getLastFourDigits();
    }
}
