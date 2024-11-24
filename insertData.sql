
SET @path = 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/imageBTL/';

INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image) 
VALUES
 ('Fools Crusade', 'Diana Johnstone', 'NYU Press', '2003', 1, 'English', 'Fiction',
 'A discussion of the political illusion created by the humanitarian bombing of Yugoslavia in 1999 that tests popular beliefs',
 'http://books.google.com/books/content?id=h-FWCgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
 load_file(concat(@path,'Fools Crusade.png'))),
 
 ('Dracula', 'Bram Stoker', 'Penguin', '2007-09-04', 1, 'English', 'Fiction', 
 'Bram Stoker’s gothic horror masterpiece pits good against evil and life against death, all under the thrall of the original vampire.... “Listen to them—the children of the night. What music they make!” He is a creature of darkness. His face deathly pale, his eyes ablaze with the fires of hell. He has been dead for centuries, yet he may never die. He waits in his crumbling castle in the mountains of Transylvania, as his prey draws closer and closer to destruction.... Here begins one of the most celebrated horror stories in history,
 the tale of an undead monster who craves the blood of his victims and relishes his dominance over mankind. With its delicious mix of action, suspense, and looming dread, Bram Stoker’s Dracula has terrified and inspired readers for more than a hundred years. With an Introduction by Leonard Wolf and an Afterword by Jeffrey Meyers',
 'http://books.google.com/books/content?id=h-Z2FmxYKxcC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
 load_file(concat(@path, 'Dracula.png'))),
 
 
('Aram Khachaturyan', 'Viktor I︠U︡zefovich', 'N/A', '1985', 1, 'English', 'Fiction', 'N/A', 
'http://books.google.com/books/content?id=H-4HAQAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api',
 load_file(concat(@path, 'Aram Khachaturyan.png'))),
 
