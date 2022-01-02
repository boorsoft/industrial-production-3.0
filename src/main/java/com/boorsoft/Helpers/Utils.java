package com.boorsoft.Helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Utils {

    private static AnchorPane pane;

    public static AnchorPane load(String url, Class<?> window) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(window.getResource(url));

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pane;

    }

}
