/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BTL_OOP.test.users;

import BTL_OOP.users.DisplayDocumentPanel;
import java.io.File;
import javax.swing.JLabel;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngothuyet
 */
public class DisplayDocumentPanelTest {
    
    public DisplayDocumentPanelTest() {
    }

   


    @Test
    public void testLoadImageFromFilePath()  {
       JLabel label = new JLabel();
        String testImagePath = "D:\\OOP\\BTL_OOP\\src\\BTL_OOP\\image\\A Study in Scarlet.png";
        File imageFile = new File(testImagePath);
        try {
            if (!imageFile.exists()) {
                assertTrue(imageFile.createNewFile());
            }
            DisplayDocumentPanel.loadImageFromFilePath(label, testImagePath);
            Thread.sleep(600);
            assertNotNull(label.getIcon());
        } catch (Exception e) {
            fail ("Không load được ảnh" + e.getMessage());
            
        }
        finally {
            if (imageFile.exists()) {
                imageFile.delete();
            }
        }
    } 

  
}
    

