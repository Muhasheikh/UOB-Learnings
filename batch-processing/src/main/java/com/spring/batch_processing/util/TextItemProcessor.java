package com.spring.batch_processing.util;

import com.spring.batch_processing.model.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class TextItemProcessor implements ItemProcessor<Person,Person> {
    @Override
    public Person process(Person person) throws Exception {
//        person.setFirstName(person.getFirstName().toUpperCase());
//        person.setLastName(person.getLastName().toUpperCase());
        return person;
    }
}
