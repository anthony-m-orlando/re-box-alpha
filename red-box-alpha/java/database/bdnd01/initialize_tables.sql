BEGIN TRANSACTION;

INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (1, 'Lawful Good', 'Creatures who combine a dedication to good with a disciplined commitment to order and justice.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (2, 'Neutral Good', 'Creatures who are guided by their conscience, without strong adherence to rules or authority.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (3, 'Chaotic Good', 'Creatures who act as their conscience directs, with little regard for rules or expectations.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (4, 'Lawful Neutral', 'Creatures who act in accordance with law, tradition, or personal codes, without regard for good or evil.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (5, 'Neutral', 'Creatures who prefer to steer clear of moral questions and do not take sides, doing what seems best at the moment.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (6, 'Chaotic Neutral', 'Creatures who follow their whims, holding personal freedom above all else.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (7, 'Lawful Evil', 'Creatures who methodically take what they want within the limits of a code of conduct, tradition, or order.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (8, 'Neutral Evil', 'Creatures who are driven by self-interest and have no qualms about harming others to get what they want.');
INSERT INTO bdnd01.alignment (alignment_id, name, description) VALUES (9, 'Chaotic Evil', 'Creatures who act with arbitrary violence, spurred by their greed, hatred, or bloodlust.');

INSERT INTO bdnd01.species (species_id, name, description) VALUES (1, 'Human', 'Versatile and adaptable, humans are the most common race in many worlds.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (2, 'Elf', 'Graceful and long-lived, elves are often associated with nature and magic.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (3, 'Dwarf', 'Stout and hardy, dwarves are skilled miners and craftsmen, known for their resilience.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (4, 'Halfling', 'Small and nimble, halflings are often cheerful and adventurous, valuing community and comfort.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (5, 'Gnome', 'Small and clever, gnomes are known for their inventiveness and love of knowledge.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (6, 'Orc', 'Fierce and warlike, orcs are often seen as savage and aggressive.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (7, 'Tiefling', 'Humanoids with infernal heritage, tieflings often face prejudice and suspicion.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (8, 'Dragonborn', 'Humanoids with draconic ancestry, dragonborn are often proud and honorable.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (9, 'Half-Elf', 'The offspring of humans and elves, half-elves combine the best of both races.');
INSERT INTO bdnd01.species (species_id, name, description) VALUES (10, 'Half-Orc', 'The offspring of humans and orcs, half-orcs often struggle with their dual heritage.');

INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (1, 'Barbarian', 'A fierce warrior with primal rage, drawing strength from their untamed nature.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (2, 'Bard', 'An inspiring performer and storyteller, wielding magic through music and words.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (3, 'Cleric', 'A divine caster devoted to a deity, healing and protecting their allies.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (4, 'Druid', 'A nature-attuned spellcaster, drawing power from the wilds and shapeshifting.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (5, 'Fighter', 'A master of martial combat, skilled in weaponry and tactics.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (6, 'Monk', 'A disciplined martial artist, channeling ki to achieve superhuman feats.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (7, 'Paladin', 'A holy warrior devoted to an oath, wielding divine magic and righteous might.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (8, 'Ranger', 'A skilled hunter and tracker, attuned to nature and adept at ranged combat.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (9, 'Rogue', 'A cunning and stealthy operative, skilled in deception and infiltration.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (10, 'Sorcerer', 'An innate spellcaster, wielding magic born from their bloodline or a cosmic source.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (11, 'Warlock', 'A pact-bound spellcaster, drawing power from otherworldly patrons.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (12, 'Wizard', 'A scholarly spellcaster, wielding magic through arcane study and ritual.');
INSERT INTO bdnd01.professions (profession_id, name, description) VALUES (13, 'Artificer', 'A master of invention, creating magical devices and mechanical wonders.');


INSERT INTO bdnd01.characters(
	name, alignment_id, species_id, armor_class, current_hit_points, max_hit_points, strength, intelligence, wisdom, dexterity, charisma, constitution, experience, proficiency_bonus)
	VALUES ('Test Human Barbarian', 1, 1, 13, 14, 14, 18, 10, 8, 16, 10, 18, 1, 2);

INSERT INTO bdnd01.character_professions(
	character_id, profession_id, level)
	VALUES (1,1,1);

INSERT INTO bdnd01.characters(
	name, alignment_id, species_id, armor_class, current_hit_points, max_hit_points, strength, intelligence, wisdom, dexterity, charisma, constitution, experience, proficiency_bonus)
	VALUES ('Test Elf Bard', 2, 2, 14, 10, 10, 12, 15, 18, 18, 12, 16, 1, 2);

INSERT INTO bdnd01.character_professions(
	character_id, profession_id, level)
	VALUES (2,2,1);
	
INSERT INTO bdnd01.characters(	
	name, alignment_id, species_id, armor_class, current_hit_points, max_hit_points, strength, intelligence, wisdom, dexterity, charisma, constitution, experience, proficiency_bonus)
	VALUES ('Test Dwarf Cleric', 3, 3, 10, 10, 10, 14, 13, 17, 16, 12, 16, 1, 2);

INSERT INTO bdnd01.character_professions(
	character_id, profession_id, level)
	VALUES (3,3,1);

INSERT INTO bdnd01.characters(	
	name, alignment_id, species_id, armor_class, current_hit_points, max_hit_points, strength, intelligence, wisdom, dexterity, charisma, constitution, experience, proficiency_bonus)
	VALUES ('Test Halfling Druid Fighter', 4, 4, 10, 18, 18, 14, 13, 17, 16, 12, 16, 301, 2);

INSERT INTO bdnd01.character_professions(
	character_id, profession_id, level)
	VALUES (4,4,1);
	
INSERT INTO bdnd01.character_professions(
	character_id, profession_id, level)
	VALUES (4,5,1);

-- Insert scripts for bdnd01.skills table

INSERT INTO bdnd01.skills (skill_id, name, description, ability) VALUES
(1, 'Acrobatics', 'Your Dexterity (Acrobatics) check covers your attempt to stay on your feet in a tricky situation, such as when you re trying to run across a sheet of ice, balance on a tightrope, or stay upright on a rocking ship. The DC of the check varies from situation to situation.', 'DEX'),
(2, 'Animal Handling', 'When there is any question whether you can calm down a domesticated animal, keep a mount from getting spooked, or intuit an animals intentions, the DM might call for a Wisdom (Animal Handling) check. You also make a Wisdom (Animal Handling) check to control your mount when you attempt a risky maneuver.', 'WIS'),
(3, 'Arcana', 'Your Intelligence (Arcana) check measures your ability to recall lore about spells, magic items, eldritch symbols, magical traditions, planes of existence, and the inhabitants of those planes.', 'INT'),
(4, 'Athletics', 'Your Strength (Athletics) check covers difficult situations you encounter while climbing, jumping, or swimming. Other applications include escaping a grapple or shoving someone.', 'STR'),
(5, 'Deception', 'Your Charisma (Deception) check determines whether you can convincingly hide the truth, either verbally or through your actions. This deception can encompass anything from misleading others through ambiguity to telling outright lies. Typical situations include trying to fast-talk your way past a guard, con a merchant, or win favors with a lie.', 'CHA'),
(6, 'History', 'Your Intelligence (History) check measures your ability to recall lore about historical events, legendary people, ancient kingdoms, past wars, lost civilizations, and so on.', 'INT'),
(7, 'Insight', 'Your Wisdom (Insight) check decides whether you can determine the true intentions of a creature, such as when searching out a lie or predicting the next move of an individual. Doing so involves gleaning clues from body language, speech habits, and changes in mannerisms.', 'WIS'),
(8, 'Intimidation', 'When you attempt to influence someone through overt threats, hostile actions, and physical violence, the DM might ask you to make a Charisma (Intimidation) check. Examples include trying to pry information out of a prisoner, convincing town guards to let you pass through a gate, or using threats to get someone to do what you want.', 'CHA'),
(9, 'Investigation', 'When you look around for clues and make deductions based on those clues, you make an Intelligence (Investigation) check. You might deduce the location of a hidden object, discern from the appearance of a wound what kind of weapon dealt it, or determine the weakest point in a tunnel that could cause it to collapse. Poring through written records in search of a clue requires an Intelligence (Investigation) check.', 'INT'),
(10, 'Medicine', 'A Wisdom (Medicine) check lets you try to stabilize a dying companion or diagnose an illness.', 'WIS'),
(11, 'Nature', 'Your Intelligence (Nature) check measures your ability to recall lore about terrain, plants, animals, weather, and natural cycles.', 'INT'),
(12, 'Perception', 'Your Wisdom (Perception) check lets you spot, hear, or otherwise detect the presence of something. It measures your general awareness of your surroundings and the keenness of your senses. For example, you might try to hear a conversation happening behind a closed door, eavesdrop under an open window, or hear monsters moving stealthily in the forest. Or you might try to spot things that are obscured or easily missed, whether they are orcs hiding in ambush, thugs lurking in the shadows of an alley, or notes about a treasure’s location written on the back of a poster.', 'WIS'),
(13, 'Performance', 'Your Charisma (Performance) check determines how well you can delight an audience with music, dance, acting, storytelling, or some other form of entertainment.', 'CHA'),
(14, 'Persuasion', 'When you attempt to influence someone or a group of people with tact, social graces, or good nature, the DM might ask you to make a Charisma (Persuasion) check. Typically, you use persuasion when acting in good faith, to foster friendships, make cordial requests, or inspire others cooperation.', 'CHA'),
(15, 'Religion', 'Your Intelligence (Religion) check measures your ability to recall lore about deities, rites and prayers, religious hierarchies, holy symbols, and the practices of secret cults.', 'INT'),
(16, 'Sleight of Hand', 'Whenever you attempt an act of legerdemain or manual trickery, such as planting something on someone else or concealing an object on your person, make a Dexterity (Sleight of Hand) check.', 'DEX'),
(17, 'Stealth', 'Make a Dexterity (Stealth) check when you attempt to conceal yourself from enemies, slink past guards, slip away without being noticed, or sneak up on someone without being seen or heard.', 'DEX'),
(18, 'Survival', 'Your Wisdom (Survival) check lets you follow tracks, hunt wild game, guide your group through frozen wastelands, identify signs that owlbears live nearby, predict weather, or avoid quicksand and other natural hazards.', 'WIS');

INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (1, 4);
INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (1, 18);

INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (2, 2);
INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (2, 13);
INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (2, 14);

INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (3, 3);
INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (3, 15);

INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (4, 4);
INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (4, 8);
INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (4, 11);
INSERT INTO bdnd01.character_skills(character_id, skill_id) VALUES (4, 18);

INSERT INTO bdnd01.languages (language_id, name) VALUES
(1, 'Common'),
(2, 'Dwarvish'),
(3, 'Elvish'),
(4, 'Giant'),
(5, 'Gnomish'),
(6, 'Goblin'),
(7, 'Halfling'),
(8, 'Orc'),
(9, 'Abyssal'),
(10, 'Celestial'),
(11, 'Draconic'),
(12, 'Deep Speech'),
(13, 'Infernal'),
(14, 'Primordial'),
(15, 'Sylvan'),
(16, 'Undercommon');

INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (1, 1);
INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (1, 2);
INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (1, 3);

INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (2, 1);
INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (2, 3);

INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (3, 1);
INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (3, 2);

INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (4, 1);
INSERT INTO bdnd01.character_languages(character_id, language_id) VALUES (4, 7);
	
COMMIT TRANSACTION;

