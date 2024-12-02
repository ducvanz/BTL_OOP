package BTL_OOP.publicc;
import BTL_OOP.API.API;
import BTL_OOP.document.DocumentDAO;
import BTL_OOP.document.Document;
import java.util.*;
import java.util.concurrent.*;

public class MultiThreaded {

    public static ArrayList<Document> getArrayDocumentFromAPI(String title, String author, String ISBN, String category, String language) {
        // Logic lấy dữ liệu từ API
        ArrayList<Document> result = API.getArrayDocument(title, author, ISBN, category, language);
        System.out.println("Fetching from API...");
        try {
            Thread.sleep(1000); // Giả lập thời gian lấy dữ liệu
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tải tài liệu từ API xong.");
        return result; // Trả về danh sách tài liệu từ API
    }

    public static ArrayList<Document> getArrayDocumentFromDB(String title, String author, String ISBN, String category, String language) {
        // Logic lấy dữ liệu từ CSDL
        ArrayList<Document> result = DocumentDAO.getAllDocumentInDB(title, author, ISBN, category, language);
        System.out.println("Fetching from Database...");
        try {
            Thread.sleep(1000); // Giả lập thời gian lấy dữ liệu
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tải tài liệu từ CSDL xong.");
        return result; // Trả về danh sách tài liệu từ CSDL
    }
    
    // Lấy tài liệu: check = true: từ API và CSDL, false : lấy tưf csdl.
    public static ArrayList<Document> searchDocument(String title, String author, String ISBN, String category, String language) {
        // Kết hợp kết quả
        ArrayList<Document> allResults = new ArrayList<>();

//        if (check == false) { // Chỉ lấy từ CSDL
            System.out.println("false");
            ArrayList<Document> dbResults = getArrayDocumentFromDB(title, author, ISBN, category, language);
            dbResults = dbResults != null ? dbResults : new ArrayList<>();
            allResults.addAll(dbResults);
//        } else if (check == true) { // Lấy từ cả API và CSDL
//            // Tạo CompletableFuture cho từng hàm
//             System.out.println("true");
//            CompletableFuture<ArrayList<Document>> fetchFromAPI = CompletableFuture.supplyAsync(() -> getArrayDocumentFromAPI(title, author, ISBN, category, language));
//            CompletableFuture<ArrayList<Document>> fetchFromDB = CompletableFuture.supplyAsync(() -> getArrayDocumentFromDB(title, author, ISBN, category, language));
//
//            // Kết hợp cả hai kết quả sau khi chúng hoàn thành
//            CompletableFuture<Void> allOf = CompletableFuture.allOf(fetchFromAPI, fetchFromDB);
//
//            try {
//                allOf.join(); // Chờ tất cả các task hoàn thành
//
//                // Lấy kết quả từ API và DB
//                ArrayList<Document> apiResults = fetchFromAPI.get();
//                ArrayList<Document> dbResults = fetchFromDB.get();
//
//                // Nếu kết quả từ API hoặc DB là null, thay thế bằng danh sách trống
//                apiResults = apiResults != null ? apiResults : new ArrayList<>();
//                dbResults = dbResults != null ? dbResults : new ArrayList<>();
//
//                // Loại bỏ các tài liệu trùng lặp
//                Set<Document> result = new HashSet<>(apiResults);
//                result.addAll(dbResults);
//
//                allResults = new ArrayList<>(result);
//
//                // In kết quả
//                System.out.println("API Results: " + apiResults.size() + " documents.");
//                System.out.println("DB Results: " + dbResults.size() + " documents.");
//                System.out.println("ALL Results: " + allResults.size() + " documents.");
//
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("Invalid source parameter. Please use 1 for DB only, or 2 for both API and DB.");
//        }

        return allResults;
    }


//    public static void main(String[] args) {
//        // Test searchDocument
//        ArrayList<Document> arr = searchDocument("C", "", "", "", "");
//    }
}
