/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BTL_OOP;

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
    public void testGetConnection() {
           // Gọi phương thức kết nối cơ sở dữ liệu
        Connection connection = DatabaseConnection.getConnection();

        // Kiểm tra kết quả: connection không được null
        // Nếu test pass thì kết nối được, ngược lại 
        assertNotNull(connection);

        // Đóng kết nối sau khi kiểm tra
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
