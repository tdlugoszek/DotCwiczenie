package com.example.dotcwiczenie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = loader.load();
        HelloController controller = loader.getController();

        stage.setTitle("Zdarzenia");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

        stage.getScene().setOnKeyPressed(event -> controller.handleKeyPressed(event));
        stage.widthProperty().addListener((obs, ov, nv) -> controller.stageResized());
        stage.heightProperty().addListener((obs, ov, nv) -> controller.stageResized());
    }

    public static void main(String[] args) {
        launch();
    }
}

