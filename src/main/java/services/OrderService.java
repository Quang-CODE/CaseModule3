package services;

import ConnectToDB.ConnectMySQLDb;
import Model.Order;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class OrderService {
    private static final String INSERT_ORDER_SQL = "insert into orders" + "(userId, total) VALUES" +
            "(?, ?);";

    private static final String SELECT_ORDER_BY_ID = "select * from orders where id = ?";
    private static final String SELECT_ALL_ORDER = "select * from orders";
    private static final String DELETE_ORDER_SQL = "delete from orders where id = ?";
    private static final String UPDATE_ORDER_SQL = "update orders set userId = ?,total = ? where id = ?;";

    public List<Order> getOrderList() {
        List<Order> orders = new ArrayList<>();
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                int userId = resultSet.getInt("userId");
                int total = resultSet.getInt("total");
                Order order = new Order(Id,userId,total);
                orders.add(order);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return orders;
    }
    public static void addOrder(Order order){
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL);
            preparedStatement.setInt(1,order.getUserId());
            preparedStatement.setInt(2,order.getTotal());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean updateOrder(Order order) {
        boolean orderUpdated = false;
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_SQL);
            preparedStatement.setInt(1,order.getUserId());
            preparedStatement.setInt(2,order.getTotal());
            preparedStatement.setInt(3,order.getId());
            orderUpdated = preparedStatement.executeUpdate() > 0;
        }catch(Exception e){}
        return orderUpdated;
    }
    public static Order findOrder(int id){
        Order order = null;
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                int userId = resultSet.getInt("userId");
                int total = resultSet.getInt("total");
                order = new Order(id,userId,total);
            }
        }catch (SQLException e){}
        return order;
    }
    public static boolean deleteOrder(int id){
        boolean deleteOrder = false;
        try {
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_SQL);
            preparedStatement.setInt(1,id);
            deleteOrder = preparedStatement.executeUpdate() > 0;
        }catch (Exception e){}
        return deleteOrder;
    }
}
