package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Class: RegistrationForm
 * `Example of Registration Form (from differents elements)`
 */
public class RegistrationForm
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

                    User u = new User(firstNametxt.getText(), lastNametxt.getText(), passwordtxt.getText(), gender, phonetxt.getText(), emailtxt.getText(), (String)city.getValue());

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

