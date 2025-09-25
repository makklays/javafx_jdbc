package com.techmatrix.javafx_jdbc.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import java.io.IOException;
import java.util.function.Consumer;

public class Navigator {
    private static AnchorPane rightContentPane;

    public static void setContentPane(AnchorPane pane) {
        rightContentPane = pane;
    }

    // Базовая загрузка без параметров
    public static void load(String fxml) {
        load(fxml, null);
    }

    // Загрузка с параметром
    public static <T> void load(String fxml, Consumer<T> controllerInitializer) {
        if (rightContentPane == null) {
            throw new IllegalStateException("Navigator: rightContentPane не установлен!");
        }
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/com/techmatrix/javafx_jdbc/" + fxml));
            Node node = loader.load();

            // Если нужно, передаём данные контроллеру
            if (controllerInitializer != null) {
                @SuppressWarnings("unchecked")
                T controller = loader.getController();
                controllerInitializer.accept(controller);
            }

            rightContentPane.getChildren().setAll(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

