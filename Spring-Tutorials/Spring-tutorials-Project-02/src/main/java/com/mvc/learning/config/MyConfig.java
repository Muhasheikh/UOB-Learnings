package com.mvc.learning.config;


import com.mvc.learning.utils.MobileNumberFormatter;
import com.mvc.learning.utils.convertor.CreditCardConvertor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.mvc.learning")
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {

    @Bean
    InternalResourceViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }


    //Registering the bean to locate the message prop file
    @Bean(name ="messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:messages-en");
        return reloadableResourceBundleMessageSource;
    }

    //Tells the Spring we are using this message prop file for validation using this bean
    @Bean(name = "validator")
    LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
          localValidatorFactoryBean.setValidationMessageSource(messageSource());
          return localValidatorFactoryBean;
    }


    @Override
    public Validator getValidator() {
        return validatorFactoryBean();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MobileNumberFormatter());
        registry.addConverter(new CreditCardConvertor());
//        registry.addFormatter(new CreditCardNumberFormatter());
    }
}
