package com.techelevator.dao;

import com.techelevator.model.AIAction;

import java.util.List;

public interface ActionDao {

    List<AIAction> getActionsForCreature(int creatureId);

}
