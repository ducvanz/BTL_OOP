/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

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
    public static int accountLogin(String account, String password, int pp, Connection con) {
        if (pp == 1) {
            // check tai khoan nguoi dung

            String selectSQL = "SELECT password, role FROM User WHERE username = ?";
            try (PreparedStatement statement = con.prepareStatement(selectSQL)) {
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
            try (PreparedStatement statement = con.prepareStatement(selectSQL)) {
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

    public static String checkName(String name) {
    if (name.length() > 30) {
        return "Name too long!";
    }

    // Regular expression to match valid characters, including Vietnamese characters with diacritics
    String regex = "^[\\p{L} ]+$"; // \p{L} matches any kind of letter from any language

    if (name.matches(regex)) {
        return "true";  // valid name
    } else {
        return "Invalid name!";  // name contains invalid characters
        }
    }
    
    public static boolean checkID (int ID, Connection con) {
        String select = "SELECT 1 FROM User WHERE userID = ?";
        try(PreparedStatement pstm = con.prepareStatement(select)) {
            
            pstm.setInt(1, ID);
            // Thực thi câu lệnh truy vấn
            try (ResultSet res = pstm.executeQuery()) {
                // Nếu có kết quả, nghĩa là tài khoản tồn tại
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
    
    public static boolean checkAccount(String account, Connection con) {
        String select = "SELECT 1 FROM User WHERE username = ?";
        try(PreparedStatement pstm = con.prepareStatement(select)) {
            
            pstm.setString(1, account);
            // Thực thi câu lệnh truy vấn
            try (ResultSet res = pstm.executeQuery()) {
                // Nếu có kết quả, nghĩa là tài khoản tồn tại
                return res.next();
            }
             catch (SQLException e) {
                e.printStackTrace();
            }
            // Trả về false nếu có lỗi hoặc tài khoản không tồn tại
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
