BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, monster, terrain, monster_group, monster_role,
monster_terrain, event, trap, trap_terrain, feature, hero;

CREATE TABLE public.users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS public.event
(
    event_id integer NOT NULL,
    event_name varchar(25) NOT NULL UNIQUE
    CONSTRAINT PK_event PRIMARY KEY (event_id)
);

CREATE TABLE IF NOT EXISTS public.monster
(
    monster_id integer NOT NULL,
    monster_name varchar(25) NOT NULL,
    monster_challenge_rating integer NOT NULL,
    group_id integer NOT NULL,
    role_id integer NOT NULL,
    monster_intelligence integer NOT NULL,
    monster_endpoint varchar(50) NOT NULL
	CONSTRAINT pk_monster PRIMARY KEY (monster_id)
);

CREATE TABLE IF NOT EXISTS public.monster_group
(
    group_id integer NOT NULL,
    group_name varchar(25),
    CONSTRAINT pk_group PRIMARY KEY (group_id)
);

CREATE TABLE IF NOT EXISTS public.monster_role
(
    role_id integer NOT NULL,
    role_name varchar(25) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (role_id)
);

CREATE TABLE IF NOT EXISTS public.monster_terrain
(
    monster_id integer NOT NULL,
    terrain_id integer NOT NULL,
    CONSTRAINT pk_monster_terrain PRIMARY KEY (monster_id, terrain_id)
);

CREATE TABLE IF NOT EXISTS public.trap
(
    trap_id integer NOT NULL,
    trap_name varchar(25) NOT NULL,
    trap_find_dc integer NOT NULL,
    trap_disable_dc integer NOT NULL,
    trap_challenge_rating integer NOT NULL,
    trap_description varchar(600) NOT NULL,
    trap_image_path varchar(50) NOT NULL,
    CONSTRAINT PK_trap PRIMARY KEY (trap_id)
);

CREATE TABLE IF NOT EXISTS public.trap_terrain
(
    trap_id integer NOT NULL,
    terrain_id integer NOT NULL,
    CONSTRAINT trap_terrain_pkey PRIMARY KEY (trap_id, terrain_id)
);

CREATE TABLE IF NOT EXISTS public.feature
(
    feature_id integer NOT NULL,
    feature_name varchar(25) NOT NULL,
    feature_description varchar(500) NOT NULL,
    feature_image_path varchar(50) NOT NULL,
    CONSTRAINT feature_pkey PRIMARY KEY (feature_id)
);

CREATE TABLE IF NOT EXISTS public.hero
(
    hero_id integer NOT NULL,
    hero_name varchar(50) NOT NULL,
    level integer NOT NULL,
    primary_class_id integer NOT NULL,
    species_id integer NOT NULL,
    hero_perception integer NOT NULL,
    hero_height integer NOT NULL,
    hero_image_path varchar(50) NOT NULL,
    CONSTRAINT hero_pkey PRIMARY KEY (hero_id)
);

CREATE TABLE IF NOT EXISTS public.profession
(
    profession_id integer NOT NULL,
    profession_name varchar(25) NOT NULL,
    CONSTRAINT PK_profession_pkey PRIMARY KEY (profession_id)
);

CREATE TABLE IF NOT EXISTS public.species
(
    species_id integer NOT NULL,
    species_name varchar(25) NOT NULL,
    species_dark_vision integer NOT NULL,
    CONSTRAINT "PK_species_pkey" PRIMARY KEY (species_id)
);


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
    CONSTRAINT "PK_creature" PRIMARY KEY (creature_id)
);

CREATE TABLE IF NOT EXISTS public.creature_action
(
    creature_action_id integer NOT NULL,
    creature_id integer NOT NULL,
    action_type_id" integer NOT NULL,
    action_type_description" text NOT NULL,
    CONSTRAINT "PK_creature_action" PRIMARY KEY (creature_action_id)
);


CREATE TABLE IF NOT EXISTS public.creature_trait
(
    creature_id integer NOT NULL,
    creature_trait text NOT NULL,
    CONSTRAINT "PK_creature_trait" PRIMARY KEY (creature_id, creature_trait)
);


COMMIT TRANSACTION;
