package com.techelevator.dao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcCreatureDao implements CreatureDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcCreatureDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Creature getCreatureById(int creatureId) {
        Creature creature = new Creature();
        String sql = "SELECT " +
                "creature.creature_id, " +
                "creature_name, " +
                "creature_type.creature_type_name, " +
                "creature_sub_type.sub_type_name, " +
                "creature_organization.organization_name, " +
                "creature_size.creature_size_name, " +
                "creature_ai_type.creature_ai_type_name, " +
                "creature_alignment.alignment_name, " +
                "creature_armor_type.armor_type_name, " +
                "creature.creature_challenge_rating, " +
                "creature.creature_hit_points, " +
                "creature.creature_hit_dice, " +
                "creature.creature_strength, " +
                "creature.creature_dexterity, " +
                "creature.creature_constitution, " +
                "creature.creature_intelligence, " +
                "creature.creature_wisdom, " +
                "creature.creature_charisma, " +
                "creature.creature_image_name " +
                "FROM creature " +
                "INNER JOIN creature_type ON creature.creature_type_id = creature_type.creature_type_id\n" +
                "INNER JOIN creature_sub_type ON creature.creature_sub_type_id = creature_sub_type.sub_type_id\n" +
                "INNER JOIN creature_organization ON creature.creature_organization_id = creature_organization.organization_id\n" +
                "INNER JOIN creature_size ON creature.creature_size_id = creature_size.creature_size_id\n" +
                "INNER JOIN creature_ai_type ON creature.creature_ai_type_id = creature_ai_type.creature_ai_type_id\n" +
                "INNER JOIN creature_alignment ON creature.creature_alignment_id = creature_alignment.alignment_id\n" +
                "INNER JOIN creature_armor_type ON creature.creature_armor_type_id = creature_armor_type.armor_type_id\n" +
                "WHERE creature.creature_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creatureId);
            if (results.next()) {
                creature = mapRowToCreature(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return creature;
    }

    public List<Creature> getCreaturesForDungeon(int terrainType, int minChallengeRating, int maxChallengeRating) {
        List<Creature> creatures = new ArrayList<>();
        String sql = "SELECT " +
                "creature.creature_id, " +
                "creature_name, " +
                "creature_type.creature_type_name, " +
                "creature_sub_type.sub_type_name, " +
                "creature_organization.organization_name, " +
                "creature_size.creature_size_name, " +
                "creature_ai_type.creature_ai_type_name, " +
                "creature_alignment.alignment_name, " +
                "creature_armor_type.armor_type_name, " +
                "creature.creature_challenge_rating, " +
                "creature.creature_hit_points, " +
                "creature.creature_hit_dice, " +
                "creature.creature_strength, " +
                "creature.creature_dexterity, " +
                "creature.creature_constitution, " +
                "creature.creature_intelligence, " +
                "creature.creature_wisdom, " +
                "creature.creature_charisma, " +
                "creature.creature_image_name " +
                "FROM creature " +
                "INNER JOIN creature_type ON creature.creature_type_id = creature_type.creature_type_id\n" +
                "INNER JOIN creature_sub_type ON creature.creature_sub_type_id = creature_sub_type.sub_type_id\n" +
                "INNER JOIN creature_organization ON creature.creature_organization_id = creature_organization.organization_id\n" +
                "INNER JOIN creature_size ON creature.creature_size_id = creature_size.creature_size_id\n" +
                "INNER JOIN creature_ai_type ON creature.creature_ai_type_id = creature_ai_type.creature_ai_type_id\n" +
                "INNER JOIN creature_alignment ON creature.creature_alignment_id = creature_alignment.alignment_id\n" +
                "INNER JOIN creature_armor_type ON creature.creature_armor_type_id = creature_armor_type.armor_type_id\n" +
                "INNER JOIN creature_terrain ON creature.creature_id = creature_terrain.creature_id " +
                "WHERE creature.creature_challenge_rating BETWEEN ? AND ? AND creature_terrain.terrain_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, minChallengeRating, maxChallengeRating, terrainType);
            while (results.next()) {
                Creature creature = mapRowToCreature(results);
                creatures.add(creature);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
            return creatures;
        }

    public Creature getRandomCreature(int terrainType, int minChallengeRating, int maxChallengeRating){
        Creature creature = new Creature();
        String sql = "SELECT " +
                            "creature.creature_id, " +
                            "creature_name, " +
                            "creature_type.creature_type_name, " +
                            "creature_sub_type.sub_type_name, " +
                            "creature_organization.organization_name, " +
                            "creature_size.creature_size_name, " +
                            "creature_ai_type.creature_ai_type_name, " +
                            "creature_alignment.alignment_name, " +
                            "creature_armor_type.armor_type_name, " +
                            "creature.creature_challenge_rating, " +
                            "creature.creature_hit_points, " +
                            "creature.creature_hit_dice, " +
                            "creature.creature_strength, " +
                            "creature.creature_dexterity, " +
                            "creature.creature_constitution, " +
                            "creature.creature_intelligence, " +
                            "creature.creature_wisdom, " +
                            "creature.creature_charisma, " +
                            "creature.creature_image_name " +
                            "FROM creature " +
                            "INNER JOIN creature_type ON creature.creature_type_id = creature_type.creature_type_id\n" +
                            "INNER JOIN creature_sub_type ON creature.creature_sub_type_id = creature_sub_type.sub_type_id\n" +
                            "INNER JOIN creature_organization ON creature.creature_organization_id = creature_organization.organization_id\n" +
                            "INNER JOIN creature_size ON creature.creature_size_id = creature_size.creature_size_id\n" +
                            "INNER JOIN creature_ai_type ON creature.creature_ai_type_id = creature_ai_type.creature_ai_type_id\n" +
                            "INNER JOIN creature_alignment ON creature.creature_alignment_id = creature_alignment.alignment_id\n" +
                            "INNER JOIN creature_armor_type ON creature.creature_armor_type_id = creature_armor_type.armor_type_id\n" +
                            "INNER JOIN creature_terrain ON creature.creature_id = creature_terrain.creature_id " +
                            "WHERE creature.creature_challenge_rating BETWEEN ? AND ? AND creature_terrain.terrain_id = ? " +
                            "ORDER BY Random() " +
                            "LIMIT 1;";


        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, terrainType, minChallengeRating, maxChallengeRating);
            if (results.next()) {
                creature = mapRowToCreature(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return creature;
    }

    public List<Action> getCreatureActions(int creatureId) {
        List<Action> actions = new ArrayList<>();
        String sql = "SELECT " +
                "creature_action.creature_action_id, " +
                "creature_action.action_type_id," +
                "creature_action_type.action_type_name," +
                "creature_action.action_type_description " +
                "FROM creature " +
                "INNER JOIN creature_action on creature.creature_id = creature_action.creature_id\n" +
                "INNER JOIN creature_action_type ON creature_action.action_type_id = creature_action_type.action_type_id\n" +
                "WHERE creature.creature_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creatureId);
            while (results.next()) {
                actions.add(mapRowToAction(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return actions;

    }

    public List<Trait> getCreatureTraits(int creatureId){
        List<Trait> traits = new ArrayList<>();
        String sql = "SELECT " +
                "creature_trait.creature_trait " +
                "FROM creature " +
                "INNER JOIN creature_trait on creature.creature_id = creature_trait.creature_id " +
                "WHERE creature.creature_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creatureId);
            int traitIdSeed = 1;
            while (results.next()) {
                traits.add(new Trait(traitIdSeed, results.getString("creature_trait")));
                traitIdSeed++;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return traits;
    }

    public List<Language> getCreatureLanguages(int creatureId){
        List<Language> languages = new ArrayList<>();
        String sql = "SELECT " +
                "language.language_id, " +
                "language.language_name " +
                "FROM creature " +
                "INNER JOIN creature_language on creature.creature_id = creature_language.creature_id\n" +
                "INNER JOIN language ON creature_language.language_id = language.language_id\n" +
                "WHERE creature.creature_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creatureId);
            while (results.next()) {
                languages.add(new Language(results.getInt("language_id"), results.getString("language_name")));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return languages;
    }

    public List<Proficiency> getCreatureProficiencies(int creatureId) {
        List<Proficiency> proficiencies = new ArrayList<>();
        String sql = "SELECT " +
                "creature_proficiency.modifier, " +
                "skill.skill_id, " +
                "skill.skill_name, " +
                "skill.skill_description, " +
                "ability.ability_name " +
            "FROM creature " +
            "INNER JOIN creature_proficiency ON creature.creature_id = creature_proficiency.creature_id " +
            "INNER JOIN skill ON creature_proficiency.skill_id = skill.skill_id " +
            "INNER JOIN ability ON skill.skill_ability_id = ability.ability_id " +
            "Where creature.creature_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creatureId);
            int proficiencyIdSeed = 1;
            while (results.next()) {
                Skill skill = new Skill(results.getInt("skill_id"), results.getString("skill_name"), results.getString("skill_description"), results.getString("ability_name"));
                proficiencies.add(new Proficiency(proficiencyIdSeed, skill, results.getInt("modifier")));
                proficiencyIdSeed++;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return proficiencies;
    }

    public List<Save> getCreatureSaves(int creatureId){
        List<Save> saves = new ArrayList<>();
        String sql = "SELECT " +
                "creature_save.creature_save_id, " +
                "creature_save.modifier, " +
                "ability.ability_name " +
                "FROM creature " +
                "INNER JOIN creature_save ON creature.creature_id = creature_save.creature_id " +
                "INNER JOIN ability ON creature_save.ability_id = ability.ability_id " +
                "WHERE creature.creature_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creatureId);
            while (results.next()) {
                saves.add(new Save(results.getString("ability_name"), results.getInt("modifier")));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return saves;
    }
    public List<AIAction> getCreatureTurn(int creatureId) {
        List<AIAction> actions = new java.util.ArrayList<>();
        String sql = "SELECT DISTINCT " +
                "ai_type_action_priority.priority, " +
                "ai_action.ai_action_name, " +
                "ai_target.ai_target_name " +
                "FROM creature " +
                "INNER JOIN ai_type on creature.creature_ai_type_id = ai_type.ai_type_id " +
                "INNER JOIN ai_type_target on ai_type.ai_type_id = ai_type_target.ai_type_id " +
                "INNER JOIN ai_target on ai_type_target.ai_target_id = ai_target.ai_target_id " +
                "INNER JOIN ai_type_action_priority on ai_type.ai_type_id = ai_type_action_priority.ai_type_id " +
                "INNER JOIN ai_action on ai_type_action_priority.ai_action_id = ai_action.ai_action_id " +
                "WHERE creature.creature_id = ? " +
                "ORDER BY priority;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creatureId);
            while (results.next()) {
                AIAction action = new AIAction(results.getInt("priority"), results.getString("ai_action_name"), results.getString("ai_target_name"));
                actions.add(action);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return actions;
    }
    public Creature mapRowToCreature(SqlRowSet results) {
        Creature creature = new Creature();
        creature.setCreatureId(results.getInt("creature_id"));
        creature.setName(results.getString("creature_name"));
        creature.setCreatureType(results.getString("creature_type_name"));
        creature.setCreatureSubType(results.getString("sub_type_name"));
        creature.setOrganization(results.getString("organization_name"));
        creature.setSize(results.getString("creature_size_name"));
        creature.setAiType(results.getString("creature_ai_type_name"));
        creature.setAlignment(results.getString("alignment_name"));
        creature.setArmorType(results.getString("armor_type_name"));
        creature.setChallengeRating(results.getInt("creature_challenge_rating"));
        creature.setHitPoints(results.getInt("creature_hit_points"));
        creature.setHitDice(results.getString("creature_hit_dice"));
        creature.setStrength(results.getInt("creature_strength"));
        creature.setDexterity(results.getInt("creature_dexterity"));
        creature.setConstitution(results.getInt("creature_constitution"));
        creature.setIntelligence(results.getInt("creature_intelligence"));
        creature.setWisdom(results.getInt("creature_wisdom"));
        creature.setCharisma(results.getInt("creature_charisma"));
        creature.setImageName(results.getString("creature_image_name"));

        creature.setActions(getCreatureActions(creature.getCreatureId()));
        creature.setTraits(getCreatureTraits(creature.getCreatureId()));
        creature.setLanguages(getCreatureLanguages(creature.getCreatureId()));
        creature.setProficiencies(getCreatureProficiencies(creature.getCreatureId()));
        creature.setSaves(getCreatureSaves(creature.getCreatureId()));
        return creature;
    }


    public Action mapRowToAction(SqlRowSet results){
        Action action = new Action();
        action.setActionId(results.getInt("creature_action_id"));
        action.setActionType(results.getString("action_type_name"));
        action.setActionDescription(results.getString("action_type_description"));
        return action;
    }
}
