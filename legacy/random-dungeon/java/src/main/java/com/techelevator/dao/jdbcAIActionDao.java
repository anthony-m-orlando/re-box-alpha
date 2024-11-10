package com.techelevator.dao;

import com.techelevator.model.AIAction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;


public class jdbcAIActionDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcAIActionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AIAction> getActionsForCreature(int creatureId) {
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
                    AIAction action = mapRowToAction(results);
                    actions.add(action);
                }
        } catch (org.springframework.jdbc.CannotGetJdbcConnectionException e) {
            throw new com.techelevator.exception.DaoException("Unable to connect to server or database", e);
        }
        return actions;
    }

    private AIAction mapRowToAction(SqlRowSet results) {
        AIAction action = new AIAction();
        action.setPriority(results.getInt("priority"));
        action.setActionName(results.getString("ai_action_name"));
        action.setTarget (results.getString("ai_target_name"));
        return action;
    }
}
