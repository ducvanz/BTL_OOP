package BTL_OOP.document;

import BTL_OOP.document.Document;

public class Newspaper extends Document {
    private String date;  // Ngày phát hành
    private String ISSN;  // Số ISBN
    private String issueNumber;

    // Constructor mặc định
    public Newspaper() {
        super();  // Gọi constructor mặc định của lớp cha (Document)
        this.date = "";
        this.ISSN = "";
        this.issueNumber = "";
    }


    // Constructor với các tham số
    public Newspaper(String title, String author, String publisher, String publishedDate, int quantity,
                     String category, String language, String description, String imageLink,
                     String date, String ISSN, String issueNumber) {
        super(title, author, publisher, publishedDate, quantity, category, language, description, imageLink);
        this.date = date;
        this.ISSN = ISSN;
        this.issueNumber = issueNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getISSN() {
        return ISSN;
    }

    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public void getInfo() {

    }

}