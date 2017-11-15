package com.sabel.sqlite;

import java.sql.*;

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


        connection = DriverManager.getConnection("jdbc:sqlite:d:\\Test.sqlite");
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select id, nachname, jahrgang from person");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nachname = resultSet.getString("nachname");
            int jahrgang = resultSet.getInt("jahrgang");
            System.out.println("Person: " + id  + ", Nachname: " + nachname + ", Jahrgang: " + jahrgang );
        }
        resultSet.close();
        statement.close();
        connection.close();




    }
}
