/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package BTL_OOP.main.ui.users;

import BTL_OOP.main.Main;
import BTL_OOP.main.ui.login.LoginPanel;
import BTL_OOP.main.models.user.User;
import BTL_OOP.main.dao.DocumentDAO;
import BTL_OOP.main.database.Transaction;
import BTL_OOP.main.models.document.Book;
import BTL_OOP.main.models.document.Document;
import BTL_OOP.main.models.document.Newspaper;
import BTL_OOP.main.models.document.Thesis;
import BTL_OOP.main.services.API;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author thinh
 */
public class DisplayDocumentPanel extends javax.swing.JPanel {

    private final JFrame mainFrame;
    private final JPanel mainPanel;
    private static Document document;
    private static User user;
    public static boolean isFromHome;
    
    public DisplayDocumentPanel() {
        initComponents();
        this.mainFrame = Main.mainFrame;
        this.mainPanel = Main.mainPanel;
        this.document = null;
        isFromHome = false;
    }


    public static Document getDocument() {
        return document;
    }

    public static void setDocument(Document document) {
        DisplayDocumentPanel.document = document;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        borrowDialog = new javax.swing.JDialog();
        questionDiaLog = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        titleInDiaLog = new javax.swing.JLabel();
        borrowDate = new javax.swing.JLabel();
        returnDate = new javax.swing.JLabel();
        borrowDateJLabel = new javax.swing.JLabel();
        returnDateJLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        returnDialog = new javax.swing.JDialog();
        returnJLabel = new javax.swing.JLabel();
        confirmReturnButton = new javax.swing.JButton();
        avataJLabel = new javax.swing.JLabel();
        usernameJLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        infoDocumentJLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        imageDocumentJLabel = new javax.swing.JLabel();
        author = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        publisher = new javax.swing.JLabel();
        publishedDate = new javax.swing.JLabel();
        language = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        borrowButton = new javax.swing.JButton();
        description = new javax.swing.JLabel();
        authorJLabel = new javax.swing.JLabel();
        categoryJLabel = new javax.swing.JLabel();
        publisherJLabel = new javax.swing.JLabel();
        publishedDateJLabel = new javax.swing.JLabel();
        languageJLabel = new javax.swing.JLabel();
        quantityJLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionJTextArea = new javax.swing.JTextArea();
        ISBN = new javax.swing.JLabel();
        ISBNJLabel = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        degreeJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();

        borrowDialog.setTitle("Mượn sách");
        borrowDialog.setBackground(new java.awt.Color(0, 0, 0));

        questionDiaLog.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        questionDiaLog.setText("Bạn muốn mượn tài liệu ?");

        title.setText("Tên tài liệu:");

        titleInDiaLog.setText("jLabel3");

        borrowDate.setText("Ngày mượn:");

        returnDate.setText("Hạn trả tài liệu:");

        borrowDateJLabel.setText("jLabel6");

        returnDateJLabel.setText("jLabel7");

        confirmButton.setText("Xác nhận");
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBorrowButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout borrowDialogLayout = new javax.swing.GroupLayout(borrowDialog.getContentPane());
        borrowDialog.getContentPane().setLayout(borrowDialogLayout);
        borrowDialogLayout.setHorizontalGroup(
            borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowDialogLayout.createSequentialGroup()
                .addGroup(borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(borrowDialogLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(questionDiaLog))
                    .addGroup(borrowDialogLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(borrowDialogLayout.createSequentialGroup()
                                .addComponent(returnDate)
                                .addGap(18, 18, 18)
                                .addComponent(returnDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(borrowDialogLayout.createSequentialGroup()
                                .addComponent(borrowDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(borrowDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(borrowDialogLayout.createSequentialGroup()
                                .addComponent(title)
                                .addGap(18, 18, 18)
                                .addComponent(titleInDiaLog, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(borrowDialogLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(confirmButton)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        borrowDialogLayout.setVerticalGroup(
            borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borrowDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(questionDiaLog, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title)
                    .addComponent(titleInDiaLog))
                .addGap(18, 18, 18)
                .addGroup(borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrowDate)
                    .addComponent(borrowDateJLabel))
                .addGap(18, 18, 18)
                .addGroup(borrowDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnDate)
                    .addComponent(returnDateJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(confirmButton)
                .addGap(27, 27, 27))
        );

        returnJLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        returnJLabel.setText("Bạn muốn trả tài liệu?");
        returnJLabel.setToolTipText("");

        confirmReturnButton.setText("Xác nhận");
        confirmReturnButton.setToolTipText("");
        confirmReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmReturnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout returnDialogLayout = new javax.swing.GroupLayout(returnDialog.getContentPane());
        returnDialog.getContentPane().setLayout(returnDialogLayout);
        returnDialogLayout.setHorizontalGroup(
            returnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnDialogLayout.createSequentialGroup()
                .addGroup(returnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(returnDialogLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(returnJLabel))
                    .addGroup(returnDialogLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(confirmReturnButton)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        returnDialogLayout.setVerticalGroup(
            returnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnDialogLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(returnJLabel)
                .addGap(18, 18, 18)
                .addComponent(confirmReturnButton)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 650));

        avataJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BTL_OOP/image/DeafaultAvata.png"))); // NOI18N

        usernameJLabel.setBackground(new java.awt.Color(255, 255, 255));
        usernameJLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        usernameJLabel.setText("ACCOUNT");

        jSeparator1.setForeground(new java.awt.Color(255, 0, 51));

        infoDocumentJLabel.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        infoDocumentJLabel.setText("Thông tin tài liệu");

        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });

        imageDocumentJLabel.setBackground(new java.awt.Color(255, 255, 255));

        author.setText("Tác giả: ");

        category.setText("Thể loại:");

        publisher.setText("Nhà xuất bản:");

        publishedDate.setText("Ngày xuất bản:");

        language.setText("Ngôn ngữ:");

        quantity.setText("Số lượng:");

        borrowButton.setText("Mượn");
        borrowButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowButtonMouseClicked(evt);
            }
        });

        description.setText("Mô tả:");

        authorJLabel.setText("jLabel1");

        categoryJLabel.setText("jLabel1");

        publisherJLabel.setText("jLabel1");

        publishedDateJLabel.setText("jLabel1");

        languageJLabel.setText("jLabel1");

        quantityJLabel.setText("jLabel1");

        jScrollPane2.setToolTipText("\"imageLinks\":{\"smallThumbnail\":\"http://books.google.com/books/content?id=PSUNAAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\"thumbnail\":\"http://books.google.com/books/content?id=PSUNAAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"},");

        descriptionJTextArea.setEditable(false);
        descriptionJTextArea.setBackground(new java.awt.Color(255, 255, 255));
        descriptionJTextArea.setColumns(20);
        descriptionJTextArea.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        descriptionJTextArea.setLineWrap(true);
        descriptionJTextArea.setRows(5);
        descriptionJTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(descriptionJTextArea);

        ISBN.setText("ISBN:");

        ISBNJLabel.setText("jLabel1");

        degree.setText("Degree:");

        degreeJLabel.setText("jLabel1");

        titleJLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        titleJLabel.setText("Title");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(imageDocumentJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(borrowButton)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(category)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(categoryJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(author)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(authorJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(publisher)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(publisherJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(publishedDate)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(publishedDateJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(quantity)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(quantityJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(language)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(languageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(84, 84, 84)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(degree)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(degreeJLabel))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(ISBN)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(ISBNJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(description))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(avataJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(infoDocumentJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(backButton)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoDocumentJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(avataJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageDocumentJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(borrowButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleJLabel)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(author)
                            .addComponent(authorJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publisher)
                            .addComponent(publisherJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publishedDate)
                            .addComponent(publishedDateJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(language)
                            .addComponent(languageJLabel)
                            .addComponent(degree)
                            .addComponent(degreeJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity)
                            .addComponent(quantityJLabel)
                            .addComponent(ISBN)
                            .addComponent(ISBNJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(description)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("displayDocumentPanel");
    }// </editor-fold>//GEN-END:initComponents
    // true là hiển thị sách có trong db, false là kco và lấy từ API, k thể mượn
    public static void displayDocument(boolean hasInDB) {
        user = LoginPanel.userOverAll;
        
        titleJLabel.setText(document.getTitle());
        authorJLabel.setText(document.getAuthor());
        publisherJLabel.setText(document.getPublisher());
        publishedDateJLabel.setText(document.getPublishedDate());
        categoryJLabel.setText(document.getCategory());
        languageJLabel.setText(document.getLanguage());
        if (hasInDB) {
            quantityJLabel.setText(String.valueOf(document.getQuantity()));
        } else {
            quantityJLabel.setText("Not available.");
        }
        descriptionJTextArea.setText(document.getDescription());

        if (document.getImage()!= null) {
            DocumentDAO.displayImageFromBytes(document.getImage(), imageDocumentJLabel);
//            System.out.println("Ảnh từ csdl image");

        } else if (!document.getImageLink().equals("N/A")){
            API.displayImage(document, imageDocumentJLabel);
//            System.out.println("Ảnh từ csdl imageLink");
        } else {

//            System.out.println("Ảnh mặc định");
            //Sua dong dnay 
            loadImageFromFilePath(imageDocumentJLabel, "C:\\Users\\thinh\\JAVA\\SWING\\src\\BTL_OOP\\image\\Screenshot_63.png");

        }
        
        if (document instanceof Book) {
//            System.out.println("OK");
            Book book = (Book) document;
            ISBN.setText("ISBN");
            ISBNJLabel.setText(book.getISBN());
            degree.setVisible(false);
            degreeJLabel.setVisible(false);
        } else if (document instanceof Thesis) {
            Thesis thesis = (Thesis) document;
            degree.setVisible(true);
            degreeJLabel.setVisible(true);
            degreeJLabel.setText(thesis.getDegree());
            ISBN.setText("University:");
            ISBNJLabel.setText(thesis.getUniversity());
        } else {
            Newspaper newspaper = (Newspaper) document;
            degree.setText("Date:");
            degreeJLabel.setText(newspaper.getDate());
            ISBN.setText("ISSN:");
            ISBNJLabel.setText(newspaper.getISSN());
        }
        
        user.reset();
        for (Transaction transaction : user.getLoanList()) {
//            transaction.toString();
//                    System.out.println("docID: " + document.getID() + " ** " + transaction.getDocumentID());
                    if (document.getID() == transaction.getDocumentID()) {
                        borrowButton.setText("Đang mượn");
                        return;
                    }
        }
        borrowButton.setText("Mượn");
    }

    /**
     * Load anh len
     * @param label label can load anh
     * @param filePath link file anh
     */
    public static void loadImageFromFilePath(JLabel label, String filePath) {
        SwingWorker<ImageIcon, Void> worker = new SwingWorker<ImageIcon, Void>() {
            @Override
            protected ImageIcon doInBackground() throws Exception {
                File imageFile = new File(filePath);
                if (!imageFile.exists()) {
                    return null; // Return null if image not found
                }

                ImageIcon imageIcon = new ImageIcon(filePath);
                int labelWidth = label.getWidth();
                int labelHeight = label.getHeight();
                Image image = imageIcon.getImage();
                Image scaledImage = image.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImage);
            }

            @Override
            protected void done() {
                try {
                    ImageIcon icon = get();
                    if (icon != null) {
                        label.setIcon(icon);
                    } else {
                        label.setText("");
                    }
                } catch (Exception e) {
                    label.setText("Error loading image!");
                    System.out.println("Error loading image: " + e.getMessage());
                }
            }
        };
        worker.execute(); // Start the thread
    }
    
    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        if (!isFromHome) {
            imageDocumentJLabel.setIcon(null);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "findDocumentPanel");
        } else if (InFoUserPanel.isFromInfoUser) {
            imageDocumentJLabel.setIcon(null);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "inFoUserPanel");
            InFoUserPanel.isFromInfoUser = false;
        }else {
            if (LoginPanel.isManage) {
                imageDocumentJLabel.setIcon(null);
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "managePanel");
            } else {
                imageDocumentJLabel.setIcon(null);
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "userPanel");
            }
        }
    }//GEN-LAST:event_backButtonMouseClicked

    private void confirmReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmReturnButtonActionPerformed
        // Xacs nhan tra sach
        System.out.println("OK1");
        user.setNumberBorrowed(user.getNumberBorrowed() - 1);
        document.setQuantity(document.getQuantity() + 1);
        String borrowedDateString = new String();
        String returnedDateString = new String();
        for(Transaction tran: user.getLoanList()) {
            if(document.getID() == tran.getDocumentID()) {
                borrowedDateString = tran.getBorrowedDate();
                returnedDateString = tran.getReturnedDate();
            }
        }
        LocalDate returned = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String returnedDate= returned.format(formatter);

        Transaction transaction = new Transaction(0,user.getID(), document.getID(), borrowedDateString, returnedDateString, "borrowed");

        user.returnDocument(transaction, returnedDate);
        returnDialog.setVisible(false);
        JOptionPane.showMessageDialog(mainFrame, "Trả thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        displayDocument(true);
        borrowButton.setText("Mượn");
    }//GEN-LAST:event_confirmReturnButtonActionPerformed

    private void confirmBorrowButtonMouseClicked(java.awt.event.MouseEvent evt) {   
            user.setNumberBorrowed(user.getNumberBorrowed() + 1);
            document.setQuantity(document.getQuantity() - 1);
            LocalDate borrowedDate = LocalDate.now();
            LocalDate returnedDate = borrowedDate.plusMonths(2);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String borrowedDateString = borrowedDate.format(formatter);
            String returnedDateString = returnedDate.format(formatter);

            Transaction transaction = new Transaction(0,user.getID(), document.getID(), borrowedDateString, returnedDateString, "borrowed");
            
            user.borrowDocument(transaction);
            borrowDialog.setVisible(false);
            JOptionPane.showMessageDialog(mainFrame, "Mượn thành công!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            displayDocument(true);
            borrowButton.setText("Đang mượn");
     
    }

    private void borrowButtonMouseClicked(java.awt.event.MouseEvent evt) {                                    
        if (!quantityJLabel.getText().equals("Not available.")) {
            if (borrowButton.getText().equals("Mượn")){
                if (document.getQuantity() == 0) {
                    JOptionPane.showMessageDialog(mainFrame, "Sách đã hết!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else if (!LoginPanel.userOverAll.isLoanTerm()) {
                    JOptionPane.showMessageDialog(mainFrame, "Số lượng sách bạn mượn quá giới hạn!", "Thông báo", JOptionPane.WARNING_MESSAGE);

                } else {
                    // Muon sasch
                    System.out.println("OK3");
                    borrowDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    borrowDialog.pack();
                    borrowDialog.setLocationRelativeTo(mainFrame);
                    LocalDate borrowedDate = LocalDate.now();
                    titleInDiaLog.setText(document.getTitle());
                    LocalDate returnedDate = borrowedDate.plusMonths(2);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String borrowedDateString = borrowedDate.format(formatter);
                    String returnedDateString = returnedDate.format(formatter);
                    borrowDateJLabel.setText(borrowedDateString);
                    returnDateJLabel.setText(returnedDateString);
                    
                    borrowDialog.setVisible(true);
                }
            } else {
                //Tra sach
                System.out.println("OK4");
                returnDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                returnDialog.pack();
                returnDialog.setLocationRelativeTo(mainFrame);
                returnDialog.setVisible(true);
            }
        } else {
            System.out.println("OK5");
            JOptionPane.showMessageDialog(mainFrame, "Sách không có trong thư viện!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel ISBN;
    private static javax.swing.JLabel ISBNJLabel;
    private javax.swing.JLabel author;
    private static javax.swing.JLabel authorJLabel;
    private javax.swing.JLabel avataJLabel;
    private javax.swing.JButton backButton;
    private static javax.swing.JButton borrowButton;
    private javax.swing.JLabel borrowDate;
    private javax.swing.JLabel borrowDateJLabel;
    private javax.swing.JDialog borrowDialog;
    private javax.swing.JLabel category;
    private static javax.swing.JLabel categoryJLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton confirmReturnButton;
    private static javax.swing.JLabel degree;
    private static javax.swing.JLabel degreeJLabel;
    private javax.swing.JLabel description;
    private static javax.swing.JTextArea descriptionJTextArea;
    private static javax.swing.JLabel imageDocumentJLabel;
    private javax.swing.JLabel infoDocumentJLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel language;
    private static javax.swing.JLabel languageJLabel;
    private javax.swing.JLabel publishedDate;
    private static javax.swing.JLabel publishedDateJLabel;
    private javax.swing.JLabel publisher;
    private static javax.swing.JLabel publisherJLabel;
    private javax.swing.JLabel quantity;
    private static javax.swing.JLabel quantityJLabel;
    private javax.swing.JLabel questionDiaLog;
    private javax.swing.JLabel returnDate;
    private javax.swing.JLabel returnDateJLabel;
    private javax.swing.JDialog returnDialog;
    private javax.swing.JLabel returnJLabel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleInDiaLog;
    private static javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel usernameJLabel;
    // End of variables declaration//GEN-END:variables
}
