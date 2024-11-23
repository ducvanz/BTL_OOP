/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import static BTL_OOP.FindDocumentPanel.render;
import java.awt.CardLayout;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author thinh
 */
public class UserPanel extends JPanel {


    private Connection con;
    private JFrame mainFrame;
    private JPanel mainPanel;
    static RenderDocument render;
    
    /**
     * Creates new form userPanel
     */
    public UserPanel(){
    }
    public UserPanel(Connection con, JFrame mainFrame, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        render = new RenderDocument();
        enterLogin();
        
    }
    public static void enterLogin() {
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên accountInLoginTextField
        LoginPanel.getAccountInLoginTextField().addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !LoginPanel.getAccountInLoginTextField().getText().trim().isEmpty() // Ô tài khoản không trống
                    && LoginPanel.getPasswordInLoginPasswordField().getPassword().length > 0) { // ô mk k trống
                LoginPanel.getLoginButton().doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jPasswordField1
        LoginPanel.getPasswordInLoginPasswordField().addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER
                    && !LoginPanel.getAccountInLoginTextField().getText().trim().isEmpty()
                    && LoginPanel.getPasswordInLoginPasswordField().getPassword().length > 0) {
                LoginPanel.getLoginButton().doClick();  // Giả lập hành động nhấn nút
            }
        }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserPanel_ = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        homeUser = new javax.swing.JLabel();
        thongtin = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        timtailieu = new javax.swing.JLabel();
        avata = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        titleJLabel1 = new javax.swing.JLabel();
        imageJLabel1 = new javax.swing.JLabel();
        titleJLabel2 = new javax.swing.JLabel();
        imageJLabel2 = new javax.swing.JLabel();
        titleJLabel3 = new javax.swing.JLabel();
        imageJLabel3 = new javax.swing.JLabel();
        imageJLabel6 = new javax.swing.JLabel();
        titleJLabel4 = new javax.swing.JLabel();
        imageJLabel4 = new javax.swing.JLabel();
        titleJLabel5 = new javax.swing.JLabel();
        imageJLabel5 = new javax.swing.JLabel();
        titleJLabel6 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setLayout(new java.awt.GridBagLayout());

        UserPanel_.setBackground(new java.awt.Color(255, 255, 255));
        UserPanel_.setPreferredSize(new java.awt.Dimension(800, 650));

        home.setBackground(new java.awt.Color(153, 204, 255));
        home.setPreferredSize(new java.awt.Dimension(270, 650));

        homeUser.setBackground(new java.awt.Color(255, 255, 255));
        homeUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        homeUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeUser.setText("TRANG CHỦ");
        homeUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        thongtin.setBackground(new java.awt.Color(204, 204, 204));
        thongtin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        thongtin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thongtin.setText("THÔNG TIN");
        thongtin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        thongtin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thongtinMouseClicked(evt);
            }
        });

        username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username.setText("ACCOUNT");

        timtailieu.setBackground(new java.awt.Color(204, 204, 204));
        timtailieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timtailieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timtailieu.setText("TÌM TÀI LIỆU");
        timtailieu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        timtailieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedFindDoucument(evt);
            }
        });

        avata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/Remove-bg.ai_1729220335126.png"))); // NOI18N
        avata.setCursor(new java.awt.Cursor(java.awt.Cursor.SW_RESIZE_CURSOR));
        avata.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        avata.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        avata.setIconTextGap(0);
        avata.setMaximumSize(new java.awt.Dimension(19, 196));

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timtailieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(avata, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(avata, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(homeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(timtailieu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(thongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        thongtin.getAccessibleContext().setAccessibleName("");

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("LIBRARY");

        logOutButton.setBackground(new java.awt.Color(102, 153, 0));
        logOutButton.setForeground(new java.awt.Color(51, 51, 51));
        logOutButton.setText("Đăng xuất");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("TRANG CHỦ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152)
                .addComponent(logOutButton)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logOutButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        titleJLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        titleJLabel1.setText("Sách gì đây ai biết 1");

        imageJLabel1.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/logOut.png"))); // NOI18N
        imageJLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel1MouseClicked(evt);
            }
        });

        titleJLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        titleJLabel2.setText("Sách gì đây ai biết 1");

        imageJLabel2.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/logOut.png"))); // NOI18N
        imageJLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel2MouseClicked(evt);
            }
        });

        titleJLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        titleJLabel3.setText("Sách gì đây ai biết 1");

        imageJLabel3.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/logOut.png"))); // NOI18N
        imageJLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel3MouseClicked(evt);
            }
        });

        imageJLabel6.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/logOut.png"))); // NOI18N
        imageJLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel6MouseClicked(evt);
            }
        });

        titleJLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        titleJLabel4.setText("Sách gì đây ai biết 1");

        imageJLabel4.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/logOut.png"))); // NOI18N
        imageJLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel4MouseClicked(evt);
            }
        });

        titleJLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        titleJLabel5.setText("Sách gì đây ai biết 1");

        imageJLabel5.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/logOut.png"))); // NOI18N
        imageJLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel5MouseClicked(evt);
            }
        });

        titleJLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        titleJLabel6.setText("Sách gì đây ai biết 1");

        javax.swing.GroupLayout UserPanel_Layout = new javax.swing.GroupLayout(UserPanel_);
        UserPanel_.setLayout(UserPanel_Layout);
        UserPanel_Layout.setHorizontalGroup(
            UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanel_Layout.createSequentialGroup()
                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UserPanel_Layout.createSequentialGroup()
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imageJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40)
                                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imageJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageJLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imageJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(imageJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageJLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserPanel_Layout.setVerticalGroup(
            UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanel_Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserPanel_Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UserPanel_Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addComponent(imageJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addComponent(imageJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addComponent(imageJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addComponent(imageJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addComponent(imageJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserPanel_Layout.createSequentialGroup()
                                .addComponent(imageJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titleJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(UserPanel_, new java.awt.GridBagConstraints());
        UserPanel_.getAccessibleContext().setAccessibleName("userPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClickedFindDoucument(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedFindDoucument

        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "findDocumentPanel");
        FindDocumentPanel.setUsername(getUsername());
    }//GEN-LAST:event_mouseClickedFindDoucument

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
      int result = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc chắn muốn đăng xuất?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (result == JOptionPane.YES_OPTION) {
            CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
            cl.show(mainPanel, "loginPanel");
        }
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void thongtinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thongtinMouseClicked
        // TODO add your handling code here:
        InFoUserPanel.setDefaultInfo();
        
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "inFoUserPanel");
    }//GEN-LAST:event_thongtinMouseClicked

    public static Map<JLabel, JLabel> getListRecomentDocumentJLabel() {
        Map<JLabel, JLabel> result = new LinkedHashMap<>();
        result.put(titleJLabel1, imageJLabel1);
        result.put(titleJLabel2, imageJLabel2);
        result.put(titleJLabel3, imageJLabel3);
        result.put(titleJLabel4, imageJLabel4);
        result.put(titleJLabel5, imageJLabel5);
        result.put(titleJLabel6, imageJLabel6);
        return result;
    }
    
    //Hiển thị sách gơij ý 
    public static void displayRecommentDocument() {
        // Lấy tất cả tài liệu từ cơ sở dữ liệu và lịch sử mượn trả
        ArrayList<Document> allDocument = DocumentDAO.getAllDocuments();
        TransactionDAO transaction = new TransactionDAO();
        ArrayList<Document> suggest = transaction.topDocument();
        
        // Lấy Map chứa các JLabel cho tiêu đề và ảnh
        Map<JLabel, JLabel> labelMap = getListRecomentDocumentJLabel();
        
        // Duyệt qua danh sách tài liệu gợi ý và cập nhật vào JLabel
        if (suggest != null) {
            render.renderDocument(suggest, labelMap);
        }
    }
    
    private void imageJLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel1MouseClicked
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            render.renderDocumentToInfoDocument(imageJLabel1);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "displayDocumentPanel");
        }

    }//GEN-LAST:event_imageJLabel1MouseClicked

    private void imageJLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            render.renderDocumentToInfoDocument(imageJLabel2);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "displayDocumentPanel");
        }
    }//GEN-LAST:event_imageJLabel2MouseClicked

    private void imageJLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel3MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            render.renderDocumentToInfoDocument(imageJLabel3);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "displayDocumentPanel");
        }
    }//GEN-LAST:event_imageJLabel3MouseClicked

    private void imageJLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel6MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            render.renderDocumentToInfoDocument(imageJLabel6);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "displayDocumentPanel");
        }
    }//GEN-LAST:event_imageJLabel6MouseClicked

    private void imageJLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel4MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            render.renderDocumentToInfoDocument(imageJLabel4);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "displayDocumentPanel");
        }
    }//GEN-LAST:event_imageJLabel4MouseClicked

    private void imageJLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel5MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            render.renderDocumentToInfoDocument(imageJLabel5);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "displayDocumentPanel");
        }
    }//GEN-LAST:event_imageJLabel5MouseClicked

    public static void setUsername(String username){
        UserPanel.username.setText(username);
    }

    public static String getUsername() {
        return username.getText();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UserPanel_;
    private javax.swing.JLabel avata;
    private javax.swing.JPanel home;
    private javax.swing.JLabel homeUser;
    private static javax.swing.JLabel imageJLabel1;
    private static javax.swing.JLabel imageJLabel2;
    private static javax.swing.JLabel imageJLabel3;
    private static javax.swing.JLabel imageJLabel4;
    private static javax.swing.JLabel imageJLabel5;
    private static javax.swing.JLabel imageJLabel6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel thongtin;
    private javax.swing.JLabel timtailieu;
    private static javax.swing.JLabel titleJLabel1;
    private static javax.swing.JLabel titleJLabel2;
    private static javax.swing.JLabel titleJLabel3;
    private static javax.swing.JLabel titleJLabel4;
    private static javax.swing.JLabel titleJLabel5;
    private static javax.swing.JLabel titleJLabel6;
    private static javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
