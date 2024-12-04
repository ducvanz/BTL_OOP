package BTL_OOP.main.dao;

import BTL_OOP.main.database.DatabaseConnection;
import BTL_OOP.main.models.user.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageDAO {
    private final Connection connection = DatabaseConnection.getDatabaseConnection().con;

    private static final ManageDAO manageDao = new ManageDAO();
    private ManageDAO() {}

    /**
     * Thêm nguòi dùng mới.
     * @param user  người dùng cần thêm
     */
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
    public static ManageDAO getManageDAO() {
        return manageDao;
    }

    /**
     * Lấy người dùng bằng tên.
     * @param username tên người dùng cần lấy thông tin
     * @return 
     */
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

    /**
     * Lấy người dùng thông qua id.
     * @param userID id
     * @return người dùng
     */
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

    /**
     * Cập nhật thong tin người dung.
     * @param user người dùng mới
     */
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

    /**
     * Xoá người dùng.
     * @param userID  id cần xoá
     */
    public void removeUser (int userID) {
        String sql = "DELETE FROM User WHERE userID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lấy toàn bộ danh sách người dùng.
     * @return danh sách
     */
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

    /**
     * Cập nhật thông tin.
     * @param user user mới
     * @param fieldName 
     * @param newValue 
     */
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