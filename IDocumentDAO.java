/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BTL_OOP;

import java.util.ArrayList;

/**
 *
 * @author thinh
 */
public interface IDocumentDAO {
    void addDocument(Document doc);           // Thêm tài liệu
    void removeDocument(int documentID);      // Xóa tài liệu theo ID
    void updateDocument(Document doc);        // Cập nhật tài liệu
    Document getDocumentByID(int documentID); // Lấy tài liệu theo ID
    ArrayList<Document> getAllDocuments();
}
