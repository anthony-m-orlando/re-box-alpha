package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.AIAction;
import com.techelevator.model.Monster;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class jdbcMonsterDao implements MonsterDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcMonsterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Monster getMonsterById(int monsterId) {
        Monster monster = new Monster();
        String sql = "SELECT monster_id, monster_name, monster_challenge_rating, monster_group.group_id, " +
                "monster_group.group_name, monster_role.role_id, monster_role.role_name, monster_intelligence " +
                "FROM monster " +
                "INNER JOIN monster_group on monster.group_id = monster_group.group_id " +
                "INNER JOIN monster_role on monster.role_id = monster_role.role_id " +
                "WHERE monster_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, monsterId);
            if (results.next()) {
                monster = mapRowToMonster(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return monster;
    }

    @Override
    public List<Monster> getAllMonsters() {
        List<Monster> monsters = new java.util.ArrayList<>();
        String sql = "SELECT monster_id, monster_name, monster_challenge_rating, monster_group.group_id, " +
                "monster_group.group_name, monster_role.role_id, monster_role.role_name, monster_intelligence " +
                "FROM monster " +
                "INNER JOIN monster_group on monster.group_id = monster_group.group_id " +
                "INNER JOIN monster_role on monster.role_id = monster_role.role_id;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Monster monster = mapRowToMonster(results);
                monsters.add(monster);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return monsters;
    }

    @Override
    public Monster getRandomMonster(int terrain_id, int max_challenge_rating) {
        Monster monster = new Monster();
        String sql = "SELECT monster.monster_id, monster_name, monster_challenge_rating, monster_group.group_id, " +
                "monster_group.group_name, monster_role.role_id, monster_role.role_name, monster_intelligence " +
                "FROM monster " +
                "INNER JOIN monster_group on monster.group_id = monster_group.group_id " +
                "INNER JOIN monster_role on monster.role_id = monster_role.role_id " +
                "INNER JOIN monster_terrain on monster.monster_id = monster_terrain.monster_id " +
                "WHERE  monster_terrain.terrain_id = ? AND monster_challenge_rating <= ? " +
                "ORDER BY RANDOM() LIMIT 1;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, terrain_id, max_challenge_rating);
            if (results.next()) {
                monster = mapRowToMonster(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return monster;
    }


    private Monster mapRowToMonster(SqlRowSet results) {

        Monster monster = new Monster();
        monster.setMonsterId(results.getInt("monster_id"));
        monster.setMonsterName(results.getString("monster_name"));
        monster.setChallengeRating(results.getInt("monster_challenge_rating"));
        monster.setGroupId(results.getInt("group_id"));
        monster.setGroup_name(results.getString("group_name"));
        monster.setRoleId(results.getInt("role_id"));
        monster.setRole_name(results.getString("role_name"));
        monster.setMonsterIntelligence(results.getInt("monster_intelligence"));
        return monster;
    }

}
