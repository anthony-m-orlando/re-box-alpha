BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, heroes, monsters, npcs, professions, rooms, room_monsters, room_npcs;

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

CREATE TABLE IF NOT EXISTS npcs
(
    npc_id int NOT NULL,
    npc_name varchar(20) NOT NULL,
    npc_health int NOT NULL,
    npc_defense int NOT NULL,
    npc_attack int NOT NULL,
    CONSTRAINT pk_npc PRIMARY KEY (npc_id)
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




CREATE TABLE IF NOT EXISTS rooms
(
    room_id integer NOT NULL,
    room_name character varying COLLATE pg_catalog."default" NOT NULL,
    room_description text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_room PRIMARY KEY (room_id)
);


CREATE TABLE IF NOT EXISTS room_monsters
(
    room_id integer NOT NULL,
    monster_id integer NOT NULL,
    CONSTRAINT pk_room_monsters PRIMARY KEY (room_id, monster_id),
    CONSTRAINT fk_room_monsters_to_room FOREIGN KEY (room_id) REFERENCES rooms (room_id),
	CONSTRAINT fk_room_monsters_to_monster FOREIGN KEY (monster_id) REFERENCES monsters (monster_id)
);

CREATE TABLE IF NOT EXISTS room_npcs
(
    room_id integer NOT NULL,
    npc_id integer NOT NULL,
    CONSTRAINT pk_room_npcs PRIMARY KEY (room_id, npc_id),
    CONSTRAINT fk_room_npcs_to_room FOREIGN KEY (room_id) REFERENCES rooms (room_id),
	CONSTRAINT fk_room_npcs_to_npc FOREIGN KEY (npc_id) REFERENCES npcs (npc_id)
);



COMMIT;