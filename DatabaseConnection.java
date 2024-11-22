/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

/**
 *
 * @author thinh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {

<<<<<<< HEAD
    // Kết nối với MySQL
//    private static final String URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12739033"; 
//    private static final String USER = "sql12739033"; 
//    private static final String PASSWORD = "IrDju4s9qc"; 
=======

>>>>>>> ce95f07e9768dfd8395399dc7908e4d79ba8aa73
    private static final String URL = "jdbc:mysql://localhost:3306/libraryoop"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "maiducvan112@##";
    public static Connection con;

    public  Connection getConnection() {
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
