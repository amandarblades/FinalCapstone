BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Nate','$2a$10$Z0FflW7YICKcqIgtZc.gLODWCYZgOmuFmASBPe7VRnUT.m.wvXWKS','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Amanda','$2a$10$Z0FflW7YICKcqIgtZc.gLODWCYZgOmuFmASBPe7VRnUT.m.wvXWKS','ROLE_USER');

INSERT INTO user_book (user_id, book_id) VALUES (3, 2);
INSERT INTO user_book (user_id, book_id) VALUES (3, 4);
INSERT INTO user_book (user_id, book_id) VALUES (3, 5);

INSERT INTO activity_log(user_id, book_id,format_id,minutes_read, notes)VALUES(3, 2, 1, 7, 'this was a weird book');
INSERT INTO activity_log(user_id, book_id,format_id,minutes_read, notes)VALUES(3, 2, 2, 6, 'tired');
INSERT INTO activity_log(user_id, book_id,format_id,minutes_read, notes)VALUES(3, 2, 3, 5, 'what is the plot');

INSERT INTO activity_log(user_id, book_id,format_id,minutes_read) VALUES(4, 1, 4, 17);
INSERT INTO activity_log(user_id, book_id,format_id,minutes_read, notes)VALUES(4, 1, 5, 66, 'PRIZE TIME');
INSERT INTO activity_log(user_id, book_id,format_id,minutes_read, notes)VALUES(4, 1, 6, 25, 'Reading is fun!');

INSERT INTO family_unit(family_name)VALUES('Bookworms');

INSERT INTO user_family(family_id, user_id)
VALUES((SELECT id FROM family_unit WHERE family_name = 'Bookworms'), (SELECT user_id FROM users WHERE username= 'Nate'));

INSERT INTO user_family(family_id, user_id)
VALUES((SELECT id FROM family_unit WHERE family_name = 'Bookworms'), (SELECT user_id FROM users WHERE username= 'Amanda'));


COMMIT TRANSACTION;
