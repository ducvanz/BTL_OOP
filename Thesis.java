/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

/**
 *
 * @author thinh
 */
public class Thesis extends Document{
    private String degree;
    private String university;

    public Thesis(String degree, String university, String documentID, String title, String author, String publisher, int yearPublished, int quantity, String category, String language) {
        super(documentID, title, author, publisher, yearPublished, quantity, category, language);
        this.degree = degree;
        this.university = university;
    }

    public Thesis(String degree, String university) {
        this.degree = degree;
        this.university = university;
    }

    public Thesis() {
    }
    
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void displayDocumentInfor() {
        super.displayDocumentInfor();
    }

    
}
