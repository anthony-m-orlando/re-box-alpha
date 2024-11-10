package com.techelevator.controller;
import com.techelevator.dao.MonsterDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Monster;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/monster")
public class MonsterController {

    private MonsterDao monsterDao;

    public MonsterController(MonsterDao monsterDao){
        this.monsterDao = monsterDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Monster> getMonsters() {
        try {
            return monsterDao.getMapOfMonsters();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Monster getMonsterById(@PathVariable int id) {
        Monster monster;
        try {
            monster = monsterDao.getMonsterById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return monster;
    }

}
