package com.techelevator.useless_dungeon.dao;

import com.techelevator.useless_dungeon.model.main.Monster;

import java.util.List;

public interface MonsterDao {
    Monster getMonsterById(int id);
    List<Monster> getListOfMonsters();

}