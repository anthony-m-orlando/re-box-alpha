package com.techelevator.useless_dungeon.controller;

import java.security.Principal;
import java.util.List;
import com.techelevator.useless_dungeon.dao.MonsterDao;
import com.techelevator.useless_dungeon.exception.DaoException;
import com.techelevator.useless_dungeon.model.main.Monster;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/monsters")
@PreAuthorize("isAuthenticated()")
public class MonsterController {

    private MonsterDao monsterDao;

    public MonsterController( MonsterDao monsterDao) {
        this.monsterDao = monsterDao;
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Monster> getListOfMonsters(Principal principal) {
		List<Monster> monsters = null;
		try {
			monsters = monsterDao.getListOfMonsters();
		} catch (DaoException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return monsters;
	}
}
