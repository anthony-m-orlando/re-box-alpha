BEGIN TRANSACTION;

DROP TABLE IF EXISTS bdnd01.characters, bdnd01.alignment, bdnd01.species, bdnd01.character_professions, bdnd01.professions,
bdnd01.skills, bdnd01.character_skills, bdnd01.languages, bdnd01.character_languages;

CREATE TABLE bdnd01.alignment (
	alignment_id int NOT NULL,
	name varchar(20) NOT NULL,
	description text NOT NULL,
	CONSTRAINT PK_alignment PRIMARY KEY (alignment_id)
);

CREATE TABLE bdnd01.species (
	species_id int NOT NULL,
	name varchar(20) NOT NULL,
	description text NOT NULL,
	CONSTRAINT PK_species PRIMARY KEY (species_id)
);

CREATE TABLE bdnd01.professions (
	profession_id int NOT NULL,
	name varchar(20) NOT NULL,
	description text NOT NULL,
	CONSTRAINT PK_profession PRIMARY KEY (profession_id)
);

CREATE TABLE bdnd01.character_professions (
	character_id int NOT NULL,
	profession_id int NOT NULL,
	level int NOT NULL,
	CONSTRAINT PK_character_professions PRIMARY KEY (character_id, profession_id)
);

CREATE TABLE bdnd01.characters (
	character_id SERIAL,
	name varchar(50) NOT NULL,
	alignment_id int NOT NULL,
	species_id int NOT NULL,
	armor_class int NOT NULL,
	current_hit_points int NOT NULL,
	max_hit_points int NOT NULL,
	strength int NOT NULL,
	dexterity int NOT NULL,
	constitution int NOT NULL,
	intelligence int NOT NULL,
	wisdom int NOT NULL,
	charisma int NOT NULL,
	experience int NOT NULL,
	proficiency_bonus int NOT NULL,
	CONSTRAINT PK_characters PRIMARY KEY (character_id)
);

CREATE TABLE bdnd01.skills (
	skill_id int NOT NULL,
	name varchar(50) NOT NULL,
	description text NOT NULL,
	ability varchar(10) NOT NULL,
	CONSTRAINT PK_skills PRIMARY KEY (skill_id)
);

CREATE TABLE bdnd01.character_skills (
	character_id int NOT NULL,
	skill_id int NOT NULL,
	CONSTRAINT PK_character_skills PRIMARY KEY (character_id, skill_id)
);

CREATE TABLE bdnd01.languages (
	language_id int NOT NULL,
	name varchar(20) NOT NULL,
	CONSTRAINT PK_languages PRIMARY KEY (language_id)
);

CREATE TABLE bdnd01.character_languages (
	character_id int NOT NULL,
	language_id int NOT NULL,
	CONSTRAINT PK_character_languages PRIMARY KEY (character_id, language_id)
);

COMMIT TRANSACTION;
