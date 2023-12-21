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
		    /*Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/makklaysdb","admin","admin");

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

        InputStream iconStream = getClass().getResourceAsStream("/images/Cyberpolice.png");
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

class RegistrationForm
{
    Label firstNamelbl;
    TextField firstNametxt;
    Label lastNamelbl;
    TextField lastNametxt;

    Label passwordlbl;
    PasswordField passwordtxt;

    Label genderlbl;
    RadioButton opt1;
    RadioButton opt2;

    Label jpostlbl;
    CheckBox chk1;
    CheckBox chk2;
    CheckBox chk3;

    Label phonelbl;
    TextField phonetxt;
    Label emaillbl;
    TextField emailtxt;

    Label citylbl;
    ComboBox<String> city;

    Button submit;
    Label errorlbl;

    public void showForm(Stage primaryStage) {
        //
        firstNamelbl = new Label("First name");
        firstNametxt = new TextField();
        lastNamelbl = new Label("Last name");
        lastNametxt = new TextField();

        passwordlbl = new Label("Password");
        passwordtxt = new PasswordField();

        genderlbl = new Label("Select your gender");
        ToggleGroup group = new ToggleGroup();
        opt1 = new RadioButton("Male");
        opt2 = new RadioButton("Female");
        opt1.setToggleGroup(group);
        opt2.setToggleGroup(group);

        jpostlbl = new Label("Select your post");
        chk1 = new CheckBox("Polisman");
        chk2 = new CheckBox("System administrator");
        chk3 = new CheckBox("Analitic");

        phonelbl = new Label("Phone");
        phonetxt = new TextField();
        emaillbl = new Label("E-mail");
        emailtxt = new TextField();

        citylbl = new Label("Select your city");
        city = new ComboBox<String>();
        city.getItems().add("Abu Dabi");
        city.getItems().add("Belgia");
        city.getItems().add("Bucharest");
        city.getItems().add("Cidney");
        city.getItems().add("London");
        city.getItems().add("Helsinki");

        submit = new Button("Submit");
        errorlbl = new Label();
        errorlbl.setId("error_lbl");

        submit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                boolean connect = validate_form();
                if (connect) {
                    String gender = "";
                    if (opt1.isSelected()) {
                        gender = opt1.getText();
                    }
                    if (opt2.isSelected()) {
                        gender = opt2.getText();
                    }

                    String selectedjpost = "";
                    if (chk1.isSelected()) {
                        selectedjpost+=chk1.getText() + " ";
                    }
                    if (chk2.isSelected()) {
                        selectedjpost+=chk2.getText() + " ";
                    }
                    if (chk3.isSelected()) {
                        selectedjpost+=chk3.getText() + " ";
                    }

                    User u = new User(firstNametxt.getText(), lastNametxt.getText(), passwordtxt.getText(), gender, selectedjpost, phonetxt.getText(), emailtxt.getText(), (String)city.getValue());

					/*TodoDataAccess tt = null;
					try {
						tt = new TodoDataAccess();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						tt.getAllRows();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/

                    System.out.println("DATA: "+firstNametxt.getText()+" "+lastNametxt.getText()+" "+passwordtxt.getText()+" "+gender+" "+selectedjpost+" "+phonetxt.getText()+" "+emailtxt.getText()+" "+(String)city.getValue());

                    boolean result = u.insertUser();

                    if (result) {
                        errorlbl.setText("Record inserted successfully");
                        errorlbl.setTextFill(Color.GREEN);
                    } else {
                        errorlbl.setText("Record not inserted in the database");
                    }
                } else {
                    errorlbl.setTextFill(Color.RED);
                }
            }
        });

        GridPane root = new GridPane();
        root.add(firstNamelbl, 0, 1);
        root.add(firstNametxt, 1, 1);
        root.add(lastNamelbl, 0, 2);
        root.add(lastNametxt, 1, 2);
        root.add(passwordlbl, 0, 3);
        root.add(passwordtxt, 1, 3);
        root.add(genderlbl, 0, 4);
        root.add(opt1, 1, 4);
        root.add(opt2, 1, 5);
        root.add(jpostlbl, 0, 7);
        root.add(chk1, 1, 7);
        root.add(chk2, 1, 8);
        root.add(chk3, 1, 9);
        root.add(phonelbl, 0, 11);
        root.add(phonetxt, 1, 11);
        root.add(emaillbl, 0, 12);
        root.add(emailtxt, 1, 12);
        root.add(citylbl, 0, 13);
        root.add(city, 1, 13);
        //root.add(submit, 1, 15);
        //root.add(errorlbl, 1, 16);

        HBox hbox = new HBox();
        hbox.getChildren().add(root);
        hbox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.setId("my_vbox");

        Label headlbl = new Label("Registration");
        headlbl.setId("regisration");
        vbox.getChildren().add(headlbl);
        vbox.getChildren().add(hbox);

        vbox.getChildren().add(submit);
        vbox.getChildren().add(errorlbl);

        //vbox.prefWidthProperty().bind(root.widthProperty());
        //vbox.prefHeightProperty().bind(root.heightProperty());

        Scene scene = new Scene(vbox, 800, 500);

        scene.getStylesheets().add(getClass().getResource("/com.example.demo3/mystyle.css").toExternalForm());

        primaryStage.setTitle("Department of Cyberpolice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public boolean validate_form() {
        boolean proceed = true;
        if (firstNametxt.getText().isEmpty() && proceed == true) {
            errorlbl.setText("Enter first name");
            proceed = false;
        }
        if (lastNametxt.getText().isEmpty() && proceed == true) {
            errorlbl.setText("Enter last name");
            proceed = false;
        }
        if (passwordtxt.getText().isEmpty() && proceed == true) {
            errorlbl.setText("Enter password");
            proceed = false;
        }
        if (opt1.isSelected() == false && opt2.isSelected() == false && proceed == true) {
            errorlbl.setText("Select gender");
            proceed = false;
        }
        if (chk1.isSelected() == false && chk2.isSelected() == false && chk3.isSelected() == false && proceed == true) {
            errorlbl.setText("Select post");
            proceed = false;
        }
        if (phonetxt.getText().isEmpty() && proceed == true) {
            errorlbl.setText("Enter phone");
            proceed = false;
        }
        if (emailtxt.getText().isEmpty() && proceed == true) {
            errorlbl.setText("Enter email");
            proceed = false;
        }
        if (city.getValue() == null && proceed == true) {
            errorlbl.setText("Select city");
            proceed = false;
        }

        return proceed;
    }
}

/******************************
 CREATE TABLE `users` (
 `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `login` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `lastname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
 `is_auth` int(2) DEFAULT 0,
 `code` varchar(25) DEFAULT NULL,
 `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (`id`),
 KEY `login` (`login`),
 KEY `firstname` (`firstname`),
 KEY `lastname` (`lastname`),
 KEY `password` (`password`),
 KEY `gender` (`gender`),
 KEY `is_auth` (`is_auth`),
 KEY `code` (`code`),
 KEY `phone` (`phone`),
 KEY `email` (`email`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin
 *******************************/
