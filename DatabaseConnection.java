/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

/**
 *
 * @author thinh
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnection {

    // Kết nối với MySQL
    private static final String URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12739033"; 
    private static final String USER = "sql12739033"; 
    private static final String PASSWORD = "IrDju4s9qc"; 
    
    public void connectDatabase() {
        getConnection();
    }
    
    public  Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối csdl thành công!");
        } catch (SQLException e) {
            System.out.println("Kết nối csdl thất bại!");
            e.printStackTrace();
        }
        return connection;
    }
    /*
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "SELECT userID, userName, email, phone, birthday, address, loanTerm, numberBorrowed FROM User";

        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String userID = resultSet.getString("userID");
                String userName = resultSet.getString("userName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String birthday = resultSet.getString("birthday");
                String address = resultSet.getString("address");
                boolean loanTerm = resultSet.getBoolean("loanTerm");
                int numberBorrowed = resultSet.getInt("numberBorrowed");

                // Tạo đối tượng User và thêm vào danh sách
                User user = new User(userID, userName, email, phone, birthday, address, loanTerm, numberBorrowed);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    */

    public ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "SELECT b.ISBN, d.documentID, d.title, d.author, d.publisher, d.yearPublished, d.quantity, d.category, d.language " +
                     "FROM Book b INNER JOIN Document d ON b.documentID = d.documentID";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String ISBN = resultSet.getString("ISBN");
                String documentID = resultSet.getString("documentID");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                int yearPublished = resultSet.getInt("yearPublished");
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");
                String language = resultSet.getString("language");

                Book book = new Book(ISBN, documentID, title, author, publisher, yearPublished, quantity, category, language);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
    
    public ArrayList<Thesis> getThesis() {
        ArrayList<Thesis> theses = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "SELECT t.degree, t.university, d.documentID, d.title, d.author, d.publisher, d.yearPublished, d.quantity, d.category, d.language " +
                     "FROM Thesis t INNER JOIN Document d ON t.documentID = d.documentID";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String degree = resultSet.getString("degree");
                String university = resultSet.getString("university");
                String documentID = resultSet.getString("documentID");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                int yearPublished = resultSet.getInt("yearPublished");
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");
                String language = resultSet.getString("language");

                Thesis thesis = new Thesis(degree, university, documentID, title, author, publisher, yearPublished, quantity, category, language);
                theses.add(thesis);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return theses;
    }

    public ArrayList<Newspaper> getNewspaper() {
        ArrayList<Newspaper> newspapers = new ArrayList<>();
        Connection connection = getConnection();
        String sql = "SELECT n.date, n.ISBN, d.documentID, d.title, d.author, d.publisher, d.yearPublished, d.quantity, d.category, d.language " +
                     "FROM Newspaper n INNER JOIN Document d ON n.documentID = d.documentID";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String ISBN = resultSet.getString("ISBN");
                String documentID = resultSet.getString("documentID");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                int yearPublished = resultSet.getInt("yearPublished");
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");
                String language = resultSet.getString("language");

                Newspaper newspaper = new Newspaper(date, ISBN, documentID, title, author, publisher, yearPublished, quantity, category, language);
                newspapers.add(newspaper);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newspapers;
    }
}
