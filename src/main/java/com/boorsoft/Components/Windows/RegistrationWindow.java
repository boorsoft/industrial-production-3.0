package com.boorsoft.Components.Windows;

import com.jfoenix.controls.JFXRadioButton;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import com.boorsoft.Components.DataBaseHandler;
import com.boorsoft.Helpers.Constants;
import com.boorsoft.Helpers.Utils;
import com.boorsoft.Models.WorkersModel;

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
        

        DataBaseHandler dbHandler = new DataBaseHandler();

        confirmBtn.setOnAction(event -> {
            String registrLoginInput = registrLoginField.getText().trim();
            String registrPassInput = registrPassField.getText().trim();
            String registrPassRepeatInput = registrPassRepeatField.getText().trim();
            if (!registrLoginInput.equals("") && !registrPassInput.equals("") && !registrPassRepeatInput.equals("")) {
                if (registrPassInput.equals(registrPassRepeatInput)){
                    try {
                        if (checkIfExists(registrLoginInput) <= 1){
                            if (toogleGroup.getSelectedToggle().equals(selasmanRegistrRadioBtn)) {
                                Constants.Type = "salesman";
                            } else if (toogleGroup.getSelectedToggle().equals(providerRegistrRadioBtn)) {
                                Constants.Type = "provider";
                            } else if (toogleGroup.getSelectedToggle().equals(deliverRegistrRadioBtn)) {
                                Constants.Type = "deliver";
                            }
                            dbHandler.toDBWorkersData(registrLoginInput, registrPassInput, Constants.Type);
                            registrLoginField.setText("Регистрация прошла успешно");
                            registrPassField.setText("");
                            registrPassRepeatField.setText("");
                        }else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning alert");
                            alert.setHeaderText("Warning Status:");
                            alert.setContentText("Пользователь уже существует!");
            
                            alert.showAndWait();
                        }
                    
                    }catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }   
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning alert");
                alert.setHeaderText("Warning Status:");
                alert.setContentText("Пароли не совпадают!");

                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning alert");
            alert.setHeaderText("Warning Status:");
            alert.setContentText("Поля не должны быть пустыми!");

            alert.showAndWait();
        }
        });

        

        backBtn.setOnAction(event -> {
            backBtn.getScene().getWindow().hide();
            Utils.load("/com/boorsoft/sample.fxml", RegistrationWindow.class);
        });
    }

    private int checkIfExists(String login) throws SQLException, ClassNotFoundException{ 
        DataBaseHandler dbHandler = new DataBaseHandler();
        WorkersModel workers = new WorkersModel();
        workers.setLogin(login);
        ResultSet resultSet = dbHandler.fromDBWorkersData(workers);

        int count = 0;
        int i = 0;
        while (resultSet.next()) {
            count++;
        }
        if (count >= 1) {
            if (workers.getLogin().equals(login))  i++;
        } 
        return i;
    }
}
