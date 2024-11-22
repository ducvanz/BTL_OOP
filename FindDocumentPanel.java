/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author thinh
 */
public class FindDocumentPanel extends JPanel {
    DocumentDAO documentDAO = new DocumentDAO();
    private Connection con;
    private JFrame mainFrame;
    private JPanel mainPanel;
    DefaultListModel<Document> listModel = new DefaultListModel<>();
    String title = "";
    String author = "";
    String ISBN = "";
    String category = "All";
    String language = "All";
    String oldTitle = "";
    String oldAuthor = "";
    
    

    /**
     * Creates new form managePanel
     */
    public FindDocumentPanel(Connection con, JFrame mainFframe, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.mainFrame = mainFframe;
        this.mainPanel = mainPanel;
        resultFindDocumentJList.setVisible(false);
        jScrollPane1.setVisible(false);
        Document doc = documentDAO.getDocumentByID(1);
        ImageIcon imageIcon = new ImageIcon(doc.getImageLink());

        
    }

    public void displayResultFindDocument(boolean check, String title, String author, String ISBN, String category, String language) {
        // Tạo một SwingWorker để thực hiện tìm kiếm trong nền
        SwingWorker<ArrayList<Document>, Void> worker;
        worker = new SwingWorker<ArrayList<Document>, Void>() {
            @Override
            protected ArrayList<Document> doInBackground() throws Exception {
                ArrayList<Document> result =MultiThreaded.searchDocument(check, title, author, ISBN, category, language);
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
                            resultFindDocumentJList.setModel((DefaultListModel) listModel);
                            resultFindDocumentJList.setVisibleRowCount(Math.min(listModel.size(), 5));
                            resultFindDocumentJList.setFixedCellHeight(30);
                            jScrollPane1.setVisible(true);
                            resultFindDocumentJList.setVisible(true);
                            jScrollPane1.setViewportView(resultFindDocumentJList);
                        } else {
                            jScrollPane1.setVisible(false);
                            resultFindDocumentJList.setVisible(false);
                        }
                    } else {
                        listModel.clear();
                        jScrollPane1.setVisible(false);
                        resultFindDocumentJList.setVisible(false);
                    }
                    System.out.println("Hiển thị danh sách tài liệu thành công.");
                } catch (Exception e) {
                    e.printStackTrace();
                    // Xử lý lỗi nếu có
                    JOptionPane.showMessageDialog(null, "Lỗi khi nhập để tìm kiếm tài liệu: " + e.getMessage());
                }
                if (checkDisplayResult()){
                    jScrollPane1.setVisible(true);
                    resultFindDocumentJList.setVisible(true);
                }
            }
        };
        
        // Bắt đầu thực hiện worker
        worker.execute();
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imageJLabel2 = new javax.swing.JLabel();
        imageJLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        imageJLabel3 = new javax.swing.JLabel();
        imageJLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        imageJLabel1 = new javax.swing.JLabel();
        imageJLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imageJLabel4 = new javax.swing.JLabel();
        imageJLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jSeparator1.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 51));

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

        jSeparator2.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 0, 51));

        jLabel2.setText("Sách gì đây ai biết");

        jLabel3.setText("Sách gì đây ai biết");

        imageJLabel2.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        imageJLabel7.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        jLabel4.setText("Sách gì đây ai biết");

        jLabel5.setText("Sách gì đây ai biết");

        imageJLabel3.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        imageJLabel8.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        jLabel6.setText("Sách gì đây ai biết");

        jLabel7.setText("Sách gì đây ai biết");

        imageJLabel1.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        imageJLabel6.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        jLabel1.setText("Sách gì đây ai biết");

        imageJLabel4.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        imageJLabel9.setBackground(new java.awt.Color(255, 0, 51));
        imageJLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTLOOP/logOut.png"))); // NOI18N

        jLabel8.setText("Sách gì đây ai biết");

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
                        .addComponent(avata, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(imageJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imageJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(imageJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imageJLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(imageJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imageJLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(imageJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imageJLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))))
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(resultFindDocumentJList, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(username))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(avata, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultFindDocumentJList, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(imageJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(imageJLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(13, 13, 13)
                        .addComponent(imageJLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageJLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(13, 13, 13)
                        .addComponent(imageJLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );

        resultFindDocumentJList.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("findDocumentPanel1");
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        titleJTextField.setText("");
        authorJTextField.setText("");
        ISBNJTextField.setText("");
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
            if (checkDocument()) {
                displayResultFindDocument(checkDocument(), title, author, ISBN, "", "");
            } else {
                displayResultFindDocument(checkDocument(), title, author, ISBN, category, language);
            }
        }

    }//GEN-LAST:event_authorJTextFieldKeyTyped

    private void ISBNJTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ISBNJTextFieldKeyReleased
        ISBN = ISBNJTextField.getText().trim();
        if (ISBN.length()==13){
            if (checkDocument()) {
                displayResultFindDocument(checkDocument(), title, author, ISBN, "", "");
            } else {
                displayResultFindDocument(checkDocument(), title, author, ISBN, category, language);
            }
        }
        

    }//GEN-LAST:event_ISBNJTextFieldKeyReleased

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
       
        category = (String) categoryComboBox.getSelectedItem();
        if (checkDisplayResult()){
            
        }
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        language = (String) languageComboBox.getSelectedItem();

    }//GEN-LAST:event_languageComboBoxActionPerformed

    private void resultFindDocumentJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultFindDocumentJListMouseClicked
        if (evt.getClickCount() == 2) {
        // Lấy chỉ số của dòng được nhấp đúp
        
        ArrayList<Document> arrDocument = documentDAO.getAllDocuments();
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
    // true: tìm cả API và CSDL, false: tìm CSDL
    private boolean checkDocument(){
        System.out.println("Category: " + category);
        System.out.println("Language: "  + language);
        if ((category.equals("All") || category.equals("Fiction")) && (language.equals("All") || language.equals("English"))) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean checkDisplayResult(){
        if(title.equals("") && author.equals("") && ISBN.length()!=13) {
            return false;
        }
        return true;
    }
    private void titleJTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
        title = titleJTextField.getText().trim();
        if (!title.equals(oldTitle) && !title.equals("")){
            oldTitle = title;
            if (checkDocument()) {
                displayResultFindDocument(checkDocument(), title, author, ISBN, "", "");
            } else {
                displayResultFindDocument(checkDocument(), title, author, ISBN, category, language);
            }
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
    private javax.swing.JLabel imageJLabel1;
    private javax.swing.JLabel imageJLabel2;
    private javax.swing.JLabel imageJLabel3;
    private javax.swing.JLabel imageJLabel4;
    private javax.swing.JLabel imageJLabel6;
    private javax.swing.JLabel imageJLabel7;
    private javax.swing.JLabel imageJLabel8;
    private javax.swing.JLabel imageJLabel9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> languageComboBox;
    private javax.swing.JLabel languageJLabel;
    private javax.swing.JList<String> resultFindDocumentJList;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTextField titleJTextField;
    private static javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
