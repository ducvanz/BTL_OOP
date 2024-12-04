
package BTL_OOP.main.models.user;
import BTL_OOP.main.dao.ManageDAO;
import BTL_OOP.main.dao.DocumentDAO;
import BTL_OOP.main.models.document.Document;
import java.util.ArrayList;
/**
 *
 * @author thinh
 */
public class Manage extends User {
    private ArrayList<User> users;
    private ArrayList<Document> documents; 
    ManageDAO manageDAO = ManageDAO.getManageDAO();
    DocumentDAO documentDAO = new DocumentDAO();
    
    public Manage(){
        
    }
    
    public Manage(User user){
        this.setID(user.getID());
        this.setName(user.getName());
        this.setAddress(user.getAddress());
        this.setPhone(user.getPhone());
        this.setEmail(user.getEmail());
        this.setBirthday(user.getBirthday());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setLoanList(user.getLoanList());
        this.setBorrowedList(user.getBorrowedList());
        this.setLoanTerm(user.isLoanTerm());
        this.setNumberBorrowed(user.getNumberBorrowed());      
    }
    public ArrayList<User> getArrayUsers() {
        setArrayUsers();
        return users;
    }

    public void setArrayUsers() {
        users = manageDAO.getAllUsers();
    }

    public ArrayList<Document> getArrayDocuments() {
        setArrayDocuments();
        return documents;
    }

    public void setArrayDocuments() {
        documents = documentDAO.getAllDocuments();
    }

    public void addUser(User user){
        manageDAO.addUser(user);       
    }
    

    
    public User getUserByUsername(String username) {
        return manageDAO.getUserByUsername(username);
    }
        
    public void removeUser(int user) {
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
    
}