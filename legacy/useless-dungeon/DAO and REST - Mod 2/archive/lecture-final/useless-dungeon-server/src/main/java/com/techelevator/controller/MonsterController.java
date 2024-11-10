package com.techelevator.controller;
import com.techelevator.dao.MonsterDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Monster;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
@RequestMapping("/monsters")
public class MonsterController {

    private MonsterDao monsterDao;

    public MonsterController(MonsterDao monsterDao){
        this.monsterDao = monsterDao;
    }

    /**
     * GET
     * /monsters
     *
     *
     * @return a list of monsters in the dungeon
     */
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Monster> getMonsters() {
        try {
            return monsterDao.getListOfMonsters();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /**
     * GET
     * /monsters/{monsterID}
     *
     * @param monsterID the id of the hotel
     * @return all data for a given monster
     */
    @RequestMapping(path = "{monsterID}", method = RequestMethod.GET)
    public Monster getMonsterById(@PathVariable int monsterID) {
        Monster monster;
        try {
            monster = monsterDao.getMonsterById(monsterID);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return monster;
    }

}
