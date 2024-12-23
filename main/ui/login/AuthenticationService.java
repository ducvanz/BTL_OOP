/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main.ui.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Các phương thức tĩnh static để giúp class tự gọi để check các thao tác liên quan đến Login và Sign Up
 * @author thinh
 */

public class AuthenticationService {

    /**
     * Chuyển hướng đăng nhập.
     * 0: thông tin sai
     * 1: người dùng
     * 2: quản lý
     */
    public static int accountLogin(String account, String password, int pp, Connection connection) {
        if (pp == 1) {
            // check tai khoan nguoi dung

            String selectSQL = "SELECT password, role FROM User WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
                // Truyền giá trị cho tham số "?"
                statement.setString(1, account);  // userAccount là biến chứa tên tài khoản người dùng

                // Thực thi câu lệnh truy vấn
                try (ResultSet res = statement.executeQuery()) {
                    if (res.next()) {
                        // Lấy password từ kết quả
                        String pass = res.getString("password");
                        String role = res.getString("role");
                        if (pass.equals(password) && role.equals("user")) {
                            return 1;
                        }
                    }
                    return 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }
        else {
            String selectSQL = "SELECT password, role FROM User WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
                // Truyền giá trị cho tham số "?"
                statement.setString(1, account);  // userAccount là biến chứa tên tài khoản người dùng

                // Thực thi câu lệnh truy vấn
                try (ResultSet res = statement.executeQuery()) {
                    if (res.next()) {
                        // Lấy password từ kết quả
                        String pass = res.getString("password");
                        String role = res.getString("role");
                        if (pass.equals(password) && role.equals("manage")) {
                            return 2;
                        }
                    }
                    return 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    /**
     * Kiểm tra sơ cấp tên người dùng.
     * @param name
     * @return 
     */
    public static String checkName(String name) {
    if (name.length() > 30) {
        return "Name too long!";
    }

    String regex = "^[\\p{L} ]+$";

    if (name.matches(regex)) {
        return "true"; 
    } else {
        return "Invalid name!";
        }
    }
    
    /**
     * Check id if exist
     * @param ID
     * @param connection
     * @return 
     */
    public static boolean checkID (int ID, Connection connection) {
        String select = "SELECT 1 FROM User WHERE userID = ?";
        try(PreparedStatement pstm = connection.prepareStatement(select)) {
            
            pstm.setInt(1, ID);
            try (ResultSet res = pstm.executeQuery()) {
                if (res.next()) {
                    return false;
                }
            }
             catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s = Integer.toString(ID);
        if (s.length() != 8) return false;
        
        if (s.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }
    
    /**
     * Kiểm tra nếu tài khoản đã tồn tại.
     * @param account tên tài khoản
     * @param connection
     * @return 
     */
    public static boolean checkAccount(String account, Connection connection) {
        String select = "SELECT 1 FROM User WHERE username = ?";
        try(PreparedStatement pstm = connection.prepareStatement(select)) {
            
            pstm.setString(1, account);
            try (ResultSet res = pstm.executeQuery()) {
                return res.next();
            }
             catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
