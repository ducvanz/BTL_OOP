package BTL_OOP.main.dao;

import BTL_OOP.main.models.document.Book;
import BTL_OOP.main.database.DatabaseConnection;
import BTL_OOP.main.models.document.Document;
import BTL_OOP.main.models.document.Newspaper;
import BTL_OOP.main.models.document.Thesis;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DocumentDAO {

    private static final Connection connection = DatabaseConnection.getDatabaseConnection().connection;
    
    public DocumentDAO() {
    }

    /**
     * trả về sách từ ID.
     * @param ID sách cần tìm
     * @return sách từ ID
     */
    public Document getDocumentByID(int ID) {
        ArrayList<Document> allDocuments = getAllDocuments();
        for (Document doc : allDocuments) {
            if (doc.getID() == ID) {
                return doc; // Trả về tài liệu nếu tìm thấy
            }
        }
        return null;
    }

//    /**
//     * Trả lại sách từ title.
//     * @param title tên scahs
//     * @return  sách cần tìm
//     */
//    public Document getDocumentByTitle(String title) {
//        ArrayList<Document> allDocuments = getAllDocuments();
//        for (Document doc : allDocuments) {
//            if (doc.getTitle().equals(title)) {
//                return doc; // Trả về tài liệu nếu tìm thấy
//            }
//        }
//        return null;
//    }
    
    /**
     * Lấy danh sách tài liệu từ cơ sở dữ liệu.
     * @param title tên sach
     * @param author tên tác giả
     * @param ISBN mã isbn
     * @param category thể loại
     * @param language ngôn ngữ
     * @return 
     */
    public static ArrayList<Document> getAllDocumentInDatabase(String title, String author, String ISBN, String category, String language) {
        ArrayList<Document> documents = new ArrayList<>();
        String query = DocumentQueryBuilder.buildQuery(title, author, ISBN, category, language);

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int index = 1;
            if (title != null && !title.isEmpty()) {
                preparedStatement.setString(index++, "%" + title + "%");
            }
            if (author != null && !author.isEmpty()) {
                preparedStatement.setString(index++, "%" + author + "%");
            }
            if (ISBN != null && !ISBN.isEmpty()) {
                preparedStatement.setString(index++, "%" + ISBN + "%");
            }
            if (category != null && !category.isEmpty()) {
                preparedStatement.setString(index++, "%" + category + "%");
            }
            if (language != null && !language.isEmpty()) {
                preparedStatement.setString(index++, "%" + language + "%");
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Thực hiện truy vấn và lấy tài liệu
                    Document document = DocumentQueryBuilder.createDocument(resultSet);
                    if (document != null) {
                        documents.add(document);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }

    // Chuyển filePath xang mảng byte
    /**
     * Chuyển ảnh sang link.
     * @param filePath link ảnh
     * @return trả về file
     */
    public byte[] getImageBytesFromUrl(String filePath) {
        if(filePath == null) return null;
        try {
            URL url = new URL(filePath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();

            InputStream input = connection.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            return output.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Trả về null nếu có lỗi
        }
    }
    
    /**
     * Lấy ảnh ra từ link trên cơ sở dữ liệu.
     * @param imageData ảnh
     * @param label load ảnh lên label này
     */
    public static void displayImageFromBytes(byte[] imageData, JLabel label) {
        if (imageData == null || imageData.length == 0) {
            label.setText("Không có dữ liệu hình ảnh.");
            return;
        }

        try {
            // Chuyển đổi byte[] thành BufferedImage
            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
            BufferedImage bufferedImage = ImageIO.read(bis);

            if (bufferedImage != null) {
                // Chuyển đổi BufferedImage thành ImageIcon
                ImageIcon imageIcon = new ImageIcon(bufferedImage);

                // Thay đổi kích thước của hình ảnh để vừa với JLabel
                Image scaledImage = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(scaledImage));  // Cập nhật icon mới
                System.out.println("Hiển thị ảnh thành công");
            } else {
                label.setText("Không thể tạo hình ảnh từ dữ liệu.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            label.setText("Lỗi khi hiển thị hình ảnh.");
        }
    }


    /**
     * Hàm thực hiện chức năng thêm sách.
     * @param doc loại tài liệu
     * @param imageUrl link ảnh
     */
    public void addDocument(Document doc, String imageUrl) {
        String insertDocumentQuery = "INSERT INTO Document (title, author, publisher, publishedDate, quantity, category, language, description, imageLink, image) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        String insertBookQuery = "INSERT INTO Book (ID, ISBN) VALUES (?, ?)";
        String insertThesisQuery = "INSERT INTO Thesis (ID, degree, university) VALUES (?, ?, ?)";
        String insertNewspaperQuery = "INSERT INTO Newspaper (ID, ISSN, issueNumber) VALUES (?, ?, ?)";

        try (PreparedStatement documentStmt = connection.prepareStatement(insertDocumentQuery, Statement.RETURN_GENERATED_KEYS)) {

            // Thêm vào bảng Document
            documentStmt.setString(1, doc.getTitle());
            documentStmt.setString(2, doc.getAuthor());
            documentStmt.setString(3, doc.getPublisher());
            documentStmt.setString(4, doc.getPublishedDate()); // Chuyển đổi từ String sang Date
            documentStmt.setInt(5, doc.getQuantity());
            documentStmt.setString(6, doc.getCategory());
            documentStmt.setString(7, doc.getLanguage());
            documentStmt.setString(8, doc.getDescription());
            documentStmt.setString(9, doc.getImageLink());
            doc.setImage(getImageBytesFromUrl(imageUrl));
            if (imageUrl != null) {
                if (getImageBytesFromUrl(imageUrl) != null) {
                    doc.setImage(getImageBytesFromUrl(imageUrl));
                    documentStmt.setBytes(10, doc.getImage());
                }
            } else {
                documentStmt.setNull(10, Types.BLOB); // Nếu không có hình ảnh, đặt NULL
            }

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
                        newspaperStmt.setString(2, newspaper.getISSN());
                        newspaperStmt.setString(3, newspaper.getIssueNumber());
                        newspaperStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cập nhật sửa sách.
     * @param doc sách đã thay đổi
     */
    public void updateDocument(Document doc) {
        String updateDocumentQuery = "UPDATE Document SET title = ?, author = ?, publisher = ?, " +
                "publishedDate = ?, quantity = ?, category = ?, language = ?, description = ?, imageLink = ?, image = ? " +
                "WHERE documentID = ?";

        String updateBookQuery = "UPDATE Book SET ISBN = ? WHERE ID = ?";
        String updateThesisQuery = "UPDATE Thesis SET degree = ?, university = ? WHERE ID = ?";
        String updateNewspaperQuery = "UPDATE Newspaper SET ISSN = ?, issue Number = ? WHERE ID = ?";

        try (PreparedStatement documentStmt = connection.prepareStatement(updateDocumentQuery)) {
            // Cập nhật thông tin bảng Document
            documentStmt.setString(1, doc.getTitle());
            documentStmt.setString(2, doc.getAuthor());
            documentStmt.setString(3, doc.getPublisher());
            documentStmt.setString(4, doc.getPublishedDate()); // Chuyển đổi từ String sang Date
            documentStmt.setInt(5, doc.getQuantity());
            documentStmt.setString(6, doc.getCategory());
            documentStmt.setString(7, doc.getLanguage());
            documentStmt.setString(8, doc.getDescription());
            documentStmt.setString(9, doc.getImageLink());
            if (doc.getImage() != null) {
                documentStmt.setBytes(10, doc.getImage());
            } else {
                documentStmt.setNull(10, Types.BLOB); // Nếu không có hình ảnh, đặt NULL
            }
            documentStmt.setInt(11,doc.getID()); // Sử dụng documentID để cập nhật
            documentStmt.executeUpdate();

            // Cập nhật bảng con dựa trên loại tài liệu
            if (doc instanceof Book) {
                Book book = (Book) doc;
                try (PreparedStatement bookStmt = connection.prepareStatement(updateBookQuery)) {
                    bookStmt.setString(1, book.getISBN());
                    bookStmt.setInt(2, book.getID()); // Sử dụng documentID
                    bookStmt.executeUpdate();
                }
            } else if (doc instanceof Thesis) {
                Thesis thesis = (Thesis) doc;
                try (PreparedStatement thesisStmt = connection.prepareStatement(updateThesisQuery)) {
                    thesisStmt.setString(1, thesis.getDegree());
                    thesisStmt.setString(2, thesis.getUniversity());
                    thesisStmt.setInt(3, thesis.getID()); // Sử dụng documentID
                    thesisStmt.executeUpdate();
                }
            } else if (doc instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) doc;
                try (PreparedStatement newspaperStmt = connection.prepareStatement(updateNewspaperQuery)) {
                    newspaperStmt.setString(1, newspaper.getISSN());
                    newspaperStmt.setString(2, newspaper.getIssueNumber());
                    newspaperStmt.setInt(3, newspaper.getID()); // Sử dụng documentID
                    newspaperStmt.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DocumentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Xoá tài liệu.
     * @param documentID id tài liệu cần xoá 
     */
    public void removeDocument(int documentID) {
        String deleteDocumentQuery = "DELETE FROM Document WHERE documentID = ?";
        String deleteBookQuery = "DELETE FROM Book WHERE ID = ?";
        String deleteThesisQuery = "DELETE FROM Thesis WHERE ID = ?";
        String deleteNewspaperQuery = "DELETE FROM Newspaper WHERE ID = ?";

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

    /**
     * Trả lại danh sách document từ cơ sở dữ liệu.
     * @return danh sách
     */
    public static ArrayList<Document> getAllDocuments() {
        ArrayList<Document> documents = new ArrayList<>();
        String query = "SELECT d.documentID, d.title, d.author, d.publisher, d.publishedDate, d.quantity, d.category, d.language, d.description, d.imageLink, d.image, " +
                "b.ISBN, t.degree, t.university, n.ISSN, n.issueNumber " +
                "FROM Document d " +
                "LEFT JOIN Book b ON d.documentID = b.ID " +
                "LEFT JOIN Thesis t ON d.documentID = t.ID " +
                "LEFT JOIN Newspaper n ON d.documentID = n.ID";

        
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int documentID = resultSet.getInt("documentID");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                String publishedDate = resultSet.getString("publishedDate");
                int quantity = resultSet.getInt("quantity");
                String category = resultSet.getString("category");
                String language = resultSet.getString("language");
                String description = resultSet.getString("description");
                String imageLink = resultSet.getString("imageLink");
                byte[] image = resultSet.getBytes("image");

                // Kiểm tra loại tài liệu và tạo đối tượng tương ứng
                if (resultSet.getString("ISBN") != null) {
                    // Tài liệu là Book
                    Book book = new Book();
                    book.setID(documentID);
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setPublisher(publisher);
                    book.setPublishedDate(publishedDate); // Chuyển đổi từ Date sang String
                    book.setQuantity(quantity);
                    book.setCategory(category);
                    book.setLanguage(language);
                    book.setISBN(resultSet.getString("ISBN"));
                    book.setDescription(description);
                    book.setImagelink(imageLink);
                    book.setImage(image);

                    documents.add(book); // Thêm vào danh sách tài liệu
                } else if (resultSet.getString("degree") != null) {
                    // Tài liệu là Thesis
                    Thesis thesis = new Thesis();
                    thesis.setID(documentID);
                    thesis.setTitle(title);
                    thesis.setAuthor(author);
                    thesis.setPublisher(publisher);
                    thesis.setPublishedDate(publishedDate); // Chuyển đổi từ Date sang String
                    thesis.setQuantity(quantity);
                    thesis.setCategory(category);
                    thesis.setLanguage(language);
                    thesis.setDegree(resultSet.getString("degree"));
                    thesis.setUniversity(resultSet.getString("university"));
                    thesis.setDescription(description);
                    thesis.setImagelink(imageLink);
                    thesis.setImage(image);
                    documents.add(thesis); // Thêm vào danh sách tài liệu
                } else if (resultSet.getString("ISSN") != null) {
                    // Tài liệu là Newspaper
                    Newspaper newspaper = new Newspaper();
                    newspaper.setID(documentID);
                    newspaper.setTitle(title);
                    newspaper.setAuthor(author);
                    newspaper.setPublisher(publisher);
                    newspaper.setPublishedDate(publishedDate); // Chuyển đổi từ Date sang String
                    newspaper.setQuantity(quantity);
                    newspaper.setCategory(category);
                    newspaper.setLanguage(language);
                    newspaper.setDescription(description);
                    newspaper.setImagelink(imageLink);
                    newspaper.setImage(image);
                    newspaper.setISSN(resultSet.getString("ISSN"));
                    newspaper.setIssueNumber(resultSet.getString("issueNumber"));
                    documents.add(newspaper); // Thêm vào danh sách tài liệu
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        }

        return documents; // Trả về danh sách tài liệu 
    }
    
    
}