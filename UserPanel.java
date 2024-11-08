/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author thinh
 */
public class UserPanel extends JPanel {


    private Connection con;
    JFrame mainFrame;
    JPanel mainPanel;
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
        java.awt.GridBagConstraints gridBagConstraints;

        UserPanel_ = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        homeUser = new javax.swing.JLabel();
        thongtin = new javax.swing.JLabel();
        tailieumuon = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        timtailieu = new javax.swing.JLabel();
        avata = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();

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

        tailieumuon.setBackground(new java.awt.Color(204, 204, 204));
        tailieumuon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tailieumuon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tailieumuon.setText("TÀI LIỆU MƯỢN");
        tailieumuon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        avata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/Remove-bg.ai_1729220335126.png"))); // NOI18N
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
                    .addComponent(homeUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thongtin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tailieumuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timtailieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(avata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(avata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(homeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(tailieumuon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(timtailieu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(thongtin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );

        thongtin.getAccessibleContext().setAccessibleName("");

        jButton2.setText("Cập nhật");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel26.setText("khó qué");

        javax.swing.GroupLayout UserPanel_Layout = new javax.swing.GroupLayout(UserPanel_);
        UserPanel_.setLayout(UserPanel_Layout);
        UserPanel_Layout.setHorizontalGroup(
            UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanel_Layout.createSequentialGroup()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserPanel_Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jButton2))
                    .addGroup(UserPanel_Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 95, Short.MAX_VALUE))
        );
        UserPanel_Layout.setVerticalGroup(
            UserPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPanel_Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jButton2)
                .addGap(148, 148, 148))
            .addGroup(UserPanel_Layout.createSequentialGroup()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 139;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 6, 6);
        add(UserPanel_, gridBagConstraints);
        UserPanel_.getAccessibleContext().setAccessibleName("userPanel");
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClickedFindDoucument(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedFindDoucument

        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "findDocumentPanel");
        FindDocumentPanel.setUsername(getUsername());
    }//GEN-LAST:event_mouseClickedFindDoucument

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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel tailieumuon;
    private javax.swing.JLabel thongtin;
    private javax.swing.JLabel timtailieu;
    private static javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
