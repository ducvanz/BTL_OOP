package BTL_OOP.document;

import BTL_OOP.document.Document;

public class Thesis extends Document {
    private String degree;    // Bằng cấp
    private String university; // Tên trường đại học

    // Constructor mặc định
    public Thesis() {
        super(); // Gọi constructor mặc định của lớp cha (Document)
        this.degree = "";
        this.university = "";
    }

    @Override
    public void getInfo() {
        System.out.println();
    }

    // Constructor với các tham số
    public Thesis(String title, String author, String publisher, String publishedDate, int quantity,
                  String category, String language, String description, String imageLink,
                  String degree, String university) {
        super(title, author, publisher, publishedDate, quantity, category, language, description, imageLink);
        this.degree = degree;
        this.university = university;
    }

    // Getter và Setter cho thuộc tính degree
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    // Getter và Setter cho thuộc tính university
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}