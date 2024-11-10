package com.techelevator.dao;
import com.techelevator.model.main.Dungeon;
import java.util.List;

public interface DungeonDao {
    Dungeon getDungeonById(int dungeonId);
    Dungeon createDungeon(Dungeon dungeon, int userId);
    Dungeon updateDungeon(Dungeon dungeon, int userId);
    List<Dungeon> getAllDungeons();
    List<Dungeon> getDungeonsForUser(int userId);

}
