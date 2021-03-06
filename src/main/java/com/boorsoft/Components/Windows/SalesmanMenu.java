package com.boorsoft.Components.Windows;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;

import com.boorsoft.Components.DataBaseHandler;
import com.boorsoft.Helpers.Utils;
import com.boorsoft.Models.GoodsModel;

public class SalesmanMenu {

    @FXML
    private Button quitButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button maximizeButton;

    @FXML
    private AnchorPane salesmanMenuPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private TableColumn<?, ?> dldeliveryDateColumn;

    @FXML
    private JFXButton exitBtn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private JFXButton orderBtn;

    @FXML
    private TableColumn<?, ?> orderDateColumn;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private JFXButton salesReportBtn;

    @FXML
    private JFXButton searchSubmitBtn;

    @FXML
    private JFXButton showListBtn;

    @FXML
    private TableView<?> table;

    @FXML
    private JFXButton toSellBtn;

    @FXML
    void initialize() {

        showListBtn.setOnAction(event -> {
            try {
                showGoods();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

        // Выходит в главное меню
        exitBtn.setOnAction(event -> {
            AnchorPane loginPane = Utils.load("/com/boorsoft/loginWindow.fxml", SalesmanMenu.class);
            salesmanMenuPane.getChildren().setAll(loginPane);
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
    }

    private void showGoods() throws SQLException, ClassNotFoundException {
        DataBaseHandler dbHandler = new DataBaseHandler();
        GoodsModel goods = new GoodsModel();
        ResultSet resultSet = dbHandler.fromDBGoodsData(goods);

        while (resultSet.next()) {
        }
    }
}
