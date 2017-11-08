package com.sabel.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testklasse {

    public static void main(String[] args) throws SQLException {

        Person person = new Person(1981,"Meyer");
        Person person1 = new Person(1982, "Huber");

        System.out.println(person);
        System.out.println(person1);


        Connection connection = DriverManager.getConnection("jdbc:sqlite:d:\\Test.sqlite");
        Statement statement = connection.createStatement();

        statement.executeUpdate("insert into person VALUES (" + person.getId() + ",'" + person.getNachname() + "','" + person.getJahrgang() + "')");
        statement.executeUpdate("insert into person  VALUES (" + person1.getId() + ",'" + person1.getNachname() + "','" + person1.getJahrgang() + "')");


        System.out.println("Daten erfolgreich in db gespeichert");
        statement.close();
        connection.close();

    }
}
