/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;
import java.util.ArrayList;
import java.util.concurrent.*;
/**
 *
 * @author thinh
 */
public class test {

    public static ArrayList<Document> getArrayDocumentAPI(String title, String author, String ISBN, String category, String language) {
        // Logic lấy dữ liệu từ API
        ArrayList<Document> result = API.getArrayDocument(title, author, ISBN, category, language);
        System.out.println("Fetching from API...");
        try {
            Thread.sleep(2000); // Giả lập thời gian lấy dữ liệu
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result; // Trả về danh sách tài liệu từ API
    }

    public static ArrayList<Document> getArrayDocumentInDB(String title, String author, String ISBN, String category, String language) {
        // Logic lấy dữ liệu từ CSDL
        ArrayList<Document> result = DocumentDAO.getAllDocumentInDB(title, author, ISBN, category, language);
        System.out.println("Fetching from Database...");
        try {
            Thread.sleep(3000); // Giả lập thời gian lấy dữ liệu
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(); // Trả về danh sách tài liệu từ CSDL
    }

    public static void main(String[] args) {
        // Tạo ExecutorService với 2 luồng
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Tạo Callable cho từng hàm
        Callable<ArrayList<Document>> fetchFromAPI = () -> getArrayDocumentAPI("C++", "", "", "", "");
        Callable<ArrayList<Document>> fetchFromDB = () -> getArrayDocumentInDB("C", "", "", "", "");

        try {
            // Gửi Callable vào ExecutorService và nhận kết quả
            Future<ArrayList<Document>> futureAPI = executorService.submit(fetchFromAPI);
            Future<ArrayList<Document>> futureDB = executorService.submit(fetchFromDB);

            // Chờ kết quả từ cả hai
            ArrayList<Document> apiResults = futureAPI.get();
            ArrayList<Document> dbResults = new ArrayList<>();
            if (futureAPI.get() != null){
                dbResults = futureDB.get();
            }

            // Kết hợp kết quả (nếu cần)
            ArrayList<Document> allResults = new ArrayList<>();
            
            allResults.addAll(apiResults);
            allResults.addAll(dbResults);

            System.out.println("API Results: " + apiResults.size() + " documents.");
            for(Document doc:apiResults){
                doc.getInfo();
            }
                        System.out.println("DB Results: " + dbResults.size() + " documents.");

            for(Document doc:dbResults){
                doc.getInfo();
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo tắt ExecutorService
            executorService.shutdown();
        }
    }
}


