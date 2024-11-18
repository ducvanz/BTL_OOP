/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author Admin
 */
public class FindBookManage extends javax.swing.JPanel {

    /**
     * Creates new form FindBookManage
     */
    public FindBookManage() {
        initComponents();
        allSetUp();
    }

        private Connection con;
        JFrame frame;
        JPanel mainPanel;
        static User user;
    /**
     * Creates new form managePanel
     */
    public FindBookManage(Connection con, JFrame frame, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.frame = frame;
        this.mainPanel = mainPanel;
        if(user == null) {
            user = new User();
        }
        allSetUp();
    }
    
    public void allSetUp() {
        resizeButtonIcon(jButton1, 12, 12);
        resizeLabelIcon(jLabel1, 80, 80);
        //resizeLabelIcon(jLabel8, 247, 161);
        addMenuItem();
        enterUpLoad();
        desDefault("avataBook.png", jLabel5);
    }
    
    
    // set icon cho button1(dang xuat)
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

    
    // thong tin mac dinh khi khoi tao
    public static void setDefaultInfo() {
        user = LoginPanel.userOverAll;
        String name = user.getName();
        jLabel2.setText(name);
    }
    
    
    // 
    public void setTable() {
        
        
    }
    
    public void desDefault(String ima, JLabel label) {
        try {
            // Địa chỉ ảnh mặc định
            String imagePath = "C:\\Users\\Admin\\NetBean\\DEMO_BTL\\src\\BTL_OOP\\image\\" + ima;  // Thay đổi đường dẫn ảnh mặc định của bạn

            // Đọc ảnh từ file
            Image image = ImageIO.read(new File(imagePath));

            // Lấy kích thước của ảnh gốc
            int originalWidth = image.getWidth(null);
            int originalHeight = image.getHeight(null);

            // Kích thước của JLabel (jLabel5)
            int labelWidth = 150;  // Chiều rộng mong muốn
            int labelHeight = 210; // Chiều cao mong muốn

            // Tính toán tỷ lệ thay đổi kích thước sao cho ảnh không bị méo
            double widthRatio = (double) labelWidth / originalWidth;
            double heightRatio = (double) labelHeight / originalHeight;

            // Chọn tỷ lệ nhỏ hơn để giữ tỷ lệ gốc của ảnh
            double scaleRatio = Math.min(widthRatio, heightRatio);

            // Tính toán kích thước mới của ảnh
            int newWidth = (int) (originalWidth * scaleRatio);
            int newHeight = (int) (originalHeight * scaleRatio);

            // Thay đổi kích thước ảnh với tỷ lệ vừa đủ mà không bị méo
            Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Đặt icon cho jLabel5
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            label.setIcon(imageIcon);  // Cập nhật icon cho jLabel5
            label.setText(""); // Xóa văn bản trên JLabel khi ảnh được hiển thị

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load the image", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        trangchu.setText("Trang chủ");
        trangchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangchuActionPerformed(evt);
            }
        });

        themSach.setText("Thêm sách");

        suaSach.setText("Sửa sách");
        suaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaSachActionPerformed(evt);
            }
        });

        timsach.setText("Tìm sách");
        timsach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timsachActionPerformed(evt);
            }
        });

        xoaSach.setText("Xoá sách");
        xoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaSachActionPerformed(evt);
            }
        });

        nguoidung.setText("Người dùng");

        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(122, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/DeafaultAvata.png"))); // NOI18N
        jLabel1.setText("IMAGE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("ACCOUNT");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 28)); // NOI18N
        jLabel3.setText("Thêm tài liệu");

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

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel5");
        jLabel5.setPreferredSize(new java.awt.Dimension(40, 20));

        jButton2.setText("Up Image");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel6.setText("Tên tài liệu: ");

        jLabel7.setText("ISBN: ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nhập", "Tên", "Tác giả", "ISBN", "Nhà xuất bản", "Năm xuất bản", "Thể loại", "Ngôn ngữ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jLabel8.setText("Nhà xuất bản: ");

        jLabel9.setText("Năm xuất bản: ");

        jLabel10.setText("Ngôn ngữ:");

        jLabel12.setText("Mô tả: file .dox");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton3.setText("up file");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("Hoàn Tất");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setText("Tác giả:");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(300, 300, 300)
                                        .addComponent(jLabel11))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(442, 442, 442)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6))
                                .addGap(21, 21, 21))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(97, 97, 97)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3))))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(137, 137, 137)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel13)))
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        add(jPanel1);

        getAccessibleContext().setAccessibleName("findBookManage");
    }// </editor-fold>//GEN-END:initComponents

    private void trangchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangchuActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "managePanel");
    }//GEN-LAST:event_trangchuActionPerformed

    private void timsachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timsachActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "findDocumentPanel");
    }//GEN-LAST:event_timsachActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    // nhan nut -> tai file
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select an Image");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy file đã chọn
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Đọc ảnh từ file đã chọn
                Image image = ImageIO.read(selectedFile);
                
                // Lấy kích thước của ảnh gốc
                int originalWidth = image.getWidth(null);
                int originalHeight = image.getHeight(null);

                int labelWidth = jLabel5.getWidth();
                int labelHeight = jLabel5.getHeight();

                double widthRatio = (double) labelWidth / originalWidth;
                double heightRatio = (double) labelHeight / originalHeight;

                double scaleRatio = Math.min(widthRatio, heightRatio);

                int newWidth = (int) (originalWidth * scaleRatio);
                int newHeight = (int) (originalHeight * scaleRatio);

                Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                ImageIcon imageIcon = new ImageIcon(scaledImage);
                jLabel5.setIcon(imageIcon);  
                jLabel5.setText(""); 
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to load the image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

        public String imageLabelToBase64String(JLabel jLabel) {
        try {
            // Lấy ImageIcon từ JLabel
            ImageIcon icon = (ImageIcon) jLabel.getIcon();
            if (icon == null) {
                JOptionPane.showMessageDialog(null, "No image found in the label", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // Chuyển ImageIcon sang BufferedImage
            BufferedImage bufferedImage = new BufferedImage(
                    icon.getIconWidth(),
                    icon.getIconHeight(),
                    BufferedImage.TYPE_INT_ARGB);
            bufferedImage.getGraphics().drawImage(icon.getImage(), 0, 0, null);

            // Lưu ảnh tạm ra file để lấy đường dẫn local
            File tempFile = File.createTempFile("tempImage", ".png");
            ImageIO.write(bufferedImage, "png", tempFile);
            String localPath = tempFile.getAbsolutePath();
            System.out.println("Local path of the temporary image: " + localPath);

            // Chuyển BufferedImage sang chuỗi base64
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos); // Định dạng png
            baos.flush();
            byte[] imageBytes = baos.toByteArray();
            String base64String = Base64.getEncoder().encodeToString(imageBytes);
            baos.close();

            return base64String;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to process the image", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
        
    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited

    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        manageMenu.show(jLabel4, evt.getX(), evt.getY());
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Book Abook = new Book();
                Abook.setTitle(jTextField2.getText());
                Abook.setAuthor(jTextField6.getText());
                Abook.setISBN(jTextField4.getText());
                Abook.setPublisher(jTextField1.getText());
                try {
                    String year = jTextField5.getText();
                    Abook.setPublishedDate(year);
                } catch (NumberFormatException e) {
                    Abook.setPublishedDate("0");
                }
                Abook.setCategory("");
                Abook.setLanguage(jTextField3.getText());
                
                if (Abook.getTitle() != null && !Abook.getTitle().isEmpty() &&
                    Abook.getAuthor() != null && !Abook.getAuthor().isEmpty() &&
                    Abook.getPublisher() != null && !Abook.getPublisher().isEmpty()) {
                    String inff = "Tên tài liệu: " + Abook.getTitle() + "\n" +
                            "Tác giả: " + Abook.getAuthor() + "\n" +
                            "ISBN: " + Abook.getISBN() + "\n" +
                            "Nhà xuất bản: " + Abook.getPublisher() + "\n" +
                            "Năm xuất bản: " + Abook.getPublishedDate() + "\n" +
                            "Thể loại: " + Abook.getCategory() + "\n" +
                            "Ngôn ngữ: " + Abook.getLanguage();
                    int results = JOptionPane.showConfirmDialog(
                    null,
                    inff,
                    "Xác nhận thông tin tài liệu thêm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                    
                    if (results == JOptionPane.YES_OPTION) {
                        List<Book> list = Abook.searchBooks(con, Abook.getTitle(),
                                Abook.getAuthor(), Abook.getISBN(), Abook.getPublisher(), 
                                Abook.getPublishedDate(), Abook.getCategory(), Abook.getLanguage());
                        
                        if (!list.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Thông tin tài liệu đã tồn lại trong cơ sở dữ liệu");
                        } else {
                            String input = JOptionPane.showInputDialog(
                                null,                   // Cha mẹ của hộp thoại (null để hiển thị ở giữa màn hình)
                                "Nhập số lượng:",     // Thông báo hiển thị trên hộp thoại
                                "Thông báo",             // Tiêu đề của hộp thoại
                                JOptionPane.INFORMATION_MESSAGE);
                            
                            if (input != null || input.trim().isEmpty()) {
                            
                                try {
                                    int nh = Integer.parseInt(input);
                                    Abook.setQuantity(nh);
                                    JOptionPane.showMessageDialog(null, "thêm thành công!");
                                    Abook.setImagelink(imageLabelToBase64String(jLabel5));

                                    Abook.addBook(con, Abook);
                                    resetPane();
                                } catch (NumberFormatException es) {
                                    JOptionPane.showMessageDialog(null, "Lỗi nhập số lượng!");
                                }
                            }
                        }
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Nhập thủ công, vui lòng điền đầy đủ thông tin",
                            "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void xoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaSachActionPerformed
        
    }//GEN-LAST:event_xoaSachActionPerformed

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

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Find Book Manage");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng ứng dụng khi đóng frame
//        frame.setSize(800, 650); // Kích thước frame (chiều rộng, chiều cao)
//        
//        // Tạo một đối tượng FindBookManage và thêm vào frame
//        FindBookManage findBookManagePanel = new FindBookManage();
//        frame.add(findBookManagePanel); // Thêm panel vào frame
//        
//        // Đặt frame ở giữa màn hình
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true); // Hiển thị frame
//    }
    
    public void enterUpLoad() {
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) { 
                upDateDataFromAPI();
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) { 
                upDateDataFromAPI();
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jTextField1
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) { // ô mk k trống
                upDateDataFromAPI();
            }
        }
        });
        
        // Thêm KeyListener để bắt sự kiện nhấn phím Enter trên jPasswordField1
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) { 
                upDateDataFromAPI();
            }
        }
        });
        
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) { 
                upDateDataFromAPI();
            }
        }
        });
    }
    
    public void upDateDataFromAPI() {
        ToolTipManager.sharedInstance().setInitialDelay(0);

        // Tạo model cho bảng với các tiêu đề cột
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{}, 
            new String[]{"Nhập", "Tên", "Tác giả", "ISBN", "Nhà xuất bản", "Ngày xuất bản", "Ngôn ngữ", "Thể loại"}
        );
        jTable1.setModel(model);

        // Lấy dữ liệu từ API
        String isbn = jTextField4.getText();
        String title = jTextField2.getText();
        String author = jTextField6.getText();
        String published = jTextField1.getText();
        String publishedDate = jTextField5.getText();
        List<Book> book = API.searchBook(isbn, title, author, published, publishedDate);

        if (book == null || book.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books found!", "No Results", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Thêm dữ liệu từ API vào model
        for (int dem = 0; dem < book.size() && dem < 15; dem++) {
            Object[] rowData = new Object[] {
                "Nhập",                            // Văn bản hiển thị trong nút
                book.get(dem).getTitle(),          // Tên
                book.get(dem).getAuthor(),         // Tác giả
                book.get(dem).getISBN(),           // ISBN
                book.get(dem).getPublisher(),      // Nhà xuất bản
                book.get(dem).getPublishedDate(),  // Ngày xuất bản  
                book.get(dem).getLanguage(),       // Ngôn ngữ
                book.get(dem).getCategory()        // Thể loại
            };
            model.addRow(rowData);
        }

        // Thiết lập renderer và editor để hiển thị nút
        jTable1.getColumn("Nhập").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JButton button = new JButton("Nhập");
                button.setOpaque(true);
                return button;
            }
        });

        jTable1.getColumn("Nhập").setCellEditor(new DefaultCellEditor(new JTextField()) {
            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
                JButton button = new JButton("Nhập");
                Book Abook = new Book();
                Abook.setTitle(table.getValueAt(row, 1).toString() == null ? "null" : table.getValueAt(row, 1).toString());
                Abook.setAuthor(table.getValueAt(row, 2).toString() == null ? "null" : table.getValueAt(row, 2).toString());
                Abook.setISBN(table.getValueAt(row, 3).toString() == null ? "null" : table.getValueAt(row, 3).toString());
                Abook.setPublisher(table.getValueAt(row, 4).toString() == null ? "null" : table.getValueAt(row, 4).toString());
                Abook.setPublishedDate(table.getValueAt(row, 5).toString());
                Abook.setCategory(table.getValueAt(row, 6).toString() == null ? "null" : table.getValueAt(row, 6).toString());
                Abook.setLanguage(table.getValueAt(row, 7).toString() == null ? "null" : table.getValueAt(row, 7).toString());
                button.addActionListener(e -> {

                    String inff = "Tên tài liệu: " + Abook.getTitle() + "\n" +
                            "Tác giả: " + Abook.getAuthor() + "\n" +
                            "ISBN: " + Abook.getISBN() + "\n" +
                            "Nhà xuất bản: " + Abook.getPublisher() + "\n" +
                            "Năm xuất bản: " + Abook.getPublishedDate() + "\n" +
                            "Thể loại: " + Abook.getCategory() + "\n" +
                            "Ngôn ngữ: " + Abook.getLanguage();
                    int results = JOptionPane.showConfirmDialog(
                    null,
                    inff,
                    "Xác nhận thông tin tài liệu thêm",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                    
                    if (results == JOptionPane.YES_OPTION) {
                        List<Book> list = Abook.searchBooks(con, Abook.getTitle(),
                                Abook.getAuthor(), Abook.getISBN(), Abook.getPublisher(), 
                                Abook.getPublishedDate(), Abook.getCategory(), Abook.getLanguage());
                        
                        if (!list.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Thông tin tài liệu đã tồn lại trong cơ sở dữ liệu");
                        } else {
                            String input = JOptionPane.showInputDialog(
                                null,                   // Cha mẹ của hộp thoại (null để hiển thị ở giữa màn hình)
                                "Nhập số lượng:",     // Thông báo hiển thị trên hộp thoại
                                "Thông báo",             // Tiêu đề của hộp thoại
                                JOptionPane.INFORMATION_MESSAGE);
                            
                            if (input != null || input.trim().isEmpty()) {
                            
                                try {
                                    int nh = Integer.parseInt(input);
                                    Abook.setQuantity(nh);
                                    JOptionPane.showMessageDialog(null, "thêm thành công!");
                                    Abook.setImagelink(imageLabelToBase64String(jLabel5));

                                    Abook.addBook(con, Abook);
                                    resetPane();
                                } catch (NumberFormatException es) {
                                    JOptionPane.showMessageDialog(null, "Lỗi nhập số lượng!");
                                }
                            }
                        }
                    }
                });
                return button;
            }
        });

        // Thiết lập tooltip
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int row = jTable1.rowAtPoint(e.getPoint());
                int col = jTable1.columnAtPoint(e.getPoint());

                if (row > -1 && col > -1) {
                    Object value = jTable1.getValueAt(row, col);
                    String tooltipText = (value != null) ? value.toString() : null; // Kiểm tra nếu ô không trống
                    jTable1.setToolTipText(tooltipText); // Đặt tooltip hiển thị nội dung của ô
                    ToolTipManager.sharedInstance().mouseMoved(
                        new java.awt.event.MouseEvent(
                            jTable1, java.awt.event.MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 
                            0, e.getX(), e.getY(), e.getXOnScreen(), e.getYOnScreen(), 
                            1, false, java.awt.event.MouseEvent.NOBUTTON
                        )
                    );
                }
            }
        });
    }
    
    public void resetPane() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa toàn bộ hàng trong bảng
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPopupMenu manageMenu;
    private javax.swing.JMenuItem nguoidung;
    private javax.swing.JMenuItem suaSach;
    private javax.swing.JMenuItem themSach;
    private javax.swing.JMenuItem timsach;
    private javax.swing.JMenuItem trangchu;
    private javax.swing.JMenuItem xoaSach;
    // End of variables declaration//GEN-END:variables
}
