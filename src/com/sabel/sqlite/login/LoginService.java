package com.sabel.sqlite.login;

import javax.swing.*;
import java.sql.*;

public class LoginService {

    private static final String URL = "jdbc:sqlite:d:\\Personen.sqlite";
    private Connection connection;
    private Statement statement;


    public LoginService() throws SQLException {
        this.connection = DriverManager.getConnection(URL);
        this.statement = connection.createStatement();
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public boolean Login(Login login) throws SQLException {
        String injection = " ' or '1' = '1";

        String sql = "select count(*) as anzahl from login where loginname = '" + login.getLoginname() + "' and passwort = '" + login.getPasswort() + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        int anzahl = resultSet.getInt("anzahl");
        if (anzahl > 0) {
            return true;
        }
        return false;
    }

    public boolean einloggen(Login login) throws SQLException {
        String sql = "select * from login where loginname = ? and passwort = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, login.getLoginname());
        preparedStatement.setString(2, login.getPasswort());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public static void main(String[] args) throws SQLException {

        LoginService loginService = new LoginService();
        String loginname = JOptionPane.showInputDialog(null, "Bitte Loginname eingeben: ");
        String passwort = JOptionPane.showInputDialog(null, "Bitte geben Sie ihr Passwort ein: ");

        Login login = new Login(loginname, passwort);

        if (loginService.Login(login)) {
            System.out.println("Login erfolgreich");
        } else {
            System.out.println("Login fehlgeschlagen");
        }

        if (loginService.einloggen(login)) {
            System.out.println("einloggen erfolgreich");
        } else {
            System.out.println("einloggen fehlgeschlagen");
        }
    }

}
