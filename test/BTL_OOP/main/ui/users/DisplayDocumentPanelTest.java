/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package BTL_OOP.main.ui.users;

import java.awt.Image;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngothuyet
 */
public class DisplayDocumentPanelTest {
    
    public DisplayDocumentPanelTest() {
    }

   


    private JLabel label;
    private String validImagePath;
    private String invalidImagePath;

  
    public void setUp() {
        // Khởi tạo các đối tượng trước mỗi lần kiểm thử
        
        ImageIcon originalIcon = new ImageIcon("path/to/your/image.jpg");

        // Thay đổi kích thước của icon
        Image resizedImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Tạo JLabel và gán icon đã thay đổi kích thước
        label = new JLabel(resizedIcon);
        validImagePath = "D:\\OOP\\ahihi\\src\\BTL_OOP\\image\\A_Tour_of_C++.png";  // Đường dẫn hình ảnh hợp lệ
  
    }

    @Test
    public void testLoadImageFromValidFilePath() throws InterruptedException {
        // Giả lập việc tệp ảnh hợp lệ
        setUp();
        File validFile = new File(validImagePath);
        try {
            if (!validFile.exists()) {
                validFile.createNewFile();  // Tạo tệp giả lập
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error creating valid file for testing.");
        }

        // Act: Gọi phương thức để tải ảnh vào label
        System.out.print("hihi");
        DisplayDocumentPanel.loadImageFromFilePath(label, validImagePath);

        // Đợi cho đến khi công việc trong SwingWorker hoàn thành
        Thread.sleep(1000);  // Đợi một chút để SwingWorker hoàn thành

        // Assert: Kiểm tra xem label có icon không (có thể cần phải điều chỉnh cho phù hợp)
        if (label.getIcon() == null) {
            System.out.print("no");
        }
        else System.out.print("yes");
        assertNotNull(label.getIcon());
      
        // Clean up: Xóa tệp sau khi kiểm thử
        if (validFile.exists()) {
            validFile.delete();
        }
    }
}
