BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Nate','$2a$10$Z0FflW7YICKcqIgtZc.gLODWCYZgOmuFmASBPe7VRnUT.m.wvXWKS','ROLE_ADMIN');

INSERT INTO user_book (user_id, book_id) VALUES (3, 2);
INSERT INTO user_book (user_id, book_id) VALUES (3, 4);
INSERT INTO user_book (user_id, book_id) VALUES (3, 5);

COMMIT TRANSACTION;
