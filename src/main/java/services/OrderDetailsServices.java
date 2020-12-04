package services;

import ConnectToDB.ConnectMySQLDb;
import Model.Order;
import Model.OrderDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsServices {
    private static final String INSERT_ORDERDETAILS_SQL = "insert into orderdetails" + "(Id, OrderId, ProductId, orderNumber, price, Quantity, productDescription) VALUES" +
            " (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_ORDERDETAILS_BY_ID = "select * from orderdetails where id = ?";
    private static final String SELECT_ALL_ORDERDETAILS = "select * from orderdetails";
    private static final String DELETE_ORDERDETAILS_SQL = "delete from orderdetails where id = ?";
    private static final String UPDATE_ORDERDETAILS_SQL = "update orderdetails set OrderId = ?,ProductId = ?,orderNumber = ?,price = ?,Quantity = ?,productDescription = ?  where id = ?;";



    public List<OrderDetails> getOrderDetailsList() {
        List<OrderDetails> orderDetails = new ArrayList<>();
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERDETAILS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                int OrderId = resultSet.getInt("OrderId");
                int ProductId = resultSet.getInt("ProductId");
                int orderNumber = resultSet.getInt("orderNumber");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("Quantity");
                String shipAddress = resultSet.getString("shipAddress");
                OrderDetails orderDetails1 = new OrderDetails(Id,OrderId,ProductId,orderNumber,price,quantity,shipAddress);
                orderDetails.add(orderDetails1);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return orderDetails;
    }
    public void addOrderDetails(OrderDetails orderDetails1){
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERDETAILS_SQL);
            preparedStatement.setInt(1,orderDetails1.getId());
            preparedStatement.setInt(2,orderDetails1.getOrderId());
            preparedStatement.setInt(3,orderDetails1.getProductId());
            preparedStatement.setInt(4,orderDetails1.getOrderNumber());
            preparedStatement.setInt(5,orderDetails1.getPrice());
            preparedStatement.setInt(6,orderDetails1.getQuantity());
            preparedStatement.setString(7,orderDetails1.getShipAddress());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean updateOrderDetails(OrderDetails orderDetails1) {
        boolean orderUpdated = false;
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDERDETAILS_SQL);
            preparedStatement.setInt(1,orderDetails1.getOrderId());
            preparedStatement.setInt(2,orderDetails1.getProductId());
            preparedStatement.setInt(3,orderDetails1.getOrderNumber());
            preparedStatement.setInt(4,orderDetails1.getPrice());
            preparedStatement.setInt(5,orderDetails1.getQuantity());
            preparedStatement.setString(6,orderDetails1.getShipAddress());
            preparedStatement.setInt(7,orderDetails1.getId());
            orderUpdated = preparedStatement.executeUpdate() > 0;
        }catch(Exception e){}
        return orderUpdated;
    }
    public OrderDetails findOrderDetails(int id){
        OrderDetails orderDetails1 = null;
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERDETAILS_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                int OrderId = resultSet.getInt("OrderId");
                int ProductId = resultSet.getInt("ProductId");
                int orderNumber = resultSet.getInt("orderNumber");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("Quantity");
                String shipAddress = resultSet.getString("shipAddress");
                orderDetails1 = new OrderDetails(Id,OrderId,ProductId,orderNumber,price,quantity,shipAddress);
            }
        }catch (SQLException e){}
        return orderDetails1;
    }
    public boolean deleteOrderDetails(int id){
        boolean deleteOrderDetails = false;
        try {
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDERDETAILS_SQL);
            preparedStatement.setInt(1,id);
            deleteOrderDetails = preparedStatement.executeUpdate() > 0;
        }catch (Exception e){}
        return deleteOrderDetails;
    }
}
