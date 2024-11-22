package BTL_OOP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private final Connection connection;
    ManageDAO manageDAO;
    DocumentDAO documentDAO;
    User user = new User();

    public TransactionDAO() {
        connection = DatabaseConnection.con;
        user = LoginPanel.userOverAll;
        System.out.println(user.getName());
        user.setBorrowedList(getReturnedDocumentByUser(user));
        System.out.println("-----" + (char) user.getLoanList().size()+ "     ---------");
        user.setLoanList(getBorrowedDocumentByUser(user));
        System.out.println("****" + user.getBorrowedList().size() + "      ***");
        user.displayUserInfo();
        manageDAO = new ManageDAO();
        documentDAO = new DocumentDAO();
    }

    // Hàm để lấy tài liệu đã mượn theo tên người dùng
    public ArrayList<Transaction> getReturnedDocumentByUser (User user) {
        ArrayList<Transaction> returnedTransactions = new ArrayList<>();
        String sql = "SELECT DISTINCT title, borrowedDate, returnDate FROM TRANSACTION WHERE name = ? AND status = 'returned'";
        System.out.println("1");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("2");
                String title = resultSet.getString("title");
                String borrowedDate = resultSet.getString("borrowedDate");
                String returnedDate = resultSet.getString("returnDate");
                Transaction transaction = new Transaction(user, title, borrowedDate, returnedDate, "returned");
                System.out.print(transaction.toString());
                returnedTransactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedTransactions;
    }

    // Hàm để lấy danh sách tài liệu đang mượn theo tên người dùng
    public ArrayList<Transaction> getBorrowedDocumentByUser (User user) {
        ArrayList<Transaction> borrowedTransactions = new ArrayList<>();
        String sql = "SELECT DISTINCT title, borrowedDate, returnDate FROM TRANSACTION WHERE name = ? AND status = 'borrowed'";
        System.out.println("3");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("4");
                String title = resultSet.getString("title");
                String borrowedDate = resultSet.getString("borrowedDate");
                String returnedDate = resultSet.getString("returnDate");
                Transaction transaction = new Transaction(user, title, borrowedDate, returnedDate, "borrowed");
                System.out.print(transaction.toString());
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
        transaction.getUser().displayUserInfo();
        user.setNumberBorrowed(user.getNumberBorrowed() + 1);
        manageDAO.updateUser(user);
        
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
        user.setNumberBorrowed(user.getNumberBorrowed()  - 1);
        manageDAO.updateUser(user);
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