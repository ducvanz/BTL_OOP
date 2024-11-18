/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTLOOP;


/**
 *
 * @author thinh
 */
public class Transaction {
    private User user;
    private String title;
    private String borrowedDate;
    private String returnedDate;
    private String status;

    public Transaction(){
    }
    
    public Transaction(User user, String title, String borrowedDate, String returnedDate, String status) {
        this.user = user;
        this.title = title;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" + "user=" + user + ", title=" + title + ", borrowedDate=" + borrowedDate + ", returnedDate=" + returnedDate + ", status=" + status + '}';
    }
    
}
