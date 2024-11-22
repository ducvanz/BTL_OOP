package BTL_OOP;

import java.util.ArrayList;

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
    
    public User(int ID, String name, String username, String password) {
        this.ID = ID;
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
        if (numberBorrowed < 10) {
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

    
    // Phương thức mượn tài liệu
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

    // Phương thức trả tài liệu
    public void returnDocument(Transaction transaction, String returnedDate) {
        for(Transaction t : LoanList) {
            System.out.println(t.toString());
        }
        System.out.println(" ****" + transaction.toString() + "      ******");
        if (LoanList.contains(transaction)) {
            LoanList.remove(transaction);
            transaction.setStatus("returned");
            transaction.setReturnedDate(returnedDate);
            TransactionDAO transactionDAO = new TransactionDAO();
            transactionDAO.returnTransaction(transaction);
            BorrowedList.add(transaction);
            numberBorrowed--;
            System.out.println("Trả tài liệu thành công.");

        } else {
            System.out.println("Document not found in borrowed list.");
        }
    }

    // Phương thức hiển thị thông tin người dùng
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