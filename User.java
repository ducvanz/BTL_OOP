
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

import java.util.ArrayList;

public class User extends Document{
    private String userID;
    private String userName;
    private String email;
    private String phone;
    private String birthday;
    private String address;
    private boolean loanTerm;
    private int numberBorrowed;
    private ArrayList<Document> borrowedDocument;
    private String passWord;

    public User() {
    }

    public User(String userID, String userName, String passWord){
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
    }
    
    public User(String userID, String userName, String email, String phone, String birthday, String address, boolean loanTerm, int numberBorrowed) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.loanTerm = loanTerm;
        this.numberBorrowed = numberBorrowed;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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
    
     
    public void printInfor() {
        // Hiển thị thông tin tài liệu
        System.out.println ("User Information:");
        System.out.println ("ID:" + userID);
        System.out.println ("Name:" + userName);
        System.out.println ("Email:" + email);
        System.out.println ("Phone:" + phone);
        System.out.println ("Birthday:" + birthday);
        System.out.println ("Address:" + address);
        System.out.println ("Loan term:" + (loanTerm? "Active": "Inactive"));
        System.out.println ("Number of Borrowed Documents:" + numberBorrowed);
  
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
    
    public int checkAccout(String accout, String passWord, int pp, Connection con) {
        if (pp == 1) {
            // check tai khoan nguoi dung
            
            String selectSQL = "1?"; // code search mysql
            try (PreparedStatement pstmt = con.prepareStatement(selectSQL)) {
                //
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            // check tai khoan quan ly
            
            String selectSQL = "1?"; // code search mysql
            try (PreparedStatement pstmt = con.prepareStatement(selectSQL)) {
                //
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // mat khau sai
        return 0;
    }
     
}
