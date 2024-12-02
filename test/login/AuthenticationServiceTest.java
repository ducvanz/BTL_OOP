/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BTL_OOP.test.login;

import BTL_OOP.login.AuthenticationService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngothuyet
 */
public class AuthenticationServiceTest {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/libraryoop";
    private static final String USER = "root";
    private static final String PASSWORD = "Thuyet@30042005";
    public AuthenticationServiceTest() {
    }

    @Test
    public void testAccountLogin() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Thiết lập dữ liệu mẫu
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE from user where username in ('testuser', 'manage')");
            statement.executeUpdate("INSERT INTO User ( name, username, password, role) VALUES ( 'Testuser','testuser', '1234', 'user')");
           statement.executeUpdate("INSERT INTO User ( name, username, password, role) VALUES ( 'Manage','manage', '12345', 'manage')");
           
            // Kiểm tra đăng nhập user
            assertEquals(1, AuthenticationService.accountLogin("testuser", "1234",1, con));

            // Kiểm tra đăng nhập manage
            assertEquals(2, AuthenticationService.accountLogin("thuyet", "111111", 2, con));

            // Kiểm tra tài khoản không tồn tại
            assertEquals(0, AuthenticationService.accountLogin("nonexistent", "1234", 1, con));

            // Xoá dữ liệu mẫu
            statement.executeUpdate("DELETE FROM User WHERE username IN ('testuser', 'testmanage')");
        } catch (Exception e) {
            fail("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
    

    @Test
    public void testCheckName() {
        assertEquals(true, AuthenticationService.checkName("Ngo viet thuyet"));
        
        assertEquals(false, AuthenticationService.checkName("%*^*&^"));
        
        assertEquals(false, AuthenticationService.checkName("MaiDucVanNguyenVanThinh"));
    }

    @Test
    public void testCheckID() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Thiết lập dữ liệu mẫu
            Statement statement = con.createStatement();
            statement.executeUpdate("DELETE from user where username in ('testuser', 'manage')");
            statement.executeUpdate("INSERT INTO User ( name, username, password, role) VALUES ( 'Testuser','testuser', '1234', 'user')");

            // Kiểm tra ID đã tồn tại
            assertFalse(AuthenticationService.checkID(1234, con));

            // Kiểm tra ID hợp lệ nhưng chưa tồn tại
            assertTrue(AuthenticationService.checkID(87654321, con));

            // Kiểm tra ID không hợp lệ
            assertFalse(AuthenticationService.checkID(12345, con)); // Không đủ 8 chữ số

            // Xoá dữ liệu mẫu
            statement.executeUpdate("DELETE FROM User WHERE userID = 12345678");
        } catch (Exception e) {
            fail("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
    

    @Test
    public void testCheckAccount() {
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Thiết lập dữ liệu mẫu
            Statement statement = con.createStatement();
              statement.executeUpdate("DELETE from user where username in ('testuser', 'manage')");
            statement.executeUpdate("INSERT INTO User ( name, username, password, role) VALUES ( 'Testuser','testuser', '1234', 'user')");

            // Kiểm tra tài khoản tồn tại
            assertTrue(AuthenticationService.checkAccount("testuser", con));

            // Kiểm tra tài khoản không tồn tại
            assertFalse(AuthenticationService.checkAccount("nonexistent", con));

            // Xoá dữ liệu mẫu
            statement.executeUpdate("DELETE FROM User WHERE username = 'testuser'");
        } catch (Exception e) {
            fail("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
    
    
}
