BEGIN TRANSACTION;

--Primary User Table
INSERT INTO appcon.subscribers(username, email_addresss, first_name, last_name, password_hash)
	        VALUES ('Gero_The_Magnificent', 'orlandoamo@gmail.com', 'Anthony', 'Orlando', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');

INSERT INTO appcon.subscribers(username, email_addresss, first_name, last_name, password_hash)
	        VALUES ('Test_Player', 'redbox_test_player@gmail.com', 'Anthony', 'Orlando', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');

INSERT INTO appcon.subscribers(username, email_addresss, first_name, last_name, password_hash)
	        VALUES ('Test_GM', 'redbox_test_gm@gmail.com', 'Anthony', 'Orlando', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');

INSERT INTO appcon.subscribers(username, email_addresss, first_name, last_name, password_hash)
	        VALUES ('Test_Developer', 'redbox_test_developer@gmail.com', 'Anthony', 'Orlando', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC');


--Primary User Role Table
INSERT INTO appcon.roles(role_name) VALUES ('Player');
INSERT INTO appcon.roles(role_name) VALUES ('Game Master');
INSERT INTO appcon.roles(role_name) VALUES ('Developer');

--Associate Initial Users to Roles
--Gero the Magnificent (All Roles)
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (1, 1);
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (1, 2);
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (1, 3);

--Test Player (Player Role)
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (2, 1);

--Test GM (Player and GM Roles)
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (3, 1);
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (3, 2);

--Test Developer (Player, GM and Developer Roles)
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (4, 1);
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (4, 2);
INSERT INTO appcon.subscriber_roles(subscriber_id, role_id) VALUES (4, 3);


--Initial Invitations
INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (1, 1, CURRENT_TIMESTAMP);
INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (1, 2, CURRENT_TIMESTAMP);
INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (1, 3, CURRENT_TIMESTAMP);

INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (2, 1, CURRENT_TIMESTAMP);

INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (3, 1, CURRENT_TIMESTAMP);
INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (3, 2, CURRENT_TIMESTAMP);

INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (4, 1, CURRENT_TIMESTAMP);
INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (4, 2, CURRENT_TIMESTAMP);
INSERT INTO appcon.invitations(subscriber_id, role_id, intivation_date) VALUES (4, 3, CURRENT_TIMESTAMP);

COMMIT TRANSACTION;

