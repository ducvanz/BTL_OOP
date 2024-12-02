/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.connectionDB;

/**
 *
 * @author thinh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    private static final String URL = "jdbc:mysql://localhost:3306/libraryoop";
    private static final String USER = "root"; 
    private static final String PASSWORD = "";
    public Connection con;
    private static DatabaseConnection database;
    private DatabaseConnection() {}

    public static DatabaseConnection getDatabaseConnection() {
        if (database == null) {
            database = new DatabaseConnection();
            database.getConnection();
        }
        return database;
    }
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Kết nối csdl thất bại!");
            e.printStackTrace();
        }
        con = connection;
        return connection;
    }

}
