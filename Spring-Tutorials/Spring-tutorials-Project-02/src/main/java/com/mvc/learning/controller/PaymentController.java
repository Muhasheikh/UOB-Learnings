package com.mvc.learning.controller;


import com.mvc.learning.dto.CreditCardNumber;
import com.mvc.learning.dto.PaymentDTO;
import com.mvc.learning.utils.propertyEditors.CreditCardEditor;
import com.mvc.learning.utils.propertyEditors.CustomCurrencyEditor;
import com.mvc.learning.utils.propertyEditors.CustomUpperCaseEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;

@Controller
public class PaymentController {


    @GetMapping("/payment")
    public String paymentInformation(@ModelAttribute("paymentInfo")PaymentDTO paymentInfo) {
        CreditCardNumber creditCardNumber = new CreditCardNumber("123","456","789","012");
        paymentInfo.setCreditCardNumber(creditCardNumber);
        return "payment";
    }

    @GetMapping("/process-payment")
    public String proccessPayment(@Valid @ModelAttribute("paymentInfo") PaymentDTO paymentDTO, BindingResult result){
        if(result.hasErrors()) {
            return "payment";
        }
        return "process-payment";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, "date",dateEditor);

        NumberFormat numberFormat = new DecimalFormat("##,###.00");
        CustomNumberEditor customNumberEditor = new CustomNumberEditor(BigDecimal.class,numberFormat,true);
        binder.registerCustomEditor(BigDecimal.class, "amount",customNumberEditor);

        CustomCurrencyEditor customCurrencyEditor = new CustomCurrencyEditor();
        binder.registerCustomEditor(Currency.class, "currency",customCurrencyEditor);

       // CreditCardEditor creditCardEditor = new CreditCardEditor();
       // binder.registerCustomEditor(CreditCardEditor.class, "creditCardNumber",creditCardEditor);
    }
}
