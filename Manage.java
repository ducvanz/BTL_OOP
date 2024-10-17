/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import BTL_OOP.Document;
import java.util.ArrayList;
import java.sql.Connection;
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
public class Manage extends User implements IBorrowDocument{
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

    @Override
    public void addUser(User user) {
        DatabaseConnection db = new DatabaseConnection();
        Connection con = db.getConnection();
        String sql = "INSERT INTO User (userID, name, userAccount, password) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getUserID());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserAccount());
            statement.setString(4, user.getPassWord());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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