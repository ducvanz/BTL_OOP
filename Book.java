/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

/**
 *
 * @author thinh
 */
public class Book extends Document {
    private String ISBN;

    public Book(String ISBN, String documentID, String title, String author, String publisher, int yearPublished, int quantity, String category, String language) {
        super(documentID, title, author, publisher, yearPublished, quantity, category, language);
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
    public void displayDocumentInfor() {
        super.displayDocumentInfor(); 
        System.out.println("ISBN " + ISBN);
        
    }

    
}
