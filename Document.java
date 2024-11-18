package BTLOOP;
public abstract class Document {
    private String ID;
    private String title;
    private String author;
    private String publisher;
    private String publishedDate; // Nên sử dụng kiểu DATE hoặc String cho ngày tháng
    private int quantity;
    private String category;
    private String language;
    private String description;
    private String imageLink;
    private byte[] image;

    // Constructor mặc định
    public Document() {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getQuantity() {
        return quantity;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
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
    
    public abstract void getInfo();
}