/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main.models.document;

import BTL_OOP.main.ui.users.DisplayDocumentPanel;
import BTL_OOP.main.dao.DocumentDAO;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JLabel;

/**
 *
 * @author thinh
 */
public class RenderDocument {

    public RenderDocument() {
        
    }
    
    /**
     * Hiển thị ảnh và tên tài liệu lên các trang cần thiết.
     * @param documents danh sách tài liệu phù hợp
     * @param labelMap Map của ảnh và tên sách tương ứng
     */
    public void renderDocument(ArrayList<Document> documents, Map<JLabel, JLabel> labelMap) {
        int count = 0;
        if (documents != null) {
            for (Document doc : documents) {
                if (count >= labelMap.size()) break;  // Dừng khi hết số lượng JLabel cần thiết

                // Lấy cặp JLabel cho tiêu đề và hình ảnh
                Map.Entry<JLabel, JLabel> entry = (Map.Entry<JLabel, JLabel>) labelMap.entrySet().toArray()[count];
                JLabel titleLabel = entry.getKey();
                JLabel imageLabel = entry.getValue();
//                System.out.println(entry.getKey().getText() + "  " +  entry.getValue().getText());
                // Cập nhật tiêu đề tài liệu vào JLabel
                titleLabel.setText(doc.getTitle());
                imageLabel.setText(doc.getTitle());
                // Cập nhật hình ảnh tài liệu vào JLabel
                if (doc.getImage() != null) {
                    DocumentDAO.displayImageFromBytes(doc.getImage(), imageLabel);
//                   System.out.println("Ảnh từ csdl image");
                } else {
//                    System.out.println("Ảnh mặc định");
                    DisplayDocumentPanel.loadImageFromFilePath(imageLabel, "C:\\Users\\thinh\\JAVA\\SWING\\src\\BTL_OOP\\image\\Screenshot_63.png");
                }
                count++;  // Tiến tới tài liệu tiếp theo
            }
        }
        
        // Đặt lại các JLabel còn lại trong Map nếu không có tài liệu nào được cập nhật
        for (int i = count; i < labelMap.size(); i++) {
            Map.Entry<JLabel, JLabel> entry = (Map.Entry<JLabel, JLabel>) labelMap.entrySet().toArray()[i];
            JLabel titleLabel = entry.getKey();
            JLabel imageLabel = entry.getValue();
            // Đặt lại tiêu đề và hình ảnh mặc định cho những JLabel còn lại
            titleLabel.setText("");  // Xóa tên tài liệu
            imageLabel.setText("");
            imageLabel.setIcon(null); // Xóa ảnh
        }
        
    }
    
    
    /**
     * Thực hiện chuyển sang trang thông tin tài liệu khi nhấn vào bìa sách.
     * @param label chứa bìa sách
     */
    public void renderDocumentToInfoDocument(JLabel label) {
        ArrayList<Document> arrDocument = DocumentDAO.getAllDocuments();
        for(Document d: arrDocument) {
            if (d.getTitle().equals(label.getText())){
                DisplayDocumentPanel.setDocument(d);
                DisplayDocumentPanel.displayDocument(true);
                    
                return;
            }
        }           
    }
}
