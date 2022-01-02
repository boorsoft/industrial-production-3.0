package com.boorsoft.Components.Windows;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.boorsoft.Components.DataBaseHandler;
import com.boorsoft.Helpers.Utils;
import com.boorsoft.Models.GoodsModel;

public class SalesmanMenu {

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
            exitBtn.getScene().getWindow().hide();
            Utils.load("/com/boorsoft/loginWindow.fxml", SalesmanMenu.class);
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
