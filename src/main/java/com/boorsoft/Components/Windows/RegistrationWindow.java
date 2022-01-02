package com.boorsoft.Components.Windows;

import com.jfoenix.controls.JFXRadioButton;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

import com.boorsoft.Components.DataBaseHandler;
import com.boorsoft.Helpers.Constants;
import com.boorsoft.Helpers.Utils;
import com.boorsoft.Models.WorkersModel;

public class RegistrationWindow {

    @FXML
    private AnchorPane registerPane;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button maximizeButton;

    @FXML
    private Button quitButton;

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
    private JFXRadioButton salesmanRegistrRadioBtn;

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
                if (registrPassInput.equals(registrPassRepeatInput)) {
                    try {
                        if (checkIfExists(registrLoginInput) <= 1) {
                            if (toogleGroup.getSelectedToggle().equals(salesmanRegistrRadioBtn)) {
                                Constants.Type = "salesman";
                            } else if (toogleGroup.getSelectedToggle().equals(providerRegistrRadioBtn)) {
                                Constants.Type = "provider";
                            } else if (toogleGroup.getSelectedToggle().equals(deliverRegistrRadioBtn)) {
                                Constants.Type = "deliver";
                            }
                            dbHandler.toDBWorkersData(registrLoginInput, registrPassInput, Constants.Type);
                            registrLoginField.setText("Erfolgreich angemeldet");
                            registrPassField.setText("");
                            registrPassRepeatField.setText("");
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning alert");
                            alert.setHeaderText("Warning Status:");
                            alert.setContentText("Benutzere existiert bereits");

                            alert.showAndWait();
                        }

                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warnung");
                    alert.setHeaderText("Warnstatus:");
                    alert.setContentText("Passwörter stimmen nicht");

                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warnung");
                alert.setHeaderText("Warnstatus:");
                alert.setContentText("Felder dürfen nicht leer sein");

                alert.showAndWait();
            }
        });

        backBtn.setOnAction(event -> {
            AnchorPane loginPane = Utils.load("/com/boorsoft/loginWindow.fxml", RegistrationWindow.class);
            registerPane.getChildren().setAll(loginPane);
        });

        maximizeButton.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if (stage.isFullScreen())
                stage.setFullScreen(false);
            else
                stage.setFullScreen(true);
        });

        minimizeButton.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setIconified(true);
        });

        quitButton.setOnAction(event -> {
            Platform.exit();
        });

        quitButton.setOnAction(event -> {
            Platform.exit();
        });
    }

    private int checkIfExists(String login) throws SQLException, ClassNotFoundException {
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
            if (workers.getLogin().equals(login))
                i++;
        }
        return i;
    }
}
