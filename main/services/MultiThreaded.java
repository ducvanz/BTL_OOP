package BTL_OOP.main.services;

import BTL_OOP.main.dao.DocumentDAO;
import BTL_OOP.main.models.document.Document;
import java.util.*;

public class MultiThreaded {

    /**
     * Lấy về mảng tài liệu từ API.
     * @param title tra cứu bằng tên tài liệu
     * @param author tra cứu bằng tác giả
     * @param ISBN tra cứu bằng ISBN
     * @param category tra cứu bằng category
     * @param language
     * @return 
     */
    public static ArrayList<Document> getArrayDocumentFromAPI(String title, 
            String author, String ISBN, String category, String language) {
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

    /**
     * Lấy danh sách tài liệu từ DB.
     * @param title
     * @param author
     * @param ISBN
     * @param category
     * @param language
     * @return 
     */
    public static ArrayList<Document> getArrayDocumentFromDatabase(String title, String author, 
            String ISBN, String category, String language) {
        // Logic lấy dữ liệu từ CSDL
        ArrayList<Document> result = DocumentDAO.getAllDocumentInDatabase(title, author, ISBN, category, language);
        System.out.println("Fetching from Database...");
        try {
            Thread.sleep(1000); // Giả lập thời gian lấy dữ liệu
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Tải tài liệu từ CSDL xong.");
        return result; // Trả về danh sách tài liệu từ CSDL
    }
    
    /**
     * Phân luồng để kiểm tra nơi lấy tài liệu.
     * @param title
     * @param author
     * @param ISBN
     * @param category
     * @param language
     * @return 
     */
    public static ArrayList<Document> searchDocument(String title, String author, 
            String ISBN, String category, String language) {
        // Kết hợp kết quả
        ArrayList<Document> allResults = new ArrayList<>();
            System.out.println("false");
            ArrayList<Document> dbResults = getArrayDocumentFromDatabase(title, author, ISBN, category, language);
            dbResults = dbResults != null ? dbResults : new ArrayList<>();
            allResults.addAll(dbResults);

        return allResults;
    }

}
