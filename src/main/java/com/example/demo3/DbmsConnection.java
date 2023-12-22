package com.example.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbmsConnection {
    // JDBC URL, username and password of MySQL server
    private final String url;
    private final String username;
    private final String password;

    private static DbmsConnection INSTANCE;

    private DbmsConnection() {
        this.url = "jdbc:mysql://89.184.93.8:3306/javafx_aibot";
        this.username = "u_javafx_aib";
        this.password = "Ul1SwXimEQ9W";

        String info = "Initial info class";
        System.out.println(info);
    }


    private DbmsConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

        String info = "Initial info class";
        System.out.println(info);
    }

    public static DbmsConnection getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DbmsConnection();
        }

        return INSTANCE;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // opening database connection to MySQL server
        // JDBC variables for opening and managing connection
        Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
        //conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/makklaysdb", "admin", "admin");
        //conn = DriverManager.getConnection("jdbc:mysql://89.184.93.8:3306/javafx_aibot","u_javafx_aib","Ul1SwXimEQ9W");

        //Connection con = null;
        //Class.forName("com.mysql.cj.jdbc.Driver").instnewInstance();
        // getting Statement object to execute query
        Statement stmt = conn.createStatement();

        System.out.println("Connection successfully");

        return conn;
    }

    public void closeConnection(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
        System.out.println("The connection is closed");
    }
}
