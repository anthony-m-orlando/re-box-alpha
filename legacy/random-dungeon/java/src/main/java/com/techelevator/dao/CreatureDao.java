package com.techelevator.dao;

import com.techelevator.model.AIAction;
import com.techelevator.model.Creature;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

public interface CreatureDao {

    Creature getCreatureById(int creatureId);
    List<Creature> getCreaturesForDungeon(int terrainType, int minChallengeRating, int maxChallengeRating);
    Creature getRandomCreature(int terrainType, int minChallengeRating, int maxChallengeRating);
    List<AIAction> getCreatureTurn(int creatureId);

}
