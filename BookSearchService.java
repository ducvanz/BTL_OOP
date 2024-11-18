package BTLOOP;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BookSearchService {
    private static final String API_KEY = "AIzaSyB5dvT2OSJZxqpMKgS7gEw-5GN_uKpQAPs"; // Thay YOUR_API_KEY bằng API Key của bạn

    public static void main(String[] args) {
        
        String result = searchBooks("Doraemon "); 
        if (result != null) {
            System.out.println("Response: " + result);
            parseBooks(result); // Gọi phương thức phân tích dữ liệu
        }

        /*
        String isbn = "9780321563842"; // Thay thế bằng ISBN bạn muốn tìm
        String result = searchBookByISBN(isbn);
        if (result != null) {
            System.out.println("Response: " + result);
            parseBooks(result);
        }
        */
    }

    public static String searchBooks(String title) {
        try {
            String encodedTitle = URLEncoder.encode(title, "UTF-8");
            //String encodedQuery = URLEncoder.encode(query, "UTF-8");
            //String encodedSubCategory = URLEncoder.encode(subCategory, "UTF-8");
            // Tạo URL để tìm kiếm sách theo từ khóa và mục con
            //String urlString = "https://www.googleapis.com/books/v1/volumes?q=" + encodedQuery + "+subject:" + encodedSubCategory + "&key=" + API_KEY;
            String urlString = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + encodedTitle + "&key=" + API_KEY;
            System.out.println("Request URL: " + urlString); // In URL để kiểm tra
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            conn.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String searchBookByISBN(String isbn) {
        try {
            String encodedISBN = URLEncoder.encode("isbn:" + isbn, "UTF-8");
            String urlString = "https://www.googleapis.com/books/v1/volumes?q=" + encodedISBN + "&key=" + API_KEY;
            
            System.out.println("Request URL: " + urlString); // In URL để kiểm tra

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            conn.disconnect();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static void parseBooks(String jsonResponse) {
        // Chuyển đổi chuỗi JSON thành một đối tượng JsonObject
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Kiểm tra nếu có trường "items" và trường này là một mảng
        if (jsonObject.has("items") && jsonObject.get("items").isJsonArray()) {
            JsonArray items = jsonObject.getAsJsonArray("items");

            // Duyệt qua từng cuốn sách trong mảng
            for (int i = 0; i < items.size(); i++) {
                JsonObject item = items.get(i).getAsJsonObject();
                    JsonObject volumeInfo = item.has("volumeInfo") && item.get("volumeInfo").isJsonObject() ?
                            item.getAsJsonObject("volumeInfo") : new JsonObject();

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

                    book.getInfo(); // Hiển thị thông tin sách
            }
        } else {
            System.out.println("No items found in the JSON response.");
        }
    }
}
