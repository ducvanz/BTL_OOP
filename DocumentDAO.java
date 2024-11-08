
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
public class DocumentDAO {
    private final Connection connection;

    public DocumentDAO() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        connection = dbConnection.getConnection();
    }
 
    public Document getDocumentByID(int documentID) {
        ArrayList<Document> allDocuments = getAllDocuments();
        for (Document doc : allDocuments) {
        if (Integer.parseInt(doc.getDocumentID()) == documentID) {
            return doc; // Trả về tài liệu nếu tìm thấy
        }
    }
        return null;
    }

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


    public void removeDocument(int documentID) {
        String deleteDocumentQuery = "DELETE FROM Document WHERE documentID = ?";
        String deleteBookQuery = "DELETE FROM Book WHERE documentID = ?";
        String deleteThesisQuery = "DELETE FROM Thesis WHERE documentID = ?";
        String deleteNewspaperQuery = "DELETE FROM Newspaper WHERE documentID = ?";

        try {
            // Xóa bảng con trước, sau đó mới xóa bảng Document
            try (PreparedStatement bookStmt = connection.prepareStatement(deleteBookQuery)) {
                bookStmt.setInt(1, documentID);
                bookStmt.executeUpdate();
            }

            try (PreparedStatement thesisStmt = connection.prepareStatement(deleteThesisQuery)) {
                thesisStmt.setInt(1, documentID);
                thesisStmt.executeUpdate();
            }

            try (PreparedStatement newspaperStmt = connection.prepareStatement(deleteNewspaperQuery)) {
                newspaperStmt.setInt(1, documentID);
                newspaperStmt.executeUpdate();
            }

            // Cuối cùng xóa tài liệu trong bảng Document
            try (PreparedStatement documentStmt = connection.prepareStatement(deleteDocumentQuery)) {
                documentStmt.setInt(1, documentID);
                documentStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Document> getAllDocuments() { 
        
        ArrayList<Document> documents = new ArrayList<>(); 
        String query = "SELECT d.documentID, d.title, d.author, d.publisher, d.yearPublished, d.quantity, d.category, d.language, " +
                       "b.ISBN, t.degree, t.university, n.date, n.ISBN " +
                       "FROM Document d " +
                       "LEFT JOIN Book b ON d.documentID = b.documentID " +
                       "LEFT JOIN Thesis t ON d.documentID = t.documentID " +
                       "LEFT JOIN Newspaper n ON d.documentID = n.documentID";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int documentID = resultSet.getInt("documentID");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                int yearPublished = resultSet.getInt("yearPublished");
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");
                String language = resultSet.getString("language");

                // Kiểm tra loại tài liệu và tạo đối tượng tương ứng
                if (resultSet.getString("ISBN") != null) {
                    // Tài liệu là Book
                    Book book = new Book();
                    book.setDocumentID(String.format("%06d", documentID));
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setPublisher(publisher);
                    book.setYearPublished(yearPublished);
                    book.setQuantity(quantity);
                    book.setCategory(category);
                    book.setLanguage(language);
                    book.setISBN(resultSet.getString("ISBN"));
                    documents.add(book); // Thêm vào danh sách tài liệu
                } else if (resultSet.getString("thesisID") != null) {
                    // Tài liệu là Thesis
                    Thesis thesis = new Thesis();
                    thesis.setDocumentID(String.format("%06d", documentID));
                    thesis.setTitle(title);
                    thesis.setAuthor(author);
                    thesis.setPublisher(publisher);
                    thesis.setYearPublished(yearPublished);
                    thesis.setQuantity(quantity);
                    thesis.setCategory(category);
                    thesis.setLanguage(language);
                    thesis.setDegree(resultSet.getString("degree"));
                    thesis.setUniversity(resultSet.getString("university"));
                    documents.add(thesis); // Thêm vào danh sách tài liệu
                } else if (resultSet.getString("newspaperID") != null) {
                    // Tài liệu là Newspaper
                    Newspaper newspaper = new Newspaper();
                    newspaper.setDocumentID(String.format("%06d", documentID));
                    newspaper.setTitle(title);
                    newspaper.setAuthor(author);
                    newspaper.setPublisher(publisher);
                    newspaper.setYearPublished(yearPublished);
                    newspaper.setQuantity(quantity);
                    newspaper.setCategory(category);
                    newspaper.setLanguage(language);
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    newspaper.setDate((Date) dateFormat.parse(resultSet.getString("date")));
                    newspaper.setISBN(resultSet.getString("ISBN"));
                    documents.add(newspaper); // Thêm vào danh sách tài liệu
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        } catch (ParseException ex) {
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return documents; // Trả về danh sách tài liệu 
    }
    
    
}
