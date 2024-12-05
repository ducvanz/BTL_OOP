/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main.models.document;

import BTL_OOP.main.dao.DocumentDAO;
import BTL_OOP.main.services.API;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author thinh
 */
public class RecommendDocument {
    public ArrayList<Document> getRecommendations(ArrayList<Document> history,
        ArrayList<Document> allDocument, int total) {
        Map<String, Integer> keyword = Collections.synchronizedMap(new HashMap<>());
        Map<String, Integer> category = Collections.synchronizedMap(new HashMap<>());
        // Tạo 2 Thread: Một cho việc đếm từ khóa, một cho việc đếm thể loại
        Thread keywordThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Document doc : history) {
                    String[] words = doc.getTitle().toLowerCase().split("\\s+");
                    for (String word : words) {
                        // Cập nhật tần suất từ khóa
                        synchronized (keyword) {
                            keyword.put(word, keyword.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            }
        });
        Thread categoryThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Document doc : history) {
                    synchronized (category) {
                        category.put(doc.getCategory(), category.getOrDefault(doc.getCategory(), 0) + 1);
                    }
                }
            }
        });
        // Khởi chạy cả hai luồng song song
        keywordThread.start();
        categoryThread.start();
        // Chờ đợi cả hai luồng hoàn thành
        try {
            keywordThread.join();
            categoryThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted", e);
        }
        // Lấy 3 từ khóa xuất hiện nhiều nhất
        List<String> topKeywords = getTopKeywords(keyword);
        //  Lấy thể loại xuất hiện nhiều nhất
        String topCategory = getTopCategory(category);
        // Tìm và trả về tài liệu gợi ý
        return searchDocumentRecomment(topKeywords, topCategory, allDocument, total, history);
    }

    /**
     * Lấy danh sách gợi ý sách.
     * @param topKeywords
     * @param topCategory
     * @param allDocuments
     * @param total
     * @param history
     * @return 
     */
    private ArrayList<Document> searchDocumentRecomment(List<String> topKeywords, 
        String topCategory, List<Document> allDocuments, int total, ArrayList<Document> history) {
        ArrayList<Document> result = new ArrayList<>();
    
        // Lọc các tài liệu theo từ khóa và thể loại
        // Lọc các tài liệu theo số lượng từ khóa có sẵn
        for (Document doc : allDocuments) {
            String title = doc.getTitle();
            boolean matchesKeyword = false;
            // Kiểm tra xem title có chứa bất kỳ từ khóa nào trong danh sách topKeywords không
            for (String keyword : topKeywords) {
                if (title.contains(keyword)) {
                    matchesKeyword = true;
                    break;
                }
            }
            // Nếu title chứa ít nhất 1 từ khóa và cùng thể loại, thêm vào kết quả nếu không có trong lịch sử
            if (matchesKeyword && doc.getCategory().equals(topCategory) && !history.contains(doc)) {
                result.add(doc);
            }
        }
        // Nếu kết quả ít hơn total, thêm tài liệu cùng thể loại vào
        if (result.size() < total) {
            for (Document doc : allDocuments) {
                if (doc.getCategory().equals(topCategory) && !result.contains(doc) && !history.contains(doc)) {
                    result.add(doc);
                }
                if (result.size() >= total) break; // Nếu đủ tài liệu, thoát vòng lặp
            }
        }    
        // Nếu vẫn thiếu tài liệu, thêm tài liệu ngẫu nhiên từ allDocuments (không có trong lịch sử)
        if (result.size() < total) {
            Random random = new Random();
            while (result.size() < total) {
                Document randomDoc = allDocuments.get(random.nextInt(allDocuments.size()));
                if (!result.contains(randomDoc) && !history.contains(randomDoc)) {
                    result.add(randomDoc);
                }
            }
        }    
        // Trả về total tài liệu ngẫu nhiên
        Collections.shuffle(result); // Sắp xếp ngẫu nhiên để đảm bảo tính ngẫu nhiên
        return new ArrayList<>(result.subList(0, total));
    }
    

    
    /**
     * Trả về 2 từ khoá được dùng phổ biến nhất.
     * @param keywordFrequency
     * @return 
     */
    private List<String> getTopKeywords(Map<String, Integer> keywordFrequency) {
        List<Map.Entry<String, Integer>> keywordList = new ArrayList<>(keywordFrequency.entrySet());

        // Sắp xếp danh sách các từ khóa theo tần suất giảm dần
        keywordList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });

        List<String> topKeywords = new ArrayList<>();
        for (int i = 0; i < Math.min(2, keywordList.size()); i++) {
            topKeywords.add(keywordList.get(i).getKey());
        }

        return topKeywords;
    }
   
    /**
     * Tìm kiếm thể loại sách được tìm kiếm, mượn nhiều nhất.
     * @param category
     * @return 
     */
    private String getTopCategory(Map<String, Integer> category) {
        String topCategory = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : category.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                topCategory = entry.getKey();
            }
        }

        return topCategory;
    }   
    
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
