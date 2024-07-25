package mini.mini;

import java.sql.*;
import java.sql.DriverManager;


public class DatabaseConnection {


    public Connection databaselink;

    public Connection getConnection() {
        String databaseName = "mini_project";
        String databaseUser = "root";
        String databasePassword = "";
        String url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, databaseUser, databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("not done");
        }
        return databaselink;

    }
}



