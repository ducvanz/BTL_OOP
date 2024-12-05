/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.database;

import BTL_OOP.main.database.DatabaseConnection;
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngothuyet
 */
public class DatabaseConnectionTest {
    
    public DatabaseConnectionTest() {
    }

    @Test
    public void testGetDatabaseConnection() {
    }

    @Test
    public void testGetConnection() {
        
        Connection connection = DatabaseConnection.getDatabaseConnection().connection;
        assertNotNull(connection);
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
