/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import java.sql.Date;
import java.text.SimpleDateFormat;


/**
 *
 * @author thinh
 */
public class Newspaper extends Document{
    private String date;
    private String ISBN;

    public Newspaper(String date, String ISBN, String documentID, String title, String author, String publisher, int yearPublished, int quantity, String category, String language) {
        super(documentID, title, author, publisher, yearPublished, quantity, category, language);
        this.date = date;
        this.ISBN = ISBN;
    }

    public Newspaper(String date, String ISBN) {
        this.date = date;
        this.ISBN = ISBN;
    }
    
    public Newspaper() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng năm-tháng-ngày
        this.date = dateFormat.format(date); 
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    

    @Override
    public void printInfor() {
        super.printInfor();
        System.out.println("Date: " + date);
        System.out.println("ISBN: " + ISBN);
    }
}
