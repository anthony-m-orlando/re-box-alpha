
SELECT alignment_id, name, description	FROM bdnd01.alignment; --9 rows

SELECT profession_id, name, description FROM bdnd01.professions; --13 Rows

SELECT species_id, name, description FROM bdnd01.species; --10 Rows


SELECT characters.character_id, characters.name, alignment.name, character_professions.level, professions.name, species.name, armor_class, current_hit_points, max_hit_points, strength, intelligence, wisdom, dexterity, charisma, constitution, experience, proficiency_bonus	
FROM bdnd01.characters
	INNER JOIN bdnd01.alignment ON characters.alignment_id = alignment.alignment_id
	INNER JOIN bdnd01.species ON characters.species_id = species.species_id
	INNER JOIN bdnd01.character_professions ON bdnd01.characters.character_id = bdnd01.character_professions.character_id
	INNER JOIN bdnd01.professions ON character_professions.profession_id = professions.profession_id;
--4 Rows

SELECT skill_id, name, description, ability FROM bdnd01.skills; --18 rows


SELECT characters.character_id, characters.name, skills.name
FROM bdnd01.characters	
	INNER JOIN bdnd01.character_skills ON character_skills.character_id = characters.character_id
	INNER JOIN bdnd01.skills ON skills.skill_id = character_skills.skill_id;
	

SELECT characters.character_id, characters.name, languages.name
FROM bdnd01.characters	
	INNER JOIN bdnd01.character_languages ON character_languages.character_id = characters.character_id
	INNER JOIN bdnd01.languages ON languages.language_id = character_languages.language_id;
	


