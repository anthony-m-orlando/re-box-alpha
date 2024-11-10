package com.techelevator.dao;
import com.techelevator.model.main.Monster;

import java.util.List;
import java.util.Map;


public interface MonsterDao {
    Monster getMonsterById(int id);
    List<Monster> getListOfMonsters();

    List<Monster> getMonstersByRoomID(int roomID);

}
