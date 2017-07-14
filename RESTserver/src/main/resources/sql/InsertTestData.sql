USE library;

DELETE FROM tbl_book_authors;
DELETE FROM tbl_book_genres;
DELETE FROM tbl_book;
DELETE FROM tbl_author;
DELETE FROM tbl_genre;
DELETE FROM tbl_publisher;
DELETE FROM tbl_user;
DELETE FROM tbl_role;

INSERT INTO tbl_role (role_name) VALUES ('admin');
INSERT INTO tbl_role (role_name) VALUES ('user');

INSERT INTO tbl_user (user_name, password, user_role_id) VALUES ('deputat', '547E177201F1E8979F3B6B8C80689BBB', 1);
INSERT INTO tbl_user (user_name, password, user_role_id) VALUES ('test', '098F6BCD4621D373CADE4E832627B4F6', 2);

INSERT INTO tbl_publisher (name) VALUES ('Pearson');
INSERT INTO tbl_publisher (name) VALUES ('ThomsonReuters');
INSERT INTO tbl_publisher (name) VALUES ('RELX Group');

INSERT INTO tbl_genre (name) VALUES ('romance');
INSERT INTO tbl_genre (name) VALUES ('fantasy');
INSERT INTO tbl_genre (name) VALUES ('science-fiction');
INSERT INTO tbl_genre (name) VALUES ('historical');
INSERT INTO tbl_genre (name) VALUES ('sci-fi');
INSERT INTO tbl_genre (name) VALUES ('thriller');
INSERT INTO tbl_genre (name) VALUES ('crime');
INSERT INTO tbl_genre (name) VALUES ('biography');

INSERT INTO tbl_author (first_name, last_name) VALUES ('Ernest', 'Hemingway');
INSERT INTO tbl_author (first_name, last_name) VALUES ('Joan', 'Didion');
INSERT INTO tbl_author (first_name, last_name) VALUES ('Mark', 'Twain');
INSERT INTO tbl_author (first_name, last_name) VALUES ('John', 'Steinbeck');

INSERT INTO tbl_book (name, description, file, page_count, publisher_id, publish_year, user_id, image)
VALUES ('The Old Man and the Sea',
        'It is the story of an old Cuban fisherman and his supreme ordeal: a relentless, agonizing battle with a giant marlin far out in the Gulf Stream. Using the simple, powerful language of a fable, Hemingway takes the timeless themes of courage in the face of defeat and personal triumph won from loss and transforms them into a magnificent twentieth-century classic.',
        'https://la.utexas.edu/users/jmciver/Honors/Fiction%202013/Hemmingway_The%20Old%20Man%20and%20the%20Sea_1952.pdf',
        132, 1, CURRENT_TIMESTAMP(), 1,
        'http://images.gr-assets.com/books/1329189714l/2165.jpg');
INSERT INTO tbl_book (name, description, file, page_count, publisher_id, publish_year, user_id, image)
VALUES ('South and West',
        'From the best-selling author of the National Book Award-winning The Year of Magical Thinking two extended excerpts from her never-before-seen notebooks--writings that offer an illuminating glimpse into the mind and process of a legendary writer.',
        '', 160, 2, CURRENT_TIMESTAMP(), 2,
        'http://images.gr-assets.com/books/1478652887l/32842454.jpg');

INSERT INTO tbl_book_genres (genre_id, book_id) VALUES (1, 1);
INSERT INTO tbl_book_genres (genre_id, book_id) VALUES (2, 1);
INSERT INTO tbl_book_genres (genre_id, book_id) VALUES (3, 2);
INSERT INTO tbl_book_genres (genre_id, book_id) VALUES (4, 2);

INSERT INTO tbl_book_authors (author_id, book_id) VALUES (1, 1);
INSERT INTO tbl_book_authors (author_id, book_id) VALUES (2, 1);
INSERT INTO tbl_book_authors (author_id, book_id) VALUES (3, 2);
INSERT INTO tbl_book_authors (author_id, book_id) VALUES (4, 2);