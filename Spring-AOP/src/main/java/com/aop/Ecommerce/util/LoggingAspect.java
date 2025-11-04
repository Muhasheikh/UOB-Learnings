package com.aop.Ecommerce.util;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.aop.Ecommerce.service.ShoppingCart.*(..))")
    public void cartLogger(JoinPoint joinPoint){

        List<String> username =   Arrays.stream(joinPoint.getArgs()).filter(s -> s instanceof String[])
                .flatMap(args -> Arrays.stream((String[]) args))
                .toList();

        username.forEach(System.out::println);
//        String userName = (String) joinPoint.getArgs()[1];
//       System.out.println("Shopping cart checkout in progress for user: " + userName);
    }

    @AfterThrowing(pointcut = "execution(* com.aop.Ecommerce.service.ShoppingCart.*(..))", throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println(ex.getMessage());
    }

    @Pointcut("execution(* com.aop.Ecommerce.service.ShoppingCart.checkout(..))")
    public void testCartPointCut( ){

    }

    @Before("testCartPointCut()")
    public void callPointcutLogger(JoinPoint joinPoint){
        String username = joinPoint.getArgs()[1].toString();
        if(username.contains("Love")){
            System.out.println("Inside testCartPointCut");

        }
    }

    @Pointcut("execution(int com.aop.Ecommerce.service.ShoppingCart.checkQuantity(..))")
    public void returnValuePointCut(){}

    @AfterReturning(pointcut = "returnValuePointCut()",returning = "result")
    public void logReturnQUantityValue(Integer result){
        System.out.println("Returned Value : "+ result);
    }


    @AfterReturning(pointcut = "execution(int com.aop.Ecommerce.service.ShoppingCart.checkQuantity(..))",returning = "result")
    public void logReturnQUantityValueMethod2(Integer result){
        System.out.println("Returned Value : "+ result);
    }
}
