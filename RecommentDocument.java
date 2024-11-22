/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thinh
 */
public class RecommentDocument {
    
    public ArrayList<Document> getRecommendations(ArrayList<Document> history, ArrayList<Document> allDocument) {
        Map<String, Integer> keyword = Collections.synchronizedMap(new HashMap<>());
        Map<String, Integer> category= Collections.synchronizedMap(new HashMap<>());

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

        // 7. Tìm và trả về tài liệu gợi ý
        return searchDocuments(topKeywords, topCategory, allDocument);
    }
    
    // Trả về danh sách 3 từ khóa phổ biến nhất
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
        for (int i = 0; i < Math.min(3, keywordList.size()); i++) {
            topKeywords.add(keywordList.get(i).getKey());
        }

        return topKeywords;
    }
    // Trả về thể loại phổ biến nhất
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
    
    // Trả về các tài liệu gợi ý 
    private ArrayList<Document> searchDocuments(List<String> topKeywords, String topCategory, List<Document> allDocuments) {
        ArrayList<Document> result = new ArrayList<>();
        
            String top1 = topKeywords.get(0);
            String top2 = topKeywords.get(1);
            String top3 = topKeywords.get(2);
            System.out.println(top1 + "*" + top2 + "*" + top3);
            System.out.println(topCategory);
        for(Document doc : allDocuments) {
            String title = doc.getTitle();
            
            if ((title.contains(top1) || title.contains(top2) || title.contains(top3)) && doc.getCategory().equals(topCategory)) {
                System.out.println(title);
                result.add(doc);
            }
        }
         return result;
    }
}
