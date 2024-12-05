package BTL_OOP.main.dao;

import BTL_OOP.main.models.document.Book;
import BTL_OOP.main.models.document.Document;
import BTL_OOP.main.models.document.Newspaper;
import BTL_OOP.main.models.document.Thesis;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentAdapter {
    // Tạo tài liệu từ kết quả trả về từ CSDL
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
