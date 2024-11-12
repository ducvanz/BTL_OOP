/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author thinh
 */
public class Main extends JFrame {

    private Connection con;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    JFrame mainFframe = new JFrame();

    public Main() {
        init();
    }

    public void init() {
        setDB();
        mainFframe.setTitle("A+ OOP nè!");
        mainFframe.setSize(900, 650);
        mainFframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFframe.setLocationRelativeTo(null);

        // Khởi tạo CardLayout và mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Tạo và thêm SignupPanel vào mainPanel
        SignupPanel signupPanel = new SignupPanel(con, mainFframe, mainPanel);
        LoginPanel loginPanel = new LoginPanel(con, mainFframe, mainPanel);
        UserPanel userPanel = new UserPanel(con, mainFframe, mainPanel);
        ManagePanel managePanel = new ManagePanel(con, mainFframe, mainPanel);
        FindDocumentPanel findDocumentPanel = new FindDocumentPanel(con, mainFframe, mainPanel);

        mainPanel.add(signupPanel, "signupPanel");
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.add(userPanel, "userPanel");
        mainPanel.add(managePanel, "managePanel");
        mainPanel.add(findDocumentPanel, "findDocumentPanel");

        mainFframe.add(mainPanel);
        mainFframe.pack();
        // Hiển thị SignupPanel khi khởi động
        cardLayout.show(mainPanel, "signupPanel");
        
        
        //cardLayout.show(mainPanel, "findDocumentPanel");
        

        mainFframe.setVisible(true);
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
