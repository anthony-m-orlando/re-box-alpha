package com.techelevator.controller;

import com.techelevator.dao.MonsterDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.AIAction;
import com.techelevator.model.Monster;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.techelevator.model.Creature;
import com.techelevator.dao.CreatureDao;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/monster")

public class MonsterController {

    private CreatureDao creatureDao;

    public MonsterController(CreatureDao creatureDao) {
        this.creatureDao = creatureDao;
    }

    @RequestMapping(path = "creature/dungeon/{terrainId}/{minChallengeRating}/{maxChallengeRating}", method = RequestMethod.GET)
    public List<Creature> getCreaturesForDungeon(@PathVariable int terrainId, @PathVariable int minChallengeRating, @PathVariable int maxChallengeRating) {
        try {
            return creatureDao.getCreaturesForDungeon(terrainId,minChallengeRating,maxChallengeRating);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Creature getMonsterById(@PathVariable int id) {
        try {
            return creatureDao.getCreatureById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "creature/random/{terrainId}/{minChallengeRating}/{maxChallengeRating}", method = RequestMethod.GET)
    public Creature getRandomCreature(@PathVariable int terrainId, @PathVariable int minChallengeRating, @PathVariable int maxChallengeRating) {
        try {
            return creatureDao.getRandomCreature(terrainId, minChallengeRating, maxChallengeRating);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(path = "creature/turns/{creatureId}", method = RequestMethod.GET)
    public List<AIAction> getCreatureTurns(@PathVariable int creatureId) {
        try {
            return creatureDao.getCreatureTurn(creatureId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
