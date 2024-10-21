/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import BTL_OOP.Document;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author thinh
 */
public class Manage extends User {
    private ArrayList<User> users;
    private ArrayList<Document> documents;   
    
    public ArrayList<User> getArrayUsers() {
        return users;
    }

    public void setArrayUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Document> getArrayDocuments() {
        return documents;
    }

    public void setArrayDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public void addUser(User user) {      
        ManageDAO manageDAO = new ManageDAO() {};
        manageDAO.addUser(user);
        
    }
    
    public User getUserByID(int userID) {
        ManageDAO manageDAO = new ManageDAO();
        return manageDAO.getUserByID(userID);
    }
    
    public int getUserIDByUserAccount(String userAccount) {
        ManageDAO manageDAO = new ManageDAO();
        return manageDAO.getUserIDByUserAccount(userAccount);
    }
        
    public ArrayList<User> getAllUsers() {
        return null;
    }
    public void removeUser(User user) {
    }


    public void updateUser(User user) {
    }


    public void addDocument(Document doc) {
    }


    public void removeDocument(Document doc) {
    }


    public void updateDocument(Document doc) {
    }

}