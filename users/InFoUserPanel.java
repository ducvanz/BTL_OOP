/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP.users;

import BTL_OOP.login.LoginPanel;
import BTL_OOP.users.User;
import BTL_OOP.publicc.CheckInput;
import BTL_OOP.manage.FindBookManage;
import BTL_OOP.manage.ManageDAO;
import BTL_OOP.document.Document;
import static BTL_OOP.manage.FindBookManage.user;
import BTL_OOP.publicc.Transaction;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ngothuyet
 */
public class InFoUserPanel extends javax.swing.JPanel {

    /**
     * Creates new form InFoManage
     */
    
    
    private Connection con;
    private JFrame frame;
    private JPanel mainPanel;
    static User beforeUpdateUser;
    private static ManageDAO manageDAO = ManageDAO.getManageDAO();
    
    public static boolean isFromInfoUser = false;
    
    public InFoUserPanel(Connection con, JFrame frame, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.frame = frame;
        this.mainPanel = mainPanel;
        setAvata();
    }
    
    public static void displayBorrowedDocument() {
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false; // Trả về false để không cho phép chỉnh sửa bất kỳ ô nào
            }
        };
        borrowedDocumentTable.setModel(defaultTableModel);
        borrowedDocumentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Tên sách");
        defaultTableModel.addColumn("Ngày Mượn");
        defaultTableModel.addColumn("Ngày Trả");
    
        ArrayList<Transaction> loanList = user.getLoanList();
        ArrayList<Document> borrowedDocument = user.getBorrowedDocument();
    
        if (loanList.isEmpty()) {
            borrowedDocumentTable.setVisible(false);
            System.out.println("Không có sách mượn.");
            return;
        }
    
        borrowedDocumentTable.setVisible(true);
        System.out.println("loanlist: " + loanList.size());
        System.out.println("borrowedlist: " + borrowedDocument.size());
    
        int i = 1; // Khởi tạo thứ tự dòng
        for (Transaction t : loanList) {
            String documentName = "Không tìm thấy tên sách"; // Tên mặc định nếu không khớp
    
            // So sánh ID sách
            for (Document doc : borrowedDocument) {
                System.out.println("tran:" + t.getDocumentID() + "--doc:" + doc.getID());
                if (t.getDocumentID() == doc.getID()) { // So sánh ID sách
                    documentName = doc.getTitle(); // Lấy tên sách nếu khớp
                    break;
                }
            }
    
            // Thêm dòng dữ liệu vào bảng
            Object[] row = new Object[]{
                i,
                t.getDocumentID(),
                documentName,
                t.getBorrowedDate(),
                t.getReturnedDate()
            };
            defaultTableModel.addRow(row);
    
            // In ra dòng vừa thêm
            System.out.println("Dòng dữ liệu: " + Arrays.toString(row));
    
            i++; // Tăng thứ tự dòng

        }
    
        // Cập nhật chiều cao mỗi dòng
        borrowedDocumentTable.setRowHeight(30);

        // Cập nhật chiều cao bảng dựa trên số dòng
        int totalHeight = borrowedDocumentTable.getRowCount() * borrowedDocumentTable.getRowHeight();
        borrowedDocumentTable.setPreferredScrollableViewportSize(new Dimension(
            borrowedDocumentTable.getWidth(), totalHeight
        ));

        // Cập nhật chiều cao JScrollPane dựa trên số dòng
        int totalHeightJScroll = borrowedDocumentTable.getRowCount() * borrowedDocumentTable.getRowHeight();
        int preferredHeight = Math.min(totalHeightJScroll, 300); // Giới hạn chiều cao tối đa của JScrollPane

        // Cập nhật kích thước của JScrollPane
        borrowedJScroll.setPreferredSize(new Dimension(
            borrowedDocumentTable.getWidth(), 
            preferredHeight
        ));

        // Cập nhật lại giao diện
        borrowedDocumentTable.revalidate();
        borrowedDocumentTable.repaint();
        borrowedJScroll.revalidate();
        borrowedJScroll.repaint();
        }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        avataJlabel = new javax.swing.JLabel();
        manageNameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nameJlabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        emailJlabel = new javax.swing.JLabel();
        birthdayJlabel = new javax.swing.JLabel();
        phoneJlabel = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        showPassCheckBox = new javax.swing.JCheckBox();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        addressJlabel = new javax.swing.JLabel();
        changName = new javax.swing.JLabel();
        changEmail = new javax.swing.JLabel();
        changeBirth = new javax.swing.JLabel();
        changePhone = new javax.swing.JLabel();
        changPassword = new javax.swing.JLabel();
        changeAddress = new javax.swing.JLabel();
        UpdateInfo = new javax.swing.JButton();
        nameUserJlabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        borrowedJScroll = new javax.swing.JScrollPane();
        borrowedDocumentTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 45));

        avataJlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/DeafaultAvata.png"))); // NOI18N
        avataJlabel.setText("jLabel1");
        avataJlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avataJlabelMouseClicked(evt);
            }
        });

        manageNameLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        manageNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        manageNameLabel.setText("ACCOUNT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TRANG CÁ NHÂN");

        backButton.setBackground(new java.awt.Color(0, 255, 102));
        backButton.setForeground(new java.awt.Color(51, 51, 51));
        backButton.setText("Quay lại");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(avataJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(avataJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(manageNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Name:");

        jLabel4.setText("Email:");

        jLabel5.setText("Ngày sinh:");

        jLabel6.setText("Số điện thoại:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("DANH SÁCH SÁCH MƯỢN");

        emailJlabel.setText("jLabel12");

        birthdayJlabel.setText("jLabel12");

        phoneJlabel.setText("jLabel12");

        jLabel12.setText("Mật khẩu:");

        passwordLabel.setText("jLabel13");

        showPassCheckBox.setText("xem");
        showPassCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassCheckBoxActionPerformed(evt);
            }
        });

        jLabel13.setText("Địa chỉ:");

        addressJlabel.setText("jLabel14");

        changName.setText(".....");
        changName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changNameMouseClicked(evt);
            }
        });

        changEmail.setText(".....");
        changEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changEmailMouseClicked(evt);
            }
        });

        changeBirth.setText("......");
        changeBirth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeBirthMouseClicked(evt);
            }
        });

        changePhone.setText(".....");
        changePhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePhoneMouseClicked(evt);
            }
        });

        changPassword.setText(".....");
        changPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changPasswordMouseClicked(evt);
            }
        });

        changeAddress.setText(".....");

        UpdateInfo.setBackground(new java.awt.Color(0, 153, 51));
        UpdateInfo.setForeground(new java.awt.Color(51, 51, 51));
        UpdateInfo.setText("Cập nhật");
        UpdateInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateInfoActionPerformed(evt);
            }
        });

        nameUserJlabel.setText("jLabel1");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("THÔNG TIN CÁ NHÂN");

        borrowedDocumentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID", "Tên sách", "Ngày Mượn", "Ngày Trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        borrowedDocumentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowedDocumentTableMouseClicked(evt);
            }
        });
        borrowedJScroll.setViewportView(borrowedDocumentTable);
        if (borrowedDocumentTable.getColumnModel().getColumnCount() > 0) {
            borrowedDocumentTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            borrowedDocumentTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            borrowedDocumentTable.getColumnModel().getColumn(2).setPreferredWidth(300);
            borrowedDocumentTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            borrowedDocumentTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(birthdayJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(changeBirth)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(emailJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(changEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(changName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(nameUserJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(addressJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(changeAddress))
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(phoneJlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(changePhone))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator6)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48)
                                    .addComponent(showPassCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(changPassword)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borrowedJScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(name)
                    .addComponent(jLabel10)
                    .addComponent(nameJlabel)
                    .addComponent(jLabel11)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UpdateInfo)
                .addGap(364, 364, 364))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(name)
                    .addComponent(jLabel10)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJlabel)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nameUserJlabel)
                            .addComponent(changName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(phoneJlabel)
                                .addComponent(jLabel6))
                            .addComponent(changePhone))
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changEmail)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(emailJlabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birthdayJlabel)
                            .addComponent(jLabel5)
                            .addComponent(changeBirth))
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(addressJlabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(changPassword)
                                .addComponent(showPassCheckBox))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(passwordLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(UpdateInfo)
                .addGap(23, 23, 23)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(borrowedJScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setAvata() {
        FindBookManage.resizeLabelIcon(avataJlabel, 60, 60);
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        if (LoginPanel.isManage){
            cl.show(mainPanel, "managePanel");
        } else {
            cl.show(mainPanel, "userPanel");
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void showPassCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassCheckBoxActionPerformed
        // TODO add your handling code here:
        if (showPassCheckBox.isSelected()) {
            String password = user.getPassword();
            passwordLabel.setText(password);
        } 
        else  passwordLabel.setText("*******");
    }//GEN-LAST:event_showPassCheckBoxActionPerformed

    private void changNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changNameMouseClicked
        // TODO add your handling code here:
           try {
               String newName = JOptionPane.showInputDialog(this,"Đổi tên người dùng.", "Nhập tên bạn muốn đổi", JOptionPane.INFORMATION_MESSAGE,null, null, nameJlabel.getText()).toString();
               if (!CheckInput.checkFullName(newName)) {
                JOptionPane.showMessageDialog(mainPanel, "Tên không hợp lệ!");
                } 
               user.setName(newName);
               nameUserJlabel.setText(newName);
           } 
           catch (Exception e) {
               System.out.print("");
           }
          
    }//GEN-LAST:event_changNameMouseClicked

    // Thay avatar
    private void avataJlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avataJlabelMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Avatar","jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);
        int x = fileChooser.showDialog(this,"Chọn ảnh");
        if (x == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
           try {
                // Đọc ảnh từ file đã chọn
                Image image = ImageIO.read(selectedFile);
                
                // Lấy kích thước của ảnh gốc
                int originalWidth = image.getWidth(null);
                int originalHeight = image.getHeight(null);

                int labelWidth = avataJlabel.getWidth();
                int labelHeight = avataJlabel.getHeight();

                double widthRatio = (double) labelWidth / originalWidth;
                double heightRatio = (double) labelHeight / originalHeight;

                double scaleRatio = Math.min(widthRatio, heightRatio);

                int newWidth = (int) (originalWidth * scaleRatio);
                int newHeight = (int) (originalHeight * scaleRatio);

                Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

                ImageIcon imageIcon = new ImageIcon(scaledImage);
                avataJlabel.setIcon(imageIcon);  
                avataJlabel.setText(""); 
            } 
           catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to load the image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_avataJlabelMouseClicked

    private void changEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changEmailMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
         try {
            String newEmail = JOptionPane.showInputDialog(this,"Đổi email người dùng.", "Nhập email bạn muốn đổi", JOptionPane.INFORMATION_MESSAGE,null, null, user.getEmail()).toString();
            
            if (!CheckInput.checkEmail(newEmail)) {
                JOptionPane.showMessageDialog(mainPanel, "Email không hợp lệ!");
            }
            user.setEmail(newEmail);
           // System.out.print(user.getName());
            emailJlabel.setText(newEmail);
         } 
         catch (Exception e) {
               System.out.print("");
           }
    }//GEN-LAST:event_changEmailMouseClicked

    private void changePhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePhoneMouseClicked
            String note = "Nhập số điện thoại bạn muốn đối : "
                    + "'0325349605";
            try {
            String newName = JOptionPane.showInputDialog(this,"Đổi số điện thoại người dùng.", note, JOptionPane.INFORMATION_MESSAGE,null, null, user.getPhone()).toString();

            if (!CheckInput.checkNumberPhone(newName)) {
                JOptionPane.showMessageDialog(mainPanel, "SDT không hợp lệ!");
            }
            user.setPhone(newName);
           // System.out.print(user.getName());
            phoneJlabel.setText(newName);
            }
            catch (Exception e) {
               System.out.print("");
           }
    }//GEN-LAST:event_changePhoneMouseClicked

    private void changPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changPasswordMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
            String newName = JOptionPane.showInputDialog(this,"Đổi mật khẩu người dùng.", "Nhập mật khẩu bạn muốn đổi", JOptionPane.INFORMATION_MESSAGE,null, null, user.getPassword()).toString();
            user.setPassword(newName);
           // System.out.print(user.getName());
            passwordLabel.setText(newName);
    }//GEN-LAST:event_changPasswordMouseClicked

    private void changeBirthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeBirthMouseClicked
        // TODO add your handling code here:
         // TODO add your handling code here:
         try {
            String newName = JOptionPane.showInputDialog(this,"Đổi ngày sinh người dùng.", "Nhập ngày sinh bạn muốn đổi", JOptionPane.INFORMATION_MESSAGE,null, null, user.getBirthday()).toString();
            
            if (!CheckInput.checkBirthday(newName)) {
                JOptionPane.showMessageDialog(mainPanel, "Ngày sinh không hợp lệ!");
            }
            user.setBirthday(newName);
           // System.out.print(user.getName());
            birthdayJlabel.setText(newName);
         } catch (Exception e) {
               System.out.print("");
           }
    }//GEN-LAST:event_changeBirthMouseClicked

    private void UpdateInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateInfoActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(
                this, // Component cha
                "Bạn có chắc chắn muốn chỉnh sửa không?", // Nội dung thông báo
                "Xác nhận", // Tiêu đề của hộp thoại
                JOptionPane.YES_NO_OPTION, // Loại hộp thoại (Yes/No/Cancel)
                JOptionPane.QUESTION_MESSAGE // Biểu tượng
        );
        if (result == 0) {
                manageDAO.updateUser(user);
               manageNameLabel.setText(user.getName());
        }
        else if(result == 1) {
              nameJlabel.setText(beforeUpdateUser.getName());
              emailJlabel.setText(beforeUpdateUser.getEmail());
              birthdayJlabel.setText(beforeUpdateUser.getBirthday());
              addressJlabel.setText(beforeUpdateUser.getAddress());
              phoneJlabel.setText(beforeUpdateUser.getPhone());
              if (showPassCheckBox.isSelected()) {
                  passwordLabel.setText(beforeUpdateUser.getPassword());
              } else passwordLabel.setText("********");
        }
    }//GEN-LAST:event_UpdateInfoActionPerformed

    private void borrowedDocumentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowedDocumentTableMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int selectedRow = borrowedDocumentTable.getSelectedRow(); // Lấy chỉ số dòng đã chọn
    
            if (selectedRow != -1) {
                // Lấy ID của sách từ cột "ID" trong dòng đã chọn
                int documentID = (int) borrowedDocumentTable.getValueAt(selectedRow, 1);
                
                // Tìm kiếm Document tương ứng với documentID trong borrowedDocument
                ArrayList<Document> borrowedDocuments = user.getBorrowedDocument();
                Document selectedDocument = null;
    
                for (Document doc : borrowedDocuments) {
                    if (doc.getID() == documentID) {
                        selectedDocument = doc;
                        break;
                    }
                }
    
                // Kiểm tra nếu tìm thấy Document tương ứng
                if (selectedDocument != null) {
                    DisplayDocumentPanel.setDocument(selectedDocument);
                    DisplayDocumentPanel.displayDocument(true);
                    CardLayout cl = (CardLayout) mainPanel.getLayout();
                    cl.show(mainPanel, "displayDocumentPanel");
                    isFromInfoUser = true;
                    
                    return;
                } else {
                    System.out.println("Không tìm thấy Document với ID: " + documentID);
                }
            }
        }
    }//GEN-LAST:event_borrowedDocumentTableMouseClicked

    public static void setDefaultInfo() {
        user = LoginPanel.userOverAll;
        beforeUpdateUser = LoginPanel.userOverAll;
        String name = user.getName();
        nameUserJlabel.setText(name);
        manageNameLabel.setText(name);
        String email = user.getEmail();
        String birthday = user.getBirthday();
        String phone = user.getPhone();
        //String sex = user.getSex();

        phoneJlabel.setText(phone);
        emailJlabel.setText(email);
        passwordLabel.setText("************"); 
        birthdayJlabel.setText(birthday);
        String addressUser = user.getAddress();
        addressJlabel.setText(addressUser);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateInfo;
    private static javax.swing.JLabel addressJlabel;
    private javax.swing.JLabel avataJlabel;
    private javax.swing.JButton backButton;
    private static javax.swing.JLabel birthdayJlabel;
    private static javax.swing.JTable borrowedDocumentTable;
    private static javax.swing.JScrollPane borrowedJScroll;
    private javax.swing.JLabel changEmail;
    private javax.swing.JLabel changName;
    private javax.swing.JLabel changPassword;
    private javax.swing.JLabel changeAddress;
    private javax.swing.JLabel changeBirth;
    private javax.swing.JLabel changePhone;
    private static javax.swing.JLabel emailJlabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private static javax.swing.JLabel manageNameLabel;
    private javax.swing.JLabel name;
    private static javax.swing.JLabel nameJlabel;
    private static javax.swing.JLabel nameUserJlabel;
    private static javax.swing.JLabel passwordLabel;
    private static javax.swing.JLabel phoneJlabel;
    private static javax.swing.JCheckBox showPassCheckBox;
    // End of variables declaration//GEN-END:variables
}
