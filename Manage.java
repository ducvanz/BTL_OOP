
package BTLOOP;
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
    
    public int getUserIDByUsername(String username) {
        return manageDAO.getUserIDByUsername(username);
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


    public void addDocument(Document doc, String imageUrl) {
        documentDAO.addDocument(doc, imageUrl);
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