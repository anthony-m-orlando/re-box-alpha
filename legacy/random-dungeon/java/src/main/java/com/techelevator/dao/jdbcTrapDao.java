package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Trap;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
@Component
public class jdbcTrapDao implements TrapDao {

    private JdbcTemplate jdbcTemplate;

    public jdbcTrapDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Trap getTrapById(int trapId) {
        Trap trap = new Trap();
        String sql = "SELECT trap_id, trap_name, trap_find_dc, " +
                "trap_disable_dc, trap_challenge_rating, trap_description FROM trap WHERE trap_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, trapId);
            if (results.next()) {
                trap = mapRowToTrap(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return trap;
    }

    @Override
    public Trap getRandomTrap(int terrain_id, int max_challenge_rating) {
        Trap trap = new Trap();
        String sql = "SELECT trap.trap_id, trap_name, trap_find_dc, " +
                "trap_disable_dc, trap_challenge_rating, trap_description, trap_image_path FROM trap " +
                "INNER JOIN trap_terrain ON trap.trap_id = trap_terrain.trap_id " +
                "WHERE trap_challenge_rating <= ? ORDER BY RANDOM() LIMIT 1";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, max_challenge_rating);
            if (results.next()) {
                trap = mapRowToTrap(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return trap;

    }

    @Override
    public List<Trap> getAllTraps() {
        List<Trap> traps = new java.util.ArrayList<>();
        String sql = "SELECT trap_id, trap_name, trap_find_dc, " +
                "trap_disable_dc, trap_challenge_rating, trap_description FROM trap";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Trap trap = mapRowToTrap(results);
                traps.add(trap);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return traps;
    }

    private Trap mapRowToTrap(SqlRowSet results) {
        Trap trap = new Trap();
        trap.setTrapId(results.getInt("trap_id"));
        trap.setName(results.getString("trap_name"));
        trap.setFindDC(results.getInt("trap_find_dc"));
        trap.setDisableDC(results.getInt("trap_disable_dc"));
        trap.setChallengeRating(results.getInt("trap_challenge_rating"));
        trap.setDescription(results.getString("trap_description"));
        trap.setImageFile(results.getString("trap_image_path"));
        return trap;
    }

}
