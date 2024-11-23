/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Admin
 */
public class EditBook extends javax.swing.JPanel {

    private Connection con;
    JFrame frame;
    JPanel mainPanel;
    static User user;
    
    public EditBook() {
        initComponents();
        this.con = con;
        this.frame = frame;
        this.mainPanel = mainPanel;
        allSetUp();
    }
    
    public EditBook(Connection con, JFrame frame, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.frame = frame;
        this.mainPanel = mainPanel;
        //allSetUp();
    }

    
    public void allSetUp() {
        resizeButtonIcon(jButton1, 12, 12);
        resizeLabelIcon(jLabel1, 80, 80);
        //resizeLabelIcon(jLabel8, 247, 161);
        addMenuItem();
        //enterUpLoad();
    }
    
    public void addMenuItem() {
        manageMenu.setBackground(new Color(50, 50, 50));  // Màu nền cho menu
        manageMenu.setForeground(Color.WHITE);            // Màu chữ cho menu

        trangchu.setBackground(new Color(255, 255, 255));       // Màu nền cho item
        trangchu.setForeground(Color.BLACK);                 // Màu chữ cho item
        suaSach.setBackground(new Color(255, 255, 255));
        suaSach.setForeground(Color.BLACK);
        themSach.setBackground(new Color(255, 255, 255));       // Màu nền cho item
        themSach.setForeground(Color.BLACK);                 // Màu chữ cho item
        timsach.setBackground(new Color(255, 255, 255));
        timsach.setForeground(Color.BLACK);
        xoaSach.setBackground(new Color(255, 255, 255));
        xoaSach.setForeground(Color.BLACK);
        nguoidung.setBackground(new Color(255, 255, 255));
        nguoidung.setForeground(Color.BLACK);

        manageMenu.add(trangchu);
        manageMenu.add(suaSach);
        manageMenu.add(themSach);
        manageMenu.add(timsach);
        manageMenu.add(xoaSach);
        manageMenu.add(nguoidung);
    }
        
    public void resizeButtonIcon(JButton button, int width, int height) {
        ImageIcon icon = (ImageIcon) button.getIcon(); // Lấy icon đã đặt qua phần Design
        if (icon != null) {
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage)); 
            
            button.setHorizontalTextPosition(SwingConstants.LEFT);
        }
    }
    
    // set icon cho button1(dang xuat)
    public void resizeLabelIcon(JLabel label, int width, int height) {
        ImageIcon icon = (ImageIcon) label.getIcon(); // Lấy icon đã đặt qua phần Design
        if (icon != null) {
            Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage)); 
            
            label.setHorizontalTextPosition(SwingConstants.LEFT);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageMenu = new javax.swing.JPopupMenu();
        trangchu = new javax.swing.JMenuItem();
        themSach = new javax.swing.JMenuItem();
        suaSach = new javax.swing.JMenuItem();
        timsach = new javax.swing.JMenuItem();
        xoaSach = new javax.swing.JMenuItem();
        nguoidung = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextField7 = new javax.swing.JTextField();

        trangchu.setText("Trang chủ");
        trangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangchuActionPerformed(evt);
            }
        });
        manageMenu.add(trangchu);

        themSach.setText("Thêm sách");
        themSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themSachActionPerformed(evt);
            }
        });
        manageMenu.add(themSach);

        suaSach.setText("Sửa sách");
        suaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaSachActionPerformed(evt);
            }
        });
        manageMenu.add(suaSach);

        timsach.setText("Tìm sách");
        timsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timsachActionPerformed(evt);
            }
        });
        manageMenu.add(timsach);

        xoaSach.setText("Xoá sách");
        manageMenu.add(xoaSach);

        nguoidung.setText("Người dùng");
        manageMenu.add(nguoidung);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(122, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/DeafaultAvata.png"))); // NOI18N
        jLabel1.setText("IMAGE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("ACCOUNT");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        jLabel3.setText("Sửa tài liệu");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/logOut.png"))); // NOI18N
        jButton1.setText("Đăng xuất");
        jButton1.setAlignmentY(0.0F);
        jButton1.setFocusCycleRoot(true);
        jButton1.setIconTextGap(1);
        jButton1.setMargin(new java.awt.Insets(2, 0, 3, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("menu");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel6.setText("Tên tài liệu: ");

        jLabel7.setText("ISBN: ");

        jLabel8.setText("Nhà xuất bản: ");

        jLabel9.setText("Năm xuất bản: ");

        jLabel10.setText("Ngôn ngữ:");

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel13.setText("Tác giả:");

        jSeparator1.setBackground(new java.awt.Color(255, 102, 102));
        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(577, 577, 577)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(442, 442, 442)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jLabel3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel7))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(302, 302, 302))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel3))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jLabel11)
                .addGap(50, 50, 50)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(106, 106, 106))
        );

        jPanel1.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleName("editBook");
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        manageMenu.show(jLabel4, evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited

    }//GEN-LAST:event_jLabel4MouseExited

    private void trangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangchuActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "managePanel");
    }//GEN-LAST:event_trangchuActionPerformed

    private void timsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timsachActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "findDocumentPanel");
    }//GEN-LAST:event_timsachActionPerformed

    private void themSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themSachActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "findBookManage");
    }//GEN-LAST:event_themSachActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void suaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaSachActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "editBook");
    }//GEN-LAST:event_suaSachActionPerformed

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Find Book Manage");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng ứng dụng khi đóng frame
        frame.setSize(800, 650); // Kích thước frame (chiều rộng, chiều cao)
        
        // Tạo một đối tượng FindBookManage và thêm vào frame
        EditBook editBook = new EditBook();
        frame.add(editBook); // Thêm panel vào frame
        
        // Đặt frame ở giữa màn hình
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Hiển thị frame
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPopupMenu manageMenu;
    private javax.swing.JMenuItem nguoidung;
    private javax.swing.JMenuItem suaSach;
    private javax.swing.JMenuItem themSach;
    private javax.swing.JMenuItem timsach;
    private javax.swing.JMenuItem trangchu;
    private javax.swing.JMenuItem xoaSach;
    // End of variables declaration//GEN-END:variables
}
