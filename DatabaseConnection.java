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
    private static final String URL = "jdbc:mysql://localhost:3306/library"; // Thay "library" bằng tên database của bạn
    private static final String USER = "root"; // Tên người dùng MySQL của bạn
    private static final String PASSWORD = "maiducvan112@##"; // Mật khẩu của bạn
    private static int count = 0;
    
    public void connectDatabase() {
        getConnection();
        createTables();
        if (count == 0) {
            insertAllTable();
            count ++;
        }
    }
    
    public  Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            //System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        }
        return connection;
    }

    // Tạo các bảng trong cơ sở dữ liệu
    public void createTables() {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();

            // xoa schema neu da ton tai
//            String create = "DROP SCHEMA IF EXISTS library; "
//                    + "CREATE SCHEMA library;";
//            statement.execute(create);
            
            // Bảng User
            String createUserTable = "CREATE TABLE IF NOT EXISTS User (" +
                    "userID INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(100)," +
                    "email VARCHAR(100)," +
                    "phone VARCHAR(20)," +
                    "birthday DATE," +
                    "address VARCHAR(255)," +
                    "loanTerm BOOLEAN," +
                    "numberBorrowed INT," +
                    "userAccount VARCHAR(100), " +
                    "password VARCHAR(100)" +
                    ");";
            statement.execute(createUserTable);

            // Bảng Document
            String createDocumentTable = "CREATE TABLE IF NOT EXISTS Document (" +
                    "documentID INT PRIMARY KEY AUTO_INCREMENT," +
                    "title VARCHAR(255)," +
                    "author VARCHAR(255)," +
                    "publisher VARCHAR(255)," +
                    "yearPublished INT," +
                    "quantity INT," +
                    "category VARCHAR(100)," +
                    "language VARCHAR(50)" +
                    ");";
            statement.execute(createDocumentTable);

            // Bảng Book kế thừa Document
            String createBookTable = "CREATE TABLE IF NOT EXISTS Book (" +
                    "documentID INT," +
                    "ISBN VARCHAR(20)," +
                    "FOREIGN KEY (documentID) REFERENCES Document(documentID)" +
                    ");";
            statement.execute(createBookTable);

            // Bảng Thesis kế thừa Document
            String createThesisTable = "CREATE TABLE IF NOT EXISTS Thesis (" +
                    "documentID INT," +
                    "degree VARCHAR(100)," +
                    "university VARCHAR(100)," +
                    "FOREIGN KEY (documentID) REFERENCES Document(documentID)" +
                    ");";
            statement.execute(createThesisTable);

            // Bảng Newspaper kế thừa Document
            String createNewspaperTable = "CREATE TABLE IF NOT EXISTS Newspaper (" +
                    "documentID INT," +
                    "date DATE," +
                    "ISBN VARCHAR(13)," +
                    "FOREIGN KEY (documentID) REFERENCES Document(documentID)" +
                    ");";
            statement.execute(createNewspaperTable);

            //System.out.println("Tạo bảng thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
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



    // Chèn dữ liệu vào bảng User
    public void insertUser(String userID, String name, String email, String phone, String birthday, String address, boolean loanTerm, int numberBorrowed,String userAccount, String password) {
        Connection connection = getConnection();
        String sql = "INSERT INTO User (userID, name, email, phone, birthday, address, loanTerm, numberBorrowed, userAccount, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, userID);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, birthday);
            statement.setString(6, address);
            statement.setBoolean(7, loanTerm);
            statement.setInt(8, numberBorrowed);
            statement.setString(9, userAccount);
            statement.setString(10, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                //System.out.println("Thêm người dùng thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     // Hàm ghi thông tin vào bảng Document
    public void insertDocument(String title, String author, String publisher, int yearPublished, int quantity, String category, String language) {
        Connection connection = getConnection();
        String sql = "INSERT INTO Document (title, author, publisher, yearPublished, quantity, category, language) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, publisher);
            statement.setInt(4, yearPublished);
            statement.setInt(5, quantity);
            statement.setString(6, category);
            statement.setString(7, language);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm tài liệu thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hàm ghi thông tin vào bảng Book
    public void insertBook(int documentID, String ISBN) {
        Connection connection = getConnection();
        String sql = "INSERT INTO Book (documentID, ISBN) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, documentID);
            statement.setString(2, ISBN);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm sách thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    // Hàm ghi thông tin vào bảng Thesis
    public void insertThesis(int documentID, String degree, String university) {
        Connection connection = getConnection();
        String sql = "INSERT INTO Thesis (documentID, degree, university) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, documentID);
            statement.setString(2, degree);
            statement.setString(3, university);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm luận văn thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Hàm ghi thông tin vào bảng Newspaper
    public void insertNewspaper(int documentID, String date, String ISBN) {
        Connection connection = getConnection();
        String sql = "INSERT INTO Newspaper (documentID, date, ISBN) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, documentID);
            statement.setDate(2, java.sql.Date.valueOf(date)); // Chuyển đổi chuỗi sang kiểu Date
            statement.setString(3, ISBN);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Thêm báo thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void insertAllTable(){
        insertUser("23020000", "Nguyen Van A", "nva@gmail.com", "0987654321", "1990-01-15", "Ha Noi", true, 3,"Account1", "password1");
        insertUser("23020001", "Tran Thi B", "ttb@gmail.com", "0912345678", "1992-05-20", "Da Nang", false, 1,"Account2", "password2");
        insertUser("23020002", "Le Van C", "lvc@gmail.com", "0909876543", "1995-09-10", "Ho Chi Minh", true, 4,"Account3", "password3");
        insertUser("23020003", "Pham Thi D", "ptd@gmail.com", "0932456789", "1998-03-25", "Can Tho", true, 2,"Account4", "password4");
        insertUser("23020004", "Nguyen Thi E", "nte@gmail.com", "0981234567", "2000-12-01", "Hue", false, 0,"Account5", "password5");
        insertUser("23020005", "Hoang Van F", "hvf@gmail.com", "0973456789", "1988-07-17", "Ha Noi", true, 5,"Account6", "password6");
        insertUser("23020006", "Bui Thi G", "btg@gmail.com", "0921456789", "1991-04-08", "Hai Phong", false, 2,"Account7", "password7");
        insertUser("23020007", "Vo Van H", "vvh@gmail.com", "0918765432", "1985-11-23", "Da Nang", true, 6,"Account8", "password8");
        insertUser("23020008", "Do Thi I", "dti@gmail.com", "0938765432", "1983-08-14", "Ho Chi Minh", false, 3,"Account9", "password9");
        insertUser("23020009", "Ly Van J", "lvj@gmail.com", "0906785432", "1997-06-29", "Ha Noi", true, 1,"Account10", "password10");

        insertDocument("Don Quixote", "Miguel de Cervantes", "Francisco de Robles", 1605, 10, "Novel", "Spanish");
        insertDocument("Chi Pheo", "Nam Cao", "Tao Dan", 1941, 15, "Novel", "Vietnamese");
        insertDocument("Pride and Prejudice", "Jane Austen", "T. Egerton", 1813, 12, "Novel", "English");
        insertDocument("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 1925, 10, "Novel", "English");
        insertDocument("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, 8, "Novel", "English");
        insertDocument("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Bloomsbury", 1997, 20, "Fantasy", "English");
        insertDocument("Nha Gia Kim", "Paulo Coelho", "HarperCollins", 1988, 7, "Novel", "Portuguese");
        insertDocument("Dac Nhan Tam", "Dale Carnegie", "Simon & Schuster", 1936, 18, "Self-help", "English");
        insertDocument("The Lord of the Rings", "J.R.R. Tolkien", "George Allen & Unwin", 1954, 9, "Fantasy", "English");
        insertDocument("Doi Thua", "Vu Trong Phung", "Tinh Hoa", 1937, 6, "Novel", "Vietnamese");

        // Báo nổi tiếng Việt Nam và thế giới
        insertDocument("New York Times", "New York Times Company", "NYT Publisher", 1851, 25, "Newspaper", "English");
        insertDocument("Tuoi Tre", "Tuoi Tre News", "Tuoi Tre Publisher", 1975, 20, "Newspaper", "Vietnamese");
        insertDocument("The Guardian", "Guardian Media Group", "Guardian Publisher", 1821, 18, "Newspaper", "English");
        insertDocument("Vietnam News", "Vietnam News Agency", "Vietnam News Publisher", 1991, 10, "Newspaper", "Vietnamese");
        insertDocument("Le Monde", "Le Monde Group", "Le Monde Publisher", 1944, 15, "Newspaper", "French");

        // Thêm tài liệu khác (luận văn, báo cáo, sách khoa học...)
        insertDocument("Machine Learning Thesis", "John Doe", "MIT", 2020, 5, "Thesis", "English");
        insertDocument("Quantum Computing Report", "Alice Johnson", "Stanford University", 2018, 5, "Thesis", "English");
        insertDocument("Blockchain Technology", "Satoshi Nakamoto", "Crypto Publisher", 2009, 8, "Report", "English");
        insertDocument("Economic Development in Vietnam", "Pham Van A", "VNU", 2015, 10, "Thesis", "Vietnamese");
        insertDocument("Vietnam History Overview", "Tran Quoc Bao", "VNU", 2012, 7, "Thesis", "Vietnamese");

        insertBook(1, "978-3-16-148410-0");
        insertBook(2, "978-0-13-235088-4");
        insertBook(3, "978-0-7432-7356-5");
        insertBook(4, "978-0-316-76948-0");
        insertBook(5, "978-0-06-112008-4");
        insertBook(6, "978-0-439-06486-6");
        insertBook(7, "978-0-06-251140-9");
        insertBook(8, "978-0-7432-6419-7");
        insertBook(9, "978-0-261-10236-3");
        insertBook(10, "978-604-951-854-9");

        insertThesis(16, "Master", "MIT");
        insertThesis(17, "PhD", "Stanford University");
        insertThesis(18, "PhD", "Harvard University");
        insertThesis(19, "Master", "Hanoi University of Science and Technology");
        insertThesis(20, "Bachelor", "University of Economics Ho Chi Minh City");

        insertNewspaper(11, "2023-10-01", "1234-5678");
        insertNewspaper(12, "2024-01-15", "2345-6789");
        insertNewspaper(13, "2023-12-31", "3456-7890");
        insertNewspaper(14, "2023-11-20", "4567-8901");
        insertNewspaper(15, "2023-10-10", "5678-9012");
    }
}
