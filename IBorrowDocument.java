/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BTL_OOP;
/**
 *
 * @author thinh
 */
public interface IBorrowDocument {
    void addUser(User user);
    void removeUser(User user);
    void updateUser(User user);

    void addDocument(Document doc);
    void removeDocument(Document doc);
    void updateDocument(Document doc);
}

