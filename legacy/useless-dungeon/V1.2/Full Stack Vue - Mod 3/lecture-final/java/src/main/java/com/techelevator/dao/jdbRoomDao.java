package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Room;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class jdbRoomDao implements RoomDao {
    private final JdbcTemplate jdbcTemplate;
    private MonsterDao jdbcMonsterDao;
    public jdbRoomDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbcMonsterDao = new jdbcMonsterDao(dataSource);
    }
    @Override
    public Room getRoomById(int id){
        Room room = new Room();
        String sql = "SELECT room_id, room_name, room_description " +
                "FROM rooms " +
                "WHERE room_id=?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                room = mapRowToRoom(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return room;
    }

    @Override
    public List<Room> getListOfRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT room_id, room_name, room_description " +
                "FROM rooms;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Room room =  mapRowToRoom(results);
                room.setMonsters(jdbcMonsterDao.getMonstersByRoomID(room.getId()));
                rooms.add(room);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return rooms;
    }
    @Override
    public List<Room> getRoomsByDungeonId(int dungeonId) {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT room_id, room_name, room_description " +
                "FROM rooms WHERE dungeon_id =?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dungeonId);
            while (results.next()) {
                Room room =  mapRowToRoom(results);
                room.setMonsters(jdbcMonsterDao.getMonstersByRoomID(room.getId()));
                rooms.add(room);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return rooms;
    }
    public Room mapRowToRoom(SqlRowSet rowSet){
        Room room = new Room();
        room.setId(rowSet.getInt("room_id"));
        room.setName(rowSet.getString("room_name"));
        room.setDescription(rowSet.getString("room_description"));
        return room;
    }


}
