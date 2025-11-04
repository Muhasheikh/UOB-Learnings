package com.aop.Ecommerce;

import com.aop.Ecommerce.config.BeanConfig;
import com.aop.Ecommerce.service.ShoppingCart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.naming.Context;

@SpringBootApplication
@EnableAspectJAutoProxy
public class EcommerceApplication {

	public static void main(String[] args) throws Exception {

//		SpringApplication.run(EcommerceApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		ShoppingCart cart = context.getBean(ShoppingCart.class);
		cart.checkout(1,"Muhassan");
		cart.checkQuantity();
//		cart.throwExceptionUserInvalid("Muha");

    }

}
