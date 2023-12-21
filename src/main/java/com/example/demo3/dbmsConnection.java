package com.example.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbmsConnection {
    // JDBC URL, username and password of MySQL server
    String url;
    String username;
    String password;

    // JDBC variables for opening and managing connection
    Connection conn;
    Statement stmt;

    /*public dbmsConnection() {
        this.url = "jdbc:mysql://89.184.93.8:3306/javafx_aibot";
        this.username = "u_javafx_aib";
        this.password = "Ul1SwXimEQ9W";
    }*/
    public dbmsConnection() {
        this.url = "jdbc:mysql://localhost:3306/makklaysdb";
        this.username = "admin";
        this.password = "admin";
    }

    public dbmsConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // opening database connection to MySQL server
        conn = DriverManager.getConnection(url, username, password);
        //conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/makklaysdb", "admin", "admin");
        //conn = DriverManager.getConnection("jdbc:mysql://89.184.93.8:3306/javafx_aibot","u_javafx_aib","Ul1SwXimEQ9W");

        //Connection con = null;
        //Class.forName("com.mysql.cj.jdbc.Driver").instnewInstance();
        // getting Statement object to execute query
        stmt = conn.createStatement();

        System.out.println("Connection successfully");

        return conn;
    }

    public void closeConnection(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
        System.out.println("The connection is closed");
    }
}
