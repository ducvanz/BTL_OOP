
package BTL_OOP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thinh
 */
public class DocumentDAO implements IDocumentDAO {
    private final Connection connection;

    public DocumentDAO() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
    }
 
    @Override
    public Document getDocumentByID(int documentID) {
        Document document = null; // Khởi tạo tài liệu

        // Truy vấn để kiểm tra nếu tài liệu là một Book
        String bookQuery = "SELECT d.documentID, d.title, d.author, d.publisher, d.yearPublished, " +
                           "d.quantity, d.category, d.language, b.ISBN " +
                           "FROM Document d LEFT JOIN Book b ON d.documentID = b.documentID " +
                           "WHERE d.documentID = ?";

        // Truy vấn để kiểm tra nếu tài liệu là một Thesis
        String thesisQuery = "SELECT d.documentID, d.title, d.author, d.publisher, d.yearPublished, " +
                             "d.quantity, d.category, d.language, t.degree, t.university " +
                             "FROM Document d LEFT JOIN Thesis t ON d.documentID = t.documentID " +
                             "WHERE d.documentID = ?";

        // Truy vấn để kiểm tra nếu tài liệu là một Newspaper
        String newspaperQuery = "SELECT d.documentID, d.title, d.author, d.publisher, d.yearPublished, " +
                                "d.quantity, d.category, d.language, n.date, n.ISBN" +
                                "FROM Document d LEFT JOIN Newspaper n ON d.documentID = n.documentID " +
                                "WHERE d.documentID = ?";

        try (PreparedStatement statement = connection.prepareStatement(bookQuery)) {
            statement.setInt(1, documentID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Nếu tìm thấy tài liệu là Book
                    Book book = new Book();
                    book.setDocumentID(String.format("%06d", resultSet.getInt("documentID")));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setPublisher(resultSet.getString("publisher"));
                    book.setYearPublished(resultSet.getInt("yearPublished"));
                    book.setQuantity(resultSet.getInt("quantity"));
                    book.setCategory(resultSet.getString("category"));
                    book.setLanguage(resultSet.getString("language"));
                    book.setISBN(resultSet.getString("ISBN"));
                    document = book; // Gán document là book
                    return document; // Trả về ngay nếu là Book
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi
        }

        try (PreparedStatement statement = connection.prepareStatement(thesisQuery)) {
            statement.setInt(1, documentID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Nếu tìm thấy tài liệu là Thesis
                    Thesis thesis = new Thesis();
                    thesis.setDocumentID(String.format("%06d", resultSet.getInt("documentID")));
                    thesis.setTitle(resultSet.getString("title"));
                    thesis.setAuthor(resultSet.getString("author"));
                    thesis.setPublisher(resultSet.getString("publisher"));
                    thesis.setYearPublished(resultSet.getInt("yearPublished"));
                    thesis.setQuantity(resultSet.getInt("quantity"));
                    thesis.setCategory(resultSet.getString("category"));
                    thesis.setLanguage(resultSet.getString("language"));
                    thesis.setDegree(resultSet.getString("degree"));
                    thesis.setUniversity(resultSet.getString("university"));
                    document = thesis; // Gán document là thesis
                    return document; // Trả về ngay nếu là Thesis
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi
        }

        try (PreparedStatement statement = connection.prepareStatement(newspaperQuery)) {
            statement.setInt(1, documentID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Nếu tìm thấy tài liệu là Newspaper
                    Newspaper newspaper = new Newspaper();
                    newspaper.setDocumentID(String.format("%06d", resultSet.getInt("documentID")));
                    newspaper.setTitle(resultSet.getString("title"));
                    newspaper.setAuthor(resultSet.getString("author"));
                    newspaper.setPublisher(resultSet.getString("publisher"));
                    newspaper.setYearPublished(resultSet.getInt("yearPublished"));
                    newspaper.setQuantity(resultSet.getInt("quantity"));
                    newspaper.setCategory(resultSet.getString("category"));
                    newspaper.setLanguage(resultSet.getString("language"));
                    newspaper.setDate(resultSet.getDate("date"));
                    newspaper.setISBN(resultSet.getString("ISBN"));
                    document = newspaper; // Gán document là newspaper
                    return document; // Trả về ngay nếu là Newspaper
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi
        }

        return document; // Trả về null nếu không tìm thấy
    }

    
    @Override
    public void addDocument(Document doc) {
        String insertDocumentQuery = "INSERT INTO Document (title, author, publisher, yearPublished, quantity, category, language) " +
                                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        String insertBookQuery = "INSERT INTO Book (documentID, ISBN) VALUES (?, ?)";
        String insertThesisQuery = "INSERT INTO Thesis (documentID, degree, university) VALUES (?, ?, ?)";
        String insertNewspaperQuery = "INSERT INTO Newspaper (documentID, date, ISBN) VALUES (?, ?, ?)";

        try (PreparedStatement documentStmt = connection.prepareStatement(insertDocumentQuery, Statement.RETURN_GENERATED_KEYS)) {
            
            // Thêm vào bảng Document
            documentStmt.setString(1, doc.getTitle());
            documentStmt.setString(2, doc.getAuthor());
            documentStmt.setString(3, doc.getPublisher());
            documentStmt.setInt(4, doc.getYearPublished());
            documentStmt.setInt(5, doc.getQuantity());
            documentStmt.setString(6, doc.getCategory());
            documentStmt.setString(7, doc.getLanguage());

            documentStmt.executeUpdate();

            // Lấy documentID vừa được tạo
            ResultSet generatedKeys = documentStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int documentID = generatedKeys.getInt(1);

                // Thêm vào bảng con dựa trên loại tài liệu
                if (doc instanceof Book) {
                    Book book = (Book) doc;
                    try (PreparedStatement bookStmt = connection.prepareStatement(insertBookQuery)) {
                        bookStmt.setInt(1, documentID);
                        bookStmt.setString(2, book.getISBN());
                        bookStmt.executeUpdate();
                    }
                } else if (doc instanceof Thesis) {
                    Thesis thesis = (Thesis) doc;
                    try (PreparedStatement thesisStmt = connection.prepareStatement(insertThesisQuery)) {
                        thesisStmt.setInt(1, documentID);
                        thesisStmt.setString(2, thesis.getDegree());
                        thesisStmt.setString(3, thesis.getUniversity());
                        thesisStmt.executeUpdate();
                    }
                } else if (doc instanceof Newspaper) {
                    Newspaper newspaper = (Newspaper) doc;
                    try (PreparedStatement newspaperStmt = connection.prepareStatement(insertNewspaperQuery)) {
                        newspaperStmt.setInt(1, documentID);
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                        newspaperStmt.setDate(2, (Date) dateFormat.parse(newspaper.getDate()));
                        newspaperStmt.setString(3, newspaper.getISBN());
                        newspaperStmt.executeUpdate();
                    } catch (ParseException ex) {
                        Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDocument(Document doc) {
        String updateDocumentQuery = "UPDATE Document SET title = ?, author = ?, publisher = ?, " +
                                     "yearPublished = ?, quantity = ?, category = ?, language = ? " +
                                     "WHERE documentID = ?";

        String updateBookQuery = "UPDATE Book SET ISBN = ? WHERE documentID = ?";
        String updateThesisQuery = "UPDATE Thesis SET degree = ?, university = ? WHERE documentID = ?";
        String updateNewspaperQuery = "UPDATE Newspaper SET date = ?, ISBN = ? WHERE documentID = ?";

        try (PreparedStatement documentStmt = connection.prepareStatement(updateDocumentQuery)) {
            // Cập nhật thông tin bảng Document
            documentStmt.setString(1, doc.getTitle());
            documentStmt.setString(2, doc.getAuthor());
            documentStmt.setString(3, doc.getPublisher());
            documentStmt.setInt(4, doc.getYearPublished());
            documentStmt.setInt(5, doc.getQuantity());
            documentStmt.setString(6, doc.getCategory());
            documentStmt.setString(7, doc.getLanguage());
            documentStmt.setInt(8, Integer.parseInt(doc.getDocumentID())); // Sử dụng documentID để cập nhật
            documentStmt.executeUpdate();

            // Cập nhật bảng con dựa trên loại tài liệu
            if (doc instanceof Book) {
                Book book = (Book) doc;
                try (PreparedStatement bookStmt = connection.prepareStatement(updateBookQuery)) {
                    bookStmt.setString(1, book.getISBN());
                    bookStmt.setInt(2, Integer.parseInt(book.getDocumentID())); // Sử dụng documentID
                    bookStmt.executeUpdate();
                }
            } else if (doc instanceof Thesis) {
                Thesis thesis = (Thesis) doc;
                try (PreparedStatement thesisStmt = connection.prepareStatement(updateThesisQuery)) {
                    thesisStmt.setString(1, thesis.getDegree());
                    thesisStmt.setString(2, thesis.getUniversity());
                    thesisStmt.setInt(3, Integer.parseInt(thesis.getDocumentID())); // Sử dụng documentID
                    thesisStmt.executeUpdate();
                }
            } else if (doc instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) doc;
                try (PreparedStatement newspaperStmt = connection.prepareStatement(updateNewspaperQuery)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                    newspaperStmt.setDate(1, (Date) dateFormat.parse(newspaper.getDate()));
                    newspaperStmt.setString(2, newspaper.getISBN());
                    newspaperStmt.setInt(3, Integer.parseInt(newspaper.getDocumentID())); // Sử dụng documentID
                    newspaperStmt.executeUpdate();
                } catch (ParseException ex) {
                    Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void removeDocument(int documentID) {
        
    }

    
    @Override
    public ArrayList<Document> getAllDocuments() { 
        return null;
    }
    
    
}
