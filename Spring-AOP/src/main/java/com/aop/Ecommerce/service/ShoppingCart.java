package com.aop.Ecommerce.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ShoppingCart {



    public void checkout(Integer productID,String ... username) {
        System.out.println("Business Logic add here !!");
    }

    public void throwExceptionUserInvalid(String username) throws Exception{

        if(username.length()<5){
            throw new Exception("Invalid UserName");
        }
    }


    public int checkQuantity(){

        return 10;
    }
}
