/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import java.util.ArrayList;
/**
 *
 * @author thinh
 */
public class Manage extends User {
    private ArrayList<User> users;
    private ArrayList<Document> documents; 
    ManageDAO manageDAO = new ManageDAO();
    DocumentDAO documentDAO = new DocumentDAO();
    
    public ArrayList<User> getArrayUsers() {
        return users;
    }

    public void setArrayUsers() {
        users = manageDAO.getAllUsers();
    }

    public ArrayList<Document> getArrayDocuments() {
        return documents;
    }

    public void setArrayDocuments() {
        documents = documentDAO.getAllDocuments();
    }

    public void addUser(User user){
        manageDAO.addUser(user);       
    }
    
    public User getUserByID(int userID) {
        return manageDAO.getUserByID(userID);
    }
    
    public int getUserIDByUserAccount(String userAccount) {
        return manageDAO.getUserIDByUserAccount(userAccount);
    }
        
    public ArrayList<User> getAllUsers() {
        
        return manageDAO.getAllUsers();
    }
    public void removeUser(User user) {
        manageDAO.removeUser(user);
    }


    public void updateUser(User user) {
        manageDAO.updateUser(user);
    }


    public void addDocument(Document doc) {
        documentDAO.addDocument(doc);
    }


    public void removeDocument(int documentID) {
        documentDAO.removeDocument(documentID);
    }


    public void updateDocument(Document doc) {
        documentDAO.updateDocument(doc);
    }

    public ArrayList<Document> getAllDocuments() { 
        return documentDAO.getAllDocuments();
    }
    


}