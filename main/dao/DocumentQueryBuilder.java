package BTL_OOP.main.dao;

import BTL_OOP.main.models.document.Book;
import BTL_OOP.main.models.document.Document;
import BTL_OOP.main.models.document.Newspaper;
import BTL_OOP.main.models.document.Thesis;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentQueryBuilder {
    //Tạo lệnh truy vấn SQL
    public static String buildQuery(String title, String author, String ISBN, String category, String language) {
        StringBuilder query = new StringBuilder(
            "SELECT " +
            "d.documentID, d.title, d.author, d.publisher, d.publishedDate, d.quantity, d.language, d.category, d.description, d.imageLink, d.image, " +
            "b.ISBN AS book_ISBN, t.degree AS thesis_degree, t.university AS thesis_university, n.ISSN AS newspaper_ISSN, n.issueNumber AS newspaper_issueNumber " +
            "FROM Document d " +
            "LEFT JOIN Book b ON d.documentID = b.ID " +
            "LEFT JOIN Thesis t ON d.documentID = t.ID " +
            "LEFT JOIN Newspaper n ON d.documentID = n.ID " +
            "WHERE 1=1 "
        );

        if (title != null && !title.isEmpty()) {
            query.append("AND d.title LIKE ? ");
        }
        if (author != null && !author.isEmpty()) {
            query.append("AND d.author LIKE ? ");
        }
        if (ISBN != null && !ISBN.isEmpty()) {
            query.append("AND b.ISBN LIKE ? ");
        }
        if (category != null && !category.isEmpty()) {
            query.append("AND d.category LIKE ? ");
        }
        if (language != null && !language.isEmpty()) {
            query.append("AND d.language LIKE ? ");
        }
        return query.toString();
    }
    
    // Tạo sách từ 
    public static Document createDocument(ResultSet resultSet) throws SQLException {
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

        if (resultSet.getString("book_ISBN") != null) {
            Book book = new Book();
            book.setID(documentID);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setPublishedDate(publishedDate);
            book.setQuantity(quantity);
            book.setCategory(category);
            book.setLanguage(language);
            book.setISBN(resultSet.getString("book_ISBN"));
            book.setDescription(description);
            book.setImagelink(imageLink);
            book.setImage(image);
            return book;
        } else if (resultSet.getString("thesis_degree") != null) {
            Thesis thesis = new Thesis();
            thesis.setID(documentID);
            thesis.setTitle(title);
            thesis.setAuthor(author);
            thesis.setPublisher(publisher);
            thesis.setPublishedDate(publishedDate);
            thesis.setQuantity(quantity);
            thesis.setCategory(category);
            thesis.setLanguage(language);
            thesis.setDegree(resultSet.getString("thesis_degree"));
            thesis.setUniversity(resultSet.getString("thesis_university"));
            thesis.setDescription(description);
            thesis.setImagelink(imageLink);
            thesis.setImage(image);
            return thesis;
        } else if (resultSet.getString("newspaper_ISSN") != null) {
            Newspaper newspaper = new Newspaper();
            newspaper.setID(documentID);
            newspaper.setTitle(title);
            newspaper.setAuthor(author);
            newspaper.setPublisher(publisher);
            newspaper.setPublishedDate(publishedDate);
            newspaper.setQuantity(quantity);
            newspaper.setCategory(category);
            newspaper.setLanguage(language);
            newspaper.setDescription(description);
            newspaper.setImagelink(imageLink);
            newspaper.setImage(image);
            newspaper.setISSN(resultSet.getString("newspaper_ISSN"));
            newspaper.setIssueNumber(resultSet.getString("newspaper_issueNumber"));
            return newspaper;
        }
        return null;
    }
}
