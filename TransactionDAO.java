package BTL_OOP;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TransactionDAO {
    private final Connection connection;
    ManageDAO manageDAO;
    DocumentDAO documentDAO;
    User user = new User();

    public TransactionDAO() {
        connection = DatabaseConnection.con;
        user = LoginPanel.userOverAll;
        user.setBorrowedList(getReturnedDocumentByUser(user));
        user.setLoanList(getBorrowedDocumentByUser(user));
        manageDAO = new ManageDAO();
        documentDAO = new DocumentDAO();
    }

    // Hàm để lấy tài liệu đã mượn theo tên người dùng
    public ArrayList<Transaction> getReturnedDocumentByUser (User user) {
        ArrayList<Transaction> returnedTransactions = new ArrayList<>();
        String sql = "SELECT DISTINCT title, borrowedDate, returnDate FROM TRANSACTION WHERE name = ? AND status = 'returned'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
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
    
    public ArrayList<Document> topDocument(User user) {
        Map<Document, Integer> count = new HashMap<>();
        
        ArrayList<Document> allDocuments = getTopDocumentForUser(user);
    
        for (Document document : allDocuments) {
            count.put(document, count.getOrDefault(document, 0) + 1);
        }
    
        // Chuyển Map thành List
        List<Map.Entry<Document, Integer>> sortedList = new ArrayList<>(count.entrySet());

        // Sắp xếp danh sách theo giá trị (giảm dần)
        sortedList.sort(new Comparator<Map.Entry<Document, Integer>>() {
            @Override
            public int compare(Map.Entry<Document, Integer> entry1, Map.Entry<Document, Integer> entry2) {
                Integer value1 = entry1.getValue();
                Integer value2 = entry2.getValue();
                return value2 - value1;
            }
        });

    
        // Lấy ra 6 tài liệu đầu tiên
        ArrayList<Document> topDocuments = new ArrayList<>();
        for (int i = 0; i < Math.min(6, sortedList.size()); i++) {
            topDocuments.add(sortedList.get(i).getKey());
        }
        for(Document doc:topDocuments){
            doc.getInfo();
            System.out.println("SÁCH+++++");
        }
        return topDocuments;
    }
    
    // Lấy danh sách các sách top tài liệu dc mượn nhiều mà ng dùng chưa từng mượn
    public ArrayList<Document> getTopDocumentForUser(User user) {
        ArrayList<String> titles = new ArrayList<>();
        String sql = "SELECT title FROM TRANSACTION " +
                     "WHERE name <> ? " +
                     "GROUP BY title " +
                     "HAVING COUNT(title) > 1 AND title NOT IN (SELECT title FROM TRANSACTION WHERE name = ?) " +
                     "ORDER BY COUNT(title) DESC LIMIT 6";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                titles.add(title);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Document> allDocuments = documentDAO.getAllDocuments();
        ArrayList<Document> resultDocuments = new ArrayList<>();

        // Sử dụng HashSet để kiểm tra nhanh sự tồn tại của title
        Set<String> titleSet = new HashSet<>(titles);

        // Lọc các tài liệu có title nằm trong danh sách titles
        for (Document document : allDocuments) {
            if (titleSet.contains(document.getTitle())) {
                resultDocuments.add(document);
            }
        }

        return resultDocuments;
    }
    

}