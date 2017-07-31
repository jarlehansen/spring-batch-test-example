package com.github.jarlehansen.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception {
        String firstName = person.getFirstName().toUpperCase();
        String lastName = person.getLastName().toUpperCase();

        log.info("Converting (firstName: {}, lastName: {}) into (firstName: {}, lastName: {})",
                person.getFirstName(), person.getLastName(), firstName, lastName);
        return new Person(firstName, lastName);
    }
}
