package com.boorsoft.Components.Windows;

import com.jfoenix.controls.JFXRadioButton;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import com.boorsoft.Helpers.Utils;

public class RegistrationWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmBtn;

    @FXML
    private JFXRadioButton deliverRegistrRadioBtn;

    @FXML
    private JFXRadioButton providerRegistrRadioBtn;

    @FXML
    private TextField registrLoginField;

    @FXML
    private PasswordField registrPassField;

    @FXML
    private PasswordField registrPassRepeatField;

    @FXML
    private JFXRadioButton selasmanRegistrRadioBtn;

    @FXML
    private ToggleGroup toogleGroup;

    @FXML
    void initialize() {
        String registrLoginInput = registrLoginField.getText();
        String registrPassInput = registrPassField.getText();
        String registrPassRepeatInput = registrPassRepeatField.getText();

        confirmBtn.setOnAction(event -> {
            
        });

        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();
            Utils.load("sample.fxml", RegistrationWindow.class);
        });
    }
}
