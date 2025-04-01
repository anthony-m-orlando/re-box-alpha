BEGIN TRANSACTION;

DROP TABLE IF EXISTS appcon.subscribers, appcon.roles, appcon.subscriber_roles, appcon.invitations;

CREATE TABLE appcon.subscribers (
	subscriber_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	email_addresss varchar(50) NOT NULL UNIQUE,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_subscriber PRIMARY KEY (subscriber_id)
);

CREATE TABLE appcon.roles (
	role_id SERIAL,
	role_name varchar(50) NOT NULL UNIQUE,
	CONSTRAINT PK_roles PRIMARY KEY (role_id)
);

CREATE TABLE appcon.subscriber_roles (
	subscriber_id int NOT NULL,
	role_id int NOT NULL,
	CONSTRAINT pk_subscriber_roles PRIMARY KEY (subscriber_id, role_id),
	CONSTRAINT fk_subscriber_roles_to_subscribers FOREIGN KEY (subscriber_id)
		REFERENCES appcon.subscribers (subscriber_id),
	CONSTRAINT fk_subscriber_roles_to_roles FOREIGN KEY (role_id)
		REFERENCES appcon.roles (role_id)
);


CREATE TABLE appcon.invitations (
	invitation_id SERIAL,
	subscriber_id int NOT NULL,
	role_id int NOT NULL, 
	intivation_date timestamp,
	CONSTRAINT pk_invitations PRIMARY KEY (invitation_id),
	CONSTRAINT fk_invitations_to_subscribers FOREIGN KEY (subscriber_id)
		REFERENCES appcon.subscribers (subscriber_id),
	CONSTRAINT fk_invitations_to_roles FOREIGN KEY (role_id)
		REFERENCES appcon.roles (role_id)
);

COMMIT TRANSACTION;
