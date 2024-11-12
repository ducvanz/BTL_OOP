/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author thinh
 */
public class SignupPanel extends JPanel {
    private Connection con;
    private JFrame mainFrame;
    private JPanel mainPanel;
    /**
     * Creates new form signupPanel
     */
    public SignupPanel(Connection con, JFrame mainFrame, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        enterSignUp();
        
    }

    public void enterSignUp() {
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
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
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !nameTextField.getText().trim().isEmpty() // Ô tài khoản không trống
                    && !userAccountTextField.getText().trim().isEmpty()
                    && !msvTextField.getText().trim().isEmpty()
                    && passwordTextField.getPassword().length > 0) { // ô mk k trống
                //loginButton.doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        msvTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !nameTextField.getText().trim().isEmpty() // Ô tài khoản không trống
                    && !userAccountTextField.getText().trim().isEmpty()
                    && !msvTextField.getText().trim().isEmpty()
                    && passwordTextField.getPassword().length > 0) { // ô mk k trống
                //loginButton.doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jPasswordField1
        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        sigupPaneCard = new javax.swing.JPanel();
        libraryNameLabel = new javax.swing.JLabel();
        windowSigupPane = new javax.swing.JPanel();
        signupLabelPanel = new javax.swing.JPanel();
        signupLabel = new javax.swing.JLabel();
        hovatenLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        msvLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        userAccountTextField = new javax.swing.JTextField();
        accountLabel = new javax.swing.JLabel();
        msvTextField = new javax.swing.JTextField();
        signupButtonPanel = new javax.swing.JPanel();
        questionSignupLabel = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setLayout(new java.awt.GridBagLayout());

        sigupPaneCard.setBackground(new java.awt.Color(255, 255, 255));

        libraryNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        libraryNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libraryNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/Screenshot_54.png"))); // NOI18N
        libraryNameLabel.setText("THƯ VIỆN SỐ ANTEXT");
        libraryNameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        windowSigupPane.setBackground(new java.awt.Color(239, 246, 246));

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
            .addComponent(signupLabel)
        );

        hovatenLabel.setText("Họ và tên");

        nameTextField.setToolTipText("Tên đăng nhập");

        msvLabel.setText("Mã sinh viên");

        passwordLabel.setText("Mật khẩu");

        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        userAccountTextField.setToolTipText("Tên đăng nhập");

        accountLabel.setText("Tài khoản");

        msvTextField.setToolTipText("Tên đăng nhập");

        signupButtonPanel.setBackground(new java.awt.Color(239, 246, 246));

        questionSignupLabel.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        questionSignupLabel.setText("Bạn đã có tài khoản?");
        questionSignupLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionSignupLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout signupButtonPanelLayout = new javax.swing.GroupLayout(signupButtonPanel);
        signupButtonPanel.setLayout(signupButtonPanelLayout);
        signupButtonPanelLayout.setHorizontalGroup(
            signupButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupButtonPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(questionSignupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        signupButtonPanelLayout.setVerticalGroup(
            signupButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupButtonPanelLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(questionSignupLabel)
                .addContainerGap())
        );

        signupButton.setBackground(new java.awt.Color(102, 255, 102));
        signupButton.setText("SIGN UP");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout windowSigupPaneLayout = new javax.swing.GroupLayout(windowSigupPane);
        windowSigupPane.setLayout(windowSigupPaneLayout);
        windowSigupPaneLayout.setHorizontalGroup(
            windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signupLabelPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(windowSigupPaneLayout.createSequentialGroup()
                .addComponent(signupButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, windowSigupPaneLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountLabel)
                    .addComponent(msvLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hovatenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(msvTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userAccountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(103, 103, 103))
            .addGroup(windowSigupPaneLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(signupButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        windowSigupPaneLayout.setVerticalGroup(
            windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowSigupPaneLayout.createSequentialGroup()
                .addComponent(signupLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(hovatenLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(msvLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msvTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(accountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userAccountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(signupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signupButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout sigupPaneCardLayout = new javax.swing.GroupLayout(sigupPaneCard);
        sigupPaneCard.setLayout(sigupPaneCardLayout);
        sigupPaneCardLayout.setHorizontalGroup(
            sigupPaneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sigupPaneCardLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(windowSigupPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
            .addGroup(sigupPaneCardLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(libraryNameLabel)
                .addContainerGap())
        );
        sigupPaneCardLayout.setVerticalGroup(
            sigupPaneCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sigupPaneCardLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(libraryNameLabel)
                .addGap(18, 18, 18)
                .addComponent(windowSigupPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 102;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(sigupPaneCard, gridBagConstraints);
        sigupPaneCard.getAccessibleContext().setAccessibleName("signupPanel");

        getAccessibleContext().setAccessibleName("signupPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    
    private void questionSignupLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionSignupLabelMouseClicked
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show( mainPanel, "loginPanel");
    }//GEN-LAST:event_questionSignupLabelMouseClicked

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed

        int check = 0;
        // check MSV -> true -> check +1;
        String msv = msvTextField.getText();

        // check tên đã đúng chưa -> true -> check +1;
        String name = nameTextField.getText();

        // check tai khoan da ton tai
        String accout = userAccountTextField.getText();

        char[] arr = passwordTextField.getPassword();
        String pass = new String(arr);
        User user = new User(msv, name, accout, pass);

        if (AuthenticationService.checkID(msv, con)) {
            check ++;
        } else {
            msvTextField.setText("Nhập sai");
            resetOfSignUp();
        }

        if (AuthenticationService.checkName(name).equals("true")) {
            check ++;
        } else {
            nameTextField.setText(AuthenticationService.checkName(name));
            resetOfSignUp();
        }

        if (!AuthenticationService.checkAccount(accout, con)) {
            check++;
        } else {
            userAccountTextField.setText("Tai khoan da ton tai!");
            resetOfSignUp();
        }

        if (check == 3) {
            // hiện thông báo đã đki thành công
            JOptionPane.showMessageDialog(null, "Bạn đã đăng ký thành công?", "Thông báo", JOptionPane.PLAIN_MESSAGE);
            //            // Tạo icon từ tệp hình ảnh
            //            ImageIcon icon = new ImageIcon("path/to/your/icon.png"); // Thay đổi đường dẫn tới icon của bạn
            //
            //            // Hiển thị thông báo với icon tùy chỉnh
            //            JOptionPane.showMessageDialog(null,
                //                "Đây là một thông báo!",
                //                "Tiêu đề thông báo",
                //                JOptionPane.INFORMATION_MESSAGE,
                //                    icon);

            // thêm vào danh sách người dung
            Manage manage = new Manage();
            manage.addUser(user);
            // chuyen sang trang dang nhap
            CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
            cl.show(mainPanel, "loginPanel");
        }
    }//GEN-LAST:event_signupButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel hovatenLabel;
    private javax.swing.JLabel libraryNameLabel;
    private javax.swing.JLabel msvLabel;
    private javax.swing.JTextField msvTextField;
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
