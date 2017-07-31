package com.github.jarlehansen.person;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonItemProcessorTest {

    @Test
    public void returnTransformedNameForPersonInput() throws Exception {
        PersonItemProcessor processor = new PersonItemProcessor();
        Person returnedPerson = processor.process(new Person("Mary", "Peterson"));
        assertEquals("MARY", returnedPerson.getFirstName());
        assertEquals("PETERSON", returnedPerson.getLastName());
    }

}