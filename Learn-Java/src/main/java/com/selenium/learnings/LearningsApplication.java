package com.selenium.learnings;

import com.selenium.learnings.Dto.PersonDTO;
import com.selenium.learnings.config.AppConfig;
import com.selenium.learnings.iocDI.Computer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LearningsApplication {

	public static void main(String[] args) {

//	SpringApplication.run(LearningsApplication.class, args);

	SpringApplication app = new SpringApplication(LearningsApplication.class);
		ApplicationContext context = app.run();
		Computer computer = context.getBean("computer", Computer.class);
		computer.start();


//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		PersonDTO personDTO = context.getBean("personDTO", PersonDTO.class);
//personDTO.print();
	}

}
