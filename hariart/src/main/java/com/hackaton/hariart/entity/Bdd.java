package com.hackaton.hariart.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {

    public static Connection getPostgreSQL() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String configuration = String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s", "localhost", "3306", "hackathon", "postrges", "postrges");
        Connection connection = DriverManager.getConnection(configuration);
        connection.setAutoCommit(false);
        return connection;
    }
    
}