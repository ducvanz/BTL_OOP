package BTL_OOP.main.database;

import java.util.Objects;

public class Transaction {
    private int transactionID; // ID duy nhất cho giao dịch
    private int userID;        // ID của người dùng
    private int documentID;    // ID của tài liệu
    private String borrowedDate; // Ngày mượn
    private String returnedDate; // Ngày trả
    private String status;       // Trạng thái

    // Constructor mặc định
    public Transaction() {
    }

    // Constructor đầy đủ
    public Transaction(int transactionID, int userID, int documentID, String borrowedDate, String returnedDate, String status) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.documentID = documentID;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
        this.status = status;
    }

    // Getter và Setter cho các thuộc tính
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDocumentID() {
        return documentID;
    }

    public void setDocumentID(int documentID) {
        this.documentID = documentID;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", userID=" + userID +
                ", documentID=" + documentID +
                ", borrowedDate='" + borrowedDate + '\'' +
                ", returnedDate='" + returnedDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, userID, documentID, borrowedDate, returnedDate, status);
    }

    // So sánh các transaction
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Transaction that = (Transaction) obj;
        return transactionID == that.transactionID &&
               userID == that.userID &&
               documentID == that.documentID &&
               Objects.equals(borrowedDate, that.borrowedDate) &&
               Objects.equals(returnedDate, that.returnedDate) &&
               Objects.equals(status, that.status);
    }
}
