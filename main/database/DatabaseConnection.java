/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main.database;

/**
 *
 * @author thinh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String URL = "jdbc:mysql://localhost:3306/libraryoop";
    private final String USER = "root"; 
    private final String PASSWORD = "";
    public Connection connection;
    private static DatabaseConnection database;
    private DatabaseConnection() {}

    /**
     * Hàm thực hiện tạo đối tượng.
     * @return 
     */
    public static DatabaseConnection getDatabaseConnection() {
        if (database == null) {
            database = new DatabaseConnection();
            database.getConnection();
        }
        return database;
    }
    
    /**
     * Kết nối database.
     * @return biến Connection
     */
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Kết nối csdl thất bại!");
            e.printStackTrace();
        }
        connection = con;
        return con;
    }

}
