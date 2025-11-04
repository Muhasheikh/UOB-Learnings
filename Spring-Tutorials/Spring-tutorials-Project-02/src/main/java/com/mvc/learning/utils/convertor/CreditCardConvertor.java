package com.mvc.learning.utils.convertor;

import com.mvc.learning.dto.CreditCardNumber;
import org.springframework.core.convert.converter.Converter;

public class CreditCardConvertor implements Converter<String, CreditCardNumber> {
    @Override
    public CreditCardNumber convert(String source) {
        int firstDigit = 0;
        int lastDigit = 4;
        String[] parts = source.split("-");
        StringBuffer sb = new StringBuffer();
        if (parts.length <= 1) {
            for(int i=0;i<=3;i++){
                sb.append(source.substring(firstDigit, lastDigit));
                int temp = lastDigit;
                firstDigit = lastDigit;
                lastDigit=temp+4;
                if(sb.length()<=15){
                    sb.append("-");
                }

            }
            parts = sb.toString().split("-");
        }

        CreditCardNumber creditCardNumber = new CreditCardNumber();
        creditCardNumber.setFirstFourDigits(parts[0]);
        creditCardNumber.setSecondFourDigits(parts[1]);
        creditCardNumber.setThirdFourDigits(parts[2]);
        creditCardNumber.setLastFourDigits(parts[3]);

        return creditCardNumber;
    }
}
