/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BTL_OOP.main;

import BTL_OOP.main.database.DatabaseConnection;
import BTL_OOP.main.ui.login.LoginPanel;
import BTL_OOP.main.ui.login.SignupPanel;
import BTL_OOP.main.ui.users.DisplayDocumentPanel;
import BTL_OOP.main.ui.users.FindDocumentPanel;
import BTL_OOP.main.ui.users.InFoUserPanel;
import BTL_OOP.main.ui.users.UserPanel;
import BTL_OOP.main.ui.manage.ManagePanel;
import BTL_OOP.main.ui.manage.FindBookManage;
import BTL_OOP.main.ui.manage.ManageDocumentPanel;
import BTL_OOP.main.ui.manage.UserManagementPanel;
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
public final class Main extends JFrame {

    public CardLayout cardLayout;
    public static JPanel mainPanel;
    public static JFrame mainFrame;
    public static Connection con = DatabaseConnection.getDatabaseConnection().con;

    public Main() {
        init();
    }

    public void init() {
        mainFrame = new JFrame();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        setTitle("A+ OOP nè!");
        setSize(800, 650);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        SignupPanel signupPanel = new SignupPanel();
        LoginPanel loginPanel = new LoginPanel();
        UserPanel userPanel = new UserPanel();
        ManagePanel managePanel = new ManagePanel();
        FindDocumentPanel findDocumentPanel = new FindDocumentPanel(con, mainFrame, mainPanel);
        FindBookManage FindBookManage = new FindBookManage(con, mainFrame, mainPanel);
        ManageDocumentPanel manageDocumentPanel = new ManageDocumentPanel(con, mainFrame, mainPanel);

        DisplayDocumentPanel displayDocumentPanel = new DisplayDocumentPanel(con, mainFrame, mainPanel);
        InFoUserPanel inFoUserPanel = new InFoUserPanel(con, mainFrame, mainPanel);

        UserManagementPanel userManagementPanel = new UserManagementPanel(con, mainFrame, mainPanel);

        mainPanel.add(signupPanel, "signupPanel");
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.add(userPanel, "userPanel");
        mainPanel.add(managePanel, "managePanel");
        mainPanel.add(findDocumentPanel, "findDocumentPanel");
        mainPanel.add(displayDocumentPanel, "displayDocumentPanel");
        mainPanel.add(FindBookManage, "findBookManage");
        mainPanel.add(inFoUserPanel, "inFoUserPanel");
        mainPanel.add(userManagementPanel, "userManagementPanel");
        mainPanel.add(manageDocumentPanel, "manageDocumentPanel");

        // Thêm mainPanel vào JDialog
        add(mainPanel);

        // Hiển thị SignupPanel khi khởi động
        cardLayout.show(mainPanel, "signupPanel");

        setVisible(true);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Khởi động ứng dụng
        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}