package com.techelevator.controller;

import com.techelevator.dao.DungeonDao;
import com.techelevator.dao.RoomDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.main.Dungeon;
import com.techelevator.model.main.Room;
import com.techelevator.model.security.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/dungeons")
public class DungeonController {
    private DungeonDao dungeonDao;
    private UserDao userDao;
    public DungeonController(DungeonDao dungeonDao, UserDao userDao){
        this.dungeonDao = dungeonDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/mydungeons", method = RequestMethod.GET)
    public List<Dungeon> getDungeons(Principal principal) {
        try {
            return dungeonDao.getDungeonsForUser(getCurrentUserId(principal));
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private int getCurrentUserId(Principal principal) {
        return userDao.getUserByUsername(principal.getName()).getId();
    }
}
