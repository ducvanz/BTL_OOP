package BTL_OOP;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GoogleBooksAPI {
    private static final String API_KEY = "AIzaSyDOv7ofcaQnYInvp-IfsydvRqIVgArjGXg"; 
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
            String urlString = API_BASE_URL + "?q=" + query.toString() + "&key=" + API_KEY;
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

                        // Cắt chuỗi publishedDate lấy năm
                        if (publishedDate != null && !publishedDate.isEmpty() && publishedDate.length() >= 4) {
                            publishedDate = publishedDate.substring(0, 4);
                        } else {
                            publishedDate = "null";
                        }

                        Book book = new Book(bookIsbn, "null", bookTitle, bookAuthors, publisher, 
                                Integer.parseInt(publishedDate), 0, categories, language);
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

//    public static void main(String[] args) {
//        String result = searchBook("", "", "", "", "");
//        System.out.println(result);
//    }
}
