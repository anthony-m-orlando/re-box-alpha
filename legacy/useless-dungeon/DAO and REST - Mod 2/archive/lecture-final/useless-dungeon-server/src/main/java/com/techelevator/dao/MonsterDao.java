package com.techelevator.dao;
import com.techelevator.model.main.Monster;

import java.util.List;



public interface MonsterDao {
    Monster getMonsterById(int id);
    List<Monster> getListOfMonsters();

}
