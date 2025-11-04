package com.mvc.learning.dto;

import com.mvc.learning.utils.validators.CreditCardNumberValidator;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class PaymentDTO {

    @Valid
    private CreditCardNumber creditCardNumber;
    private Date date;
    private Currency currency;
    private BigDecimal amount;

    public CreditCardNumber getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(CreditCardNumber creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }



}
