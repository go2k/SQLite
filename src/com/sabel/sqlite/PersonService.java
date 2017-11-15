package com.sabel.sqlite;

import java.sql.*;

public class PersonService {

    private static final String url = "jdbc:sqlite:d:\\Personen.sqlite";
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public PersonService() throws SQLException {
        this.connection = DriverManager.getConnection(url);
        this.statement = connection.createStatement();
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
            statement = null;
        }
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    public void save(Person person) throws SQLException {
        String sql = "insert into person VALUES (" + person.getId() + ",'" + person.getNachname() + "','" + person.getJahrgang() + "')";
        this.statement.execute(sql);
    }

    public Person readPerson(int id) throws SQLException {
        String sql = "select nachname, jahrgang from person where id = " + id;
        Person person = null;


        this.resultSet = this.statement.executeQuery(sql);
        if (resultSet.next()) {
            person = new Person(id, resultSet.getInt("jahrgang"), resultSet.getString("nachname"));
        }

        return person;
    }


}
