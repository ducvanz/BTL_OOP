/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main.models.document;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author thinh
 */
public class Book extends Document {
    private String ISBN;

    public Book(String title, String author, String publisher, String publishedDate, int quantity,
                     String category, String language, String description, String imageLink, String ISBN) {
        super(title, author, publisher, publishedDate, quantity, category, language, description, imageLink);
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
    public void getInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Published Date: " + getPublishedDate());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Category: " + getCategory());
        System.out.println("Language: " + getLanguage());
        System.out.println("Description: " + getDescription());
        System.out.println("Image Link: " + getImageLink());
        System.out.println("ISBN: " + getISBN());
    }
    
    @Override
    public String toString(){
        return (this.getTitle() + " - " + this.getAuthor());
    }
    
    /**
     * Tìm kiếm tài liệu từ cơ sở dữ liệu dùng id.
     * @param con biến kết nối db
     * @param title tên sách
     * @param author tác giả
     * @param isbn mã
     * @param publisher
     * @param yearPublished
     * @param category
     * @param language
     * @return danh sách tài liệu phù hợp
     */
    public List<Book> searchBooks(Connection con, String title, String author, String isbn, 
            String publisher, String yearPublished, String category, String language) {
        List<Book> books = new ArrayList<>();
        try {
            // Xây dựng câu truy vấn SQL với các điều kiện động
            StringBuilder query = new StringBuilder("SELECT * FROM document join book on document.documentID = book.ID WHERE 1=1");

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
                query.append(" AND publishedDate = ?");
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
                book.setPublishedDate(rs.getString("publishedDate"));
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
    
    /**
     * Thêm tài liệu vào cơ sở dữ liệu.
     * @param con biến kết nối
     * @param book sách cần thêm
     */
    public void addBook(Connection con, Book book) {
        String insertBookQuery = "INSERT INTO document (documentID, title, author, publisher, publishedDate, quantity, language, category, description) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(book.getImageLink());

        String insertDocumentQuery = "INSERT INTO book (ID, ISBN) VALUES (?, ?)";
        String getMaxDocumentIDQuery = "SELECT MAX(documentID) FROM document";

        try {
            // Bắt đầu giao dịch
            con.setAutoCommit(false);

            int newDocumentID = 1; // Mặc định là 1 nếu bảng trống

            // Lấy giá trị documentID lớn nhất
            try (PreparedStatement stmt = con.prepareStatement(getMaxDocumentIDQuery);
                 ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    // Nếu có giá trị MAX, cộng thêm 1
                    newDocumentID = rs.getInt(1) + 1;
                }
            }

            // Thêm sách vào bảng `document`
            try (PreparedStatement bookStmt = con.prepareStatement(insertBookQuery)) {
                bookStmt.setInt(1, newDocumentID);
                bookStmt.setString(2, book.getTitle());
                bookStmt.setString(3, book.getAuthor());
                bookStmt.setString(4, book.getPublisher());
                bookStmt.setString(5, book.getPublishedDate());
                bookStmt.setInt(6, book.getQuantity());
                bookStmt.setString(7, book.getLanguage());
                bookStmt.setString(8, book.getCategory());
                bookStmt.setString(9, book.getDescription());
                //bookStmt.setString(10, book.getImageLink());

                bookStmt.executeUpdate();
            }

            // Thêm dữ liệu vào bảng `book`
            try (PreparedStatement docStmt = con.prepareStatement(insertDocumentQuery)) {
                docStmt.setInt(1, newDocumentID);
                docStmt.setString(2, book.getISBN());
                docStmt.executeUpdate();
            }

            // Commit giao dịch
            con.commit();
            System.out.println("Book and document added successfully!");

        } catch (SQLException e) {
            // Rollback nếu có lỗi
            try {
                con.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // Đặt lại chế độ auto-commit
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    
}
