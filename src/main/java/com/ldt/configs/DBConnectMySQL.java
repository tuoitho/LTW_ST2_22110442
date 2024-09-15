package com.ldt.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/ltwst2";
    private static final String USERNAME = "root";
    private static final String PASSWORD ="88648468";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            new DBConnectMySQL();
            System.out.println(DBConnectMySQL.getDatabaseConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
