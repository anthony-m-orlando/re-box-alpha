--Database Name: useless_dungeon
BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, heroes, monsters, professions, rooms;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS monsters
(
    monster_id int NOT NULL,
    monster_name varchar(20) NOT NULL,
    monster_health int NOT NULL,
    monster_defense int NOT NULL,
	monster_attack_description text NOT NULL,
    monster_damage int NOT NULL,
    CONSTRAINT pk_monster PRIMARY KEY (monster_id)
);

CREATE TABLE IF NOT EXISTS professions
(
    profession_id int NOT NULL,
    profession_name varchar(20) NOT NULL,
    starting_health int NOT NULL,
    starting_defense int NOT NULL,
    starting_attack int NOT NULL,
    starting_attack_description varchar(20) NOT NULL,
    CONSTRAINT pk_profession PRIMARY KEY (profession_id)
);

CREATE TABLE IF NOT EXISTS heroes
(
    hero_id serial NOT NULL,
	user_id int NOT NULL,
    hero_name varchar(20) NOT NULL,
    hero_health int NOT NULL,
    hero_defense int NOT NULL,
    hero_profession_id int NOT NULL,
    CONSTRAINT pk_hero PRIMARY KEY (hero_id),
	CONSTRAINT fk_hero_to_user FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT fk_hero_to_profession FOREIGN KEY (hero_profession_id) REFERENCES professions (profession_id)
);

CREATE TABLE IF NOT EXISTS rooms
(
    room_id integer NOT NULL,
    room_name character varying COLLATE pg_catalog."default" NOT NULL,
    room_description text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_room PRIMARY KEY (room_id)
);

BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


--Insert Room Records
INSERT INTO rooms (room_id, room_name, room_description) VALUES (1, 'Entry Hall', 'This 10 foot by 20 foot entry hall has stone walls with a Door on the east side leading to another room.');
INSERT INTO rooms (room_id, room_name, room_description) VALUES (2, 'Dinning Hall', 'This 20 foot by 30 foot dinning area has Velvet Elvis Paintings with a Door on the south wall leading to another room.');
INSERT INTO rooms (room_id, room_name, room_description) VALUES (3, 'Dance Studio', 'This 40 foot by 50 foot dance studio has Mirrored Walls with a Door on the west wall leading to another room.');
INSERT INTO rooms (room_id, room_name, room_description) VALUES (4, 'Dance Studio', 'This 20 foot by 20 foot arcade has posters of Metallica  with a Door on the north wall leading to another room. Cletus is gently restrained in the comfy chair.');

--Insert Monster Records
INSERT INTO monsters (monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage) VALUES (1, 'Velociraptor', 50, 100, 'Tube Launched Optically Tracked Wire Guided Anti Personnel Missile', 500);
INSERT INTO monsters (monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage) VALUES (2, 'Darth Vader', 100, 1000, 'Red Laser Sword', 5000);
INSERT INTO monsters (monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage) VALUES (3, 'The Gelatinous Cube', 500, 100, 'Gelatinous Envelopment', 500);

--Professions Meta Table
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack, starting_attack_description) VALUES (1, 'Warrior', 10, 5, 10, 'Claymore');
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack, starting_attack_description) VALUES (2, 'Wizard', 4, 4, 100, 'Fireball');
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack, starting_attack_description) VALUES (3, 'Rogue', 6, 10, 6, 'Crossbow');
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack, starting_attack_description) VALUES (4, 'Healer', 8, 6, 4, 'Staff');

COMMIT;