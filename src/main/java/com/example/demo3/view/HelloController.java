package com.example.demo3.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException, SQLException {

        try {
            /*try {
				Class.forName("org.mariadb.jdbc.Driver");
			} catch (Exception e) {
	            System.out.println(e);
	        }*/

            // opening database connection to MySQL server
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb", "admin", "admin");

            // getting Statement object to execute query
            Statement stmt = con.createStatement();

            // executing SELECT query
            String query = "select count(*) from cities";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of cities in the table : " + count);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        welcomeText.setText("Welcome to JavaFX Application!");
    }
}