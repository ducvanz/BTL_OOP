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
import java.util.Random;
import java.util.Set;

public class TransactionDAO {
    private final Connection connection;
    ManageDAO manageDAO;
    DocumentDAO documentDAO;
    User user = new User();

    public TransactionDAO() {
        connection = DatabaseConnection.con;
        user = LoginPanel.userOverAll;
        user.setBorrowedList(getReturnedDocumentByUser(user.getID()));
        user.setLoanList(getBorrowedDocumentByUser(user.getID()));
        manageDAO = new ManageDAO();
        documentDAO = new DocumentDAO();
    }

    // Hàm để lấy tài liệu đã mượn theo tên người dùng
    public ArrayList<Transaction> getReturnedDocumentByUser(int userID) {
        ArrayList<Transaction> returnedTransactions = new ArrayList<>();
        String sql = "SELECT transactionID, documentID, borrowedDate, returnedDate, status FROM TRANSACTION WHERE userID = ? AND status = 'returned'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int transactionID = resultSet.getInt("transactionID");
                int documentID = resultSet.getInt("documentID");
                String borrowedDate = resultSet.getString("borrowedDate");
                String returnedDate = resultSet.getString("returnedDate");
                String status = resultSet.getString("status");
                Transaction transaction = new Transaction(transactionID, userID, documentID, borrowedDate, returnedDate, status);
                returnedTransactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedTransactions;
    }
    

    // Hàm để lấy danh sách tài liệu đang mượn theo tên người dùng
    public ArrayList<Transaction> getBorrowedDocumentByUser(int userID) {
        ArrayList<Transaction> borrowedTransactions = new ArrayList<>();
        String sql = "SELECT transactionID, documentID, borrowedDate, returnedDate, status FROM TRANSACTION WHERE userID = ? AND status = 'borrowed'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int transactionID = resultSet.getInt("transactionID");
                int documentID = resultSet.getInt("documentID");
                String borrowedDate = resultSet.getString("borrowedDate");
                String returnedDate = resultSet.getString("returnedDate");
                String status = resultSet.getString("status");
                Transaction transaction = new Transaction(transactionID, userID, documentID, borrowedDate, returnedDate, status);
                borrowedTransactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrowedTransactions;
    }
    

    public boolean addTransaction(Transaction transaction) {
        String sql = "INSERT INTO TRANSACTION (userID, documentID, borrowedDate, returnedDate, status) VALUES (?, ?, ?, ?, ?)";
        String updateUserSql = "UPDATE user SET numberBorrowed = numberBorrowed + 1 WHERE userID = ?";
        String updateDocumentSql = "UPDATE document SET quantity = quantity - 1 WHERE documentID = ?";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, transaction.getUserID());
            preparedStatement.setInt(2, transaction.getDocumentID());
            preparedStatement.setString(3, transaction.getBorrowedDate());
            preparedStatement.setString(4, transaction.getReturnedDate());
            preparedStatement.setString(5, transaction.getStatus());
            int rowsAffected = preparedStatement.executeUpdate();
    
            // Giảm số lượng tài liệu
            try (PreparedStatement preparedStatement2 = connection.prepareStatement(updateDocumentSql)) {
                preparedStatement2.setInt(1, transaction.getDocumentID());
                preparedStatement2.executeUpdate();
            }
    
            // Tăng số lượng sách mượn của người dùng
            try (PreparedStatement preparedStatement3 = connection.prepareStatement(updateUserSql)) {
                preparedStatement3.setInt(1, transaction.getUserID());
                preparedStatement3.executeUpdate();
            }
    
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    

    // Hàm để cập nhật trạng thái của transaction thành 'returned' theo name và title
    public boolean returnTransaction(int transactionID, int userID, int documentID) {
        String sql = "UPDATE TRANSACTION SET status = 'returned', returnedDate = CURRENT_DATE WHERE transactionID = ?";
        String updateUserSql = "UPDATE user SET numberBorrowed = numberBorrowed - 1 WHERE userID = ?";
        String updateDocumentSql = "UPDATE document SET quantity = quantity + 1 WHERE documentID = ?";
    
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, transactionID);
            int rowsAffected = preparedStatement.executeUpdate();
    
            // Tăng số lượng tài liệu
            try (PreparedStatement preparedStatement2 = connection.prepareStatement(updateDocumentSql)) {
                preparedStatement2.setInt(1, documentID);
                preparedStatement2.executeUpdate();
            }
    
            // Giảm số lượng sách mượn của người dùng
            try (PreparedStatement preparedStatement3 = connection.prepareStatement(updateUserSql)) {
                preparedStatement3.setInt(1, userID);
                preparedStatement3.executeUpdate();
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
        }
        System.out.println("CHAY VAO DAY ROI");
        return topDocuments;
    }
    
    public ArrayList<Document> getTopDocumentForUser(User user) {
        ArrayList<Integer> documentIds = new ArrayList<>();
        String sql = "SELECT documentID FROM TRANSACTION " +
                    "WHERE userID <> ? " + // Lọc những giao dịch không phải của người dùng này
                    "AND documentID NOT IN (SELECT documentID FROM TRANSACTION WHERE userID = ?) " + // Tài liệu chưa mượn bởi người dùng này
                    "GROUP BY documentID " +
                    "ORDER BY COUNT(documentID) DESC LIMIT 6"; // Chỉ lấy 6 tài liệu được mượn nhiều nhất
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getID());  // userID là của người dùng hiện tại
            preparedStatement.setInt(2, user.getID());  // userID để lọc các tài liệu người dùng này đã mượn
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int documentID = resultSet.getInt("documentID");
                documentIds.add(documentID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<Document> allDocuments = documentDAO.getAllDocuments();  // Lấy tất cả các tài liệu
        ArrayList<Document> resultDocuments = new ArrayList<>();

        // Sử dụng HashSet để kiểm tra nhanh sự tồn tại của documentID
        Set<Integer> documentIdSet = new HashSet<>(documentIds);

        // Lọc các tài liệu có documentID nằm trong danh sách documentIds
        for (Document document : allDocuments) {
            if (documentIdSet.contains(document.getID())) {
                resultDocuments.add(document);
            }
        }

        // Nếu số lượng tài liệu ít hơn 6, thêm các tài liệu chưa mượn
        if (resultDocuments.size() < 6) {
            Set<Integer> alreadyBorrowedDocumentIds = new HashSet<>();
            
            // Thêm tài liệu chưa được mượn vào kết quả
            for (Document document : allDocuments) {
                if (!documentIdSet.contains(document.getID()) && !alreadyBorrowedDocumentIds.contains(document.getID())) {
                    resultDocuments.add(document);
                    alreadyBorrowedDocumentIds.add(document.getID());
                }
                if (resultDocuments.size() >= 6) break; // Nếu đủ 6 tài liệu, thoát vòng lặp
            }
        }

        // Nếu số lượng tài liệu vẫn chưa đủ 6, thêm tài liệu ngẫu nhiên từ thư viện
        if (resultDocuments.size() < 6) {
            Random random = new Random();
            while (resultDocuments.size() < 6) {
                Document randomDoc = allDocuments.get(random.nextInt(allDocuments.size()));
                // Kiểm tra nếu tài liệu chưa được mượn bởi người dùng và chưa có trong kết quả
                if (!documentIdSet.contains(randomDoc.getID()) && !resultDocuments.contains(randomDoc)) {
                    resultDocuments.add(randomDoc);
                }
            }
        }

        // Trả về 6 tài liệu
        return new ArrayList<>(resultDocuments.subList(0, 6));
    }    

}