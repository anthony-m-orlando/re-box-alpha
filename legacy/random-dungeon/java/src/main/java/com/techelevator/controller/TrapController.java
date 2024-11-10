package com.techelevator.controller;

import com.techelevator.dao.TrapDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Trap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trap")
public class TrapController {

    private TrapDao trapDao;

    public TrapController(TrapDao trapDao) {
        this.trapDao = trapDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Trap> getTraps() {
        try {
            return trapDao.getAllTraps();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/random/{terrainId}/{maxChallengeRating}", method = RequestMethod.GET)
    public Trap getRandomTrap(@PathVariable int terrainId, @PathVariable int maxChallengeRating) {
        try {
            return trapDao.getRandomTrap(terrainId, maxChallengeRating);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Trap getTrapById(@PathVariable int id) {
        try {
            return trapDao.getTrapById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
