package BTL_OOP.main.dao;

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
}
