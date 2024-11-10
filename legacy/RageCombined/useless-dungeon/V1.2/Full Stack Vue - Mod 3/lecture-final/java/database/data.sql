BEGIN TRANSACTION;

INSERT INTO users (user_id, username, password_hash,role) VALUES (1, 'user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (user_id, username, password_hash,role) VALUES (2, 'admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO public.dungeons(dungeon_id, user_id, dungeon_name, dungeon_lateral_limit, dungeon_vertical_limit) VALUES (1, 1, 'Useless Dungeon', 2, 2);

--Insert Room Records
INSERT INTO rooms (room_id, dungeon_id, room_name, room_description, lateral_location, vertical_location) VALUES (1, 1, 'Entry Hall', 'This 10 foot by 20 foot entry hall has stone walls with a Door on the east side leading to another room.',1,1);
INSERT INTO rooms (room_id, dungeon_id, room_name, room_description, lateral_location, vertical_location) VALUES (2, 1, 'Dinning Hall', 'This 20 foot by 30 foot dinning area has Velvet Elvis Paintings with a Door on the south wall leading to another room.',2,1);
INSERT INTO rooms (room_id, dungeon_id, room_name, room_description, lateral_location, vertical_location) VALUES (3, 1, 'Dance Studio', 'This 40 foot by 50 foot dance studio has Mirrored Walls with a Door on the west wall leading to another room.',2,2);
INSERT INTO rooms (room_id, dungeon_id, room_name, room_description, lateral_location, vertical_location) VALUES (4, 1, 'Dance Studio', 'This 20 foot by 20 foot arcade has posters of Metallica  with a Door on the north wall leading to another room. Cletus is gently restrained in the comfy chair.',1,2);

--Insert Monster Records
INSERT INTO monsters (monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage) VALUES (0, 'No Monster', 0, 0, 'No Weapon', 0);
INSERT INTO monsters (monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage) VALUES (1, 'Velociraptor', 50, 100, 'Tube Launched Optically Tracked Wire Guided Anti Personnel Missile', 500);
INSERT INTO monsters (monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage) VALUES (2, 'Darth Vader', 100, 1000, 'Red Laser Sword', 5000);
INSERT INTO monsters (monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage) VALUES (3, 'The Gelatinous Cube', 500, 100, 'Gelatinous Envelopment', 500);


--Cletus
INSERT INTO npcs(npc_id, npc_name, npc_health, npc_defense, npc_attack) VALUES (1, 'Cletus Van-Dam', 1, 1, 0);

--Professions Meta Table
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack) VALUES (1, 'Warrior', 10, 5, 8);
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack) VALUES (2, 'Wizard', 4, 4, 100);
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack) VALUES (3, 'Rogue', 6, 10, 6);
INSERT INTO professions (profession_id, profession_name, starting_health, starting_defense, starting_attack) VALUES (4, 'Healer', 8, 6, 4);

--Room Monsters Join Table -- Places monsters in rooms
INSERT INTO room_monsters (room_id, monster_id) VALUES (1, 0);
INSERT INTO room_monsters (room_id, monster_id) VALUES (2, 1);
INSERT INTO room_monsters (room_id, monster_id) VALUES (3, 2);
INSERT INTO room_monsters (room_id, monster_id) VALUES (4, 3);

--Room NPCS Join Table - PLaces NPCS in Rooms
INSERT INTO room_npcs( room_id, npc_id) VALUES (4, 1);

--For first user
INSERT INTO public.heroes(user_id, hero_name, hero_health, hero_defense, hero_profession_id) VALUES (1, 'Larry', 10, 8, 1);
INSERT INTO public.heroes(user_id, hero_name, hero_health, hero_defense, hero_profession_id) VALUES (1, 'Harry', 4, 4, 2);
INSERT INTO public.heroes(user_id, hero_name, hero_health, hero_defense, hero_profession_id) VALUES (1, 'Gary', 6, 10, 1);

COMMIT TRANSACTION;
