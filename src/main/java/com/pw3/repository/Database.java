package com.pw3.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static Connection connection;
    private static PreparedStatement statement;

    public static Connection getConnection() {
        try {
            if (Database.connection == null)
                Database.connection = DriverManager.getConnection("jdbc:sqlite:persistence.db");

            Database.connection.createStatement();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Database.connection;
    }

    public static PreparedStatement createPreparedStatement(String sql) {
        try {
            statement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static Statement getStatement() {
        Statement statement = null;
        try {
            statement = Database.connection.createStatement();
        } catch (NullPointerException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return statement;
    }
}
