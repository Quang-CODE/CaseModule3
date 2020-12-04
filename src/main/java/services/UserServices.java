package services;

import ConnectToDB.ConnectMySQLDb;
import Model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServices {
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(id,firstName,lastName,address,email,shipAddress,role) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select * from users where id = ?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?";
    private static final String UPDATE_USERS_SQL = "update users set firstName = ?,lastName = ?,address = ?,email = ?,shipAddress = ?,role = ? where id = ?;";


    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                 int Id = resultSet.getInt("Id");
                 String FirstName = resultSet.getString("FirstName");
                 String LastName = resultSet.getString("LastName");
                 String Address = resultSet.getString("Address");
                 String Email= resultSet.getString("Email");
                 String ShipAddress= resultSet.getString("ShipAddress");
                 int Role= resultSet.getInt("Role");
                 User user = new User(Id,FirstName,LastName,Address,Email,ShipAddress,Role);
                 users.add(user);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return users;
    }


    public static void addUser(User user){
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getAddress());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getShipAddress());
            preparedStatement.setInt(7,user.getRole());
            preparedStatement.executeUpdate();
            }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean updateUser(User user) {
        boolean userUpdated = false;
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getShipAddress());
            preparedStatement.setInt(6,user.getRole());
            preparedStatement.setInt(7,user.getId());
            userUpdated = preparedStatement.executeUpdate() > 0;
        }catch(Exception e){}
        return userUpdated;
    }
    public static User findUser(int id){
        User user = null;
        try{
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Address = resultSet.getString("Address");
                String Email= resultSet.getString("Email");
                String ShipAddress= resultSet.getString("ShipAddress");
                int Role= resultSet.getInt("Role");
                user = new User(id,FirstName,LastName,Address,Email,ShipAddress,Role);
            }
        }catch (SQLException e){}
        return user;
    }
    public static boolean deleteUser(int id){
        boolean deleteUser = false;
        try {
            Connection connection = ConnectMySQLDb.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1,id);
            deleteUser = preparedStatement.executeUpdate() > 0;
        }catch (Exception e){}
        return deleteUser;
    }
    public static User userLogin(String firstName, String lastName, Connection connection){
        User user = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from users where FirstName ='" + firstName + "' and LastName ='" + lastName + "'";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("Id");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Address = resultSet.getString("Address");
                String Email = resultSet.getString("Email");
                String ShipAddress = resultSet.getString("ShipAddress");
                int Role = resultSet.getInt("Role");
                user = new User(id, FirstName, LastName, Address, Email, ShipAddress, Role);
            }
        }catch (Exception e){}
        return user;
    }
}
