package com.techelevator.dao;
import com.techelevator.model.main.Monster;

import java.util.List;
import java.util.Map;


public interface MonsterDao {
    public Monster getMonsterById(int id);
    public List<Monster> getMapOfMonsters();

}
