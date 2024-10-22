
package BTL_OOP;

/**
 *
 * @author thinh
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
    private int userID;
    private String userName;
    private String email;
    private String phone;
    private String birthday;
    private String address;
    private boolean loanTerm;
    private int numberBorrowed;
    private ArrayList<Document> borrowedDocument;
    private String userAccount;
    private String password;

    public User() {
    }

    public User(String msv, String userName,String userAccout, String passWord){
        this.userID = Integer.parseInt(msv);
        this.userName = userName;
        this.userAccount = userAccout;
        this.password = passWord;
    }

    public User(int userID, String userName, String email, String phone, String birthday, String address, boolean loanTerm, int numberBorrowed, String userAccount, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.loanTerm = loanTerm;
        this.numberBorrowed = numberBorrowed;
        this.userAccount = userAccount;
        this.password = password;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccout) {
        this.userAccount = userAccout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passWord) {
        this.password = passWord;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(boolean loanTerm) {
        this.loanTerm = loanTerm;
    }

    public int getNumberBorrowed() {
        return numberBorrowed;
    }

    public void setNumberBorrowed(int numberBorrowed) {
        this.numberBorrowed = numberBorrowed;
    }

    
    public Document findDocument(String title) {
        // Tìm tài liệu theo tiêu đề
        return null;
    }

    public void borrowDocument(Document doc) {
        // Mượn tài liệu
    }

    public void returnDocument(Document doc) {
        // Trả tài liệu
    }

    public void displayUserInfo(User user){
        
    }
}
