package OOPAPlus;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
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
                System.out.println("Volume Info: " + volumeInfo.toString()); // In ra dữ liệu để kiểm tra

                // Lấy thông tin về cuốn sách từ volumeInfo
                String title = volumeInfo.has("title") ? volumeInfo.get("title").getAsString() : "Unknown Title";

                // Lấy tên tác giả nếu có
                String author = "N/A";
                if (volumeInfo.has("authors") && volumeInfo.get("authors").isJsonArray()) {
                    JsonArray authorsArray = volumeInfo.getAsJsonArray("authors");
                    if (authorsArray.size() > 0) {
                        author = authorsArray.get(0).getAsString();
                    }
                }

                // Lấy thông tin nhà xuất bản nếu có
                String publisher = "N/A"; // Gán giá trị mặc định
                if (volumeInfo.has("publisher") && !volumeInfo.get("publisher").isJsonNull()) {
                    publisher = volumeInfo.get("publisher").getAsString();
                }

                // Lấy năm xuất bản nếu có
                int yearPublished = 0;
                if (volumeInfo.has("publishedDate")) {
                    try {
                        yearPublished = Integer.parseInt(volumeInfo.get("publishedDate").getAsString().substring(0, 4));
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        yearPublished = 0; // Gán giá trị mặc định nếu định dạng không chính xác
                    }
                }

                // Lấy ISBN nếu có
                String ISBN = "N/A";
                if (volumeInfo.has("industryIdentifiers") && volumeInfo.get("industryIdentifiers").isJsonArray()) {
                    JsonArray identifiersArray = volumeInfo.getAsJsonArray("industryIdentifiers");
                    if (identifiersArray.size() > 0 && identifiersArray.get(0).isJsonObject()) {
                        ISBN = identifiersArray.get(0).getAsJsonObject().get("identifier").getAsString();
                    }
                }

                // Tạo đối tượng Book và hiển thị thông tin
                Book book = new Book(ISBN, "1", title, author, publisher, yearPublished, 1, "Fiction", "English");
                book.displayDocumentInfor(); // Hiển thị thông tin sách
            }
        } else {
            System.out.println("No items found in the JSON response.");
        }
    }
}
