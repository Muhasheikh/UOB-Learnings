package com.mvc.learning.utils.propertyEditors;
import com.mvc.learning.dto.CreditCardNumber;


import java.beans.PropertyEditorSupport;

public class CreditCardEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        CreditCardNumber creditCardNumber = (CreditCardNumber) getValue();
        return "Sample " + creditCardNumber;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] parts = text.split("-");
        CreditCardNumber creditCardNumber = new CreditCardNumber();
        creditCardNumber.setFirstFourDigits(parts[0]);
        creditCardNumber.setSecondFourDigits(parts[1]);
        creditCardNumber.setThirdFourDigits(parts[2]);
        creditCardNumber.setLastFourDigits(parts[3]);

        setValue(creditCardNumber);
    }
}
