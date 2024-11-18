/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import BTL_OOP.DatabaseConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class Book extends Document {
    private String ISBN;

    
    public Book(String ISBN, String documentID, String title, String author, String publisher, int yearPublished, int quantity, String category, String language) {
        super(documentID, title, author, publisher, yearPublished, quantity, category, language);
        this.ISBN = ISBN;
    }

    public Book(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public Book() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public void displayDocumentInfor() {
        super.displayDocumentInfor(); 
        System.out.println("ISBN " + ISBN);
        
    }
    
    /**
     *
     * @param con
     * @param title
     * @param author
     * @param isbn
     * @param publisher
     * @param yearPublished
     * @param category
     * @param language
     * @return
     */
    public List<Book> searchBooks(Connection con, String title, String author, String isbn, 
            String publisher, String yearPublished, String category, String language) {
        List<Book> books = new ArrayList<>();
        try {
            // Xây dựng câu truy vấn SQL với các điều kiện động
            StringBuilder query = new StringBuilder("SELECT * FROM document join book using (documentID) WHERE 1=1");

            // Thêm điều kiện nếu tham số không rỗng
            if (!title.isEmpty()) {
                query.append(" AND title LIKE ?");
            }
            if (!author.isEmpty()) {
                query.append(" AND author LIKE ?");
            }
            if (!isbn.isEmpty()) {
                query.append(" AND isbn = ?");
            }
            if (!publisher.isEmpty()) {
                query.append(" AND publisher LIKE ?");
            }
            if (!yearPublished.isEmpty()) {
                query.append(" AND yearPublished = ?");
            }
            if (!category.isEmpty()) {
                query.append(" AND category LIKE ?");
            }
            if (!language.isEmpty()) {
                query.append(" AND language = ?");
            }

            PreparedStatement stmt = con.prepareStatement(query.toString());

            // Đặt giá trị tham số vào PreparedStatement
            int paramIndex = 1;
            if (!title.isEmpty()) {
                stmt.setString(paramIndex++, "%" + title + "%");
            }
            if (!author.isEmpty()) {
                stmt.setString(paramIndex++, "%" + author + "%");
            }
            if (!isbn.isEmpty()) {
                stmt.setString(paramIndex++, isbn);
            }
            if (!publisher.isEmpty()) {
                stmt.setString(paramIndex++, "%" + publisher + "%");
            }
            if (!yearPublished.isEmpty()) {
                stmt.setString(paramIndex++, yearPublished);
            }
            if (!category.isEmpty()) {
                stmt.setString(paramIndex++, "%" + category + "%");
            }
            if (!language.isEmpty()) {
                stmt.setString(paramIndex++, language);
            }

            // Thực thi truy vấn
            ResultSet rs = stmt.executeQuery();

            // Duyệt qua kết quả và thêm vào danh sách sách
            while (rs.next()) {
                Book book = new Book();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setISBN(rs.getString("isbn"));
                book.setPublisher(rs.getString("publisher"));
                book.setYearPublished(Integer.parseInt(rs.getString("yearPublished")));
                book.setCategory(rs.getString("category"));
                book.setLanguage(rs.getString("language"));
                books.add(book);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Trả về danh sách sách, nếu không có sách nào thì trả về danh sách rỗng
        return books;
    }
    
    public void addBook(Connection con, Book book) {
        
    }


    
}
