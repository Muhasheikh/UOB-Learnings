package com.mvc.learning.utils;

import com.mvc.learning.dto.MobileNumberDTO;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class MobileNumberFormatter implements Formatter<MobileNumberDTO> {
    @Override
    public MobileNumberDTO parse(String mobileNumber, Locale locale) throws ParseException {
        String[] completeNumber = mobileNumber.split("-");
        int index = mobileNumber.indexOf("-");
        if(index==-1){
            return new MobileNumberDTO("94",completeNumber[0]);

        }
        return new MobileNumberDTO(completeNumber[0],completeNumber[1]);
    }

    @Override
    public String print(MobileNumberDTO mobileNumberDTO, Locale locale) {
        return mobileNumberDTO.getCountryCode() + "-" + mobileNumberDTO.getNumber();
    }
}