('A Study in Scarlet', 'Arthur Conan Doyle', 'anboco', '2016-10-25', 1, 'English', 'Fiction',
'A Study in Scarlet, detective novel by Conan Doyle, written in 1886, the story marks the first appearance of Sherlock Holmes and Dr. Watson, who would become two of the most famous characters in popular fiction. The books title derives from a speech given by Holmes, an amateur detective, to his friend and chronicler Watson on the nature of his work, in which he describes the storys murder investigation as his "study in scarlet": "Theres the scarlet thread of murder running through the colourless skein of life, and our duty is to unravel it, and isolate it, and expose every inch of it." The story, and its main characters, attracted little public interest when it first appeared. Only 11 complete copies of the magazine in which the story first appeared, Beetons Christmas Annual for 1887, are known to exist now and they have considerable value. Although Conan Doyle wrote 56 short stories featuring Holmes, A Study in Scarlet is one of only four full-length novels in the original canon. The novel was followed by The Sign of the Four, published in 1890. A Study in Scarlet was the first work of detective fiction to incorporate the magnifying glass as an investigative tool.',
'http://books.google.com/books/content?id=_wyvEAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path,'A Study in Scarlet.png'))),

('A World at Arms', 'Gerhard L. Weinberg', 'Cambridge University Press', '2005-03-28', 1, 'English', 'Fiction', 
'A truly global account of WWII - the war that encompassed six continents.', 
'http://books.google.com/books/content?id=a-Wb45gW3P4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
load_file(concat(@path, 'A World at Arms.png'))),

('A Dictionary of the Avant-Gardes', 'Richard Kostelanetz',  'Routledge', ' 2018-11-15', 1, 'English', 'Fiction',
'Twenty-five years after the publication of A Dictionary of the Avant-Gardes, the distinguished critic and arts historian Richard Kostelanetz returns to his favorite subject for a third edition. Rewriting earlier entries, adding hundreds of new ones, Kostelanetz provides intelligence and information unavailable anywhere else, no less in print than online, about a wealth of subjects and individuals. Focused upon what is truly innovative and excellent, he ranges widely with insight and surprise, including appreciations of artistic athletes such as Muhammad Ali, Johan Cruyff, and the Harlem Globetrotters and such collective creations as Las Vegas and his native New York City. Continuing the traditions of cheeky high-style Dictionarysts, honoring Samuel Johnson and Nicolas Slonimsky (both with individual entries), Kostelanetz offers a "reference book" to be enjoyed not only in bits and chunks, but continuously as one of the dozen books someone would take if they planned to be stranded on a desert isle.',
'http://books.google.com/books/content?id=kDZ7DwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'A Dictionary of the Avant-Gardes.png'))),

('Foundations of Complex-system Theories', 'Sunny Y. Auyang', 'Cambridge University Press', '1998', 1, 'English', 'Business & Economics', 
'Analyzes approaches to the study of complexity in the physical, biological, and social sciences.',
'http://books.google.com/books/content?id=YCaTftszYFsC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
load_file(concat(@path, 'Foundations of Complex-system Theories.png'))),

('Essays in Positive Economics', 'Milton Friedman', 'University of Chicago Press', '1953', 1, 'English', 'Business & Economics',
'This paper is concerned primarily with certain methodological problems that arise in constructing the "distinct positive science" that John Neville Keynes called for, in particular, the problem how to decide whether a suggested hypothesis or theory should be tentatively accepted as part of the "body of systematized knowledge concerning what is."',
'http://books.google.com/books/content?id=Fv8846OSbvwC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
load_file(concat(@path,'Essays in Positive Economics.png')));




 INSERT INTO Book (ISBN,ID) VALUES
('9781583670842', LAST_INSERT_ID()),  -- ISBN cho cuốn "Fools Crusade"
('9781101076156', last_insert_ID() + 1),
('N/A', last_insert_ID() + 2),
('9783736417281', last_insert_ID()  + 3),
('9780521618267', last_insert_ID() + 4),
('9781351267106', last_insert_ID() + 5),
('9780521778268', last_insert_ID() + 6),
('9780226264035', last_insert_ID() + 7);


INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image)
VALUES 
('Politics', 'Aristotle', 'Unknown', '1944', 1, 'English', 'Literary Criticism', 
'The book covers Aristotle’s work on the nature of human beings, political theory, and ethics. It includes various works that Aristotle prepared for publication, focusing on practical ethics, logical systems, physical studies, metaphysics, and art.',
'http://books.google.com/books/content?id=ZzxgAAAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 
load_file(concat(@path, 'Politics.png')));

-- Inserting data into the Book table for the "Politics" ISBN (Assuming a generated ID for the Book table)
INSERT INTO Book (ISBN, ID)
VALUES 
('39015022275997', LAST_INSERT_ID());  -- Assuming the ID in Book is linked to the last inserted Document ID

-- Inserting data into the Document table for "An Inquiry Into the Nature and Causes of the Wealth of Nations" by Adam Smith
INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image)
VALUES 
('An Inquiry Into the Nature and Causes of the Wealth of Nations', 'Adam Smith', 'Unknown', '1776', 1, 'English', 'Commercial Policy', 
'This book is considered the foundation of classical economics. It discusses the concepts of division of labor, productivity, and free markets, and is a key text in the study of economics during the early Industrial Revolution.',
'http://books.google.com/books/content?id=C5dNAAAAcAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path,'An Inquiry Into the Nature and Causes of the Wealth of Nations.png')));

-- Inserting data into the Book table for "The Wealth of Nations" ISBN
INSERT INTO Book (ISBN, ID)
VALUES 
('161538303', LAST_INSERT_ID());  -- Assuming the ID in Book is linked to the last inserted Document ID

-- Inserting data into the Document table for "Living in the End Times" by Slavoj Žižek
INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image)
VALUES 
('Living in the End Times', 'Slavoj Žižek', 'Verso', '2011-04-18', 1, 'English', 'Business & Economics', 
'A critical examination of contemporary global capitalism and the socio-political issues leading to the current economic crisis. Žižek explores the limits of capitalism and the crisis facing modern societies.',
'http://books.google.com/books/content?id=MIz6BPT23Q4C&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'Living in the End Times.png')));

-- Inserting data into the Book table for "Living in the End Times" ISBN
INSERT INTO Book (ISBN, ID)
VALUES 
('9781844677023', LAST_INSERT_ID()); 

-- Thêm sách thuộc thể loại Kinh tế học vào bảng Document
INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image) 
VALUES 
('Unto this Last', 'John Ruskin', 'N/A', '1862', 1, 'English', 'Economics', 
'Unto This Last is an essay on economy by John Ruskin, first published in December 1860...', 
'http://books.google.com/books/content?id=da5cAAAAcAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'Unto this Last.png'))),

('On the Principles of Political Economy, and Taxation', 'David Ricardo', 'N/A', '1821', 1, 'English', 'Economics', 
'A work by David Ricardo on the principles of political economy and taxation...', 
'http://books.google.com/books/content?id=iUUJAAAAQAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api',
load_file(concat(@path, 'On the Principles of Political Economy, and Taxation.png'))),

('The Science of Political Economy', 'Henry George', 'Morang; Doubleday & McClure; Kegan Paul, Trench, Trübner', '1897', 1, 'English', 'Economics', 
'The Science of Political Economy discusses economic theory from the perspective of Henry George...', 
'http://books.google.com/books/content?id=Qz5DAAAAIAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'The Science of Political Economy.png')));

-- Thêm sách thuộc thể loại Kinh tế học vào bảng Book
INSERT INTO Book (ISBN, ID) 
VALUES 
('BL:A0018645771', last_insert_id()),
('OXFORD:300151240', last_insert_id() + 1),
('UCAL:$B28341', last_insert_id() + 2 );


-- Thêm sách thuộc thể loại Business & Economics vào bảng Document
INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image) 
VALUES 
('Jingji Xue', 'Paul B. Trescott', 'Chinese University of Hong Kong Press', '2007', 1, 'English', 'Business & Economics', 
'Based on solid research, "Jingji Xue" presents how Economics, as a thought as well as an intellectual discipline, had been introduced to China...', 
'http://books.google.com/books/content?id=VSmzAAAAIAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 
load_file(concat(@path, 'Jingji Xue.png'))),
('Handbook of Economic Growth', 'Philippe Aghion, Steven N. Durlauf', 'Elsevier', '2005-12-21', 1, 'English', 'Business & Economics', 
'Featuring survey articles by leading economists working on growth theory...', 
'http://books.google.com/books/content?id=NllvjGwAq7sC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'Handbook of Economic Growth.png')));

-- Thêm sách thuộc thể loại Business & Economics vào bảng Book
INSERT INTO Book (ISBN, ID) 
VALUES 
('UCSD:31822035214576', last_insert_id()),
('9780444520432', last_insert_id() + 1);


-- Thêm thông tin sách vào bảng Document
INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image) 
VALUES 
('How to Write a Thesis', 'Harry Teitelbaum', 'Arco', '1998', 1, 'English', 'Dissertations, Academic', 
'This book contains all the information-gathering techniques and style guidelines required for a first-rate thesis.', 
'http://books.google.com/books/content?id=bzm-QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api', 
load_file(concat(@path, 'How to Write a Thesis.png'))),

('Rights of Citizens and Persons Under the Fourteenth Amendment', 'Chin-Yung Yen', 'N/A', '1905', 1, 'English', 'Legal Studies',
 'A work discussing the rights of citizens and persons under the Fourteenth Amendment of the United States.', 
 'http://books.google.com/books/content?id=znpDAAAAIAAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'Rights of Citizens and Persons Under the Fourteenth Amendment.png')));

-- Thêm thông tin luận văn vào bảng Thesis
INSERT INTO Thesis (degree, university, ID) 
VALUES 
('Master', 'Arco University',  last_insert_id()),
('Doctorate', 'Yale University', last_insert_id() + 1);

INSERT INTO Document (title, author, publisher, publishedDate, quantity, language, category, description, imageLink, image) 
VALUES
('Looking Together at Student Work, Third Edition', 'Tina Blythe, David Allen, Barbara Schieffelin Powell', 'Teachers College Press', '2015-04-17', 1, 'English', 'Education', 
'This bestseller provides teachers and administrators with strategies for examining and discussing student work, such as essays, math problems, projects, artwork, and more...', 
'http://books.google.com/books/content?id=UhDjBwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'Looking Together at Student Work, Third Edition.png'))),

('Romance of the three kingdoms', 'Guanzhong Luo', 'พีเคพิงเคียว', '2024-05-10', 1, 'zh-CN', 'Architecture', 'Romance of the three kingdoms Guanzhong Luo', 
'http://books.google.com/books/content?id=7YrxEAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'Romance of the three kingdoms.png'))),
('Pinocchio', 'Carlo Collodi', 'Unknown Publisher', '2003', 1, 'English', 'Education', 
'A story about Pinocchio, a puppet who becomes a real boy.', 
'http://books.google.com/books/content?id=AwIKgIOG_jYC&printsec=frontcover&img=1&zoom=1&source=gbs_api', 
load_file(concat(@path, 'Pinocchio.png'))),
('Visible Learning and the Science of How We Learn', 'John Hattie, Gregory C. R. Yates', 'Routledge', '2013-10-08', 1, 'English', 'Education', 
'Visible Learning and the Science of How We Learn explains the major principles and strategies of learning, outlining why it can be so hard sometimes...', 
'http://books.google.com/books/content?id=VdhAAQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api', 
load_file(concat(@path, 'Visible Learning and the Science of How We Learn.png')));

INSERT INTO book (isbn, id) 
VALUES
('9780807756461', last_insert_id()),
('9780807756461', last_insert_id() +1),
('9583009865', last_insert_id() + 2),
('9781134643189',last_insert_id() + 3);






