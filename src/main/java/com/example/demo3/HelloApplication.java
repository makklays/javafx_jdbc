package com.example.demo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.InputStream;
import java.sql.*;
import java.util.Date;

public class HelloApplication extends Application {

    static GridPane root;

    @Override
    public void init() {
        try {
            //dbaccess = new TodoDataAccess();

            // opening database connection to MySQL server
		    /*Connection con = DriverManager.getConnection("jdbc:
*-		    ariadb://localhost:3306/makklaysdb","admin","admin");

            // getting Statement object to execute query
		    Statement stmt = con.createStatement();

            // executing SELECT query
		    String query = "select count(*) from cities";
		    ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of cities in the table : " + count);
            }*/
        }
        catch (Exception e) {
            //displayException(e);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {

        //root = new BorderPane();
        //root = new AnchorPane();
        //root = new StackPane();
        //root = new FlowPane();
        /*root = new GridPane();
        //root = new VBox();

        //Group group = new Group();
        Scene scene = new Scene(root, 800, 500);

        //scene.getStylesheets().add(getClass().getResource("/com.example.demo3/mystyle.css").toExternalForm());

        stage.setTitle("Department of Cyberpolice");
        stage.setScene(scene);
        stage.show(); */

        //load(stage);

        //RegistrationForm regForm = new RegistrationForm();
        //regForm.showForm(stage);

        //
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("AI BOT for SEO");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        //-------------
        //Connection connection;
        /*try {
            // opening database connection to MySQL server
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/makklaysdb","admin","admin");

            // getting Statement object to execute query
            Statement stmt = con.createStatement();

            // executing SELECT query
            String query = "select count(*) from cities";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total --------> number of cities in the table : " + count);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }*/
        //----------------

        launch();
    }

    public void load(Stage primaryStage) throws FileNotFoundException {
        Label login = new Label("Login");
        Label password = new Label("Password");
        TextField tf1 = new TextField();
        PasswordField tf2 = new PasswordField();
        tf2.setId("password_tf");
        Button btn = new Button("Enter");

        login.setId("label_id");
        tf1.setAlignment(Pos.CENTER);
        password.setId("password_id");
        tf2.setAlignment(Pos.CENTER);

        InputStream iconStream = getClass().getResourceAsStream("/images/Cyberpolice.png"); // Cyberpolice.png
        //FileInputStream input = new FileInputStream("src/images/Cyberpolice.png"); // buks.png
        Image image = new Image(iconStream);
        ImageView img = new ImageView(image);

        img.setFitWidth(200);
        img.setFitHeight(200);

        //root.addRow(0, img);
        //root.setVgap(20);
        //root.setHgap(20);
        //root.addRow(1, login, tf1);
        //root.addRow(2, password, tf2);

        GridPane root = new GridPane();
        root.add(img, 0, 1);
        root.add(login, 0, 2);
        root.add(tf1, 0, 3);
        root.add(password, 0, 4);
        root.add(tf2, 0, 5);

        btn.setMinWidth(200);
        btn.setMinHeight(20);
        //btn.setStyle("-fx-background-color:blue");
        //root.addRow(3, btn);

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        //hbox1.getChildren().add(img);
        hbox1.getChildren().add(root);
        //hbox1.getChildren().add(btn);

        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().add(img);
        vbox1.getChildren().add(hbox1);
        //vbox1.getChildren().add(btn);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(btn);
        StackPane.setMargin(btn, new Insets(10,0,10,0));

        vbox1.getChildren().add(stackPane);

        //root.getChildren().addAll(img, login, tf1, password, tf2, btn);

        Scene scene = new Scene(vbox1, 800, 500);

        //scene.getStylesheets().add(getClass().getResource("com.example.demo3/mystyle.css").toExternalForm());

        primaryStage.setTitle("Department of Cyberpolice");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction(e -> {
            System.out.println("Login: \"" + tf1.getText() + "\" Password: \"" + tf2.getText() + "\"");
            tf1.setText("");
            tf2.setText("");
        });

        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
				/*TextField tf1_in = tf1.getText();
				if (tf1_in == "makklays") {
					System.out.println("Login: makklays");
				}*/
                System.out.println("Pressed!");
            }
        });
    }
}