class User
{
    private String firstname;
    private String lastname;
    private String password;
    private String gender;
    private String jpost;
    private String phone;
    private String email;
    private String city;
    private String created_at;
    private String updated_at;

    public User(String firstName, String lastName, String password, String gender, String jpost, String phone, String email, String city) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.jpost = jpost;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.created_at = "2023-12-06 20:50:00";
        this.updated_at = "2023-12-06 20:50:00";
    }

    public boolean insertUser()
    {
        try {
            //dbmsConnection dbmsconnection = new dbmsConnection("jdbc:mysql://localhost:3306/makklaysdb", "admin", "admin");
            //Connection connection = dbmsconnection.getConnection();
            //Statement stmt = con.createStatement();
            //Properties connectionProps = new Properties();
            //connectionProps.put("user", "admin");
            //connectionProps.put("password", "admin");
            System.out.println("Loading driver...");

		    /*try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        System.out.println("Driver loaded!");
		    } catch (ClassNotFoundException e) {
		        throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		    }*/

		    /*Connection connection = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/makklaysdb",
		            connectionProps
		    );*/

            //------------------
            // opening database connection to MySQL server
		    /*Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/makklaysdb","admin","admin");

            // getting Statement object to execute query
		    Statement stmt = con.createStatement();

            // executing SELECT query
		    String query = "select count(*) from cities";
		    ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of cities in the table : " + count);
            }*/
            //---------------------

            return true;

            //Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/makklaysdb","admin","admin");
            //String sql = "INSERT INTO `polisman_users` VALUES (?,?,?,?,?,?,?,?);";

            //System.out.println("CON => " + connection);

            //Statement stmt = con.createStatement();
            /*String sql = "INSERT INTO `polisman_users`(firstname, lastname, password, gender, jpost, phone, email, city) VALUES ('Alexander', 'Kuziv', 'password', 'male', 'polisman', '+380988705397', 'makklays@gmail.com', 'City')";

			System.out.println("SQL => " + sql);

			int i = stmt.executeUpdate(sql);
			if (i > 0) {
				System.out.println("Record inserted successfully in the database");
				return true;
			} else {
				System.out.println("Record not inserted in the database");
				return false;
			}*/

			/*PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);
			stmt.setString(3, password);
			stmt.setString(4, gender);
			stmt.setString(5, jpost);
			stmt.setString(6, phone);
			stmt.setString(7, email);
			stmt.setString(8, city);
			/*stmt.setString(9, created_at);
			stmt.setString(10, updated_at);*/

			/*int i = stmt.executeUpdate();
			if (i > 0) {
				System.out.println("Record inserted successfully in the database");
				return true;
			} else {
				System.out.println("Record not inserted in the database");
				return false;
			}*/

        } catch (Exception sqlEx) {
            sqlEx.printStackTrace();
            return false;
        }
    }
}

class dbmsConnection
{
    // JDBC URL, username and password of MySQL server
    String url;
    String username;
    String password;

    // JDBC variables for opening and managing connection
    Connection conn;
    Statement stmt;

    public dbmsConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // opening database connection to MySQL server
        //conn = DriverManager.getConnection(url, username, password);
        conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/makklaysdb", "admin", "admin");

        //Connection con = null;
        //Class.forName("com.mysql.cj.jdbc.Driver").instnewInstance();
        // getting Statement object to execute query
        stmt = conn.createStatement();

        System.out.println("Connection Established Successfully");

		return conn;
    }

    public void closeConnection(Connection con, Statement stmt) throws SQLException {
        stmt.close();
        con.close();
        System.out.println("The connection is closed");
    }
}

