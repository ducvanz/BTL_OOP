/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author thinh
 */
public class LoginPanel extends JPanel {
    private Connection con;

    JFrame mainFrame;
    JPanel mainPanel;
    public static User userOverAll;
    public static boolean isManage;
    public static String status;
    TransactionDAO transactionDAO;

    /**
     * Creates new form loginPanel
     */
    public LoginPanel(Connection con, JFrame mainFrame, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        isManage = false; 
        if (userOverAll == null) {
            userOverAll = new User();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPane = new javax.swing.JPanel();
        librarynameInLoginLabel = new javax.swing.JLabel();
        windowLoginPanel = new javax.swing.JPanel();
        loginLabelPanel = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        accountInLoginLabel = new javax.swing.JLabel();
        accountInLoginTextField = new javax.swing.JTextField();
        passwordInLoginLabel = new javax.swing.JLabel();
        passwordInLoginPasswordField = new javax.swing.JPasswordField();
        forgotPasswordLabel = new javax.swing.JLabel();
        manageRadioButton = new javax.swing.JRadioButton();
        thongbaodangnhapsai = new javax.swing.JLabel();
        signupInLoginLabel = new javax.swing.JLabel();
        loginButtonPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setLayout(new java.awt.GridLayout(1, 0));

        loginPane.setBackground(new java.awt.Color(255, 255, 255));
        loginPane.setMaximumSize(new java.awt.Dimension(400, 350));
        loginPane.setPreferredSize(new java.awt.Dimension(400, 350));

        librarynameInLoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        librarynameInLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        librarynameInLoginLabel.setText("THƯ VIỆN SỐ ANTEXT");
        librarynameInLoginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        windowLoginPanel.setBackground(new java.awt.Color(239, 246, 246));

        loginLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("LOGIN");

        javax.swing.GroupLayout loginLabelPanelLayout = new javax.swing.GroupLayout(loginLabelPanel);
        loginLabelPanel.setLayout(loginLabelPanelLayout);
        loginLabelPanelLayout.setHorizontalGroup(
            loginLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        loginLabelPanelLayout.setVerticalGroup(
            loginLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginLabel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        accountInLoginLabel.setText("Tài khoản");

        accountInLoginTextField.setToolTipText("Tên đăng nhập");

        passwordInLoginLabel.setText("Mật khẩu");

        forgotPasswordLabel.setForeground(new java.awt.Color(0, 153, 255));
        forgotPasswordLabel.setText("Bạn quên mật khẩu?                                         Sign up");
        forgotPasswordLabel.setToolTipText("");

        manageRadioButton.setText("Tài khoản quản lý");

        thongbaodangnhapsai.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N

        signupInLoginLabel.setForeground(new java.awt.Color(0, 153, 255));
        signupInLoginLabel.setText("Sign up");
        signupInLoginLabel.setToolTipText("");
        signupInLoginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupInLoginLabelMouseClicked(evt);
            }
        });

        loginButtonPanel.setBackground(new java.awt.Color(239, 246, 246));

        loginButton.setBackground(new java.awt.Color(102, 255, 102));
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginButtonPanelLayout = new javax.swing.GroupLayout(loginButtonPanel);
        loginButtonPanel.setLayout(loginButtonPanelLayout);
        loginButtonPanelLayout.setHorizontalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginButtonPanelLayout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(loginButton))
        );
        loginButtonPanelLayout.setVerticalGroup(
            loginButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginButtonPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(loginButton))
        );

        javax.swing.GroupLayout windowLoginPanelLayout = new javax.swing.GroupLayout(windowLoginPanel);
        windowLoginPanel.setLayout(windowLoginPanelLayout);
        windowLoginPanelLayout.setHorizontalGroup(
            windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginLabelPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(windowLoginPanelLayout.createSequentialGroup()
                        .addComponent(forgotPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signupInLoginLabel)
                        .addGap(23, 23, 23))
                    .addGroup(windowLoginPanelLayout.createSequentialGroup()
                        .addComponent(thongbaodangnhapsai, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInLoginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountInLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addComponent(loginButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        windowLoginPanelLayout.setVerticalGroup(
            windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addComponent(loginLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(accountInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accountInLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(passwordInLoginLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordInLoginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thongbaodangnhapsai, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageRadioButton)
                .addGap(52, 52, 52)
                .addComponent(loginButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgotPasswordLabel)
                    .addComponent(signupInLoginLabel))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(librarynameInLoginLabel)
                    .addComponent(windowLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginPaneLayout.setVerticalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(librarynameInLoginLabel)
                .addGap(32, 32, 32)
                .addComponent(windowLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(loginPane);
        loginPane.getAccessibleContext().setAccessibleName("loginPanel");

        getAccessibleContext().setAccessibleName("loginPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void signupInLoginLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupInLoginLabelMouseClicked
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show( mainPanel, "signupPanel");
        
    }//GEN-LAST:event_signupInLoginLabelMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        loginButton.setText("Đợi...");

        String accountUser = accountInLoginTextField.getText();
        char[] passWordUser = passwordInLoginPasswordField.getPassword();
        String pass = new String(passWordUser);
        
        /**
         * Check account.
         * 0: invalid
         * 1: user
         * 2: manage
         */
        int check = 0;
        Manage manage = new Manage();
        if (manageRadioButton.isSelected()) {
            // check mk manage
            check = AuthenticationService.accountLogin(accountUser, pass, 2, con);
        } else {
            // check mk user
            check = AuthenticationService.accountLogin(accountUser, pass, 1, con);
        }
        
        userOverAll.setUsername(accountUser);
        // kiem tra tai khoan
        if (check == 0) {
            thongbaodangnhapsai.setText("Tài khoản hoặc mật khẩu chưa chính xác");
            loginButton.setText("ĐĂNG NHẬP");
            passwordInLoginPasswordField.setText("");
        } else if (check == 1) {
            
            LoginPanel.userOverAll = manage.getUserByUsername(accountUser);
            UserPanel.setUsername(userOverAll.getName());
            CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
            cl.show(mainPanel, "userPanel");
            updateAccount();
            resetLogin();

            
        } else {

            LoginPanel.userOverAll = manage.getUserByUsername(accountUser);
            ManagePanel.setUsername(userOverAll.getName());
            FindBookManage.setDefaultInfo();
            InFoUserPanel.setDefaultInfo();
            isManage = true;
            CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
            cl.show(mainPanel, "managePanel");
            UserManagementPanel managetment = new UserManagementPanel();
            
            updateAccount();
            resetLogin();


        }
        userOverAll.displayUserInfo();
        // set pane logi
        loginButton.setText("ĐĂNG NHẬP");
        accountInLoginTextField.setText("");
        passwordInLoginPasswordField.setText("");
    }//GEN-LAST:event_loginButtonActionPerformed

    public void resetLogin(){
        accountInLoginTextField.setText("");
        passwordInLoginPasswordField.setText("");
        thongbaodangnhapsai.setText("");
        loginButton.setText("LOGIN");
    }
    public void updateAccount() {
        EditBook.user = userOverAll;
        FindBookManage.user = userOverAll;
        ManagePanel.user = userOverAll;
        transactionDAO = new TransactionDAO();
        FindDocumentPanel.displayRecommentDocument();
        if (isManage) {
            UserPanel.displayRecommentDocument();
            ManagePanel.displayRecommentDocument();
        } else {
            UserPanel.displayRecommentDocument();
        }
    }

    
    public static JTextField getAccountInLoginTextField() {
        return accountInLoginTextField;
    }

    public static JPasswordField getPasswordInLoginPasswordField() {
        return passwordInLoginPasswordField;
    }

    public static JButton getLoginButton() {
        return loginButton;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountInLoginLabel;
    private static javax.swing.JTextField accountInLoginTextField;
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JLabel librarynameInLoginLabel;
    private static javax.swing.JButton loginButton;
    private javax.swing.JPanel loginButtonPanel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPanel loginLabelPanel;
    private javax.swing.JPanel loginPane;
    private javax.swing.JRadioButton manageRadioButton;
    private javax.swing.JLabel passwordInLoginLabel;
    private static javax.swing.JPasswordField passwordInLoginPasswordField;
    private javax.swing.JLabel signupInLoginLabel;
    private javax.swing.JLabel thongbaodangnhapsai;
    private javax.swing.JPanel windowLoginPanel;
    // End of variables declaration//GEN-END:variables
}
