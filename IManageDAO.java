/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BTL_OOP;

import java.util.ArrayList;

/**
 *
 * @author thinh
 */
public interface IManageDAO {
    void addUser(User user);
    void removeUser(User user);
    void updateUser(User user);
    void deleteUser(int userID);
    User getUserByID(int userID);
    ArrayList<User> getAllUsers();
    int getUserIDByUserAccount(String userAccount);
    
    void addDocument(Document doc);
    void removeDocument(int documentID);
    void updateDocument(Document doc);
}
