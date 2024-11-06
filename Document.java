
package BTL_OOP;

public abstract class Document {
    protected String documentID;
    protected String title;
    protected String author;
    protected String publisher;
    protected int yearPublished;
    protected int quantity;
    protected String category;
    protected String language;

    public Document(String documentID, String title, String author, String publisher, int yearPublished, int quantity, String category, String language) {
        this.documentID = documentID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.quantity = quantity;
        this.category = category;
        this.language = language;
    }

    public Document(){
    }
    
    public String getDocumentID() {
        return documentID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    

    public void displayDocumentInfor() {
        System.out.println("Book Information:");
        System.out.println("Document ID: " + documentID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Year Published: " + yearPublished);
        System.out.println("Quantity: " + quantity);
        System.out.println("Category: " + category);
        System.out.println("Language: " + language);
    }

    @Override
    public String toString() {
        return  title + " - " + author;
    }
}
