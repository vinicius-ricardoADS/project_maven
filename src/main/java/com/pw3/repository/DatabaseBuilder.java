package com.pw3.repository;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBuilder {
    public static void main(String[] args) {
        Database.getConnection();
        buildDatabaseIfMissing();
    }

    public static void buildDatabaseIfMissing() {
        System.out.println("Database is missing. Building database: \n");
        buildTables();
    }

    private static void buildTables() {
        try (Statement statement = Database.getStatement()) {
            statement.addBatch(criarTabelaPessoa());
            statement.executeBatch();
            System.out.println("Database successfully created.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String criarTabelaPessoa() {
        StringBuilder builder = new StringBuilder();

        builder.append("CREATE TABLE Pessoa (\n");
        builder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, \n");
        builder.append("username TEXT NOT NULL, \n");
        builder.append("name TEXT, \n");
        builder.append("hashPassword TEXT NOT NULL \n");
        builder.append("); \n");

        System.out.println(builder);
        return builder.toString();
    }
}
