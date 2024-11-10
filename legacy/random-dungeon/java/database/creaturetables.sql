
CREATE TABLE IF NOT EXISTS public.creature
(
    creature_id integer NOT NULL,
    creature_name varchar(50) NOT NULL,
    creature_type_id integer NOT NULL,
    creature_sub_type_id integer NOT NULL,
    creature_ai_type_id integer,
    creature_organization_id integer NOT NULL,
    creature_size_id integer NOT NULL,
    creature_alignment_id integer NOT NULL,
    creature_armor_class integer NOT NULL,
    creature_armor_type_id integer NOT NULL,
    creature_hit_points integer NOT NULL,
    creature_hit_dice varchar(20) NOT NULL,
    creature_challenge_rating integer NOT NULL,
    creature_strength integer NOT NULL,
    creature_dexterity integer NOT NULL,
    creature_constitution integer NOT NULL,
    creature_intelligence integer NOT NULL,
    creature_wisdom integer NOT NULL,
    creature_charisma integer NOT NULL,
    creature_image_name varchar(50) NOT NULL,
    CONSTRAINT "PK_creature" PRIMARY KEY (creature_id)
);

CREATE TABLE IF NOT EXISTS public.creature_action
(
    creature_action_id integer NOT NULL,
    creature_id integer NOT NULL,
    action_type_id integer NOT NULL,
    action_type_description text NOT NULL,
    CONSTRAINT "PK_creature_action" PRIMARY KEY (creature_action_id)
);


CREATE TABLE IF NOT EXISTS public.creature_trait
(
    creature_id integer NOT NULL,
    creature_trait text NOT NULL,
    CONSTRAINT "PK_creature_trait" PRIMARY KEY (creature_id, creature_trait)
);

CREATE TABLE IF NOT EXISTS public.creature_action_type
(
    action_type_id integer NOT NULL,
    action_type_name varchar(25) NOT NULL,
    CONSTRAINT "PK_creature_action_type" PRIMARY KEY (action_type_id)
);


CREATE TABLE IF NOT EXISTS public.creature_type
(
    creature_type_id integer NOT NULL,
    creature_type_name varchar(25) NOT NULL,
    CONSTRAINT "PK_creature_type" PRIMARY KEY ("creature_type_id")
);

CREATE TABLE IF NOT EXISTS public.creature_sub_type
(
    sub_type_id integer NOT NULL,
    sub_type_name varchar(20) NOT NULL,
    CONSTRAINT "PK_creature_sub_type" PRIMARY KEY (sub_type_id)
);

CREATE TABLE IF NOT EXISTS public.creature_organization
(
    organization_id integer NOT NULL,
    organization_name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "PK_creature_organization" PRIMARY KEY (organization_id)
);

CREATE TABLE IF NOT EXISTS public.creature_size
(
    creature_size_id integer NOT NULL,
    creature_size_name varchar(20) NOT NULL,
    CONSTRAINT "PK_creature_size" PRIMARY KEY (creature_size_id)
);

CREATE TABLE IF NOT EXISTS public.creature_ai_type
(
    creature_ai_type_id integer NOT NULL,
    creature_ai_type_name varchar(20) NOT NULL,
    CONSTRAINT "PK_creature_ai_type" PRIMARY KEY (creature_ai_type_id)
);

CREATE TABLE IF NOT EXISTS public.creature_alignment
(
    alignment_id integer NOT NULL,
    alignment_name varchar(20) NOT NULL,
    CONSTRAINT "PK_creature_alignment" PRIMARY KEY ("alignment_id")
);

CREATE TABLE IF NOT EXISTS public.creature_armor_type
(
    armor_type_id integer NOT NULL,
    armor_type_name varchar(20) NOT NULL,
    CONSTRAINT "PK_armor_type" PRIMARY KEY (armor_type_id)
);

