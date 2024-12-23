/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP.main.ui.users;

import BTL_OOP.main.Main;
import BTL_OOP.main.dao.DocumentDAO;
import BTL_OOP.main.ui.login.LoginPanel;
import BTL_OOP.main.models.document.RenderDocument;
import BTL_OOP.main.ui.manage.AddBookManage;
import BTL_OOP.main.models.document.Document;
import BTL_OOP.main.models.document.RecommendDocument;
import BTL_OOP.main.ui.manage.EditImage;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author thinh
 */
public class FindDocumentPanel extends JPanel implements EditImage {
    private final JPanel mainPanel;
    private final DefaultListModel<Document> listModel;
    private static RenderDocument render;
    String title = "";
    String author = "";
    String ISBN = "";
    String category = "All";
    String language = "All";
    String oldTitle = "";
    String oldAuthor = "";
    
    public FindDocumentPanel() {
        initComponents();
        this.mainPanel = Main.mainPanel;
        render = new RenderDocument();
        listModel = new DefaultListModel<>();
    }

    
    public void setAvata() {
        resizeLabelIcon(avata, 56, 56);
    }

    /**
     * Dùng đa luồng để hiển thị sách trả về từ API.
     * @param title
     * @param author
     * @param ISBN
     * @param category
     * @param language 
     */
    public void displayResultFindDocument(String title, String author, String ISBN, String category, String language) {
        // Tạo một SwingWorker để thực hiện tìm kiếm trong nền
        SwingWorker<ArrayList<Document>, Void> worker;
        worker = new SwingWorker<ArrayList<Document>, Void>() {
            @Override
            protected ArrayList<Document> doInBackground() throws Exception {
                ArrayList<Document> result = RecommendDocument.searchDocument(title, author, ISBN, category, language);
                if (result == null){
                    return null;
                }
                return result;
            }
            
            @Override
            protected void done() {
                try {
                    ArrayList<Document> arrDocument = get(); // Lấy kết quả từ doInBackground
                    if (arrDocument != null) {
                        listModel.clear(); // Xóa danh sách trước khi thêm mới
                        for (Document doc : arrDocument) {
                            listModel.addElement(doc);
                        }
                        if (arrDocument.size() > 0) {
                            // Cập nhật giao diện trong SwingUtilities.invokeLater
                            SwingUtilities.invokeLater(() -> {
                                resultFindDocumentJList.setVisibleRowCount(Math.min(listModel.size(), 5));
                                resultFindDocumentJList.setFixedCellHeight(30);
                                resultFindDocumentJList.setModel((DefaultListModel)listModel);
                                jScrollPane1.setVisible(true);
                                resultFindDocumentJList.setVisible(true);
                                jScrollPane1.setViewportView(resultFindDocumentJList);
                                // Làm mới giao diện
                                jScrollPane1.revalidate();
                                jScrollPane1.repaint();
                                resultFindDocumentJList.revalidate();
                                resultFindDocumentJList.repaint();
                            });
                        } else {
                            jScrollPane1.setVisible(false);
                            resultFindDocumentJList.setVisible(false);
                            System.out.println("Khoong cos tai lieu ");
                        }
                        // Làm mới container cha
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    } else {
                        listModel.clear();
                        jScrollPane1.setVisible(false);
                        resultFindDocumentJList.setVisible(false);
                        System.out.println("cha co gi .");
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    // Xử lý lỗi nếu có
                    JOptionPane.showMessageDialog(null, "Lỗi khi nhập để tìm kiếm tài liệu: " + e.getMessage());
                }
            }
        };
        // Bắt đầu thực hiện worker
        worker.execute();
        
    }
    
    /**
     * Hiển thị sách gới ý.
     * sử dụng 1 map gồm 2 label ghi lại thông tin về tên và ảnh
     * @return 
     */
    public static Map<JLabel, JLabel> getListRecomentDocumentJLabel() {
        Map<JLabel, JLabel> result = new LinkedHashMap<>();
        result.put(titleJLabel1, imageJLabel1);
        result.put(titleJLabel2, imageJLabel2);
        result.put(titleJLabel3, imageJLabel3);
        result.put(titleJLabel4, imageJLabel4);
        result.put(titleJLabel5, imageJLabel5);
        result.put(titleJLabel6, imageJLabel6);
        result.put(titleJLabel7, imageJLabel7);
        result.put(titleJLabel8, imageJLabel8);
        return result;
    }
    
    /**
     * Hiển thị sách gơij ý dựa vào lịch sử đang và đã mượn.
     */
    public static void displayRecommentDocument() {
        // Lấy tất cả tài liệu từ cơ sở dữ liệu và lịch sử mượn trả
        ArrayList<Document> allDocument = DocumentDAO.getAllDocuments();
        ArrayList<Document> borrowedDocument = LoginPanel.userOverAll.getBorrowedDocument();
        ArrayList<Document> returnedDocument = LoginPanel.userOverAll.getReturnedDocument();
        // Gộp lịch sử mượn và trả tài liệu vào một danh sách
        Set<Document> mergedDocuments = new HashSet<>();
        mergedDocuments.addAll(borrowedDocument);
        mergedDocuments.addAll(returnedDocument);
        ArrayList<Document> history = new ArrayList<>(mergedDocuments);
        
        // Lấy danh sách các tài liệu gợi ý
        RecommendDocument rcm = new RecommendDocument();
        ArrayList<Document> rcmDocument = rcm.getRecommendations(history, allDocument, 8);
        // Lấy Map chứa các JLabel cho tiêu đề và ảnh
        Map<JLabel, JLabel> labelMap = getListRecomentDocumentJLabel();
        
        render.renderDocument(rcmDocument, labelMap);
    }
    


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        avata = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ISBNJLabel = new javax.swing.JLabel();
        ISBNJTextField = new javax.swing.JTextField();
        authorJLabel = new javax.swing.JLabel();
        titleJTextField = new javax.swing.JTextField();
        titleJLabel = new javax.swing.JLabel();
        authorJTextField = new javax.swing.JTextField();
        languageJLabel = new javax.swing.JLabel();
        languageComboBox = new javax.swing.JComboBox<>();
        categoryJLabel = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultFindDocumentJList = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();
        titleJLabel5 = new javax.swing.JLabel();
        titleJLabel6 = new javax.swing.JLabel();
        imageJLabel6 = new javax.swing.JLabel();
        imageJLabel2 = new javax.swing.JLabel();
        titleJLabel2 = new javax.swing.JLabel();
        titleJLabel7 = new javax.swing.JLabel();
        imageJLabel7 = new javax.swing.JLabel();
        imageJLabel3 = new javax.swing.JLabel();
        titleJLabel3 = new javax.swing.JLabel();
        titleJLabel8 = new javax.swing.JLabel();
        imageJLabel5 = new javax.swing.JLabel();
        imageJLabel1 = new javax.swing.JLabel();
        titleJLabel1 = new javax.swing.JLabel();
        imageJLabel8 = new javax.swing.JLabel();
        imageJLabel4 = new javax.swing.JLabel();
        titleJLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jSeparator1.setBackground(new java.awt.Color(51, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(102, 255, 255));

        avata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/DeafaultAvata.png"))); // NOI18N

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        username.setText("ACCOUNT\n");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel9.setText("Tìm Tài liệu");

        ISBNJLabel.setText("ISBN:");

        ISBNJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ISBNJTextFieldKeyReleased(evt);
            }
        });

        authorJLabel.setText("Tác giả:");

        titleJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleJTextFieldKeyReleased(evt);
            }
        });

        titleJLabel.setText("Tên:");

        authorJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                authorJTextFieldKeyTyped(evt);
            }
        });

        languageJLabel.setText("Ngôn ngữ:");
        languageJLabel.setToolTipText("");

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "English", "Vietnam", "Another" }));
        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        categoryJLabel.setText("Thể loại:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Fiction", "Newspaper", "Thesis", "Cooking", "Education", "Self-help", "Biography", "Economics", "Business", "Another" }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        resultFindDocumentJList.setModel(resultFindDocumentJList.getModel());
        resultFindDocumentJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultFindDocumentJListMouseClicked(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(102, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(102, 255, 255));

        titleJLabel5.setText("Sách gì đây ai biết 5");

        titleJLabel6.setText("Sách gì đây ai biết 6");

        imageJLabel6.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/An Inquiry Into the Nature and Causes of the Wealth of Nations.png"))); // NOI18N
        imageJLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel6MouseClicked(evt);
            }
        });

        imageJLabel2.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/C_Programming.png"))); // NOI18N
        imageJLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel2MouseClicked(evt);
            }
        });

        titleJLabel2.setText("Sách gì đây ai biết 2");

        titleJLabel7.setText("Sách gì đây ai biết 7");

        imageJLabel7.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/A_Tour_of_C++.png"))); // NOI18N
        imageJLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel7MouseClicked(evt);
            }
        });

        imageJLabel3.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/C_Program_Design.png"))); // NOI18N
        imageJLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel3MouseClicked(evt);
            }
        });

        titleJLabel3.setText("Sách gì đây ai biết 3");

        titleJLabel8.setText("Sách gì đây ai biết 8");

        imageJLabel5.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/Aram Khachaturyan.png"))); // NOI18N
        imageJLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel5MouseClicked(evt);
            }
        });

        imageJLabel1.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/C++.png"))); // NOI18N
        imageJLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel1MouseClicked(evt);
            }
        });

        titleJLabel1.setText("Sách gì đây ai biết 1");

        imageJLabel8.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/A World at Arms.png"))); // NOI18N
        imageJLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel8MouseClicked(evt);
            }
        });

        imageJLabel4.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/C_For_Dummies_Volume_1.png"))); // NOI18N
        imageJLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageJLabel4MouseClicked(evt);
            }
        });

        titleJLabel4.setText("Sách gì đây ai biết 4");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel10.setText("Gợi ý tài liệu cho bạn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(avata, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(ISBNJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(ISBNJTextField))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(authorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(authorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleJLabel)
                                    .addComponent(categoryJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(languageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(imageJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imageJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(titleJLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(imageJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imageJLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(titleJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageJLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imageJLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(titleJLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(imageJLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(imageJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(titleJLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(titleJLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resultFindDocumentJList, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(username)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(avata, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryJLabel)
                            .addComponent(languageJLabel)
                            .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleJLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(authorJLabel)
                            .addComponent(authorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ISBNJLabel)
                            .addComponent(ISBNJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultFindDocumentJList, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(imageJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(imageJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(titleJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(imageJLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(imageJLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleJLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        resultFindDocumentJList.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("findDocumentPanel1");
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nhấn nút back thì xác định trạng thái và tiến hành chuyển trang.
     * @param evt 
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        DisplayDocumentPanel.isFromHome = true;
        titleJTextField.setText("");
        authorJTextField.setText("");
        ISBNJTextField.setText("");
        categoryComboBox.setSelectedIndex(0);
        languageComboBox.setSelectedIndex(0);
        jScrollPane1.setVisible(false);
        resultFindDocumentJList.setVisible(false);
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        if (LoginPanel.isManage){
            cl.show(mainPanel, "managePanel");
        } else {
            cl.show(mainPanel, "userPanel");
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void authorJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorJTextFieldKeyTyped
        author = authorJTextField.getText().trim();
        if (!author.equals(oldAuthor) && !author.equals("")){
            oldAuthor = author;
            findDocument();
        }

    }//GEN-LAST:event_authorJTextFieldKeyTyped

    private void ISBNJTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ISBNJTextFieldKeyReleased
        ISBN = ISBNJTextField.getText().trim();
        if (ISBN.length()==13){
            findDocument();
        }
        

    }//GEN-LAST:event_ISBNJTextFieldKeyReleased

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
       
        category = (String) categoryComboBox.getSelectedItem();
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        language = (String) languageComboBox.getSelectedItem();

    }//GEN-LAST:event_languageComboBoxActionPerformed

    private void resultFindDocumentJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultFindDocumentJListMouseClicked
        if (evt.getClickCount() == 2) {
        // Lấy chỉ số của dòng được nhấp đúp
        
        ArrayList<Document> arrDocument = DocumentDAO.getAllDocuments();
        int index = resultFindDocumentJList.locationToIndex(evt.getPoint());
        if (index != -1) {
            Object item = resultFindDocumentJList.getModel().getElementAt(index);
            Document doc = (Document) item;                       

            for(Document d: arrDocument) {
                if (d.getTitle().equals(doc.getTitle())){
                    DisplayDocumentPanel.setDocument(d);
                    DisplayDocumentPanel.displayDocument(true);
                    CardLayout cl = (CardLayout) mainPanel.getLayout();
                    cl.show(mainPanel, "displayDocumentPanel");
                    
                    return;
                }
            }
            DisplayDocumentPanel.setDocument(doc);
            DisplayDocumentPanel.displayDocument(false);
            
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "displayDocumentPanel");

        }
    }
        
    }//GEN-LAST:event_resultFindDocumentJListMouseClicked

    private void imageJLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel1MouseClicked

        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel1.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel1);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel1MouseClicked

    private void imageJLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel2.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel2);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel2MouseClicked

    private void imageJLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel3MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel3.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel3);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel3MouseClicked

    private void imageJLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel4MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel4.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel4);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel4MouseClicked

    private void imageJLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel5MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel5.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel5);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel5MouseClicked

    private void imageJLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel6MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel6.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel6);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel6MouseClicked

    private void imageJLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel7MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel7.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel7);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel7MouseClicked

    private void imageJLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageJLabel8MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {  // Kiểm tra nếu người dùng nhấp đúp
            if (imageJLabel8.getIcon() != null) {
                render.renderDocumentToInfoDocument(imageJLabel8);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "displayDocumentPanel");
            }
        }
    }//GEN-LAST:event_imageJLabel8MouseClicked
    
    //Hiển thị sách gơij ý 
    
    
    // true tìm theo all, false theo thể loại.
    
    private boolean checkDisplayResult(){
        if(title.equals("") && author.equals("") && ISBN.length()!=13) {
            return false;
        }
        return true;
    }
    
    private void titleJTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
        title = titleJTextField.getText().trim();
        if (!title.equals(oldTitle) && !title.equals("")){
            System.out.println(title);
            oldTitle = title;
            findDocument();
        }
    }
    
    private void findDocument() {
        if (category.equals("All") && language.equals("All")) {
            displayResultFindDocument(title, author, ISBN, "", "");
        } else if (category.equals("All")) {
            displayResultFindDocument(title, author, ISBN, "", language);
        } else if (language.equals("All")) {
            displayResultFindDocument(title, author, ISBN, category, "");
        } else {
                displayResultFindDocument(title, author, ISBN, category, language);
        }
    }
    

    public static void setUsername(String username_) {
        username.setText(username_);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ISBNJLabel;
    private javax.swing.JTextField ISBNJTextField;
    private javax.swing.JLabel authorJLabel;
    private javax.swing.JTextField authorJTextField;
    private javax.swing.JLabel avata;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryJLabel;
    private static javax.swing.JLabel imageJLabel1;
    private static javax.swing.JLabel imageJLabel2;
    private static javax.swing.JLabel imageJLabel3;
    private static javax.swing.JLabel imageJLabel4;
    private static javax.swing.JLabel imageJLabel5;
    private static javax.swing.JLabel imageJLabel6;
    private static javax.swing.JLabel imageJLabel7;
    private static javax.swing.JLabel imageJLabel8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> languageComboBox;
    private javax.swing.JLabel languageJLabel;
    private javax.swing.JList<String> resultFindDocumentJList;
    private javax.swing.JLabel titleJLabel;
    private static javax.swing.JLabel titleJLabel1;
    private static javax.swing.JLabel titleJLabel2;
    private static javax.swing.JLabel titleJLabel3;
    private static javax.swing.JLabel titleJLabel4;
    private static javax.swing.JLabel titleJLabel5;
    private static javax.swing.JLabel titleJLabel6;
    private static javax.swing.JLabel titleJLabel7;
    private static javax.swing.JLabel titleJLabel8;
    private javax.swing.JTextField titleJTextField;
    private static javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
