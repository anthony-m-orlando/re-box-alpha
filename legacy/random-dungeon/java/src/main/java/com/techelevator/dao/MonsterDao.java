package com.techelevator.dao;

import com.techelevator.model.Monster;

import java.util.List;

public interface MonsterDao {
    Monster getMonsterById(int monsterId);
    List<Monster> getAllMonsters();
    Monster getRandomMonster(int terrain_id, int max_challenge_rating);

}
