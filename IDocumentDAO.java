/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BTL_OOP;

import java.util.ArrayList;

/**
 *    Document getDocumentByID(int documentID); 

 * @author thinh
 */
public interface IDocumentDAO {
    void addDocument(Document doc);           
    void removeDocument(int documentID);      
    void updateDocument(Document doc);        
    Document getDocumentByID(int documentID); 
    ArrayList<Document> getAllDocuments();
}
