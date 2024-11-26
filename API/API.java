package BTL_OOP.API;

import BTL_OOP.document.Book;
import BTL_OOP.document.Document;
import com.google.gson.*;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class API {
    private static final String API_KEY = "AIzaSyB5dvT2OSJZxqpMKgS7gEw-5GN_uKpQAPs";

    public API() {
    }

    // Tải ảnh trong một luồng nền
    public static void loadImageInBackground(String imageUrl, JLabel label) {
        SwingWorker<ImageIcon, Void> worker = new SwingWorker<ImageIcon, Void>() {
            @Override
            protected ImageIcon doInBackground() throws Exception {
                try {
                    return new ImageIcon(new URL(imageUrl));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void done() {
                try {
                    ImageIcon icon = get();
                    if (icon != null) {
                        // Thay đổi kích thước của hình ảnh để vừa với JLabel
                        Image image = icon.getImage();
                        Image scaledImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                        label.setIcon(new ImageIcon(scaledImage));
                    } else {
                        label.setText("Không tìm thấy ảnh.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    label.setText("Lỗi khi tải ảnh.");
                }
            }
        };
        worker.execute();
    }

    // Phân tích JSON để lấy URL ảnh
    private static String parseDocumentGetImage(String jsonResponse) {
        if (jsonResponse == null || jsonResponse.isEmpty()) {
            System.out.println("Phản hồi JSON rỗng hoặc null, không thể phân tích.");
            return null;
        }

        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

            if (jsonObject.has("items") && jsonObject.get("items").isJsonArray()) {
                JsonArray items = jsonObject.getAsJsonArray("items");
                for (int i = 0; i < Math.min(1, items.size()); i++) {
                    JsonObject item = items.get(i).getAsJsonObject();
                    JsonObject volumeInfo = item.has("volumeInfo") && item.get("volumeInfo").isJsonObject() ?
                            item.getAsJsonObject("volumeInfo") : new JsonObject();

                    // Lấy link ảnh thumbnail
                    if (volumeInfo.has("imageLinks") && volumeInfo.get("imageLinks").isJsonObject()) {
                        JsonObject imageLinks = volumeInfo.getAsJsonObject("imageLinks");
                        if (imageLinks.has("thumbnail")) {
                            return imageLinks.get("thumbnail").getAsString();
                        }
                    }
                }
            } else {
                System.out.println("Không có mục nào trong phản hồi JSON.");
            }
        } catch (JsonSyntaxException e) {
            System.out.println("Lỗi khi phân tích JSON: " + e.getMessage());
        }
        return null;
    }

    // Lấy URL của ảnh từ API
    public static String getImageUrl(String title, String author, String ISBN, String category, String language) {
        String jsonResponse = searchDocument(title, author, ISBN, category, language);
        if (jsonResponse == null) {
            System.out.println("Không thể lấy dữ liệu từ API.");
            return null;
        }
        return parseDocumentGetImage(jsonResponse);
    }

    // Hiển thị ảnh
    public static void displayImage(Document doc, JLabel jlabel) {
        String imageUrl = getImageUrl(doc.getTitle(), "", "", "", "");
        if (imageUrl != null && !imageUrl.equals("N/A")) {
            loadImageInBackground(imageUrl, jlabel);
            System.out.println("Hiển thị ảnh từ API thành công");
        } else {
            jlabel.setText("");
        }
    }
    // tìm sách từ API
    public static String searchDocument(String title, String author, String ISBN, String category, String language) {
        try {
            int maxResults = 40;
            StringBuilder queryBuilder = new StringBuilder("q=");
            boolean isFirst = true;

            if (!title.isEmpty()) {
                queryBuilder.append(isFirst ? "" : "+").append("intitle:").append(URLEncoder.encode(title, "UTF-8"));
                isFirst = false;
            }
            if (!author.isEmpty()) {
                queryBuilder.append(isFirst ? "" : "+").append("inauthor:").append(URLEncoder.encode(author, "UTF-8"));
                isFirst = false;
            }
            if (!ISBN.isEmpty()) {
                queryBuilder.append(isFirst ? "" : "+").append("isbn:").append(URLEncoder.encode(ISBN, "UTF-8"));
                isFirst = false;
            }
            if (!category.isEmpty()) {
                queryBuilder.append(isFirst ? "" : "+").append("subject:").append(URLEncoder.encode(category, "UTF-8"));
                isFirst = false;
            }
            if (!language.isEmpty()) {
                queryBuilder.append(isFirst ? "" : "+").append("inlanguage:").append(URLEncoder.encode(language, "UTF-8"));
            }

            // Tạo URL cho truy vấn tìm kiếm
            String urlString = "https://www.googleapis.com/books/v1/volumes?" + queryBuilder.toString() + "&maxResults=" + maxResults + "&key=" + API_KEY;
            System.out.println("Request URL: " + urlString);

            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Kiểm tra mã phản hồi HTTP
            int responseCode = con.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) { // Không thành công
                System.out.println("Lỗi khi kết nối API: Mã phản hồi HTTP " + responseCode);
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            con.disconnect();

            return response.toString();
        } catch (Exception e) {
            System.out.println("Lỗi khi tìm kiếm tài liệu: " + e.getMessage());
        }
        return null;
    }
    
    private static ArrayList<Document> parseDocument(String jsonResponse) {
        ArrayList<Document> result = new ArrayList<>();
        if (jsonResponse == null || jsonResponse.isEmpty()) {
            System.out.println("Phản hồi JSON rỗng hoặc null, không thể phân tích.");
            return null;
        }

        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
//            System.out.println(jsonObject);
            if (jsonObject.has("items") && jsonObject.get("items").isJsonArray()) {
                JsonArray items = jsonObject.getAsJsonArray("items");
                System.out.println("item size: " + items.size());
                for (int i = 0; i < Math.min(20, items.size()); i++) {
                    JsonObject item = items.get(i).getAsJsonObject();
                    JsonObject volumeInfo = item.has("volumeInfo") && item.get("volumeInfo").isJsonObject() ?
                            item.getAsJsonObject("volumeInfo") : new JsonObject();

                    // Lấy title
                    String title = volumeInfo.has("title") && !volumeInfo.get("title").isJsonNull() ?
                            volumeInfo.get("title").getAsString() : "Unknown Title";

                    String author = "N/A";
                    if (volumeInfo.has("authors") && volumeInfo.get("authors").isJsonArray()) {
                        JsonArray authorsArray = volumeInfo.getAsJsonArray("authors");
                        if (authorsArray.size() > 0) {
                            author = authorsArray.get(0).getAsString();
                        }
                    }

                    String publisher = volumeInfo.has("publisher") && !volumeInfo.get("publisher").isJsonNull() ?
                            volumeInfo.get("publisher").getAsString() : "N/A";

                    String publishedDate = "";
                    if (volumeInfo.has("publishedDate")) {
                        try {
                            publishedDate = volumeInfo.get("publishedDate").getAsString();
                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            publishedDate = "N/A"; // Gán giá trị mặc định nếu định dạng không chính xác
                        }
                    }

                    String category = "N/A";
                    if (volumeInfo.has("categories") && volumeInfo.get("categories").isJsonArray()) {
                        JsonArray categoriesArray = volumeInfo.getAsJsonArray("categories");
                        if (categoriesArray.size() > 0) {
                            category = categoriesArray.get(0).getAsString();
                        }
                    }

                    String ISBN = "N/A";
                    if (volumeInfo.has("industryIdentifiers") && volumeInfo.get("industryIdentifiers").isJsonArray()) {
                        JsonArray identifiersArray = volumeInfo.getAsJsonArray("industryIdentifiers");
                        for (JsonElement identifier : identifiersArray) {
                            JsonObject identifierObj = identifier.getAsJsonObject();
                            if (identifierObj.has("type") && identifierObj.get("type").getAsString().equals("ISBN_13")) {
                                ISBN = identifierObj.get("identifier").getAsString();
                                break;
                            }
                        }
                    }
                    
                    String description ="N/A";
                    if (volumeInfo.has("description")) {
                        description = volumeInfo.get("description").getAsString();
                    }
                    

                    String imageLink = "N/A";
                    if (volumeInfo.has("imageLinks") && volumeInfo.get("imageLinks").isJsonObject()) {
                        JsonObject imageLinks = volumeInfo.getAsJsonObject("imageLinks");
                        if (imageLinks.has("thumbnail")) {
                            imageLink = imageLinks.get("thumbnail").getAsString();
                        }
                    }
                    
                    String language = volumeInfo.has("language") && !volumeInfo.get("language").isJsonNull() ?
                            volumeInfo.get("language").getAsString() : "N/A";

                    Book book = new Book( title, author, publisher, publishedDate, 1, "Fiction", "English", description, imageLink, ISBN);
                    result.add(book);

                }
            } else {
                
                System.out.println("Không có mục nào trong phản hồi JSON.");
                return null;
            }
        } catch (JsonSyntaxException e) {
            System.out.println("Lỗi khi phân tích JSON: " + e.getMessage());
        }
        System.out.println("Lấy tài liệu từ API thành công");
        return result;
    }

    
    
    public static ArrayList<Document> getArrayDocument(String title, String author, String ISBN, String category, String language) {
        String jsonResponse = searchDocument(title, author, ISBN, category, language);
        if (jsonResponse == null) {
            System.out.println("Không thể lấy dữ liệu từ API.");
            return null;
        }
        return parseDocument(jsonResponse);
    }
    
     private static final String API_KEYS = "AIzaSyDOv7ofcaQnYInvp-IfsydvRqIVgArjGXg"; 
    private static final String API_BASE_URL = "https://www.googleapis.com/books/v1/volumes";

    // return ten, tac gia, nxb, nam xb
    public static List<Book> searchBook(String isbn, String title, String author, String publish, String publishDate) {
        List<Book> list = new ArrayList<>();
        StringBuilder query = new StringBuilder();

        // Xử lý các tham số tìm kiếm
        if (title != null && !title.isEmpty()) {
            query.append("intitle:").append(title.replace(" ", "+")).append("+");
        }
        if (author != null && !author.isEmpty()) {
            query.append("inauthor:").append(author.replace(" ", "+")).append("+");
        }
        if (isbn != null && !isbn.isEmpty()) {
            query.append("isbn:").append(isbn).append("+");
        }
        if (publish != null && !publish.isEmpty()) {
            query.append("publisher:").append(publish.replace(" ", "+")).append("+");
        }
        if (publishDate != null && !publishDate.isEmpty()) {
            query.append("publishedDate:").append(publishDate.replace(" ", "+")).append("+");
        }

        if (query.length() > 0 && query.charAt(query.length() - 1) == '+') {
            query.setLength(query.length() - 1); // Xóa dấu "+" cuối cùng
        }

        if (query.length() > 0) {
            String urlString = API_BASE_URL + "?q=" + query.toString() + "&key=" + API_KEYS;
            try {
                URL url = new URL(urlString);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                JsonObject json = JsonParser.parseReader(new InputStreamReader(request.getInputStream())).getAsJsonObject();
                JsonArray items = json.getAsJsonArray("items");

                if (items != null && items.size() > 0) {
                    for (int i = 0; i < items.size(); i++) {
                        JsonObject volumeInfo = items.get(i).getAsJsonObject().getAsJsonObject("volumeInfo");

                        // Lấy ISBN nếu có
                        String bookIsbn = isbn != null ? isbn : "";
                        JsonArray industryIdentifiers = volumeInfo.getAsJsonArray("industryIdentifiers");
                        if (industryIdentifiers != null) {
                            for (int j = 0; j < industryIdentifiers.size(); j++) {
                                JsonObject identifier = industryIdentifiers.get(j).getAsJsonObject();
                                if (identifier.get("type").getAsString().equals("ISBN_13")) {
                                    bookIsbn = identifier.get("identifier").getAsString();
                                    break;
                                }
                            }
                        }

                        // Lấy thông tin sách
                        String bookTitle = volumeInfo.has("title") ? volumeInfo.get("title").getAsString() : "null";
                        String bookAuthors = volumeInfo.has("authors") ? volumeInfo.getAsJsonArray("authors").get(0).getAsString() : "null";
                        String publisher = volumeInfo.has("publisher") ? volumeInfo.get("publisher").getAsString() : "null";
                        String publishedDate = volumeInfo.has("publishedDate") ? volumeInfo.get("publishedDate").getAsString() : "null";
                        String categories = volumeInfo.has("categories") ? volumeInfo.getAsJsonArray("categories").get(0).getAsString() : "null";
                        String language = volumeInfo.has("language") ? volumeInfo.get("language").getAsString() : "null";
                        String description = volumeInfo.has("description") ? volumeInfo.get("description").getAsString() : "null";
                        
                        String imageLink = "null";
                        if (volumeInfo.has("imageLinks")) {
                            JsonObject imageLinks = volumeInfo.getAsJsonObject("imageLinks");
                            if (imageLinks.has("thumbnail")) {
                                imageLink = imageLinks.get("thumbnail").getAsString();
                            }
                        }
                        // Cắt chuỗi publishedDate lấy năm
                        if (publishedDate != null && !publishedDate.isEmpty() && publishedDate.length() >= 4) {
                        } else {
                            publishedDate = "null";
                        }

                        Book book = new Book(bookTitle, bookAuthors, publisher, publishedDate, 0,
                     categories, language, description, imageLink, bookIsbn);
                        list.add(book);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } 
        return list;
    }
    
}
