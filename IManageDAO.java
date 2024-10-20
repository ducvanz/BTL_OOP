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
    void deleteUser(String userID);
    User getUserByID(String userID);
    ArrayList<User> getAllUsers();
    
    void addDocument(Document doc);
    void removeDocument(Document doc);
    void updateDocument(Document doc);
}
