/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thinh
 */
public class ManageDAO implements IManageDAO{
    private final Connection connection;
    private DocumentDAO documentDAO = new DocumentDAO();

    public ManageDAO() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
    }


    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO User (name, email, phone, birthday, address, loanTerm, numberBorrowed, userAccount, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getBirthday()); 
            pstmt.setString(5, user.getAddress());
            pstmt.setBoolean(6, user.isLoanTerm()); 
            pstmt.setInt(7, user.getNumberBorrowed());
            pstmt.setString(8, user.getUserAccount());
            pstmt.setString(9, user.getPassword());
            pstmt.setString(10, "user");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getUserIDByUserAccount(String userAccount) {
        String sql = "SELECT userID FROM User WHERE userAccount = ?";
        int userID = -1; // Nếu không tìm thấy user, trả về -1
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, userAccount);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                userID = rs.getInt("userID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userID;
    }
    
    @Override
    public User getUserByID(int userID) {
        String sql = "SELECT * FROM User WHERE userID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("userID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("birthday"), // Chuyển đổi từ Date sang LocalDate
                    rs.getString("address"),
                    rs.getBoolean("loanTerm"),
                    rs.getInt("numberBorrowed"),
                    rs.getString("userAccount"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void updateUser(User user) {
        String sql = "UPDATE User SET name = ?, email = ?, phone = ?, birthday = ?, address = ?, loanTerm = ?, numberBorrowed = ?, userAccount = ?, password = ? WHERE userID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setDate(4, Date.valueOf(user.getBirthday())); // Chuyển đổi từ LocalDate sang Date
            pstmt.setString(5, user.getAddress());
            pstmt.setBoolean(6, user.isLoanTerm()); // Giả định loanTerm là một byte
            pstmt.setInt(7, user.getNumberBorrowed());
            pstmt.setString(8, user.getUserAccount());
            pstmt.setString(9, user.getPassword());
            pstmt.setString(10, "user");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userID) {
        String sql = "DELETE FROM User WHERE userID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                    rs.getInt("userID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("birthday"),
                    rs.getString("address"),
                    rs.getBoolean("loanTerm"),
                    rs.getInt("numberBorrowed"),
                    rs.getString("userAccount"),
                    rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    @Override
    public void removeUser(User user) {
        String query = "DELETE FROM User WHERE userID = ?"; // Câu lệnh SQL để xóa người dùng

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getUserID()); // Thiết lập giá trị userID cho câu lệnh
            int rowsAffected = statement.executeUpdate(); // Thực thi câu lệnh

            if (rowsAffected > 0) {
                System.out.println("User removed successfully."); 
            } else {
                System.out.println("User not found."); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        }
    }

}
