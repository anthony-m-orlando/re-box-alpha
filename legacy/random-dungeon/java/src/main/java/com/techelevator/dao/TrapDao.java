package com.techelevator.dao;

import com.techelevator.model.Trap;

import java.util.List;

public interface TrapDao {

    Trap getTrapById(int trapId);
    List<Trap> getAllTraps();
    Trap getRandomTrap(int terrain_id, int max_challenge_rating);

}