CREATE TABLE IF NOT EXISTS public.creature_language
(
    creature_id integer NOT NULL,
    language_id integer NOT NULL,
    CONSTRAINT "PK_creature_language" PRIMARY KEY (creature_id, language_id)
);

CREATE TABLE IF NOT EXISTS public.language
(
    language_id integer NOT NULL,
    language_name varchar(50) NOT NULL,
    CONSTRAINT "PK_language" PRIMARY KEY (language_id)
);

CREATE TABLE IF NOT EXISTS public.creature_save
(
    creature_save_id integer NOT NULL,
    creature_id integer NOT NULL,
    ability_id integer NOT NULL,
    modifier integer NOT NULL,
    CONSTRAINT "PK_creature_id" PRIMARY KEY (creature_save_id)
);

CREATE TABLE IF NOT EXISTS public.creature_proficiency
(
    creature_id integer NOT NULL,
    skill_id integer NOT NULL,
    modifier integer NOT NULL,
    CONSTRAINT "PK_creature_proficiency" PRIMARY KEY (creature_id, skill_id)
);

CREATE TABLE IF NOT EXISTS public.skill
(
    skill_id integer NOT NULL,
    skill_name text COLLATE pg_catalog."default" NOT NULL,
    skill_description text COLLATE pg_catalog."default" NOT NULL,
    skill_ability_id integer NOT NULL,
    CONSTRAINT "PK_skill" PRIMARY KEY (skill_id)
);

CREATE TABLE IF NOT EXISTS public.ability
(
    ability_id integer NOT NULL,
    ability_name varchar(20) NOT NULL,
    CONSTRAINT "PK_ability" PRIMARY KEY (ability_id)
);

DROP TABLE IF EXISTS public.ai_action;

CREATE TABLE IF NOT EXISTS public.ai_action
(
    ai_action_id integer NOT NULL,
    ai_action_name varchar(25) NOT NULL,
    ai_action_type_id integer NOT NULL,
    CONSTRAINT "PK_ai_action_pkey" PRIMARY KEY (ai_action_id)
);


CREATE TABLE IF NOT EXISTS public.ai_target
(
    ai_target_id integer NOT NULL,
    ai_target_name varchar(25) NOT NULL,
    CONSTRAINT "PK_ai_target" PRIMARY KEY (ai_target_id)
);


CREATE TABLE IF NOT EXISTS public.ai_type
(
    ai_type_id integer NOT NULL,
    ai_type_name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "tblAIType_pkey" PRIMARY KEY (ai_type_id)
);



CREATE TABLE IF NOT EXISTS public.ai_type_action_priority
(
    ai_type_id integer NOT NULL,
    priority integer NOT NULL,
    ai_action_id integer NOT NULL,
    CONSTRAINT "PK_ai_type_action_priority" PRIMARY KEY (ai_type_id, priority, ai_action_id)
);

CREATE TABLE IF NOT EXISTS public.ai_type_target
(
    ai_type_id integer NOT NULL,
    ai_target_id integer NOT NULL,
    CONSTRAINT "PK_ai_type_target" PRIMARY KEY (ai_type_id, ai_target_id)
);


CREATE TABLE IF NOT EXISTS public.terrain
(
    terrain_id integer NOT NULL,
    terrain_name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "tblTerrain_pkey" PRIMARY KEY (terrain_id)
);

INSERT INTO terrain (terrain_id,terrain_name) VALUES (1,'Dungeon');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (2,'Darklands');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (3,'Woods');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (4,'Forest');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (5,'Wooded Hills');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (6,'Grasslands');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (7,'Urban');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (8,'Dead Forest');
INSERT INTO terrain (terrain_id,terrain_name) VALUES (9,'Sewers');

CREATE TABLE IF NOT EXISTS public.creature_terrain
(
    terrain_creature_id integer NOT NULL,
    terrain_id integer NOT NULL,
    creature_id integer NOT NULL,
    CONSTRAINT "tblTerrainCreature_pkey" PRIMARY KEY (terrain_creature_id)
);


