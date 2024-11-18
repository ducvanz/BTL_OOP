/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTLOOP;
/**
 *
 * @author thinh
 */
public class Book extends Document {
    private String ISBN;

    public Book(String title, String author, String publisher, String publishedDate, int quantity,
                     String category, String language, String description, String imageLink, String ISBN) {
        super(title, author, publisher, publishedDate, quantity, category, language, description, imageLink);
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
    public void getInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Published Date: " + getPublishedDate());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Category: " + getCategory());
        System.out.println("Language: " + getLanguage());
        System.out.println("Description: " + getDescription());
        System.out.println("Image Link: " + getImageLink());
        System.out.println("ISBN: " + getISBN());
    }
    
    @Override
    public String toString(){
        return (this.getTitle() + " - " + this.getAuthor());
    }
    
}
