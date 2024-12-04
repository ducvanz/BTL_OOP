
package BTL_OOP.main.ui.login;

import BTL_OOP.main.Main;
import BTL_OOP.main.models.user.User;
import BTL_OOP.main.models.user.Manage;
import BTL_OOP.main.services.CheckInput;
import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public final class SignupPanel extends JPanel {
    private final Connection connection;
    private final JPanel mainPanel ;
    private final CardLayout cardLayout ;
    Manage manage = LoginPanel.manage;

    public SignupPanel() {
        initComponents();
        this.connection = Main.connection;
        this.mainPanel = Main.mainPanel;
        cardLayout = (CardLayout) mainPanel.getLayout();
        enterSignUp();
        LoginPanel.addToggleIcon(passwordTextField, LoginPanel.link 
                + "show.png", LoginPanel.link + "unShow.png");

    }

    /**
     * Nhấn enter thực hiện kiểm tra tài khoản đăng ký.
     */
    public void enterSignUp() {
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !nameTextField.getText().trim().isEmpty() // Ô tài khoản không trống
                    && !userAccountTextField.getText().trim().isEmpty()
                    && passwordTextField.getPassword().length > 0) { // ô mk k trống
                //loginButton.doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        userAccountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !nameTextField.getText().trim().isEmpty() // Ô tài khoản không trống
                    && !userAccountTextField.getText().trim().isEmpty()
                    && passwordTextField.getPassword().length > 0) { // ô mk k trống
                //loginButton.doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
        
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jPasswordField1
        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !nameTextField.getText().trim().isEmpty() // Ô tài khoản không trống
                    && !userAccountTextField.getText().trim().isEmpty()
                    && passwordTextField.getPassword().length > 0) { // ô mk k trống
                //loginButton.doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
    }
    
    /**
     * Nếu tài khoản hoặc mật khẩu sai thì reset.
     */
    public void resetOfSignUp() {
        passwordTextField.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sigupPaneCard = new javax.swing.JPanel();
        libraryNameLabel = new javax.swing.JLabel();
        windowSigupPane = new javax.swing.JPanel();
        signupLabelPanel = new javax.swing.JPanel();
        signupLabel = new javax.swing.JLabel();
        hovatenLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        userAccountTextField = new javax.swing.JTextField();
        accountLabel = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        signupButtonPanel = new javax.swing.JPanel();
        questionSignupLabel = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setLayout(new java.awt.BorderLayout());

        sigupPaneCard.setBackground(new java.awt.Color(255, 255, 255));

        libraryNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        libraryNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libraryNameLabel.setText("THƯ VIỆN SỐ ANTEXT");
        libraryNameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        windowSigupPane.setBackground(new java.awt.Color(239, 246, 246));
        windowSigupPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signupLabel.setBackground(new java.awt.Color(51, 51, 255));
        signupLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signupLabel.setText("SIGN UP");

        javax.swing.GroupLayout signupLabelPanelLayout = new javax.swing.GroupLayout(signupLabelPanel);
        signupLabelPanel.setLayout(signupLabelPanelLayout);
        signupLabelPanelLayout.setHorizontalGroup(
            signupLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signupLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        signupLabelPanelLayout.setVerticalGroup(
            signupLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupLabelPanelLayout.createSequentialGroup()
                .addComponent(signupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        windowSigupPane.add(signupLabelPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 424, -1));

        hovatenLabel.setText("Họ và tên");
        windowSigupPane.add(hovatenLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 86, 60, -1));

        nameTextField.setToolTipText("Tên đăng nhập");
        windowSigupPane.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 290, -1));

        passwordLabel.setText("Mật khẩu");
        windowSigupPane.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 70, -1));

        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });
        windowSigupPane.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 295, 290, -1));

        userAccountTextField.setToolTipText("Tên đăng nhập");
        windowSigupPane.add(userAccountTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 290, -1));

        accountLabel.setText("Tài khoản");
        windowSigupPane.add(accountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        signupButton.setBackground(new java.awt.Color(102, 255, 102));
        signupButton.setText("SIGN UP");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        windowSigupPane.add(signupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        signupButtonPanel.setBackground(new java.awt.Color(239, 246, 246));

        javax.swing.GroupLayout signupButtonPanelLayout = new javax.swing.GroupLayout(signupButtonPanel);
        signupButtonPanel.setLayout(signupButtonPanelLayout);
        signupButtonPanelLayout.setHorizontalGroup(
            signupButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        signupButtonPanelLayout.setVerticalGroup(
            signupButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        windowSigupPane.add(signupButtonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 441, -1, -1));

        questionSignupLabel.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        questionSignupLabel.setText("Bạn đã có tài khoản?");
        questionSignupLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionSignupLabelMouseClicked(evt);
            }
        });
        windowSigupPane.add(questionSignupLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 119, -1));

        javax.swing.GroupLayout sigupPaneCardLayout = new javax.swing.GroupLayout(sigupPaneCard);
        sigupPaneCard.setLayout(sigupPaneCardLayout);
        sigupPaneCardLayout.setHorizontalGroup(
            sigupPaneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sigupPaneCardLayout.createSequentialGroup()
                .addGroup(sigupPaneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sigupPaneCardLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(windowSigupPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sigupPaneCardLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(libraryNameLabel)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        sigupPaneCardLayout.setVerticalGroup(
            sigupPaneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sigupPaneCardLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(libraryNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(windowSigupPane, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        add(sigupPaneCard, java.awt.BorderLayout.CENTER);
        sigupPaneCard.getAccessibleContext().setAccessibleName("signupPanel");

        getAccessibleContext().setAccessibleName("signupPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    /**
     * Chuyển pane login.
     * @param evt 
     */
    
    private void questionSignupLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionSignupLabelMouseClicked
       cardLayout.show( mainPanel, "loginPanel");
    }//GEN-LAST:event_questionSignupLabelMouseClicked
    
    /**
     * Khi nhấn nút đăng ký thì xác nhận avf kiểm tra.
     * @param evt 
     */
    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed

        if (!CheckInput.checkFullName(nameTextField.getText())) {
            JOptionPane.showMessageDialog(mainPanel, "Họ và tên cần viết hoa "
                    + "chữ cái đầu, không chứa các kí tự đặc biệt!");
            return;
        }
        int check = 0;
        

        // check tên đã đúng chưa -> true -> check +1;
        String name = nameTextField.getText();

        if (!CheckInput.checkUserName(userAccountTextField.getText())) {
            JOptionPane.showMessageDialog(mainPanel, "Tài khoản không hợp lệ!");
            return;
        }
        // check tai khoan da ton tai
        String username = userAccountTextField.getText();

        char[] arr = passwordTextField.getPassword();
        
        if (arr.length > 30) {
            JOptionPane.showMessageDialog(mainPanel, "Mật khẩu quá dài!");
            return;
        }
        String pass = new String(arr);
        User user = new User( name, username, pass);


        if (AuthenticationService.checkName(name).equals("true")) {
            check ++;
        } else {
            nameTextField.setText(AuthenticationService.checkName(name));
            resetOfSignUp();
        }

        if (!AuthenticationService.checkAccount(username, connection)) {
            check++;
        } else {
            userAccountTextField.setText("Tai khoan da ton tai!");
            resetOfSignUp();
        }

        if (check == 2) {
            JOptionPane.showMessageDialog(null, "Bạn đã đăng ký thành công?", 
                    "Thông báo", JOptionPane.PLAIN_MESSAGE);

            // thêm vào danh sách người dung
            Manage manage = new Manage();
            manage.addUser(user);
            // chuyen sang trang dang nhap
            CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
            cl.show(mainPanel, "loginPanel");
            resetPane();
        }
    }//GEN-LAST:event_signupButtonActionPerformed
    
    /**
     * Đăng ký thành công thì reset trang.
     */
    private void resetPane() {
        nameTextField.setText("");
        userAccountTextField.setText("");
        passwordTextField.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel hovatenLabel;
    private javax.swing.JLabel libraryNameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel questionSignupLabel;
    private javax.swing.JButton signupButton;
    private javax.swing.JPanel signupButtonPanel;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JPanel signupLabelPanel;
    private javax.swing.JPanel sigupPaneCard;
    private javax.swing.JTextField userAccountTextField;
    private javax.swing.JPanel windowSigupPane;
    // End of variables declaration//GEN-END:variables
}
