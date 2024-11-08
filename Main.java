/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author thinh
 */
public class Main extends JFrame {
    public  Connection con;
    private CardLayout cardLayout; 
    private JPanel mainPanel;
    JFrame frame = new JFrame();
    
    public Main() {
        init();
    }
    public void init(){
        setDB();
        setTitle("A+ OOP nè!");
        setSize(800, 650);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Khởi tạo CardLayout và mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        // Tạo và thêm SignupPanel vào mainPanel
        SignupPanel signupPanel = new SignupPanel(con, frame, mainPanel);
        LoginPanel loginPanel = new LoginPanel(con, frame, mainPanel);
        UserPanel userPanel = new UserPanel(con, frame, mainPanel);
        ManagePanel managePanel = new ManagePanel(con, frame, mainPanel);
        FindDocumentPanel findDocumentPanel = new FindDocumentPanel(con, frame, mainPanel);
        FindBookManage FindBookManage = new FindBookManage(con, frame, mainPanel);
        
        mainPanel.add(signupPanel, "signupPanel");
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.add(userPanel, "userPanel");
        mainPanel.add(managePanel, "managePanel");
        mainPanel.add(findDocumentPanel, "findDocumentPanel");
        mainPanel.add(FindBookManage, "findBookManage");
        
        // Thêm mainPanel vào JDialog
        add(mainPanel);
        
        // Hiển thị SignupPanel khi khởi động
        cardLayout.show(mainPanel, "signupPanel");
        
        setVisible(true); 
    }
    
    public void setDB() {
        DatabaseConnection db = new DatabaseConnection();
        con = db.getConnection();
    }

    public static void main(String[] args) {
        // Khởi động ứng dụng
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}
