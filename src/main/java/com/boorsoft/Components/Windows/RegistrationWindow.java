package com.boorsoft.Components.Windows;

import com.jfoenix.controls.JFXRadioButton;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import com.boorsoft.Components.DataBaseHandler;
import com.boorsoft.Helpers.Constants;
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
        DataBaseHandler dbHandler = new DataBaseHandler();

        confirmBtn.setOnAction(event -> {
            try {
                if (toogleGroup.getSelectedToggle().equals(selasmanRegistrRadioBtn)) {
                    Constants.Type = "salesman";
                } else if (toogleGroup.getSelectedToggle().equals(providerRegistrRadioBtn)) {
                    Constants.Type = "provider";
                } else if (toogleGroup.getSelectedToggle().equals(deliverRegistrRadioBtn)) {
                    Constants.Type = "deliver";
                }
                dbHandler.toDBWorkersData(registrLoginInput, registrPassInput, Constants.Type);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });

        

        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();
            Utils.load("/com/boorsoft/sample.fxml", RegistrationWindow.class);
        });
    }

    private String checkRegistrAccType() {
     

        return Constants.Type;
    }
}
