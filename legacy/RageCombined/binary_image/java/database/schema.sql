BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, images;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE images (
	image_id SERIAL,
	user_id int NOT NULL,
	mediatype varchar(100),
	data BYTEA,
	CONSTRAINT PK_images PRIMARY KEY (image_id),
	CONSTRAINT FK_images_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);

COMMIT TRANSACTION;
