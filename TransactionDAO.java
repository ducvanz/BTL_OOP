package BTLOOP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private final Connection connection;

    public TransactionDAO() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
        User user = LoginPanel.userOverAll;
        user.setBorrowedList( getReturnedBooksByUser(user));
        user.setLoanList(getBorrowedBooksByUser(user));
        System.out.println("1");
        user.displayUserInfo();

    }

    // Hàm để lấy danh sách các Transaction đã mượn theo tên người dùng
    public ArrayList<Transaction> getReturnedBooksByUser (User user) {
        ArrayList<Transaction> returnedTransactions = new ArrayList<>();
        String sql = "SELECT title, borrowedDate, returnDate FROM TRANSACTION WHERE name = ? AND status = 'returned'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String borrowedDate = resultSet.getString("borrowedDate");
                String returnedDate = resultSet.getString("returnDate");
                Transaction transaction = new Transaction(user, title, borrowedDate, returnedDate, "returned");
                returnedTransactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedTransactions;
    }

    // Hàm để lấy danh sách các Transaction đang mượn theo tên người dùng
    public ArrayList<Transaction> getBorrowedBooksByUser (User user) {
        ArrayList<Transaction> borrowedTransactions = new ArrayList<>();
        String sql = "SELECT title, borrowedDate, returnDate FROM TRANSACTION WHERE name = ? AND status = 'borrowed'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String borrowedDate = resultSet.getString("borrowedDate");
                String returnedDate = resultSet.getString("returnDate");
                Transaction transaction = new Transaction(user, title, borrowedDate, returnedDate, "borrowed");
                borrowedTransactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowedTransactions;
    }

    // Hàm để thêm một transaction
    public boolean addTransaction(Transaction transaction) {
        String sql = "INSERT INTO TRANSACTION (name, title, borrowedDate, returnDate, status) VALUES (?, ?, ?, ?, ?)";
        System.out.println("2");
        System.out.println("1");
        transaction.getUser().displayUserInfo();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, transaction.getUser().getName());
            preparedStatement.setString(2, transaction.getTitle());
            preparedStatement.setString(3, transaction.getBorrowedDate());
            preparedStatement.setString(4, transaction.getReturnedDate());
            preparedStatement.setString(5, "borrowed");
            int rowsAffected = preparedStatement.executeUpdate();

            // Cập nhật số lượng sách trong bảng document
            String sql2 = "UPDATE document SET quantity = quantity - 1 WHERE title = ?";
            try (PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
                preparedStatement2.setString(1, transaction.getTitle());
                rowsAffected = preparedStatement2.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Hàm để cập nhật trạng thái của transaction thành 'returned' theo name và title
    public boolean returnTransaction(Transaction transaction) {
        String sql = "UPDATE TRANSACTION SET status = 'returned' WHERE name = ? AND title = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, transaction.getUser ().getName());
            preparedStatement.setString(2, transaction.getTitle());
            int rowsAffected = preparedStatement.executeUpdate();
            String sql2 = "UPDATE document SET quantity = quantity + 1 WHERE title = ?";
            try (PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)) {
                preparedStatement2.setString(1, transaction.getTitle());
                rowsAffected = preparedStatement2.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}