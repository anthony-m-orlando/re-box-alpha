--Single Monster*******************************************************************************************************
SELECT
	creature_id,
	creature_name,
	creature_type.creature_type_name,
	creature_sub_type.sub_type_name,
	creature_organization.organization_name,
	creature_size.creature_size_name,
	creature_ai_type.creature_ai_type_name,
	creature_alignment.alignment_name,
	creature_armor_type.armor_type_name,
	creature.creature_challenge_rating,
	creature.creature_hit_points,
	creature.creature_hit_dice,
	creature.creature_strength,
	creature.creature_dexterity,
	creature.creature_constitution,
	creature.creature_intelligence,
	creature.creature_wisdom,
	creature.creature_charisma
	FROM creature
	INNER JOIN creature_type ON creature.creature_type_id = creature_type.creature_type_id
	INNER JOIN creature_sub_type ON creature.creature_sub_type_id = creature_sub_type.sub_type_id
	INNER JOIN creature_organization ON creature.creature_organization_id = creature_organization.organization_id
	INNER JOIN creature_size ON creature.creature_size_id = creature_size.creature_size_id
	INNER JOIN creature_ai_type ON creature.creature_ai_type_id = creature_ai_type.creature_ai_type_id
	INNER JOIN creature_alignment ON creature.creature_alignment_id = creature_alignment.alignment_id
	INNER JOIN creature_armor_type ON creature.creature_armor_type_id = creature_armor_type.armor_type_id
	ORDER BY creature.creature_id
--/Single Monster*************************************************************************************************


--Monster Actions**********************************************************************************************************

SELECT
	creature.creature_id,
	creature.creature_name,
	creature_action.creature_action_id,
	creature_action.action_type_id,
	creature_action_type.action_type_name,
	creature_action.action_type_description
FROM creature
INNER JOIN creature_action on creature.creature_id = creature_action.creature_id
INNER JOIN creature_action_type ON creature_action.action_type_id = creature_action_type.action_type_id
ORDER BY creature.creature_id, creature_action.action_type_id

--*******************************************************************************************************

--Monster Languages**********************************************************************************************************

SELECT
	creature.creature_id,
	creature.creature_name,
	creature_language.language_id,
	language.language_name
FROM creature
INNER JOIN creature_language ON creature_language.creature_id = creature.creature_id
INNER JOIN language ON  creature_language.language_id = language.language_id
ORDER BY creature.creature_id

--/Monster Languages**********************************************************************************************************

--Monster Skills**********************************************************************************************************
SELECT
	creature.creature_id,
	creature.creature_name,
	skill.skill_name,
	ability.ability_name,
	creature_proficiency.modifier
FROM creature
INNER JOIN creature_proficiency on creature.creature_id = creature_proficiency.creature_id
INNER JOIN skill ON creature_proficiency.skill_id = skill.skill_id
INNER JOIN ability ON skill.skill_ability_id = ability.ability_id
ORDER BY creature.creature_name
--/Monster Skills**********************************************************************************************************


--/Monster Saves**********************************************************************************************************
SELECT
	creature.creature_id,
	creature.creature_name,
	ability.ability_name,
	creature_save.modifier
FROM creature
INNER JOIN creature_save ON creature.creature_id = creature_save.creature_id
INNER JOIN ability ON creature_save.ability_id = ability.ability_id
Order BY creature_id
--/Monster Saves**********************************************************************************************************


--/Monster TUrn Priority**********************************************************************************************************

SELECT DISTINCT
	ai_type_action_priority.priority,
	ai_action.ai_action_name,
	ai_target.ai_target_name
FROM creature
INNER JOIN ai_type on creature.creature_ai_type_id = ai_type.ai_type_id
INNER JOIN ai_type_target on ai_type.ai_type_id = ai_type_target.ai_type_id
INNER JOIN ai_target on ai_type_target.ai_target_id = ai_target.ai_target_id
INNER JOIN ai_type_action_priority on ai_type.ai_type_id = ai_type_action_priority.ai_type_id
INNER JOIN ai_action on ai_type_action_priority.ai_action_id = ai_action.ai_action_id
WHERE creature.creature_id = ?
ORDER BY priority

