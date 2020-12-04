package ConnectToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQLDb {
    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/amazon?useSSL=false","root","Taylorswift1102");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return connection;

    }
}
