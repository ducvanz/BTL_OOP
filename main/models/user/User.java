package BTL_OOP.main.models.user;

import BTL_OOP.main.dao.TransactionDAO;
import BTL_OOP.main.dao.DocumentDAO;
import BTL_OOP.main.database.Transaction;
import BTL_OOP.main.models.document.Document;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int ID;
    private String name;
    private String email;
    private String phone;
    private String birthday;
    private String address;
    private boolean loanTerm;
    private int numberBorrowed;
    private ArrayList<Transaction> BorrowedList;
    private ArrayList<Transaction> LoanList;
    private String username;
    private String password;

    // Constructor mặc định
    public User() {
        this.name = "User ";
        this.email = "";
        this.phone = "";
        this.birthday = "";
        this.address = "";
        this.loanTerm = true; // Mặc định cho phép mượn
        this.numberBorrowed = 0;
        this.BorrowedList = new ArrayList<>();
        this.LoanList = new ArrayList<>();
        this.username = "";
        this.password = "";
    }

    // Constructor với các tham số
    public User(int ID,String name, String email, String phone, String birthday, String address,
                boolean loanTerm, int numberBorrowed, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.loanTerm = loanTerm;
        this.numberBorrowed = numberBorrowed;
        this.BorrowedList = new ArrayList<>();
        this.LoanList = new ArrayList<>();
        this.username = username;
        this.password = password;
    }
    
    public User(String name, String username, String password) {
        this.name = name;
        this.email = "";
        this.phone = "";
        this.birthday = "2005-09-01";
        this.address = "";
        this.loanTerm = true; // Mặc định cho phép mượn
        this.numberBorrowed = 0;
        this.BorrowedList = new ArrayList<>();
        this.LoanList = new ArrayList<>();
        this.password = password;
        this.username = username;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (numberBorrowed <= 10) {
            return true;
        }
        return false;
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

    public ArrayList<Transaction> getBorrowedList() {
        return BorrowedList;
    }

    public void setBorrowedList(ArrayList<Transaction> borrowedList) {
        BorrowedList = borrowedList;
    }

    public ArrayList<Transaction> getLoanList() {
        return LoanList;
    }

    public void setLoanList(ArrayList<Transaction> loanList) {
        LoanList = loanList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void reset(){
        TransactionDAO t = new TransactionDAO();
        t.reset();
    }

    
    /**
     * Phương thức cài đặt phần mượn sách.
     * @param transaction thao tác mượn sách
     */
    public void borrowDocument(Transaction transaction) {
        if (loanTerm) {
            TransactionDAO transactionDAO = new TransactionDAO();
            LoanList.add(transaction);
            transactionDAO.addTransaction(transaction);
            numberBorrowed++;
            System.out.println("Mượn tài liệu thành công.");
        } else {
            System.out.println("User  is not allowed to borrow documents.");
        }
    }

    /**
     * Phương thức thực hiện trả sách.
     * @param transaction thao tác trả sách
     * @param returnedDate ngày trả
     */
    public void returnDocument(Transaction transaction, String returnedDate) {
        
        for (Transaction t : LoanList) {
            if (t.getUserID()==transaction.getUserID() && t.getDocumentID() == transaction.getDocumentID()
                                            && t.getBorrowedDate().equals(transaction.getBorrowedDate())
                                            && t.getReturnedDate().equals(transaction.getReturnedDate())
                                            && t.getStatus().equals(transaction.getStatus())) {

                transaction.setTransactionID(t.getTransactionID());
                if (LoanList.contains(transaction)) {
                    LoanList.remove(transaction);
                    setLoanList(LoanList);
                    transaction.setStatus("returned");
                    transaction.setReturnedDate(returnedDate);
                    TransactionDAO transactionDAO = new TransactionDAO();
                    transactionDAO.returnTransaction(transaction.getTransactionID(), transaction.getUserID(), transaction.getDocumentID());
                    BorrowedList.add(transaction);
                    numberBorrowed--;
                    System.out.println("Trả tài liệu thành công.");

                    return;
                }

            } 
        
        }
        System.out.println("Document not found in borrowed list.");

    }
    
    /**
     * Lấy về danh sách tài liệu đang mượn.
     * @return 
     */
    public ArrayList<Document> getBorrowedDocument(){
        ArrayList<Document> result = new ArrayList<>();
        List<Document> allDocument = new ArrayList<>();
        allDocument = DocumentDAO.getAllDocuments();
        List<Integer> transactionID= new ArrayList<>();
        for (Transaction transaction : LoanList) {
            transactionID.add(transaction.getDocumentID());
        }

        // Tìm các Document có tên trùng với tên trong danh sách mượn
        for (Document document : allDocument) {
            if (transactionID.contains(document.getID())) {
                result.add(document);
            }
        }
        return result;
            
    } 

    /**
     * Lấy về danh sách tài liệu đã mượn.
     * @return 
     */
    public ArrayList<Document> getReturnedDocument(){
        ArrayList<Document> result = new ArrayList<>();
        List<Document> allDocument = new ArrayList<>();
        allDocument = DocumentDAO.getAllDocuments();
        List<Integer> transactionID = new ArrayList<>();
        for (Transaction transaction : BorrowedList) {
            transactionID.add(transaction.getTransactionID());
        }

        // Tìm các Document có tên trùng với tên trong danh sách đã mượn
        for (Document document : allDocument) {
            if (transactionID.contains(document.getID())) {
                result.add(document);
            }
        }
        return result;
            
    } 

    /**
     * Hiển thị thông tin người dùng.
     * Chủ yếu dùng để check hàm
     */
    public void displayUserInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Birthday: " + birthday);
        System.out.println("Address: " + address);
        System.out.println("Number Borrowed: " + numberBorrowed);
        System.out.println("Loan Term: " + (loanTerm ? "Allowed" : "Not Allowed"));
    }
}