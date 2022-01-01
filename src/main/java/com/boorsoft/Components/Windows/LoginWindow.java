package com.boorsoft.Components.Windows;

import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.boorsoft.Components.DataBaseHandler;
import com.boorsoft.Helpers.Constants;
import com.boorsoft.Helpers.Utils;
import com.boorsoft.Models.WorkersModel;

public class LoginWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXRadioButton deliverRadioBtn;

    @FXML
    private Button enterBtn;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private JFXRadioButton providerRadioBtn;

    @FXML
    private Button registrBtn;

    @FXML
    private JFXRadioButton selasmanRadioBtn;

    ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    public void initialize() {
        selasmanRadioBtn.setToggleGroup(toggleGroup);
        providerRadioBtn.setToggleGroup(toggleGroup);
        deliverRadioBtn.setToggleGroup(toggleGroup);

        enterBtn.setOnAction(event -> {
            String loginInput = loginField.getText().trim();
            String passInput = passField.getText().trim();
            if (!loginInput.equals("") && !passInput.equals("")) {
                try {
                    checkAccType();
                    checkAuth(loginInput, passInput);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Achtung alarm!");
                alert.setHeaderText("Warnung Status:");
                alert.setContentText("Der Login oder das Passwort ist leer!");

                alert.showAndWait();
            }
        });

        registrBtn.setOnAction(event -> {
            registrBtn.getScene().getWindow().hide();
            Utils.load("/com/boorsoft/registrationWindow.fxml", LoginWindow.class);
        });
    }

    // проверят правильность заполненных данных пользователем и с данными с БД
    private void checkAuth(String loginInput, String passInput) throws SQLException, ClassNotFoundException {
        DataBaseHandler dbHandler = new DataBaseHandler();
        WorkersModel workers = new WorkersModel();
        workers.setLogin(loginInput);
        workers.setPassword(passInput);
        workers.setAccType(checkAccType());
        ResultSet resultSet = dbHandler.fromDBWorkersData(workers);

        int count = 0;
        while (resultSet.next()) {
            count++;
        }
        if (count >= 1) {
            if (workers.getAccType().equals("salesman")) {
                enterBtn.getScene().getWindow().hide();
                // если все правильно вызывает новое окно
                Utils.load("/com/boorsoft/salesmanMenu.fxml", LoginWindow.class);
            } else if (workers.getAccType().equals("provider")) {
                System.out.println("Provider menu");
            } else if (workers.getAccType().equals("deliver")) {
                System.out.println("deliver menu");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning alert");
            alert.setHeaderText("Warning Status:");
            alert.setContentText("The login or password is incorrect!");

            alert.showAndWait();
        }
    }

    // проверяет какой тип аккаунта выбрал пользователь
    private String checkAccType() {

        if (toggleGroup.getSelectedToggle().equals(selasmanRadioBtn)) {
            return Constants.Type = "salesman";
        } else if (toggleGroup.getSelectedToggle().equals(providerRadioBtn)) {
            return Constants.Type = "provider";
        } else if (toggleGroup.getSelectedToggle().equals(deliverRadioBtn)) {
            return Constants.Type = "deliver";
        }

        return Constants.Type;
    }
}