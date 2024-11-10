package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Skill;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class jdbcSkillDao implements SkillDao {
    private JdbcTemplate jdbcTemplate;

    public jdbcSkillDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Skill> getSkillList(){
        List<Skill> skillLIst = new ArrayList<>();
        String sql = "SELECT skill_id, skill_name, ability.ability_name, skill_description " +
                    "FROM skill " +
                    "INNER JOIN ability ON skill.skill_ability_id = ability.ability_id;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Skill skill = mapRowToSkill(results);
                skillLIst.add(skill);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return skillLIst;
    }

    public Skill mapRowToSkill(SqlRowSet results){
        Skill skill = new Skill();
        skill.setSkillId (results.getInt("skill_id"));
        skill.setName(results.getString("skill_name"));
        skill.setDescription(results.getString("skill_description"));
        skill.setAbilityScore(results.getString("ability_name"));
        return skill;
    }
}
