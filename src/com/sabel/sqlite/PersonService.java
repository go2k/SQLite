package com.sabel.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonService {

    private static final String url="jdbc:sqlite:d:\\Test.sqlite";
    private Connection connection;
    private Statement statement;

    public PersonService() throws SQLException{
        this.connection = DriverManager.getConnection(url);
        this.statement = connection.createStatement();
    }

    public void save(Person person) throws SQLException {
        String sql = "insert into person VALUES (" + person.getId() + ",'" + person.getNachname() + "','" + person.getJahrgang() + "')";
        this.statement.executeQuery(sql);
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

}
