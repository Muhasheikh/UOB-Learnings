package com.mvc.learning.utils;

import com.mvc.learning.dto.CreditCardNumber;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CreditCardNumberFormatter implements Formatter<CreditCardNumber> {
    @Override
    public CreditCardNumber parse(String text, Locale locale) throws ParseException {
        CreditCardNumber creditCardNumber = new CreditCardNumber();
        if(text.length()==12){
            List<String> creditNumberList = new ArrayList<>();
            int firstDigit = 0;
            int lastDigit = 3;
            while(creditNumberList.size()<=3){
                creditNumberList.add(text.substring(firstDigit,lastDigit));
                int temp = lastDigit;
                firstDigit = lastDigit;
                lastDigit = temp + 3;

            }


            creditCardNumber.setFirstFourDigits(creditNumberList.get(0));
            creditCardNumber.setSecondFourDigits(creditNumberList.get(1));
            creditCardNumber.setThirdFourDigits(creditNumberList.get(2));
            creditCardNumber.setLastFourDigits(creditNumberList.get(3));

            return creditCardNumber;
        }
    return creditCardNumber;

    }

    @Override
    public String print(CreditCardNumber creditCardNumber, Locale locale) {
        return creditCardNumber.getFirstFourDigits() + '-'
                + creditCardNumber.getSecondFourDigits() + '-'
                + creditCardNumber.getThirdFourDigits() + '-'
                + creditCardNumber.getLastFourDigits();
    }
}
