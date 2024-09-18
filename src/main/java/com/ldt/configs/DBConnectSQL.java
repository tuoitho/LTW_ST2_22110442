package com.ldt.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=ltwst2;trustServerCertificate=true";
    private static String USER_NAME = "sa";
    private static String PASSWORD = "123456";
    private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            new DBConnectSQL();
            System.out.println(DBConnectSQL.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
