package BTL_OOP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageDAO {
    private final Connection connection;

    public ManageDAO() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
    }

    public void addUser (User user) {
        String sql = "INSERT INTO User (name, email, phone, birthday, address, loanTerm, numberBorrowed, username, password, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getBirthday());
            pstmt.setString(5, user.getAddress());
            pstmt.setBoolean(6, user.isLoanTerm());
            pstmt.setInt(7, user.getNumberBorrowed());
            pstmt.setString(8, user.getUsername());
            pstmt.setString(9, user.getPassword());
            pstmt.setString(10, "user");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT userID FROM User WHERE username = ?";
        int userID = -1; // Nếu không tìm thấy user, trả về -1

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userID = rs.getInt("userID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return getUserByID(userID);
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
                        rs.getString("birthday"),
                        rs.getString("address"),
                        rs.getBoolean("loanTerm"),
                        rs.getInt("numberBorrowed"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser (User user) {
        String sql = "UPDATE User SET name = ?, email = ?, phone = ?, birthday = ?, address = ?, loanTerm = ?, numberBorrowed = ?, username = ?, password = ? WHERE userID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getBirthday()); // Giả sử birthday là String
            pstmt.setString(5, user.getAddress());
            pstmt.setBoolean(6, user.isLoanTerm());
            pstmt.setInt(7, user.getNumberBorrowed());
            pstmt.setString(8, user.getUsername());
            pstmt.setString(9, user.getPassword());
            pstmt.setInt(10, user.getID()); // Sử dụng userID để cập nhật
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser (User user) {
        int userID = user.getID();
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
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateField(User user, String fieldName, String newValue) {
        String sql = "UPDATE User SET " + fieldName + " = ? WHERE username = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newValue);
            pstmt.setString(2, user.getUsername());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User 's " + fieldName + " updated successfully.");
            } else {
                System.out.println("User  not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}