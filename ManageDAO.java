/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OOPAPlus;

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
public class ManageDAO {
    private final Connection connection;
    private DocumentDAO documentDAO = new DocumentDAO();

    public ManageDAO() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
    }


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

    public void deleteUser(int userID) {
        String sql = "DELETE FROM User WHERE userID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


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

    public void updateBirthday(User user, String birthday) {
        String query = "use library; sET SQL_safe_updates = 0; update user " +
        "set birthday = ? where userAccount = ?;" +
        "sET SQL_safe_updates = 1;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, birthday); // Thiết lập giá trị userID cho câu lệnh
            statement.setString(2, user.getUserAccount());
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
    
    public void updateEmail(User user, String email) {
        String query = "use library; sET SQL_safe_updates = 0; update user " +
        "set email = ? where userAccount = ?;" +
        "sET SQL_safe_updates = 1;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email); // Thiết lập giá trị userID cho câu lệnh
            statement.setString(2, user.getUserAccount());
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
    
    public void updatePhone(User user, String phone) {
        String query = "use library; sET SQL_safe_updates = 0; update user " +
        "set phone = ? where userAccount = ?;" +
        "sET SQL_safe_updates = 1;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, phone); // Thiết lập giá trị userID cho câu lệnh
            statement.setString(2, user.getUserAccount());
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
    
    public void updateAddress(User user, String address) {
        String query = "use library; sET SQL_safe_updates = 0; update user " +
        "set address = ? where userAccount = ?;" +
        "sET SQL_safe_updates = 1;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, address); // Thiết lập giá trị userID cho câu lệnh
            statement.setString(2, user.getUserAccount());
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
