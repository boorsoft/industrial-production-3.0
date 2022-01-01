package com.boorsoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.boorsoft.Helpers.Constants;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Boorshop");
        primaryStage.setScene(new Scene(root, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        primaryStage.setMinHeight(Constants.MIN_WINDOW_HEIGHT);
        primaryStage.setMinWidth(Constants.MIN_WINDOW_WIDTH);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
