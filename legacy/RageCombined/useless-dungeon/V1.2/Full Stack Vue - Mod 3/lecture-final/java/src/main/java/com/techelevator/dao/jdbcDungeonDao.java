package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Dungeon;
import com.techelevator.model.main.Hero;
import com.techelevator.model.main.Room;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

@Component
public class jdbcDungeonDao implements DungeonDao{
    private final JdbcTemplate jdbcTemplate;
    private final jdbRoomDao jdbRoomDao;

    public jdbcDungeonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.jdbRoomDao = new jdbRoomDao(dataSource);
    }
    @Override
    public Dungeon getDungeonById(int dungeonId){
        Dungeon dungeon = new Dungeon();
        String sql = "SELECT dungeon_id, dungeon_name, dungeon_lateral_limit, dungeon_height_rooms " +
                     "FROM public.dungeons WHERE dungeon_id =?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dungeonId);
        if (results.next()) {
            dungeon = mapRowToDungeon(results);
        }
        return dungeon;
    }
    @Override
    public Dungeon createDungeon(Dungeon dungeon, int userId){
        return new Dungeon();
    }

    @Override
    public Dungeon updateDungeon(Dungeon dungeon, int userId){
        return new Dungeon();
    }
    @Override
    public List<Dungeon> getAllDungeons(){
        return new ArrayList<Dungeon>();
    }

    @Override
    public List<Dungeon> getDungeonsForUser(int userId){
        List<Dungeon> dungeons = new ArrayList<>();
        String sql = "SELECT dungeon_id, dungeon_name, dungeon_lateral_limit, dungeon_vertical_limit " +
                     "FROM public.dungeons WHERE user_id =?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Dungeon dungeon = mapRowToDungeon(results);
                dungeon.setDungeonRooms(jdbRoomDao.getRoomsByDungeonId(dungeon.getDungeonId()));
                dungeons.add(dungeon);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return dungeons;

    }

    public Dungeon mapRowToDungeon(SqlRowSet rowSet){
        Dungeon dungeon = new Dungeon();
        dungeon.setDungeonId(rowSet.getInt("dungeon_id"));
        dungeon.setDungeonName(rowSet.getString("dungeon_name"));
        dungeon.setLateralLimit(rowSet.getInt("dungeon_lateral_limit"));
        dungeon.setVerticalLimit(rowSet.getInt("dungeon_vertical_limit"));

        return dungeon;
    }
}
