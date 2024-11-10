BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence, )VALUES (1,'Bandit  Archer',1,2,2,11,);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (2,'Bandit Captain',3,2,2,13);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (3,'Bandit Elite',2,2,1,12);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (4,'Bandit Thug',1,2,1,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (5,'Boar',0,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (6,'Dire Boar',1,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (7,'Bugbear Captain',5,5,1,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (8,'Bugbear Elite',4,5,1,9);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (9,'Bugbear Scout',3,5,2,8);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (10,'Bugbear Warrior',3,5,1,8);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (11,'Cult Leader',3,4,3,14);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (12,'Cultist',1,4,1,12);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (13,'Cultist Elite',2,4,2,13);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (14,'Fire Beetle',1,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (15,'Dire Fire Beetle',2,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (16,'Goblin Captain',3,3,2,12);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (17,'Goblin Elite',2,3,2,11);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (18,'Goblin Scout',1,3,2,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (19,'Goblin Warrior',1,3,1,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (20,'Kobold Captain',3,1,2,11);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (21,'Kobold Elite',2,1,2,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (22,'Kobold Scout',1,1,2,9);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (23,'Kobold Warrior',1,1,1,8);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (24,'LIzard Man Captain',3,1,1,13);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (25,'Lizard Man Elite',2,1,1,12);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (26,'Lizard Man Scout',1,1,2,11);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (27,'Lizard Man Warrior',1,1,1,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (28,'Mercenary Captain',3,6,1,15);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (29,'Mercenary Elite',2,6,1,14);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (30,'Mercenary Scout',1,6,2,13);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (31,'Mercenary Warrior',1,6,1,12);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (32,'Orc Captain',3,3,1,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (33,'Orc Elite',2,3,1,9);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (34,'Orc Scout',1,3,2,8);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (35,'Orc Warrior',1,3,1,8);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (36,'Rat',1,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (37,'Dire Rat',2,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (38,'Giant Rat',3,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (39,'Rogue Brawler',1,2,1,12);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (40,'Rogue Captain',3,2,2,15);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (41,'Rogue Elite',2,2,2,14);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (42,'Rogue Archer',1,2,2,13);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (43,'Skeleton Warrior',1,7,1,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (44,'Skeleton Archer',1,7,2,10);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (45,'Dark Acolyte',3,7,3,16);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (46,'Spider',1,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (47,'Dire Spider',2,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (48,'Giant Spider',3,5,1,2);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (49,'Wolf',1,5,1,4);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (50,'Dire Wolf',2,5,1,4);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (51,'Giant Wolf',3,5,1,4);
INSERT INTO public.monster(monster_id, monster_name, monster_challenge_rating, group_id, role_id, monster_intelligence)VALUES (52,'Zombie',2,7,1,3);

INSERT INTO public.monster_group (group_id,group_name) VALUES (1,'Band');
INSERT INTO public.monster_group (group_id,group_name) VALUES (2,'Gang');
INSERT INTO public.monster_group (group_id,group_name) VALUES (3,'Mob');
INSERT INTO public.monster_group (group_id,group_name) VALUES (4,'Cell');
INSERT INTO public.monster_group (group_id,group_name) VALUES (5,'Pack');
INSERT INTO public.monster_group (group_id,group_name) VALUES (6,'Squad');
INSERT INTO public.monster_group (group_id,group_name) VALUES (7,'Coven');

INSERT INTO public.monster_role (role_id,role_name) VALUES (1,'MELEE');
INSERT INTO public.monster_role (role_id,role_name) VALUES (2,'RANGED');
INSERT INTO public.monster_role (role_id,role_name) VALUES (3,'MAGIC');
INSERT INTO public.monster_role (role_id,role_name) VALUES (4,'HEALER');

INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (1,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (1,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (1,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (2,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (2,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (2,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (3,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (3,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (3,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (4,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (4,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (4,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (5,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (5,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (6,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (6,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (7,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (7,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (8,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (8,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (9,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (9,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (10,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (10,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (11,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (11,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (12,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (12,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (13,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (13,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (14,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (14,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (15,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (15,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (16,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (16,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (16,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (17,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (17,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (17,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (18,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (18,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (18,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (19,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (19,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (19,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (20,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (20,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (20,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (21,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (21,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (21,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (22,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (22,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (22,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (23,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (23,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (23,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (24,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (24,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (25,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (25,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (26,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (26,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (27,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (27,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (28,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (28,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (28,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (28,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (29,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (29,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (29,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (29,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (30,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (30,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (30,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (30,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (31,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (31,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (31,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (31,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (32,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (32,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (32,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (33,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (33,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (33,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (34,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (34,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (34,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (35,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (35,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (35,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (36,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (36,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (37,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (37,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (38,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (38,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (39,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (39,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (39,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (39,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (40,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (40,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (40,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (40,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (41,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (41,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (41,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (41,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (42,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (42,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (42,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (42,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (43,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (43,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (43,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (43,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (44,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (44,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (44,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (44,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (45,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (45,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (45,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (45,4);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (46,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (46,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (46,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (47,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (47,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (47,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (48,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (48,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (48,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (49,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (49,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (50,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (50,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (51,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (51,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (52,1);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (52,2);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (52,3);
INSERT INTO public.monster_terrain (monster_id, terrain_id)	VALUES (52,4);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (1,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (2,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (3,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (4,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (7,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (8,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (9,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (10,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (11,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (12,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (13,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (14,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (15,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (16,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (17,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (18,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (19,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (20,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (21,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (22,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (23,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (24,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (25,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (26,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (27,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (28,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (29,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (30,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (31,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (32,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (33,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (34,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (35,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (36,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (37,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (38,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (39,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (40,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (41,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (42,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (43,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (44,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (45,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (46,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (47,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (48,5);
INSERT INTO public.monster_terrain(monster_id, terrain_id) VALUES (52,5);

INSERT INTO public.event(event_id, event_name) VALUES (1, 'Random Encounter');
INSERT INTO public.event(event_id, event_name) VALUES (2, 'Trap');
INSERT INTO public.event(event_id, event_name) VALUES (3, 'Feature');
INSERT INTO public.event(event_id, event_name) VALUES (4, 'Nothing Happens');

INSERT INTO public.trap(trap_id, trap_name, trap_image_path, trap_find_dc, trap_disable_dc, trap_challenge_rating, trap_description)
VALUES (1, 'Collapsing Roof','collapse.png', 10, 15, 1, 'When the trap is triggered, the unstable ceiling collapses. Any creature in the area beneath the unstable section must succeed on a DC 15 Dexterity saving throw, taking 1d6 bludgeoning damage on a failed save, or half as much damage on a successful one. Once the trap is triggered, the floor of the area is filled with rubble and becomes difficult terrain.');

INSERT INTO public.trap(trap_id, trap_name, trap_image_path, trap_find_dc, trap_disable_dc, trap_challenge_rating, trap_description)
VALUES (2, 'Falling Net', 'net.png',  10, 15, 1, 'When the trap is triggered, the net is released, covering a 10-foot-square area. Those in the area are trapped under the net and restrained, and those that fail a DC 10 Strength saving throw are also knocked prone. A creature can use its action to make a DC 10 Strength check, freeing itself or another creature within its reach on a success. The net has AC 10 and 20 hit points. Dealing 5 slashing damage to the net (AC 10) destroys a 5-foot-square section of it, freeing any creature trapped in that section.');

INSERT INTO public.trap(trap_id, trap_name, trap_image_path, trap_find_dc, trap_disable_dc, trap_challenge_rating, trap_description)
VALUES (3, 'Hidden Pit', 'pit-trap.png', 15, 15, 1, 'When the trap is triggered, the victim falls 10 feet into a 5x5 foot pit. The victim takes 1d6 bludgeoning damage from the fall and is prone. The victim must use an action to climb out of the pit, which has a DC 10 Athletics check.');

INSERT INTO public.trap(trap_id, trap_name, trap_image_path, trap_find_dc, trap_disable_dc, trap_challenge_rating, trap_description)
VALUES (4, 'Poison Dart','poison-dart.png', 15, 15, 2, 'The trap activates when more than 20 pounds of weight is placed on the pressure plate, releasing one dart. The Dart makes a ranged attack with a +8 bonus against a random target within 10 feet of the pressure plate (vision is irrelevant to this attack roll). (If there are no targets in the area, the darts don’t hit anything.) A target that is hit takes 2 (1d4) piercing damage and must succeed on a DC 15 Constitution saving throw, taking 11 (2d10) poison damage on a failed save, or half as much damage on a successful one.');

INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (1, 1);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (2, 1);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (3, 1);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (4, 1);

INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (1, 2);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (2, 2);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (3, 2);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (4, 2);

INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (1, 3);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (2, 3);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (3, 3);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (4, 3);

INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (1, 4);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (2, 4);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (3, 4);
INSERT INTO public.trap_terrain(trap_id, terrain_id) VALUES (4, 4);

INSERT INTO public.feature(feature_id, feature_name, feature_image_path, feature_description)
	VALUES (1, 'Chest', 'chest.png', 'A Chest Containing 1D10 Gold Pieces');

INSERT INTO public.feature(feature_id, feature_name, feature_image_path, feature_description)
	VALUES (2, 'Crates', 'crate.png', 'Crates Containing 5 Days of Rations');

INSERT INTO public.feature(feature_id, feature_name, feature_image_path, feature_description)
	VALUES (3, 'Barrels', 'barrels.png', 'Barrels containing drinking water');

INSERT INTO public.feature(feature_id, feature_name, feature_image_path, feature_description)
	VALUES (4, 'Hidden Treasure', 'coins.png', 'An Assortment of Treasure Worth 1D6X10 Silver Coins');

--Demo Characters
INSERT INTO public.hero(
	hero_id, hero_name, hero_image_path, level, primary_class_id, species_id, hero_perception, hero_height)
	VALUES (1, 'Bonk', 'barbarian.png', 1, 5, 8, 10, 72);
--Fighter 5 Human 8

INSERT INTO public.hero(
	hero_id, hero_name, hero_image_path, level, primary_class_id, species_id, hero_perception, hero_height)
	VALUES (2, 'Heely','cleric.png', 1, 3, 2, 12, 54);
--Cleric 3 Dwarf 2

INSERT INTO public.hero(
	hero_id, hero_name, hero_image_path, level, primary_class_id, species_id, hero_perception, hero_height)
	VALUES (3, 'Tizard','caped.png', 1, 12, 3, 14, 65);
--Wizard 12 Elf 3

INSERT INTO public.hero(
	hero_id, hero_name, hero_image_path, level, primary_class_id, species_id, hero_perception, hero_height)
	VALUES (4, 'Logue','cloaked.png', 1, 9, 7, 15, 36);
--Rogue 9 Halfling 7

INSERT INTO public.profession(profession_id, profession_name) VALUES (1, 'Barbarian');
INSERT INTO public.profession(profession_id, profession_name) VALUES (2, 'Bard');
INSERT INTO public.profession(profession_id, profession_name) VALUES (3, 'Cleric');
INSERT INTO public.profession(profession_id, profession_name) VALUES (4, 'Druid');
INSERT INTO public.profession(profession_id, profession_name) VALUES (5, 'Fighter');
INSERT INTO public.profession(profession_id, profession_name) VALUES (6, 'Monk');
INSERT INTO public.profession(profession_id, profession_name) VALUES (7, 'Paladin');
INSERT INTO public.profession(profession_id, profession_name) VALUES (8, 'Ranger');
INSERT INTO public.profession(profession_id, profession_name) VALUES (9, 'Rogue');
INSERT INTO public.profession(profession_id, profession_name) VALUES (10, 'Sorcerer');
INSERT INTO public.profession(profession_id, profession_name) VALUES (11, 'Warlock');
INSERT INTO public.profession(profession_id, profession_name) VALUES (12, 'Wizard');

INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (1, 'Dragonborn', 0);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (2, 'Dwarf', 60);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (3, 'Elf', 60);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (4, 'Gnome', 60);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (5, 'Half Elf', 60);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (6, 'Halfling', 0);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (7, 'Half Orc', 60);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (8, 'Human', 0);
INSERT INTO public.species(species_id, species_name, species_dark_vision) VALUES (9, 'Tiefling', 60);




COMMIT TRANSACTION;