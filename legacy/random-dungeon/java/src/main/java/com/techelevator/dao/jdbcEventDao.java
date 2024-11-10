package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Event;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class jdbcEventDao implements EventDao {
    private JdbcTemplate jdbcTemplate;

    public jdbcEventDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Event getEventById(int eventId){
        Event event = new Event();
        String sql = "SELECT event_id, event_name FROM event WHERE event_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId);
            if (results.next()) {
                event = mapRowToEvent(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = new java.util.ArrayList<>();
        String sql = "SELECT event_id, event_name FROM event";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Event event = mapRowToEvent(results);
                events.add(event);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return events;
    }

    @Override
    public Event getRandomEvent() {
        Event event = new Event();
        String sql = "SELECT event_id, event_name FROM event ORDER BY RANDOM() LIMIT 1";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            if (results.next()) {
                event = mapRowToEvent(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return event;
    }
    private Event mapRowToEvent(SqlRowSet results) {
        Event event = new Event();
        event.setId(results.getInt("event_id"));
        event.setName(results.getString("event_name"));
        return event;
    }
}
