package com.mvc.ecommerce.util;


import com.mvc.ecommerce.dto.CustomUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Objects;

@Aspect
@Component
public class LoggingAspects {

    @Pointcut("within(com.mvc.ecommerce.service.impl.*)")
    public void registrationPointcut() {
    }

    @Pointcut("execution(* com.mvc.ecommerce.repository.CustomUserRepository.*(..)) && " +
            "!execution(* com.mvc.ecommerce.repository.CustomUserRepository.findUserByUserName(..))")
    public void insertToDatabasePointcut() {

    }
    @Pointcut("execution(* com.mvc.ecommerce.repository.CustomUserRepository.findUserByUserName(..))")
    public void fetchUserFromDatabasePointcut() {

    }

    @Around("fetchUserFromDatabasePointcut()")
    public List<CustomUser> findUserByUserNameLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Entering findUserByUserNameLogger ");
        String username = joinPoint.getArgs()[0].toString();
        List<CustomUser> result = (List<CustomUser>) joinPoint.proceed();
        if(Objects.nonNull(result)) {
            System.out.println("Exiting findUserByUserNameLogger " + username);
        }else {
            System.out.println("Exiting findUserByUserNameLogger");
        }



        return result;
    }


    @Around("insertToDatabasePointcut()")
    public Object  around(ProceedingJoinPoint joinPoint) throws Throwable {

        Arrays.stream(joinPoint.getArgs()).filter(arg -> arg instanceof CustomUser)
                .forEach(arg -> {
                    CustomUser customUser = (CustomUser) arg;
                    System.out.println("Inserting " + customUser + " database");
                });

        Object result = joinPoint.proceed();

        System.out.println("Inserted " + joinPoint.getArgs()[0].toString() + " database");

        return result;
    }

    @Around("registrationPointcut()")
    public void logBeforeRegistration(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Logging Before Registration: " + proceedingJoinPoint.getSignature().getName());

        proceedingJoinPoint.proceed();
        System.out.println("Logging After Registration: " + proceedingJoinPoint.getSignature().getName());
    }
}
