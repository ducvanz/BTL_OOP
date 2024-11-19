INSERT INTO User (userID, username, emailUser, phoneUser, birthdayUser, addressUser, loanTermUser, numberBorrowed, borrowedDocument)
VALUES ('U001', 'Alice Nguyen', 'alice.nguyen@example.com', '0981234567', '1992-04-15', '12 Nguyen Trai, Hanoi', TRUE, 2, 'D001, D002');

-- Ví dụ 2
INSERT INTO User (userID, username, emailUser, phoneUser, birthdayUser, addressUser, loanTermUser, numberBorrowed, borrowedDocument)
VALUES ('U002', 'Bob Tran', 'bob.tran@example.com', '0912345678', '1989-08-20', '45 Le Duan, Da Nang', FALSE, 0, NULL);

-- Ví dụ 3
INSERT INTO User (userID, username, emailUser, phoneUser, birthdayUser, addressUser, loanTermUser, numberBorrowed, borrowedDocument)
VALUES ('U003', 'Charlie Le', 'charlie.le@example.com', '0971231234', '1995-02-28', '78 Vo Van Tan, Ho Chi Minh City', TRUE, 3, 'D003, D005');

-- Ví dụ 1
INSERT INTO Manage (manageID, manageName, emailManage, phoneManage, birthdayManage, addressManage, loanTermManage, numberBorrowedManage, borrowedDocumentManage)
VALUES ('M001', 'David Pham', 'david.pham@example.com', '0908765432', '1980-05-10', '10 Nguyen Hue, Ho Chi Minh City', TRUE, 1, 'D007');

-- Ví dụ 2
INSERT INTO Manage (manageID, manageName, emailManage, phoneManage, birthdayManage, addressManage, loanTermManage, numberBorrowedManage, borrowedDocumentManage)
VALUES ('M002', 'Eva Bui', 'eva.bui@example.com', '0932456789', '1975-11-25', '22 Tran Hung Dao, Hanoi', FALSE, 4, 'D009, D010');

-- Ví dụ 3
INSERT INTO Manage (manageID, manageName, emailManage, phoneManage, birthdayManage, addressManage, loanTermManage, numberBorrowedManage, borrowedDocumentManage)
VALUES ('M003', 'Frank Nguyen', 'frank.nguyen@example.com', '0923456789', '1988-07-30', '67 Bach Dang, Da Nang', TRUE, 2, 'D008, D011');

-- Ví dụ 1
INSERT INTO Document (documentID, title, author, published, yearPublished, quanity, category, language, imageDocument)
VALUES ('D001', 'Programming in Python', 'John Doe', 'Tech Publishers', 2022, 5, 'Technology', 'English', 'image_python.jpg');

-- Ví dụ 2
INSERT INTO Document (documentID, title, author, published, yearPublished, quanity, category, language, imageDocument)
VALUES ('D002', 'Data Science Basics', 'Jane Doe', 'Data Publishers', 2020, 8, 'Science', 'English', 'image_datascience.jpg');

-- Ví dụ 3
INSERT INTO Document (documentID, title, author, published, yearPublished, quanity, category, language, imageDocument)
VALUES ('D003', 'Machine Learning Advanced', 'Alice Smith', 'AI Publishers', 2021, 3, 'Technology', 'English', 'image_ml.jpg');

-- Ví dụ 1
INSERT INTO Book (ISBN, documentID)
VALUES ('978-0-13-110362-7', 'D001');

-- Ví dụ 2
INSERT INTO Book (ISBN, documentID)
VALUES ('978-0-262-03384-8', 'D002');

-- Ví dụ 3
INSERT INTO Book (ISBN, documentID)
VALUES ('978-1-118-42441-3', 'D003');

-- Ví dụ 1
INSERT INTO Thesis (documentID, degree, university)
VALUES ('D004', 'Master of Science', 'MIT');

-- Ví dụ 2
INSERT INTO Thesis (documentID, degree, university)
VALUES ('D005', 'PhD in Physics', 'Stanford University');

-- Ví dụ 3
INSERT INTO Thesis (documentID, degree, university)
VALUES ('D006', 'Master of Engineering', 'Oxford University');