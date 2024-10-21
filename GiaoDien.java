/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class GiaoDien extends javax.swing.JFrame {

    /**
     * Creates new form GiaoDien
     */
    public GiaoDien() {
        initComponents();
        setDB();
        enterLogin();
        enterSignUp();
    }

    public  Connection con;

    public void setDB() {
        DatabaseConnection db = new DatabaseConnection();
        con = db.getConnection();
        db.connectDatabase();
    }
    
    public void enterLogin() {
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên accountInLoginTextField
        accountInLoginTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !accountInLoginTextField.getText().trim().isEmpty() // Ô tài khoản không trống
                    && passwordInLoginPasswordField.getPassword().length > 0) { // ô mk k trống
                loginButton.doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jPasswordField1
        passwordInLoginPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !accountInLoginTextField.getText().trim().isEmpty()
                    && passwordInLoginPasswordField.getPassword().length > 0) {
                loginButton.doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
    }
    
    
    public void enterSignUp() {
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !nameTextField.getText().trim().isEmpty() // Ô tài khoản không trống
                    && !userAccountTextField.getText().trim().isEmpty()
                    && passwordTextField.getPassword().length > 0) { // ô mk k trống
                loginButton.doClick();  // Giả lập hành động nhấn nút
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
                loginButton.doClick();  // Giả lập hành động nhấn nút
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
                loginButton.doClick();  // Giả lập hành động nhấn nút
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
                loginButton.doClick();  // Giả lập hành động nhấn nút
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

        jFrame1 = new javax.swing.JFrame();
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
        questionSignupLabel = new javax.swing.JLabel();
        userAccountTextField = new javax.swing.JTextField();
        accountLabel = new javax.swing.JLabel();
        msvTextField = new javax.swing.JTextField();
        signupButtonPanel = new javax.swing.JPanel();
        signupButton = new javax.swing.JButton();
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
        jLabel6 = new javax.swing.JLabel();
        signupInLoginLabel = new javax.swing.JLabel();
        loginButtonPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        homePane = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        sigupPaneCard.setBackground(new java.awt.Color(255, 255, 255));
        sigupPaneCard.setLayout(new java.awt.GridBagLayout());

        libraryNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        libraryNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        libraryNameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/Screenshot_54.png"))); // NOI18N
        libraryNameLabel.setText("THƯ VIỆN SỐ ANTEXT");
        libraryNameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(49, 200, 0, 199);
        sigupPaneCard.add(libraryNameLabel, gridBagConstraints);

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

        questionSignupLabel.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        questionSignupLabel.setText("Bạn đã có tài khoản?");
        questionSignupLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                questionSignupLabelMouseClicked(evt);
            }
        });

        userAccountTextField.setToolTipText("Tên đăng nhập");

        accountLabel.setText("Tài khoản");

        msvTextField.setToolTipText("Tên đăng nhập");

        signupButtonPanel.setBackground(new java.awt.Color(239, 246, 246));

        signupButton.setBackground(new java.awt.Color(102, 255, 102));
        signupButton.setText("SIGN UP");
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        signupButtonPanel.add(signupButton);

        javax.swing.GroupLayout windowSigupPaneLayout = new javax.swing.GroupLayout(windowSigupPane);
        windowSigupPane.setLayout(windowSigupPaneLayout);
        windowSigupPaneLayout.setHorizontalGroup(
            windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signupLabelPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(windowSigupPaneLayout.createSequentialGroup()
                .addGroup(windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(windowSigupPaneLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hovatenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(msvLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userAccountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(msvTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountLabel)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(questionSignupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 146, Short.MAX_VALUE))
                    .addComponent(signupButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        windowSigupPaneLayout.setVerticalGroup(
            windowSigupPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(windowSigupPaneLayout.createSequentialGroup()
                .addComponent(signupLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(hovatenLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msvLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(msvTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(accountLabel)
                .addGap(18, 18, 18)
                .addComponent(userAccountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(signupButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(questionSignupLabel)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 200, 69, 199);
        sigupPaneCard.add(windowSigupPane, gridBagConstraints);

        getContentPane().add(sigupPaneCard, "card1");

        loginPane.setBackground(new java.awt.Color(255, 255, 255));
        loginPane.setMaximumSize(new java.awt.Dimension(400, 350));
        loginPane.setPreferredSize(new java.awt.Dimension(400, 350));
        loginPane.setLayout(new java.awt.GridBagLayout());

        librarynameInLoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        librarynameInLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        librarynameInLoginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/Screenshot_54.png"))); // NOI18N
        librarynameInLoginLabel.setText("THƯ VIỆN SỐ ANTEXT");
        librarynameInLoginLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 199, 0, 0);
        loginPane.add(librarynameInLoginLabel, gridBagConstraints);

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N

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
        loginButtonPanel.add(loginButton);

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
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(windowLoginPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(windowLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInLoginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountInLoginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountInLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(passwordInLoginLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordInLoginPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 199, 65, 201);
        loginPane.add(windowLoginPanel, gridBagConstraints);

        getContentPane().add(loginPane, "card2");

        homePane.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TRANG CHỦ");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setBackground(new java.awt.Color(204, 204, 204));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("HỖ TRỢ");
        jLabel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("TÀI LIỆU MƯỢN");
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ACCOUNT");

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("TÌM TÀI LIỆU");
        jLabel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/Remove-bg.ai_1729220335126.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.SW_RESIZE_CURSOR));
        jLabel13.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jLabel13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/Screenshot_63.png"))); // NOI18N
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel13.setIconTextGap(0);
        jLabel13.setMaximumSize(new java.awt.Dimension(19, 196));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        jButton1.setText("Cập nhật");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel21.setText("khó qué");

        javax.swing.GroupLayout homePaneLayout = new javax.swing.GroupLayout(homePane);
        homePane.setLayout(homePaneLayout);
        homePaneLayout.setHorizontalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addGroup(homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 233, Short.MAX_VALUE))
        );
        homePaneLayout.setVerticalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(148, 148, 148))
        );

        getContentPane().add(homePane, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // set "wait" - login
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        loginButton.setText("Please Waitting");

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
        User user = new User();
        Manage manage = new Manage();
        if (manageRadioButton.isSelected()) {
            // check mk manage
            check = user.accountLogin(accountUser, pass, 2, con);
        } else {
            // check mk user
            check = user.accountLogin(accountUser, pass, 1, con);
        }
        
        user.setUserAccount(accountUser);
        
        // kiem tra tai khoan
        if (check == 0) {
            jLabel6.setText("Tài khoản hoặc mật khẩu chưa chính xác");
            loginButton.setText("LOGIN");
            passwordInLoginPasswordField.setText("");
        } else if (check == 1) {
            CardLayout cl = (CardLayout) getContentPane().getLayout(); // Lấy CardLayout
            cl.show(getContentPane(), "card3");
            int userID = manage.getUserIDByUserAccount(accountUser);
            user = manage.getUserByID(userID);
            jLabel19.setText(user.getUserName());
        } else {
            // mở giao diện quản lý
           
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    // nhấn vào nút đăng ký/ chuyển sang giao diện đăng ký
    private void signupInLoginLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupInLoginLabelMouseClicked
        CardLayout cl = (CardLayout) getContentPane().getLayout(); // Lấy CardLayout
       cl.show(getContentPane(), "card1"); 
    }//GEN-LAST:event_signupInLoginLabelMouseClicked

    // nếu đã có tài khoản thì chuyển sang trang đăng nhập
    private void questionSignupLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionSignupLabelMouseClicked
        CardLayout cl = (CardLayout) getContentPane().getLayout(); // Lấy CardLayout
        cl.show(getContentPane(), "card2");
    }//GEN-LAST:event_questionSignupLabelMouseClicked

    // bấm nút sign up
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
        
        if (user.checkID(msv, con)) {
            check ++;
        } else {
            msvTextField.setText("Nhập sai");
            resetOfSignUp();
        }
        
        if (user.checkName(name).equals("true")) {
            check ++;
        } else {
            nameTextField.setText(user.checkName(name));
            resetOfSignUp();
        }
        
        if (!user.checkAccount(accout, con)) {
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
            CardLayout cl = (CardLayout) getContentPane().getLayout(); // Lấy CardLayout
            cl.show(getContentPane(), "card2");
        }
    }//GEN-LAST:event_signupButtonActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountInLoginLabel;
    private javax.swing.JTextField accountInLoginTextField;
    private javax.swing.JLabel accountLabel;
    private javax.swing.JLabel forgotPasswordLabel;
    private javax.swing.JPanel homePane;
    private javax.swing.JLabel hovatenLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel libraryNameLabel;
    private javax.swing.JLabel librarynameInLoginLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginButtonPanel;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPanel loginLabelPanel;
    private javax.swing.JPanel loginPane;
    private javax.swing.JRadioButton manageRadioButton;
    private javax.swing.JLabel msvLabel;
    private javax.swing.JTextField msvTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel passwordInLoginLabel;
    private javax.swing.JPasswordField passwordInLoginPasswordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel questionSignupLabel;
    private javax.swing.JButton signupButton;
    private javax.swing.JPanel signupButtonPanel;
    private javax.swing.JLabel signupInLoginLabel;
    private javax.swing.JLabel signupLabel;
    private javax.swing.JPanel signupLabelPanel;
    private javax.swing.JPanel sigupPaneCard;
    private javax.swing.JTextField userAccountTextField;
    private javax.swing.JPanel windowLoginPanel;
    private javax.swing.JPanel windowSigupPane;
    // End of variables declaration//GEN-END:variables

}
