/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP.main.ui.login;

import BTL_OOP.main.Main;
import BTL_OOP.main.ui.users.DisplayDocumentPanel;
import BTL_OOP.main.dao.TransactionDAO;
import BTL_OOP.main.ui.users.FindDocumentPanel;
import BTL_OOP.main.ui.users.InFoUserPanel;
import BTL_OOP.main.models.user.User;
import BTL_OOP.main.ui.users.UserPanel;
import BTL_OOP.main.ui.manage.ManagePanel;
import BTL_OOP.main.ui.manage.FindBookManage;
import BTL_OOP.main.models.user.Manage;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPanel extends JPanel {
    private final Connection connection;
    private final JPanel mainPanel;
    public static User userOverAll;
    public static boolean isManage;
    private TransactionDAO transactionDAO;
    private CardLayout cardLayout;
    public static Manage manage = new Manage();
    public static final String link = "D:\\OOP\\ahihi\\src\\BTL_OOP\\image\\";

    
    public LoginPanel() {
        initComponents();
        this.connection = Main.connection;
        this.mainPanel = Main.mainPanel;
        isManage = false; 
        if (userOverAll == null) {
            userOverAll = new User();
        }
        cardLayout = (CardLayout) mainPanel.getLayout();
        allSetup();
    }


    
    public void allSetup() {
        addToggleIcon(passwordInLoginPasswordField, link + "show.png" , link + "unShow.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        loginLabel.setText("ĐĂNG NHẬP");

        javax.swing.GroupLayout loginLabelPanelLayout = new javax.swing.GroupLayout(loginLabelPanel);
        loginLabelPanel.setLayout(loginLabelPanelLayout);
        loginLabelPanelLayout.setHorizontalGroup(
            loginLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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
        forgotPasswordLabel.setText("Bạn quên mật khẩu?  ");
        forgotPasswordLabel.setToolTipText("");

        manageRadioButton.setText("Tài khoản quản lý");

        thongbaodangnhapsai.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N

        signupInLoginLabel.setForeground(new java.awt.Color(0, 153, 255));
        signupInLoginLabel.setText("Đăng ký");
        signupInLoginLabel.setToolTipText("");
        signupInLoginLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupInLoginLabelMouseClicked(evt);
            }
        });

        loginButtonPanel.setBackground(new java.awt.Color(239, 246, 246));

        loginButton.setBackground(new java.awt.Color(102, 255, 102));
        loginButton.setText("ĐĂNG NHẬP");
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
            .addComponent(loginLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(accountInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(accountInLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(passwordInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(passwordInLoginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(thongbaodangnhapsai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(manageRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(loginButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(forgotPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176)
                .addComponent(signupInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        windowLoginPanelLayout.setVerticalGroup(
            windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addComponent(loginLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(accountInLoginLabel)
                .addGap(18, 18, 18)
                .addComponent(accountInLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(passwordInLoginLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordInLoginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(thongbaodangnhapsai, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(manageRadioButton)
                .addGap(52, 52, 52)
                .addComponent(loginButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(forgotPasswordLabel)
                    .addComponent(signupInLoginLabel)))
        );

        javax.swing.GroupLayout loginPaneLayout = new javax.swing.GroupLayout(loginPane);
        loginPane.setLayout(loginPaneLayout);
        loginPaneLayout.setHorizontalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(windowLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPaneLayout.createSequentialGroup()
                        .addComponent(librarynameInLoginLabel)
                        .addGap(37, 37, 37)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        loginPaneLayout.setVerticalGroup(
            loginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPaneLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(librarynameInLoginLabel)
                .addGap(32, 32, 32)
                .addComponent(windowLoginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        loginPane.getAccessibleContext().setAccessibleName("loginPanel");

        getAccessibleContext().setAccessibleName("loginPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void signupInLoginLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupInLoginLabelMouseClicked
        cardLayout.show( mainPanel, "signupPanel");
        
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
        if (manageRadioButton.isSelected()) {
            // check mk manage
            check = AuthenticationService.accountLogin(accountUser, pass, 2, connection);
        } else {
            // check mk user
            check = AuthenticationService.accountLogin(accountUser, pass, 1, connection);
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
            cardLayout.show(mainPanel, "userPanel");
            updateAccount();
            resetLogin();

            
        } else {

            LoginPanel.userOverAll = manage.getUserByUsername(accountUser);
            ManagePanel.setUsername(userOverAll.getName());
            FindBookManage.setDefaultInfo();
            InFoUserPanel.setDefaultInfo();
            isManage = true;
            cardLayout.show(mainPanel, "managePanel");
            updateAccount();
            resetLogin();

        }
        // set pane logi
        loginButton.setText("ĐĂNG NHẬP");
        accountInLoginTextField.setText("");
        passwordInLoginPasswordField.setText("");
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * Reset lại trang về mặc định.
     */
    public void resetLogin(){
        accountInLoginTextField.setText("");
        passwordInLoginPasswordField.setText("");
        thongbaodangnhapsai.setText("");
        loginButton.setText("ĐĂNG NHẬP");
    }
    
    /**
     * Cập nhật thông tin tài khoản chung lên các trang khác.
     */
    public static void updateAccount() {
        FindBookManage.user = userOverAll;
//        ManagePanel.user = userOverAll;
        TransactionDAO.user = userOverAll;
        FindDocumentPanel.displayRecommentDocument();
        DisplayDocumentPanel.isFromHome = true;
        if (isManage) {
            ManagePanel.displayRecommentDocument();
            
        } else {
            UserPanel.displayRecommentDocument();
        }
        

    }
    
    /**
     * Sau khi nhấn đăng xuất thì user chung về null.
     */
    public static void resetLoginAfter() {
        userOverAll = null;
        updateAccount();
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
    
    /**
     * Them icon cho o mk
     * @param passwordField
     * @param showIconPath
     * @param hideIconPath 
     */
    public static void addToggleIcon(JPasswordField passwordField, String showIconPath, String hideIconPath) {

        ImageIcon showIcon = new ImageIcon(new ImageIcon(showIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon hideIcon = new ImageIcon(new ImageIcon(hideIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        JLabel toggleIcon = new JLabel(hideIcon);
        toggleIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        passwordField.setLayout(new BorderLayout());
        passwordField.add(toggleIcon, BorderLayout.EAST);

        toggleIcon.addMouseListener(new MouseAdapter() {
            private boolean isPasswordVisible = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                isPasswordVisible = !isPasswordVisible;
                if (isPasswordVisible) {
                    passwordField.setEchoChar((char) 0); // Hiện mật khẩu
                    toggleIcon.setIcon(showIcon); // Đổi sang icon "Hiện"
                } else {
                    passwordField.setEchoChar('\u2022'); // Ẩn mật khẩu
                    toggleIcon.setIcon(hideIcon); // Đổi sang icon "Ẩn"
                }
            }
        });
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
