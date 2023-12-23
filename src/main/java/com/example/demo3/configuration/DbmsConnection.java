package com.example.demo3.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DbmsConnection {
    private static final Logger log = LoggerFactory.getLogger(DbmsConnection.class);

    // JDBC URL, username and password of MySQL server
    private final String url;
    private final String username;
    private final String password;

    private static DbmsConnection INSTANCE;

    private DbmsConnection() {
        this.url = "jdbc:mysql://localhost:3306/javafx_aibot"; // "jdbc:mysql://89.184.93.8:3306/javafx_aibot";
        this.username = "admin"; //"u_javafx_aib";
        this.password = "admin"; //"Ul1SwXimEQ9W";
        //Parametrize logging example
        log.info("Initial info class: {} connect to DB: {}", DbmsConnection.class.getName(), url);
    }


    private DbmsConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

        log.info("Initial info class");
    }

    public static DbmsConnection getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DbmsConnection();
        }

        return INSTANCE;
    }

    public Connection getConnection() {
        // opening database connection to MySQL server
        // JDBC variables for opening and managing connection

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.url, this.username, this.password);
            conn.createStatement();


        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        //Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/makklaysdb", "admin", "admin");
        //conn = DriverManager.getConnection("jdbc:mysql://89.184.93.8:3306/javafx_aibot","u_javafx_aib","Ul1SwXimEQ9W");

        return conn;
    }

    public void closeConnection(Connection conn, Statement stmt) throws SQLException {
        stmt.close();
        conn.close();
        System.out.println("The connection is closed");
    }
}
