package com.example.demo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.io.InputStream;

public class HelloApplication extends Application {

    public void init() {
        //
    }

    @Override
    public void start(Stage stage) throws IOException {
        // first window
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("AI BOT");
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void load(Stage primaryStage) {
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
        Image image = new Image(iconStream);
        ImageView img = new ImageView(image);

        img.setFitWidth(200);
        img.setFitHeight(200);

        GridPane root = new GridPane();
        root.add(img, 0, 1);
        root.add(login, 0, 2);
        root.add(tf1, 0, 3);
        root.add(password, 0, 4);
        root.add(tf2, 0, 5);

        btn.setMinWidth(200);
        btn.setMinHeight(20);

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().add(root);

        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        vbox1.getChildren().add(img);
        vbox1.getChildren().add(hbox1);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(btn);
        StackPane.setMargin(btn, new Insets(10,0,10,0));

        vbox1.getChildren().add(stackPane);

        Scene scene = new Scene(vbox1, 800, 500);

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

