
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
    private String userAccount;
    private String passWord;

    public User() {
    }

    public User(String userID, String userName,String userAccout, String passWord){
        this.userID = userID;
        this.userName = userName;
        this.userAccount = userAccout;
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

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccout) {
        this.userAccount = userAccout;
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

    /**
     * Chuyển hướng đăng nhập.
     * 0: thông tin sai
     * 1: người dùng
     * 2: quản lý
     * @param account
     * @param password
     * @param pp
     * @param con
     * @return 
     */
    public int accountLogin(String account, String password, int pp, Connection con) {
        if (pp == 1) {
            // check tai khoan nguoi dung

            String selectSQL = "SELECT password FROM user WHERE userAccount = ?";  // Đảm bảo tên cột đúng
            try (PreparedStatement statement = con.prepareStatement(selectSQL)) {
            // Truyền giá trị cho tham số "?"
            statement.setString(1, account);  // userAccount là biến chứa tên tài khoản người dùng
    
            // Thực thi câu lệnh truy vấn
            try (ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    // Lấy password từ kết quả
                    String pass = res.getString("password");  // Chỉ định tên cột "password"
                    if (pass.equals(password)) {
                        return 1;
                    }
                }
                return 0;
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
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

    public String checkName(String name) {
    if (name.length() > 50) {
        return "Name too long!";
    }

    // Regular expression to match valid characters, including Vietnamese characters with diacritics
    String regex = "^[\\p{L} ]+$"; // \p{L} matches any kind of letter from any language

    if (name.matches(regex)) {
        return "true";  // valid name
    } else {
        return "Invalid name!";  // name contains invalid characters
        }
    }
    
    public boolean checkID(String s, Connection con) {        
        String select = "SELECT 1 FROM user WHERE userID = ?";
        try(PreparedStatement pstm = con.prepareStatement(select)) {
            
            pstm.setString(1, s);
            // Thực thi câu lệnh truy vấn
            try (ResultSet res = pstm.executeQuery()) {
                // Nếu có kết quả, nghĩa là tài khoản tồn tại
                if (res.next()) {
                    return false;
                }
            }
             catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (s.length() != 8) return false;
        
        if (s.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
        
    }
    
    public boolean checkAccount(String account, Connection con) {
        String select = "SELECT 1 FROM user WHERE userAccount = ?";
        try(PreparedStatement pstm = con.prepareStatement(select)) {
            
            pstm.setString(1, account);
            // Thực thi câu lệnh truy vấn
            try (ResultSet res = pstm.executeQuery()) {
                // Nếu có kết quả, nghĩa là tài khoản tồn tại
                return res.next();
            }
             catch (SQLException e) {
                e.printStackTrace();
            }
            // Trả về false nếu có lỗi hoặc tài khoản không tồn tại
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
