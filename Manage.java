/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import BTL_OOP.Document;
import java.util.ArrayList;

/**
 *
 * @author thinh
 */
public class Manage extends User implements IBorrowDocument{
    private String password;
    private ArrayList<User> users;
    private ArrayList<Document> documents;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    @Override
    public void addUser(User user) {
    }

    @Override
    public void removeUser(User user) {
    }

    @Override
    public void updateUser(User user) {
    }

    @Override
    public void addDocument(Document doc) {
    }

    @Override
    public void removeDocument(Document doc) {
    }

    @Override
    public void updateDocument(Document doc) {
    }

}