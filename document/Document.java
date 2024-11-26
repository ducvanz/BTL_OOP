
package BTL_OOP.document;

import java.util.Objects;

public abstract class Document {

    private int ID;
    private String title;
    private String author;
    private String publisher;
    private String publishedDate;
    private int quantity;
    private String category;
    private String language;
    private String description;
    private String imageLink;
    private byte[] image;

    // Constructor với các tham số
    public Document(String title, String author, String publisher, String publishedDate, int quantity,
                    String category, String language, String description, String imageLink) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.quantity = quantity;
        this.category = category;
        this.language = language;
        this.description = description;
        this.imageLink = imageLink;
    }
    
    public Document(String title, String author, String publisher, String publishedDate, int quantity,
                    String category, String language, String description, String imageLink, byte[] image) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.quantity = quantity;
        this.category = category;
        this.language = language;
        this.description = description;
        this.imageLink = imageLink;
        this.image = image;
    }
    public Document(){
        this.title = "";
        this.author = "";
        this.publisher = "";
        this.publishedDate = ""; // Hoặc có thể đặt là một giá trị cụ thể
        this.quantity = 0;
        this.category = "";
        this.language = "";
        this.description = "";
        this.imageLink = "";
    }

    public int getID() {
        return ID;
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

    public String getPublishedDate() {
        return publishedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setID(int documentID) {
        this.ID = documentID;
    }

    public String getLanguage() {
        return language;
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

    public void setPublishedDate(String yearPublished) {
        this.publishedDate = yearPublished;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public void setImagelink(String imageLink) {
        this.imageLink = imageLink;
    }
    
    public String getImageLink() {
        return this.imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage(){
        return image;
    }
    
    public void setImage(byte[] image){
        this.image = image;
    }

    @Override
    public String toString() {
        return  title + " - " + author;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Document) {
            Document doc = (Document) obj;
            return title.equals(doc.getTitle()) && author.equals(doc.getAuthor()) && publisher.equals(doc.getPublisher()) && category.equals(doc.getCategory())
                   && language.equals(doc.getLanguage());
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher, category, language);
    }
    
    public abstract void getInfo();
}