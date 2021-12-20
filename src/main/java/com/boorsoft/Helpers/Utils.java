package com.boorsoft.Helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Utils {

    public static void load(String url, Class window) {
        FXMLLoader load = new FXMLLoader();
        load.setLocation(window.getResource(url));

        try {
            load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = load.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
    }

}
