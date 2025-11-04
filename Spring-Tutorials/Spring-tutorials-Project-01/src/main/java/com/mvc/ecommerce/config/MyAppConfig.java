package com.mvc.ecommerce.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Configuration
@ComponentScan(basePackages = "com.mvc.ecommerce")
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class MyAppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){

        return new InternalResourceViewResolver("/WEB-INF/views/",".jsp") ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                    .addResourceLocations("/resources/");    }

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource rbms
        = new ReloadableResourceBundleMessageSource();
        rbms.setBasename("classpath:messages-en");
        return rbms;
    }

    @Bean
    public Validator validator(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());
        return localValidatorFactoryBean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }


    public static void main(String[] args) {
       List<Student> studentList =  List.of(new Student("Muhassan",List.of(9476),List.of("Auha","Faizal"),55),
               new Student("A ashid",List.of(947747),List.of("PooNana","Nana"),55));

//        List<Integer> numbers = studentList.stream().
//                flatMap(number -> number.getMobileNumbers().stream())
//                .toList();

        List<Integer> collect = studentList.stream().flatMap(student  ->
                        student.getNickNames().stream().map(String::length)
                )
            .toList();


        List<List<Integer>> list = studentList.stream().map(student -> {
            return student.getNickNames().stream().map(String::length).toList();
        }).toList();
        List<Integer> nickNameLength = new ArrayList<>();
        for (List<Integer> integers : list) {
            nickNameLength.addAll(integers);
        }

        List<List<String>> list1 = studentList.stream().map(student -> {
            return student.getNickNames().stream().map(String::toUpperCase).toList();
        }).toList();


        studentList.stream().sorted(new StudentMarksComparator()).forEach(student -> {
            System.out.println(student.studentName + " " + student.marks );
        });

        //System.out.println(list1);
    }

}

class Student{

    String studentName;
    List<Integer> mobileNumbers;
    List<String> nickNames;
    Integer marks;

    public Student(String studentName, List<Integer> mobileNumbers) {
        this.studentName = studentName;
        this.mobileNumbers = mobileNumbers;
    }

    public Student(String studentName, List<Integer> mobileNumbers, List<String> nickNames) {
        this.studentName = studentName;
        this.mobileNumbers = mobileNumbers;
        this.nickNames = nickNames;
    }

    public Student(String studentName, List<Integer> mobileNumbers, List<String> nickNames, Integer marks) {
        this.studentName = studentName;
        this.mobileNumbers = mobileNumbers;
        this.nickNames = nickNames;
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Integer> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<Integer> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public List<String> getNickNames() {
        return nickNames;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", mobileNumbers=" + mobileNumbers +
                '}';
    }

}

class StudentMarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {

        if(!Objects.equals(o1.marks, o2.marks)){
            return Integer.compare(o1.marks, o2.marks);
        }else {
            return o1.studentName.compareTo(o2.studentName);
        }

    }
}
