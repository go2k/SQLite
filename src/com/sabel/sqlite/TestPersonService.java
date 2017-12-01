package com.sabel.sqlite;

import java.sql.SQLException;

public class TestPersonService {

    public static void main(String[] args) {

        Person person = new Person(1974, "König");
        PersonService personService = null;
        try {

            personService = new PersonService();
            //personService.save(person);


            Person person1 = personService.readPerson(1);
            if (person != null) {
                System.out.println(person1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                personService.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
