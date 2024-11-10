package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Monster;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class jdbcMonsterDao implements MonsterDao{
    private final JdbcTemplate jdbcTemplate;
    public jdbcMonsterDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Monster getMonsterById(int id){
        Monster monster = new Monster();
        String sql = "SELECT monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage " +
                "FROM monsters " +
                "WHERE monster_id=?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                monster = mapRowToMonster(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return monster;
    }

    @Override
    public List<Monster> getListOfMonsters() {
        List<Monster> monsters = new ArrayList<>();
        String sql = "SELECT monster_id, monster_name, monster_health, monster_defense, monster_attack_description, monster_damage " +
                "FROM monsters;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Monster monster =  mapRowToMonster(results);
                monsters.add(monster);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return monsters;
    }

    public Monster mapRowToMonster(SqlRowSet rowSet){
        Monster monster = new Monster();
        monster.setId(rowSet.getInt("monster_id"));
        monster.setName(rowSet.getString("monster_name"));
        monster.setHealth(rowSet.getInt("monster_health"));
        monster.setDefense(rowSet.getInt("monster_defense"));
        monster.setAttack(rowSet.getInt("monster_damage"));
        monster.setAttackDescription(rowSet.getString("monster_attack_description"));
        return monster;
    }
}
