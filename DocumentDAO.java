/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        
    }

    @Override
    public void removeDocument(int documentID) {
    }

    @Override
    public void updateDocument(Document doc) {
    }

    
    @Override
    public ArrayList<Document> getAllDocuments() { 
        return null;
    }
    
    
}
