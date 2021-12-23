package com.boorsoft.Components;

import com.boorsoft.Helpers.Constants;
import com.boorsoft.Models.GoodsModel;
import com.boorsoft.Models.WorkersModel;

import java.sql.*;

public class DataBaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlite:" + dbPath;

        // Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url);

        return dbConnection;
    }
    
    public ResultSet toDBWorkersData(WorkersModel workers) throws ClassNotFoundException, SQLException{
        ResultSet resultSet= null;
        String insert = "INSERT INTO workers(login, password, accType) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
        return resultSet;
    }

    public ResultSet fromDBWorkersData(WorkersModel workers) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Constants.WORKERS_TABLE + " WHERE " + Constants.WORKERS_LOGIN + "=? AND "
                + Constants.WORKERS_PASS + "=? AND " + Constants.WORKERS_ACCTYPE + "=?";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, workers.getLogin());
        preparedStatement.setString(2, workers.getPassword());
        preparedStatement.setString(3, workers.getAccType());

        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    public ResultSet fromDBGoodsData(GoodsModel goods) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Constants.GOODS_TABLE + " WHERE " + Constants.GOODS_TITLE + "=? AND "
                + Constants.GOODS_AMOUNT + "=? AND " + Constants.GOODS_PRICE + "=? AND " + Constants.GOODS_ORDER_DATE
                + "=? AND " + Constants.GOODS_ORDER_DATE + "=?";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
        preparedStatement.setString(1, goods.getTitle());
        preparedStatement.setString(2, goods.getAmount());
        preparedStatement.setString(3, goods.getPrice());
        preparedStatement.setString(4, goods.getOrderDate());
        preparedStatement.setString(5, goods.getDeliveryDate());

        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
}
