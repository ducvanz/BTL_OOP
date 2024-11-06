/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author thinh
 */
public class FindDocumentPanel extends JPanel {

    private Connection con;
    private JFrame mainFframe;
    private JPanel mainPanel;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    String title = "";
    String author = "";
    String ISBN = "";
    String category = "";
    String language = "";

    /**
     * Creates new form managePanel
     */
    public FindDocumentPanel(Connection con, JFrame mainFframe, JPanel mainPanel) {
        initComponents();
        this.con = con;
        this.mainFframe = mainFframe;
        this.mainPanel = mainPanel;
        titleJList.setVisible(false);
        jScrollPane1.setVisible(false);
    }


    public void hienthi2(String title, String author, String ISBN, String category, String language) {
        ArrayList<Document> arrDocument = API.getArrayDocument(title, author, ISBN, category, language);
        if (arrDocument != null) {
            for (Document doc : arrDocument) {
                listModel.addElement(doc.toString());
                doc.displayDocumentInfor();
            }
            if(arrDocument!=null && (!titleJTextField.getText().trim().isEmpty() || !authorJTextField.getText().trim().isEmpty()
                    || !ISBNJTextField.getText().trim().isEmpty())){
                titleJList.setModel(listModel);
                titleJList.setVisibleRowCount(Math.min(listModel.size(), 5));
                titleJList.setFixedCellHeight(30);
                jScrollPane1.setVisible(true);
                titleJList.setVisible(true);
                jScrollPane1.setViewportView(titleJList);
            } else {
                jScrollPane1.setVisible(false);
                titleJList.setVisible(false);
            }
        } else {
            listModel.clear();
            jScrollPane1.setVisible(false);
            titleJList.setVisible(false);   
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
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
        titleJList = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        setBackground(new java.awt.Color(102, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jSeparator1.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 51));

        avata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/Remove-bg.ai_1729220335126.png"))); // NOI18N

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

        ISBNJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ISBNJTextFieldFocusLost(evt);
            }
        });
        ISBNJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ISBNJTextFieldKeyReleased(evt);
            }
        });

        authorJLabel.setText("Tác giả:");

        titleJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleJTextFieldFocusLost(evt);
            }
        });
        titleJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleJTextFieldKeyReleased(evt);
            }
        });

        titleJLabel.setText("Tên:");

        authorJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                authorJTextFieldFocusLost(evt);
            }
        });
        authorJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                authorJTextFieldKeyTyped(evt);
            }
        });

        languageJLabel.setText("Ngôn ngữ:");
        languageJLabel.setToolTipText("");

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiếng Việt", "English", "Tiếng Pháp" }));
        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        categoryJLabel.setText("Thể loại:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Tiểu Thuyết", "Truyện", "Luận Án", "Báo", " " }));
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        titleJList.setModel(titleJList.getModel());

        jSeparator2.setBackground(new java.awt.Color(255, 0, 51));
        jSeparator2.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(ISBNJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ISBNJTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(authorJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleJLabel)
                                    .addComponent(categoryJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(languageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(titleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                            .addComponent(titleJList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(avata))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(username))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(48, 48, 48)
                .addComponent(titleJList)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        titleJList.getAccessibleContext().setAccessibleName("");

        getAccessibleContext().setAccessibleName("findDocumentPanel1");
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        CardLayout cl = (CardLayout) mainPanel.getLayout(); // Lấy CardLayout
        cl.show(mainPanel, "userPanel");
    }//GEN-LAST:event_backButtonActionPerformed

    private void authorJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorJTextFieldKeyTyped
        author = authorJTextField.getText().trim();
        hienthi2(title, author, ISBN, category, language);

    }//GEN-LAST:event_authorJTextFieldKeyTyped

    private void ISBNJTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ISBNJTextFieldKeyReleased
        ISBN = ISBNJTextField.getText().trim();
        hienthi2("", "", ISBN, "", "");

    }//GEN-LAST:event_ISBNJTextFieldKeyReleased

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        category = (String) categoryComboBox.getSelectedItem();
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        language = (String) languageComboBox.getSelectedItem();
    }//GEN-LAST:event_languageComboBoxActionPerformed

    private void titleJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleJTextFieldFocusLost
        title = titleJTextField.getText().trim();
        hienthi2(title, author, ISBN, category, language);
    }//GEN-LAST:event_titleJTextFieldFocusLost

    private void authorJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_authorJTextFieldFocusLost
        author = authorJTextField.getText().trim();
        hienthi2(title, author, ISBN, category, language);
    }//GEN-LAST:event_authorJTextFieldFocusLost

    private void ISBNJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ISBNJTextFieldFocusLost
        ISBN = ISBNJTextField.getText().trim();
        if(ISBN.isEmpty()){
            hienthi2(title, author, ISBN, category, language);
        } else {
            hienthi2("", "", ISBN, "", "");
        }
    }//GEN-LAST:event_ISBNJTextFieldFocusLost

    private void titleJTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
        title = titleJTextField.getText().trim();
        hienthi2(title, author, ISBN, category, language);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> languageComboBox;
    private javax.swing.JLabel languageJLabel;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JList<String> titleJList;
    private javax.swing.JTextField titleJTextField;
    private static javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
