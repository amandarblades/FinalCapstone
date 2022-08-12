BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, book, family_unit, prize, format, activity_log, user_family, user_book, user_prize;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE book(
	id SERIAL,
	title varchar(100) NOT NULL,
	author varchar(100) NOT NULL,
	page_count int,
	isbn varchar UNIQUE,
	imgURL varchar,
	CONSTRAINT PK_book PRIMARY KEY(id)
);

CREATE TABLE family_unit (
	id SERIAL,
	family_name varchar(50) NOT NULL,
	CONSTRAINT PK_family_unit PRIMARY KEY(id)
);
CREATE TABLE prize (
	id serial,
	prize_name varchar(25) NOT NULL,
	milestone int NOT NULL,
	max_prize int NOT NULL,
	description varchar(200) NOT NULL,
	user_role varchar(10) NOT NULL,
	start_date date NOT NULL,
	end_date date NOT NULL,
	CONSTRAINT PK_prize PRIMARY KEY(id)
);
CREATE TABLE format(
	id int,
	description varchar(200) NOT NULL,
	CONSTRAINT PK_format PRIMARY KEY(id)
);

CREATE TABLE activity_log(
	id serial,
	user_id int NOT NULL,
	book_id int NOT NULL,
	format_id int NOT NULL,
	minutes_read int NOT NULL,
	notes varchar(200),
	CONSTRAINT PK_activity_log PRIMARY KEY(id)
);
CREATE TABLE user_family(
	user_id int,
	family_id int
);

CREATE TABLE user_book(
	user_id int,
	book_id int
);
CREATE TABLE user_prize(
	user_id int,
	prize_id int
);

ALTER TABLE activity_log ADD CONSTRAINT FK_activity_log_users FOREIGN KEY(user_id) REFERENCES users(user_id);
ALTER TABLE activity_log ADD CONSTRAINT FK_activity_log_book FOREIGN KEY(book_id) REFERENCES book(id);
ALTER TABLE activity_log ADD CONSTRAINT FK_activity_log_format FOREIGN KEY(format_id) REFERENCES format(id);

ALTER TABLE user_family ADD CONSTRAINT FK_user_family_users FOREIGN KEY(user_id) REFERENCES users(user_id);
ALTER TABLE user_family ADD CONSTRAINT FK_user_family_family_unit FOREIGN KEY(family_id) REFERENCES family_unit(id);

ALTER TABLE user_book ADD CONSTRAINT FK_user_book_users FOREIGN KEY(user_id) REFERENCES users(user_id);
ALTER TABLE user_book ADD CONSTRAINT FK_user_book_book FOREIGN KEY(book_id) REFERENCES book(id);

ALTER TABLE user_prize ADD CONSTRAINT FK_user_prize_users FOREIGN KEY(user_id) REFERENCES users(user_id);
ALTER TABLE user_prize ADD CONSTRAINT FK_user_prize_prize FOREIGN KEY(prize_id) REFERENCES prize(id);

INSERT INTO format(id, description) VALUES (1, 'Audiobook');
INSERT INTO format(id, description) VALUES (2, 'Digital');
INSERT INTO format(id, description) VALUES (3, 'Paper');
INSERT INTO format(id, description) VALUES (4,'Read-Aloud (Reader)');
INSERT INTO format(id, description) VALUES (5, 'Read-Aloud (Listener)');
INSERT INTO format(id, description) VALUES (6, 'Other');

INSERT INTO book(title, author, page_count, isbn, imgURL) VALUES ('Frankenstein', 'Mary Shelley', 220, '9781593080051', 'https://covers.openlibrary.org/b/isbn/9781593080051-M.jpg');
INSERT INTO book(title, author, page_count, isbn, imgURL) VALUES ('The House on the Border Land', 'William Hope Hodgeson', 300, '9780786702824', 'https://covers.openlibrary.org/b/isbn/9780786702824-M.jpg');
INSERT INTO book(title, author, page_count, isbn, imgURL) VALUES ('Dracula', 'Bram Stoker', 317, '157335368', 'https://covers.openlibrary.org/b/isbn/157335368-M.jpg');
INSERT INTO book(title, author, page_count, isbn, imgURL) VALUES ('Wuthering Heights', 'Emily Bronte', 385, '9780307455185', 'https://covers.openlibrary.org/b/isbn/9780307455185-M.jpg');
INSERT INTO book(title, author, page_count, isbn, imgURL) VALUES ('Pride and Prejudice', 'Jane Austen', 262, '9780486284736', 'https://covers.openlibrary.org/b/isbn/9780486284736-M.jpg');

COMMIT TRANSACTION;