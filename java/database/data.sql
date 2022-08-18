BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role, total_minutes_read) VALUES ('Nate','$2a$10$Z0FflW7YICKcqIgtZc.gLODWCYZgOmuFmASBPe7VRnUT.m.wvXWKS','ROLE_ADMIN', 78);
INSERT INTO users (username,password_hash,role, total_minutes_read) VALUES ('Amanda','$2a$10$Z0FflW7YICKcqIgtZc.gLODWCYZgOmuFmASBPe7VRnUT.m.wvXWKS','ROLE_USER', 118);
INSERT INTO users (username,password_hash,role, total_minutes_read) VALUES ('Jordan','$2a$10$Z0FflW7YICKcqIgtZc.gLODWCYZgOmuFmASBPe7VRnUT.m.wvXWKS','ROLE_ADMIN', 0);
INSERT INTO users (username,password_hash,role, total_minutes_read) VALUES ('Heather','$2a$10$Z0FflW7YICKcqIgtZc.gLODWCYZgOmuFmASBPe7VRnUT.m.wvXWKS','ROLE_USER', 0);

INSERT INTO user_book (user_id, book_id) VALUES (3, 2);
INSERT INTO user_book (user_id, book_id) VALUES (3, 4);
INSERT INTO user_book (user_id, book_id) VALUES (3, 5);

INSERT INTO activity_log(date_logged, user_id, book_id,format_id,minutes_read, notes)VALUES('2021-10-10', 3, 2, 1, 27, 'Pig men!');
INSERT INTO activity_log(date_logged, user_id, book_id,format_id,minutes_read, notes)VALUES('2021-8-3', 3, 2, 2, 36, 'Big hole in the basement!');
INSERT INTO activity_log(date_logged, user_id, book_id,format_id,minutes_read, notes)VALUES('2021-10-2', 3, 2, 3, 15, 'Lock the trap door!');

INSERT INTO activity_log(date_logged, user_id, book_id,format_id,minutes_read) VALUES('2021-10-2', 4, 1, 4, 17);
INSERT INTO activity_log(date_logged, user_id, book_id,format_id,minutes_read, notes)VALUES('2021-8-3', 4, 1, 5, 66, 'PRIZE TIME');
INSERT INTO activity_log(date_logged, user_id, book_id,format_id,minutes_read, notes)VALUES('2021-10-10', 4, 1, 6, 25, 'Reading is fun!');

INSERT INTO family_unit(family_name)VALUES('Bookworms');

INSERT INTO user_family(family_id, user_id)
VALUES((SELECT id FROM family_unit WHERE family_name = 'Bookworms'), (SELECT user_id FROM users WHERE username= 'Nate'));

INSERT INTO user_family(family_id, user_id)
VALUES((SELECT id FROM family_unit WHERE family_name = 'Bookworms'), (SELECT user_id FROM users WHERE username= 'Amanda'));

INSERT INTO prize(prize_name, milestone, max_prize, description, user_role, start_date, end_date, is_active, prize_winners)
VALUES('Read to Pop', 20, 2, 'You got a piece of gum!', 'ROLE_USER', '2022-08-01', '2022-08-31', true, 0);
INSERT INTO prize(prize_name, milestone, max_prize, description, user_role, start_date, end_date, is_active, prize_winners)
VALUES('Get a Lollipop', 10, 5, 'Read for 10 minutes then earn a sucker!', 'ROLE_USER', '2022-08-01', '2022-09-05', true, 0);
INSERT INTO prize(prize_name, milestone, max_prize, description, user_role, start_date, end_date, is_active, prize_winners)
VALUES('Read to Pop', 30, 3, 'You got a piece of gum!', 'ROLE_ADMIN', '2022-08-01', '2022-10-05', true, 0);

INSERT INTO user_prize(prize_id, user_id, is_complete)
VALUES(1, 4, false);
INSERT INTO user_prize(prize_id, user_id, is_complete)
VALUES(2, 4, false);
INSERT INTO user_prize(prize_id, user_id, is_complete)
VALUES(2, 3, false);
INSERT INTO user_prize(prize_id, user_id, is_complete)
VALUES(3, 3, false);

COMMIT TRANSACTION;
