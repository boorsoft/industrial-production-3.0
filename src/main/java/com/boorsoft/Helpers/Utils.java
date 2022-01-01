package com.boorsoft.Helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {

    public static void load(String url, Class<?> window) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(window.getResource(url));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        Stage stage = new Stage();
        stage.setScene(
                new Scene(parent));
        stage.setMinHeight(Constants.MIN_WINDOW_HEIGHT);
        stage.setMinWidth(Constants.MIN_WINDOW_WIDTH);
        stage.show();

    }

}
